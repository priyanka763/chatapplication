package com.logicoy.chatapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatAction implements ActionListener {

    private JTextField message;
    private JButton send;
    private JTextField ipaddress;
    private JTextField targetport;
    WritableInGUI chatbox;
    public ChatAction( JButton send,JTextField message, JTextField ipaddress, JTextField targetport,WritableInGUI chatbox) {
        this.message = message;
        this.send = send;
        this.ipaddress = ipaddress;
        this.targetport = targetport;
        this.chatbox=chatbox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MessageTransmitter transmitter = new MessageTransmitter(send, message.getText(), ipaddress.getText(), Integer.parseInt(targetport.getText()), chatbox);
        transmitter.start();
    }

}
