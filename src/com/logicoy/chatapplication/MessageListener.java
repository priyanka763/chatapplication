package com.logicoy.chatapplication;

import java.awt.PopupMenu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MessageListener extends Thread {

    int port;
    ServerSocket server;
    WritableInGUI chatbox;
    JButton listen;
    JTextArea chatarea;

    public MessageListener() {

    }

    public MessageListener(JButton listen, JTextArea chatarea, WritableInGUI chatbox, int port) {
        this.port = port;
        this.chatbox = chatbox;
        this.listen = listen;
        this.chatarea = chatarea;
        try {
            server = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        Socket clientSocket;
        try {
            listen.setEnabled(false);
            if (listen.isEnabled() == false) {
                PopupMenu popup = new PopupMenu();
                popup.add("listened");
                chatarea.add(popup);
                chatarea.append("listening.." + System.lineSeparator());
            }
            while ((clientSocket = server.accept()) != null) {
                InputStream stream = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String msg = reader.readLine();
                if (msg != null) {
                    chatbox.write(msg);
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
