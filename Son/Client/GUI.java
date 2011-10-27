package Client;

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
import javax.swing.table.DefaultTableModel;
import java.net.*;



public final class GUI extends javax.swing.JFrame /*implements Runnable*/{

    
    public static final int NAME_COL = 0;
    public static final int SIZE_COL = 1;
    public static final int STATUS_COL = 2;
    public static final int PROGRESS_COL = 3;
    public static final int HASH_COL = 4;
    public static final int LOCATION_COL = 5;
    //create file list
    public ListFile fileLst;
    
    //create socket
//    public static Socket sk;
    public static ServerSocket sv;
    
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
    GUI(){ 
        super();
        setLookandFeel();
        initComponents();
        setDefaultIP();
        fileLst = new ListFile();
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
        changeButton = new javax.swing.JButton();

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
                "Name", "Size", "Status", "Progress", "Hash" , "Location"
            }
        );
        FileTable.setModel(model );
        FileTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        FileTable.setName(""); // NOI18N
        jScrollPane1.setViewportView(FileTable);
        FileTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        removeButton.setText("REMOVE");
        removeButton.setToolTipText("Remove the current row");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        addHashButton.setText("ADDHASH");
        addHashButton.setToolTipText("Add new hash to download");
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

        changeButton.setText("CHANGE IP");
        changeButton.setToolTipText("Enable/Disable Server IP field");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
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
                            .addComponent(changeButton))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, addHashButton, changeButton, removeButton, startButton, stopButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
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
                    .addComponent(changeButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addButton, addHashButton, changeButton, removeButton, startButton, stopButton});

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
        int Hash = Integer.parseInt(FileTable.getValueAt(removedRow, HASH_COL).toString());
        fileLst.removeFile(Hash);
        String IPServer = IPField.getText();
            //Notice to server that you stopped this hash
        if(getStatusCol(removedRow).equals("Seeding")){
            try{
                Client client = new Client(IPServer);
                boolean success = client.stopSeed(getHashCol(removedRow));
                if(success) client.finishSocket();
            }catch(Exception e){
                showMess(this,e.getMessage());
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
    int Hash = -1;
    if(sltRow != -1 && getStatusCol(sltRow).isEmpty()){
        //if not seeding or done 
        String IPServer = IPField.getText();
        try{
            if(!IPServer.equals("")){
//                stopButton.setEnabled(true);
                IPField.setEditable(false);
                System.out.print("StartButton event : ");
                System.out.println("seeding hash : " + Hash);
                Client client = new Client(IPServer);
                boolean success = client.seedFile(getHashCol(sltRow), getSizeCol(sltRow));
                if(success){
                    client.finishSocket();
//                    startButton.setEnabled(false);
                    setStatus("Seeding",sltRow);
                } else{
                    setStatus("Error!",sltRow);
                }
            }else{
                showMess(this,"Please fill in Server IP field");
            }
        }catch(Exception e){
            showMess(this,"SeedFileError : " + e.getMessage());
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
    String str = JOptionPane.showInputDialog(this,"Enter hash : ");
    if(str != null){
        try{
            int hash = Integer.parseInt(str);
            String IPServer = IPField.getText();
            if(!IPServer.equals("")){
                IPField.setEditable(false);
                FileDownload down = new FileDownload(hash,this,IPServer);
                (new Thread(down)).start();
            }else{
                showMess(this,"Please fill in the Server IP field");
            }
            
        }catch(Exception e){
            showMess(this,"Invalid hash : "+str);
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
            if(getHashCol(i) == sltFile.hashCode()){
                showMess(this,"This file has already added!");
                already = true;
                break;
            }
        }
        if(!already){
            
            fileLst.addFile(sltFile.getAbsolutePath(), sltFile.length(), sltFile.hashCode());
            //Add a row into the table
            addRow();
            setName(sltFile.getName(),getCurrentRow());
            setSize(sltFile.length(),getCurrentRow());
            setHash(sltFile.hashCode(),getCurrentRow());
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
                boolean success = client.stopSeed(getHashCol(selectRow));
                if(success) client.finishSocket();
            }catch(Exception e){
                showMess(this,e.getMessage());
            }
        }
    }
}//GEN-LAST:event_stopButtonActionPerformed

private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
    IPField.setEditable(true);
}//GEN-LAST:event_changeButtonActionPerformed

private void fileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSaveActionPerformed
   
    if(JFileChooser.APPROVE_SELECTION.equals(evt.getActionCommand())){
        selectedFile = fileSave.getSelectedFile();
    }
}//GEN-LAST:event_fileSaveActionPerformed

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    String IPServer = IPField.getText();
    //Stop seed every file in the table
    for(int i = 0; i < countRow(); i++){
        try{
            if(getStatusCol(i).equals("Seeding")){
                Client client = new Client(IPServer);
                client.stopSeed(getHashCol(i));
                client.finishSocket();
            }
        }catch(Exception e){
            showMess(this,"Can't stop seed file : "+getNameCol(i));
        }
    }
}//GEN-LAST:event_formWindowClosing



public void showMess(GUI parent,String str){
    JOptionPane.showMessageDialog(parent, str, "ERROR",JOptionPane.ERROR_MESSAGE);
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

public int getHashCol(int row){
    Object t = FileTable.getValueAt(row, HASH_COL);
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
public void setHash(int hash, int sltRow){
    FileTable.setValueAt(hash, sltRow, HASH_COL);
}
public void setPath(String loc, int sltRow){
    FileTable.setValueAt(loc, sltRow, LOCATION_COL);
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

    /**
     * @param args the command line arguments
     
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                

                }
            }
        } 
 
 
 catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            GUI UI;
            @Override
            public void run() {
                try {
                    
                    
                    UI = new GUI();
                    UI.setVisible(true);
                    
                    
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(UI, ex.getMessage());
                }
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable FileTable;
    private javax.swing.JTextField IPField;
    private javax.swing.JButton addButton;
    private javax.swing.JButton addHashButton;
    private javax.swing.JButton changeButton;
    private javax.swing.JFileChooser fileOpen;
    private javax.swing.JFileChooser fileSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}
