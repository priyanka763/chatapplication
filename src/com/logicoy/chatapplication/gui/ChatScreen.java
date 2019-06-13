package com.logicoy.chatapplication.gui;

import com.logicoy.chatapplication.ChatAction;
import com.logicoy.chatapplication.MessageListener;
import com.logicoy.chatapplication.MessageTransmitter;
import com.logicoy.chatapplication.QuizAction;
import com.logicoy.chatapplication.WritableInGUI;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class ChatScreen extends javax.swing.JFrame implements WritableInGUI {

    public ChatScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listen = new javax.swing.JButton();
        receivingport = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        message = new javax.swing.JTextField();
        targetport = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatarea = new javax.swing.JTextArea();
        ipaddress = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listen.setText("Listen");
        listen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listenActionPerformed(evt);
            }
        });

        receivingport.setText("receiving port");
        receivingport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receivingportActionPerformed(evt);
            }
        });

        send.setText("Send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        message.setText("Type your message here..");

        targetport.setText("targetport");

        chatarea.setColumns(20);
        chatarea.setRows(5);
        jScrollPane1.setViewportView(chatarea);

        ipaddress.setText("ip address");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listen)
                        .addGap(18, 18, 18)
                        .addComponent(receivingport, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ipaddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(targetport, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(send)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listen)
                    .addComponent(receivingport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(targetport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ipaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(send, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(message))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listenActionPerformed
        MessageListener listener = new MessageListener(listen, chatarea, this, Integer.parseInt(receivingport.getText()));
        listener.start();


    }//GEN-LAST:event_listenActionPerformed

    private void receivingportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivingportActionPerformed

    }//GEN-LAST:event_receivingportActionPerformed
    public static boolean isChat = true;
   
    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed

        if (message.getText().equalsIgnoreCase("regex")) {
            quiz();
        }
       else if (isChat) {
            transmit();
        }
    }//GEN-LAST:event_sendActionPerformed
    public synchronized void transmit() {
       MessageTransmitter transmitter = new MessageTransmitter(send, message.getText(), ipaddress.getText(), Integer.parseInt(targetport.getText()), this);
        transmitter.start();
    }

    public synchronized void quiz() {

        isChat = false;
        chatarea.append("Lets have a quiz now! " + System.lineSeparator());
        chatarea.append("Please Enter Your Input" + System.lineSeparator());

        ActionListener action = new QuizAction(message, send, chatarea, ipaddress, targetport, this);
        send.addActionListener(action);
        return ;
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chatarea;
    private javax.swing.JTextField ipaddress;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listen;
    private javax.swing.JTextField message;
    private javax.swing.JTextField receivingport;
    private javax.swing.JButton send;
    private javax.swing.JTextField targetport;
    // End of variables declaration//GEN-END:variables

    @Override
    public void write(String str) {
        chatarea.append(str + System.lineSeparator());
    }
}
