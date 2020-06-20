

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Maxpayne47
 */
public class ClientGui extends javax.swing.JFrame {
    
    //************variables************//
    private  final String Adresse = "127.0.0.1";
    private  final int ServerPort = 9090;
    private final String connect = "¿con:";
    private final String disconnect = "¿dis:";
    private String User ;
    private Socket sock;
    private PrintWriter writer;
    private BufferedReader reader;
    private boolean isConnected =false;
    private String[] connectedClients;
    private final String err = "¿err:";
    //*********************************//
    
    public ClientGui() {
        initComponents();
        //****** inialise widgets state to Disabled*****//
        Discobtn.setEnabled(false);
        Send.setEnabled(false);
        textArea.setEditable(false);
        //****************************//
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ChatBot = new javax.swing.JLabel();
        Autor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MessageBoard = new javax.swing.JTextArea();
        Send = new javax.swing.JButton();
        Usernamefield = new javax.swing.JTextField();
        Joinbtn = new javax.swing.JButton();
        Discobtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ChatBot v1.0  By ChemsEddine Nemeur");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(16, 31, 54));
        jPanel1.setPreferredSize(new java.awt.Dimension(224, 50));

        ChatBot.setBackground(new java.awt.Color(250, 250, 250));
        ChatBot.setFont(new java.awt.Font("Tw Cen MT", 1, 15)); // NOI18N
        ChatBot.setForeground(new java.awt.Color(250, 250, 250));
        ChatBot.setText("ChatBot v1.0");

        Autor.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 10)); // NOI18N
        Autor.setForeground(new java.awt.Color(250, 250, 250));
        Autor.setText("By ChemsEddine Nemeur");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ChatBot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Autor)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ChatBot, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addComponent(Autor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        MessageBoard.setEditable(false);
        MessageBoard.setColumns(20);
        MessageBoard.setLineWrap(true);
        MessageBoard.setRows(5);
        MessageBoard.setWrapStyleWord(true);
        jScrollPane1.setViewportView(MessageBoard);

        Send.setText("Send");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });

        Usernamefield.setToolTipText("String between 3 and 10 caracters.");
        Usernamefield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UsernamefieldKeyTyped(evt);
            }
        });

        Joinbtn.setText("Join");
        Joinbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoinbtnActionPerformed(evt);
            }
        });

        Discobtn.setText("Disconnect");
        Discobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscobtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Username:");

        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new java.awt.Insets(0, 0, 0, 0));
        textArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textAreaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(textArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Send))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Usernamefield, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Joinbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Discobtn))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Discobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Usernamefield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Joinbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Send, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //**********Main methodes***********//
    private void connect(){
        try{
        String user = Usernamefield.getText().trim();
        if(user.isEmpty()){
            JOptionPane.showMessageDialog(null,"Empty Field!");
        }else if(user.length()<3){
            JOptionPane.showMessageDialog(null,"Username should be more than 3 caracters!");
        }
        else{
        this.User = user; 
        sock = new Socket(Adresse,ServerPort);
        isConnected = true;
        writer = new PrintWriter(sock.getOutputStream(),true);
        reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        writer.println(connect+this.User);
        Recieve(sock);
        Usernamefield.setText("");
        Discobtn.setEnabled(true);
        Send.setEnabled(true);
        textArea.setEditable(true);
        Joinbtn.setEnabled(false);
        }
        }catch(IOException e){JOptionPane.showMessageDialog(null,e.getMessage());}
    }
    
    private void Disconnect(){
       try {
            writer.println(disconnect);
            isConnected = false;
            writer.close();
            reader.close();
            sock.close();
            Joinbtn.setEnabled(true);
            Discobtn.setEnabled(false);
            Send.setEnabled(false);
            textArea.setEditable(false);
            MessageBoard.append("You left the chat!\n");
        } catch (IOException e) {
               {JOptionPane.showMessageDialog(null,e.getMessage());}
        }   
   }
    
    private void DisconnectError(){
        try {
            writer.println(err);
            sock.close();
            isConnected = false;
            Joinbtn.setEnabled(true);
            Discobtn.setEnabled(false);
            Send.setEnabled(false);
            textArea.setEditable(false);
        } catch (IOException e) {
               {JOptionPane.showMessageDialog(null,e.getMessage());}
        }   
    }
   
    private void Recieve(Socket so){
        Thread Recievethread = new Thread("recieve"){
            @Override
                public void run() {
                    try{ 
                        while(isConnected){  
                            String msg = reader.readLine();
                            if(msg.startsWith(err)){
                                JOptionPane.showMessageDialog(null, msg.substring(msg.indexOf(":")+1));
                                DisconnectError();  
                            }
                            else{         
                            MessageBoard.append(msg+"\n"); 
                            }
                        }                       
                       }catch(IOException e)
                            {
                            if(!(e.getMessage().equals("Socket closed"))){
                                JOptionPane.showMessageDialog(null,e.getMessage());
                                }
                            }       
                       finally{
                            try {
                               reader.close();
                            } catch (IOException e) 
                              {JOptionPane.showMessageDialog(null,e.getMessage());}
                        }
                    }
            };Recievethread.start();
    }
    //**********************************//
    
    //**********Bottons************//    
    private void SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendActionPerformed
      
            String msg = textArea.getText().trim();
            if(!msg.isEmpty()){
            writer.println(msg);         
            textArea.setText("");
            }
    }//GEN-LAST:event_SendActionPerformed

    private void JoinbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoinbtnActionPerformed
         connect();
    }//GEN-LAST:event_JoinbtnActionPerformed

    private void DiscobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscobtnActionPerformed
        Disconnect();
    }//GEN-LAST:event_DiscobtnActionPerformed
    // add a keypressed event to textArea to send messages by clicking entree!
    private void textAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaKeyPressed
        //check if the key pressed is entree 
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //disbale newline when pressing entree for the JtextArea
            textArea.getDocument().putProperty("filterNewlines", Boolean.TRUE);
            //send the message!
            String msg = textArea.getText().trim();
            if(!msg.isEmpty()){
            writer.println(msg);         
            textArea.setText("");
            }
        }
    }//GEN-LAST:event_textAreaKeyPressed
    // add keytyped event to limit the number of caracters to 10 
    private void UsernamefieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UsernamefieldKeyTyped
         if (Usernamefield.getText().length() >= 10 ) // limit to 10 characters
                evt.consume();
    }//GEN-LAST:event_UsernamefieldKeyTyped
    

    //**************************************//
    
    //**** methode main()*****//
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
            java.util.logging.Logger.getLogger(ClientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Autor;
    private javax.swing.JLabel ChatBot;
    private javax.swing.JButton Discobtn;
    private javax.swing.JButton Joinbtn;
    private javax.swing.JTextArea MessageBoard;
    private javax.swing.JButton Send;
    private javax.swing.JTextField Usernamefield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
