
/*
 * GUI.java
 *
 * Created on Oct 13, 2011, 1:28:03 PM
 */
/**
 *
 * @author Thai Son Dinh Tran
 * Assigment 1 Computer Network - BitCrazy Application
 */

import javax.swing.*;
import java.io.*;
import javax.swing.table.*;



public final class GUI extends javax.swing.JFrame /*implements Runnable*/{

    public static final int ID_COL = 0;
    public static final int NAME_COL = 1;
    public static final int SIZE_COL = 2;
    public static final int STATUS_COL = 3;
    public static final int SPEED_COL = 4;
    public static final int PROGRESS_COL = 5;
    public static final int LOCATION_COL = 6;
   
    
    //create socket
//    public static Socket sk;
    public Server sv;
    
    private DefaultTableModel model;
    private int sltRow = 0;
    private int isExist = JOptionPane.OK_OPTION;
    private File selectedFile = null;
   
//    Calendar cal = new GregorianCalendar();
    
//    public FileWriter fstream;
//    public BufferedWriter log;
// Get the components of the time
//    int hour12 = cal.get(Calendar.HOUR);            // 0..11
//    int hour24 = cal.get(Calendar.HOUR_OF_DAY);     // 0..23
//    int min = cal.get(Calendar.MINUTE);             // 0..59
//    int sec = cal.get(Calendar.SECOND);             // 0..59
//    int ms = cal.get(Calendar.MILLISECOND);         // 0..999
//    int ampm = cal.get(Calendar.AM_PM);             // 0=AM, 1=PM
//    
    

    /** Creates new form GUI */
    GUI(Server sv){ 
        super();
        this.sv = sv;
        setLookandFeel();
        initComponents();
        setDefaultIP();
        startButton.setEnabled(false);
        stopButton.setEnabled(false);
        removeButton.setEnabled(false);
    }
    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileOpen = new javax.swing.JFileChooser();
        fileSave = new javax.swing.JFileChooser();
        addButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        FileTable = new javax.swing.JTable(model){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        removeButton = new javax.swing.JButton();
        addHashButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        IPField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        connectButton = new javax.swing.JButton();

        fileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileOpenActionPerformed(evt);
            }
        });

        fileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSaveActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BitCrazy v1.0 - Computer Network - HCMUT");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        addButton.setText("ADD");
        addButton.setToolTipText("Click to add new file");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        startButton.setText("START");
        startButton.setToolTipText("Start seeding");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        model = new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID", "Name", "Size", "Status", "Speed","Progress", "Location"
            }
        );
        FileTable.setModel(model );
        FileTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        FileTable.setName(""); // NOI18N
        FileTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FileTableMouseClicked(evt);
            }
        });
        FileTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FileTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(FileTable);
        FileTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        removeButton.setText("REMOVE");
        removeButton.setToolTipText("Remove the current row");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        addHashButton.setText("ADD ID");
        addHashButton.setToolTipText("Add new ID to download");
        addHashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHashButtonActionPerformed(evt);
            }
        });

        stopButton.setText("STOP");
        stopButton.setToolTipText("Stop seeding");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Server IP");

        connectButton.setText("CONNECT");
        connectButton.setToolTipText("Connect to server");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(10, 10, 10)
                                .addComponent(IPField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(removeButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addHashButton))
                            .addComponent(connectButton))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, addHashButton, connectButton, removeButton, startButton, stopButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(startButton)
                    .addComponent(stopButton)
                    .addComponent(removeButton)
                    .addComponent(addHashButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(connectButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addButton, addHashButton, connectButton, removeButton, startButton, stopButton});

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*
 * Hàm xử lí sự kiện nút ADD
 * Chức năng :
     * Mở cửa sổ duyệt file (fileBrowser)
 */
private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    //Create a file chooser
    fileOpen.showOpenDialog(this);
    //And let it do the rest :D
}//GEN-LAST:event_addButtonActionPerformed
/*
 * Hàm xử lí sự kiện nút REMOVE
 * Chức năng :
 * + Xóa 1 dòng trong bảng danh sách các file (FileTable)
 */
private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
    int removedRow = FileTable.getSelectedRow();
    if(removedRow >= 0){
        int Hash = Integer.parseInt(FileTable.getValueAt(removedRow, ID_COL).toString());
        
        String IPServer = IPField.getText();
            //Notice to server that you stopped this hash
        if(getStatusCol(removedRow).equals("Seeding")){
            try{
                Client client = new Client(IPServer);
                boolean success = client.stopSeed(getIDCol(removedRow));
                if(success) client.finish();
            }catch(Exception e){
                showErrorMess(this,e.getMessage());
            }
        }
        model.removeRow(FileTable.getSelectedRow()); 
    }
}//GEN-LAST:event_removeButtonActionPerformed

/*
 * Hàm xử lí sự kiện nút START
 * Chức năng :
 * + Đăng kí với server để seed
 * + Listen trên ServerSocket Server.server để chờ request từ peer khác tới
 */
private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
       
    sltRow = FileTable.getSelectedRow();
    String status = null;
    String IPServer = IPField.getText();
    if(sltRow != -1){
        Client client = new Client(IPServer);
        if(!IPServer.equals("")){
            if(getStatusCol(sltRow).isEmpty()){
                //if not seeding or done 
                try{
                    System.out.println("Start seeding");
                    //get ID of the file
                    int ID = client.startSeed(getSizeCol(sltRow));
                    if(ID != -1){
                        client.finish();
                        startButton.setEnabled(false);
                        stopButton.setEnabled(true);
                        IPField.setEditable(false);
                        setStatus("Seeding",sltRow);
                        setID(ID,sltRow);
                     } else{
                        setStatus("Error!",sltRow);
                     }

                }catch(Exception e){
                    showErrorMess(this,"SeedFileError : " + e.toString());
                }
            } else if(getStatusCol(sltRow).equals("Done!")){
                try{
                    boolean success = client.reSeed(getIDCol(sltRow));
                    
                    if(success) setStatus("Seeding",sltRow);
                    else showErrorMess(this,"Cannot reseed this file!");
                    
                }catch(Exception e){
                    showErrorMess(this,"Reseed Error : " + e.getMessage());
                }
            }
        }else{
            showWarningMess(this,"Please fill in Server IP field");
        }
    }
}//GEN-LAST:event_startButtonActionPerformed

/*
 * Hàm xử lí sự kiện nút ADD HASH
 * Chức năng : 
 * + Mở một ô để nhập mã hash của file muốn down vào
 * + Nếu hash hợp lệ thì bắt đầu chạy thread FileDownload để gửi request cho peer
 * đang giữ file đó.
 */
private void addHashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHashButtonActionPerformed
    String str = JOptionPane.showInputDialog(this,"Enter ID : ");
    if(str != null){
        try{
            int ID = Integer.parseInt(str);
            String IPServer = IPField.getText();
            if(!IPServer.equals("")){
                IPField.setEditable(false);
                FileDownload down = new FileDownload(ID,this,IPServer);
                (new Thread(down)).start();
            }else{
                showWarningMess(this,"Please fill in the Server IP field");
            }
            
        }catch(Exception e){
            showWarningMess(this,"Invalid ID (number only) : "+str);
        }
    }
    
}//GEN-LAST:event_addHashButtonActionPerformed
/*
 * Hàm xử lí sự kiện cửa sổ duyệt file 
 * Chức năng :
 * + Lấy file cần add vô bảng từ cửa sổ duyệt file
 * + Thêm 1 dòng vào bảng với các filed : Name, Size, Hash, Path
 */
private void fileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileOpenActionPerformed
    if (JFileChooser.APPROVE_SELECTION.equals(evt.getActionCommand())) {
            // Open or Save was clicked
        //Get information of selectedFile
        File sltFile = fileOpen.getSelectedFile();
        boolean already = false;
        
        for(int i = 0; i < countRow(); i++){
            if(getIDCol(i) == sltFile.hashCode()){
                showWarningMess(this,"This file has already added!");
                already = true;
                break;
            }
        }
        if(!already){
            //Add a row into the table
            addRow();
            setName(sltFile.getName(),getCurrentRow());
            setSize(sltFile.length(),getCurrentRow());
//            setHash(sltFile.hashCode(),getCurrentRow());
            setPath(sltFile.getParent(),getCurrentRow());
        }
    }
}//GEN-LAST:event_fileOpenActionPerformed
/*
 * Hàm xử lí nút STOP
 * Chức năng :
 * 
 */
private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
    int selectRow = FileTable.getSelectedRow();
    if(selectRow > -1){
        if(getStatusCol(selectRow).equals("Seeding")){
            setStatus("",selectRow);
            String IPServer = IPField.getText();
            //Notice to server that you stopped this hash
            try{
                Client client = new Client(IPServer);
                //Quan
                
                int id = this.getIDCol(selectRow);
                if(id != -1) if(sv.stopThread(id)) System.out.println("OK");
                        else showErrorMess(this,"Error!");
                
                //end
                boolean success = client.stopSeed(getIDCol(selectRow));
                if(success){
                    stopButton.setEnabled(false);
                    startButton.setEnabled(true);
                    client.finish();
                }else showErrorMess(this,"Cannot stop this file!");
                
            }catch(Exception e){
                showErrorMess(this,e.toString());
            }
        }
    }
}//GEN-LAST:event_stopButtonActionPerformed

private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
    String IPServer = IPField.getText();
    if(!IPServer.equals("")){
        try{
            Client client = new Client(IPServer);
            boolean success = client.testServer();
            if(success){
                IPField.setEditable(true);
                connectButton.setEnabled(false);
                showInfMess(this,"Connect successfully to server");
            } else{
                showWarningMess(this,"Server doesn't exist");
            }
        }catch(Exception e){
            showErrorMess(this,"Cannot connect to server!");
        }
    }
    
}//GEN-LAST:event_connectButtonActionPerformed

private void fileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSaveActionPerformed
   
    if(JFileChooser.APPROVE_SELECTION.equals(evt.getActionCommand())){
        selectedFile = fileSave.getSelectedFile();
    }
}//GEN-LAST:event_fileSaveActionPerformed

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    String IPServer = IPField.getText();
    //Stop seed every file in the table
    try{
        Client client = new Client(IPServer);
        client.stopSeed();
        client.finish();
    }catch(Exception e){
//        showMess(this,"Stop seeding all file : "+e.getMessage());
        System.exit(0);
    }
}//GEN-LAST:event_formWindowClosing

private void FileTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FileTableMouseClicked
    TableAction();
}//GEN-LAST:event_FileTableMouseClicked

private void FileTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FileTableKeyReleased
    TableAction();
}//GEN-LAST:event_FileTableKeyReleased


private void TableAction(){
    System.out.println("Evnent FileTableMouseClicked");
    int selectRow = FileTable.getSelectedRow();
    if(selectRow != -1){//if there is at least 1 row is selected
        removeButton.setEnabled(true);
        if(getStatusCol(selectRow).equals("") || getStatusCol(selectRow).equals("Done!")){
            //if file is inactived or done
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
        } else /*if(getStatusCol(selectRow).equals("Seeding") || getStatusCol(selectRow).equals("Downloading"))*/{
            stopButton.setEnabled(true);
            startButton.setEnabled(false);
        }
    }else{
        startButton.setEnabled(false);
        stopButton.setEnabled(false);
        removeButton.setEnabled(false);
    }
}
public void showErrorMess(GUI parent,String str){
    JOptionPane.showMessageDialog(parent, str, "ERROR",JOptionPane.ERROR_MESSAGE);
}
public void showWarningMess(GUI parent, String str){
    JOptionPane.showMessageDialog(parent, str, "WARNING",JOptionPane.WARNING_MESSAGE);
}
public void showInfMess(GUI parent, String str){
    JOptionPane.showMessageDialog(parent, str, "INFORMATION",JOptionPane.INFORMATION_MESSAGE);
}
/*
 * These func use for file list (maybe not use anymore :D)
 */

//--------------------------
public int getCurrentRow(){
    return countRow() - 1;
}
public int getSelectedRow(){
    return this.sltRow;
}
public File getSelectFile(){
    return this.selectedFile;
}
public int fileExist(){
    System.out.println("Call");
    if(selectedFile.exists()){//if selectedFile has already existed
        isExist = JOptionPane.showConfirmDialog(this, "Overwrite existing file?", 
           "Confirm overwrite", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE); 
     }
    return isExist;
}

public void setDefaultIP(){
    IPField.setText("localhost");
}
public void setDefaultName(String name){
    fileSave.setSelectedFile(new File(name));
    fileSave.showSaveDialog(this);
}
//--------------------------------------------------------------
/*
 * These func use for file table
 */
public int countRow(){
    return FileTable.getRowCount();
}

public void addRow(){
    model.addRow(new Object[]{null,null,null,null,null});
}
public String getNameCol(int row){
    Object t = FileTable.getValueAt(row, NAME_COL);
    if(t == null) return null;
    return t.toString();
}

public long getSizeCol(int row){
    Object t = FileTable.getValueAt(row, SIZE_COL);
    if(t == null) return -1;
    return Long.parseLong(t.toString());
}

public String getStatusCol(int row){
    Object t = FileTable.getValueAt(row, STATUS_COL);
    if(t == null) return "";
    return t.toString();
}

public int getIDCol(int row){
    Object t = FileTable.getValueAt(row, ID_COL);
    if(t == null) return -1;
    return Integer.parseInt(t.toString());
}

public String getPathCol(int row){
    Object t = FileTable.getValueAt(row, LOCATION_COL);
    if(t == null) return null;
    return t.toString();
}

public void setName(String name,int sltRow){
    FileTable.setValueAt(name, sltRow, NAME_COL);
}
public void setSize(long size, int sltRow){
    FileTable.setValueAt(size, sltRow, SIZE_COL);
}
public void setStatus(String status, int sltRow){
    FileTable.setValueAt(status, sltRow, STATUS_COL);
}
public void setID(int hash, int sltRow){
    FileTable.setValueAt(hash, sltRow, ID_COL);
}
public void setPath(String loc, int sltRow){
    FileTable.setValueAt(loc, sltRow, LOCATION_COL);
}
public void setProgress(int percent, int sltRow){
    FileTable.setValueAt(Integer.toString(percent) + "%", sltRow, PROGRESS_COL);
}
public void setSpeed(int speed, int sltRow){
    String calcSpeed = null;
    if(speed >= 1024*1024*1024) calcSpeed = Integer.toString(speed/(1024*1024*1024)) + "GB/s";
    else if(speed >= 1024*1024) calcSpeed = Integer.toString(speed/(1024*1024)) + "MB/s";
    else if(speed >= 1024) calcSpeed = Integer.toString(speed/1024) + "KB/s";
    else calcSpeed = Integer.toString(speed) + "B/s";
    FileTable.setValueAt(calcSpeed, sltRow, SPEED_COL);
}
//------------------------------------------------------------



private void setLookandFeel(){
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    }catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
}

                    
                    
                
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable FileTable;
    private javax.swing.JTextField IPField;
    private javax.swing.JButton addButton;
    private javax.swing.JButton addHashButton;
    private javax.swing.JButton connectButton;
    private javax.swing.JFileChooser fileOpen;
    private javax.swing.JFileChooser fileSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}