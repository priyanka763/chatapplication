package com.logicoy.chatapplication;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MessageTransmitter extends Thread {

    int port;
    String message, hostname;
    JButton send;
    WritableInGUI chatbox;
    Socket s;

    public MessageTransmitter(JButton send, String message, String hostname, int port, WritableInGUI chatbox) {
        this.send = send;
        this.message = message;
        this.hostname = hostname;
        this.port = port;
        this.chatbox = chatbox;
        try {
            s = new Socket(hostname, port);
        } catch (IOException ex) {
            Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MessageTransmitter() {
    }

    @Override
    public void run() {

        try {

            send.setEnabled(false);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
            }
            s.getOutputStream().write(message.getBytes());
            send.setEnabled(true);
        } catch (IOException ex) {
            Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
