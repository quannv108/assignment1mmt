

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on Oct 13, 2011, 1:28:03 PM
 */
/**
 *
 * @author NS
 */
import javax.swing.*;
import java.io.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.DefaultTableModel;
import java.net.*;
import java.util.GregorianCalendar;
import java.util.Calendar;

public final class NewJFrame extends javax.swing.JFrame {

    private String path;
    private int row = 0;
    private DefaultTableModel model;
    public ListFile fileLst;
    private static final int NAME_COLUMN = 0;
    private static final int SIZE_COLUMN = 1;
    private static final int STATUS_COLUMN = 2;
    private static final int TRACK_COLUMN = 3;
    private static final int HASH_COLUMN = 4;
    public FileWriter fstream;
    public BufferedWriter log;
    Calendar cal = new GregorianCalendar();

// Get the components of the time
//    int hour12 = cal.get(Calendar.HOUR);            // 0..11
//    int hour24 = cal.get(Calendar.HOUR_OF_DAY);     // 0..23
//    int min = cal.get(Calendar.MINUTE);             // 0..59
//    int sec = cal.get(Calendar.SECOND);             // 0..59
//    int ms = cal.get(Calendar.MILLISECOND);         // 0..999
//    int ampm = cal.get(Calendar.AM_PM);             // 0=AM, 1=PM
//    
    

    /** Creates new form NewJFrame */
    public NewJFrame() {
        initComponents();
        fileLst = new ListFile();
//        initLog();
    }
    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
//    public void initLog(){
//        try{
//            
//            
//
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(this, e);
//        }
//    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        addButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        pathField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListFile = new javax.swing.JTable(model){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        removeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        startButton.setText("START");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        model = new DefaultTableModel(
            new Object [][] {
                /*{null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}*/
            },
            new String [] {
                "Name", "Size", "Status", "Tracker", "Hash"
            }
        );
        ListFile.setModel(model );
        ListFile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ListFile.setName(""); // NOI18N
        jScrollPane1.setViewportView(ListFile);
        ListFile.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        removeButton.setText("REMOVE");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton))
                    .addComponent(pathField, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(startButton)
                    .addComponent(removeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    //Create a file chooser
    JFileChooser fileBrowser = new JFileChooser();
    fileBrowser.showOpenDialog(this);
    fileBrowser.cancelSelection();
    
    //Get information of selectedFile
    File selectedFile = fileBrowser.getSelectedFile();
    String fileName = selectedFile.getAbsolutePath();
    int fileHash = selectedFile.hashCode();
    long fileSize = selectedFile.length();
    
    //Set the path of selectedFile to pathField
    pathField.setText(fileName);
    
    
    
    if((row > 0) &&(Integer.parseInt(ListFile.getValueAt(row - 1, 4).toString()) == fileHash)){
       JOptionPane.showMessageDialog(this, "This file has already added!!");
    } else{
         
       fileLst.addFile(fileName, fileSize, fileHash);
       
       model.addRow(new Object[]{null,null,null,null});
       ListFile.setValueAt(selectedFile.getName(), row, NAME_COLUMN);
       ListFile.setValueAt(selectedFile.length() , row, SIZE_COLUMN);
       ListFile.setValueAt("Seeding", row, STATUS_COLUMN);
       ListFile.setValueAt("bitcrazy.vn",row,TRACK_COLUMN); 
       ListFile.setValueAt(selectedFile.hashCode(), row, HASH_COLUMN);
       
    
    try{

            /* Try to connect to the server on localhost, port 5555 */

            Socket sk = new Socket("localhost", 5555);
            OutputStream output = sk.getOutputStream();

            /* Send filename to server */

            OutputStreamWriter outputStream = new OutputStreamWriter(sk.getOutputStream());
            outputStream.write(fileBrowser.getSelectedFile().getName() + "\n");
            outputStream.flush();

            /* Get reponse from server */

            BufferedReader inReader = new BufferedReader(new InputStreamReader(sk.getInputStream()));

            String serverStatus = inReader.readLine(); // Read the first line

            /* If server is ready, send the file */

            if ( serverStatus.equals("READY") ){
                    

                FileInputStream file = new FileInputStream(fileName);
                
                fstream = new FileWriter("src/log/log.txt",true);
                log = new BufferedWriter(fstream);
                
                byte[] buffer = new byte[/*sk.getSendBufferSize()*/File_Info.BLOCK];

                int bytesRead = 0;

                //showLog.setText("File : " + filename + "\n" + "Size : " + 
                //        fileDlg.getSelectedFile().length() +" byte\n");
                //showLog.append("Transfering...\n");
                
                
                
                
                while((bytesRead = file.read(buffer))>0)
                {
//                    showLog.append(bytesRead + " byte\n");
                    System.out.println(bytesRead);
                    output.write(buffer,0,bytesRead);
                    log.append("("+fileName +","+fileSize+","+fileHash+") => " +
                                Integer.toString(bytesRead) + "\n");
                }
                
  //              showLog.append("Finish!!");
                
                int hour24 = cal.get(Calendar.HOUR_OF_DAY);     // 0..23
                int min = cal.get(Calendar.MINUTE); 
                int ampm = cal.get(Calendar.AM_PM);
                String AMPM;  
                if(ampm == 0) AMPM = "AM"; else AMPM = "PM";
                log.append("("+fileName +","+fileSize+","+fileHash+") => " 
                            + "Done! " +hour24+"h"+min+AMPM+"\n");
                            
                log.close();
                output.close();
                file.close();
                sk.close();
                ListFile.setValueAt("Done!", row, STATUS_COLUMN);
                
                //JOptionPane.showMessageDialog(this, "Transfer complete");
            }
        }
        catch (Exception ex){
            /* Catch any errors */
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        row++;
    }
}//GEN-LAST:event_addButtonActionPerformed

private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
    int removedRow = ListFile.getSelectedRow();
    if(removedRow >= 0){
        model.removeRow(ListFile.getSelectedRow());    
        int hash = Integer.parseInt(ListFile.getValueAt(removedRow, 4).toString());
        fileLst.removeFile(hash);
    }
}//GEN-LAST:event_removeButtonActionPerformed

private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
    //int removedRow = ListFile.getSelectedRow();
    
}//GEN-LAST:event_startButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                

}
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListFile;
    private javax.swing.JButton addButton;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pathField;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}