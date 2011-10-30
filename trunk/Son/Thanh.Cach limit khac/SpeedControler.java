package bitcrazy;





import java.io.*;
import java.net.*;

/**
 *
 * @author T'PHaM
 */
public class SpeedControler implements Runnable {
    public static final int    FACTOR =   2;
    public static final int UNLIMITED =   0;
    
    private Socket          theSocket = null;
    private int     maxSendBufferSize =   -1;
    private int  maxReceiveBufferSize =   -1;
    private int               upSpeed =   -1;
    private int             downSpeed =   -1;
    private int            sendBuffer =   -1;
    private int         receiveBuffer =   -1;
    private Thread             thread = null;
    
    public SpeedControler(Socket _socket) {
        theSocket =   _socket;
        upSpeed   = UNLIMITED;
        downSpeed = UNLIMITED;
        try {
            theSocket.setTcpNoDelay(true);
        } catch (IOException ioe) {
            System.out.println("Error disable Nagle's algorithm " + ioe.getMessage());
        }
        try {
            maxSendBufferSize = theSocket.getSendBufferSize();
            maxReceiveBufferSize = theSocket.getReceiveBufferSize();
        } catch (IOException ioe) {
            System.out.println("Error getting buffer size: " + ioe.getMessage());
        }
        sendBuffer    =    maxSendBufferSize;
        receiveBuffer = maxReceiveBufferSize;
        
        thread = new Thread(this);
        thread.start();
    }
    
    public void stop(){
        thread.interrupt();
    }
    
    public static int getRTT(String _ip) {
        if (isWindows()) {
            try {
                String command[] = {"ping", _ip, "-n", "3", "-l", "32"};
                ProcessBuilder processBuilder = new ProcessBuilder(command);
                processBuilder.redirectErrorStream(true);
                Process process = processBuilder.start();
                BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = null;
                String lastline = null;
                while ((line = in.readLine()) != null) {
                    lastline = line;
                }
                int RTT = Integer.parseInt(lastline.substring(lastline.lastIndexOf(' ') + 1, lastline.length() - 2));
                return RTT;
            } catch (Exception e) {
                System.out.println("Error calling ping: " + e.getMessage());
                return -1;
            }
        } else {
            System.out.println("OS not supported.");
            return -1;
        }
    }
    
    public void setUpSpeed(int _speed) {
        upSpeed = _speed;
    }
    
    public void setDownSpeed(int _speed) {
        downSpeed = _speed;
    }
    
    public int getSendBufferSize() {
        return sendBuffer;
    }
    
    public int getReceiveBufferSize() {
        return receiveBuffer;
    }
    
    public void run() {
        int lastSend = -1;
        int lastReceive = -1;
        try {
            while (true) {
                int rtt = getRTT(getIP());
                if (rtt > 0) {
                    if (upSpeed > UNLIMITED) {
                        sendBuffer = (upSpeed * rtt) / FACTOR;
                        if (sendBuffer <= 0) sendBuffer = 1;
                    } else {
                        sendBuffer = maxSendBufferSize;
                    }
                    if (downSpeed > UNLIMITED) {
                        receiveBuffer = (downSpeed * rtt) / FACTOR;
                        if (receiveBuffer <= 0) receiveBuffer = 1;
                    } else {
                        receiveBuffer = maxReceiveBufferSize;
                    }
                    if (lastSend != sendBuffer) {
                        theSocket.setSendBufferSize(sendBuffer);
                        lastSend = sendBuffer;
                    }
                    if (lastReceive != receiveBuffer) {
                        theSocket.setReceiveBufferSize(receiveBuffer);
                        lastReceive = receiveBuffer;
                    }
                }
            }
        } catch (IOException ioe) {
            System.out.println("Error controling speed: " + ioe.getMessage());
        }
    }
    
    private static boolean isWindows() {
        String os = System.getProperty("os.name");
        return os.startsWith("Windows");
    }
    
    private String getIP() {
        String result = theSocket.getInetAddress().toString();
        result = result.substring(result.indexOf('/') + 1);
        return result;
    }
    
}