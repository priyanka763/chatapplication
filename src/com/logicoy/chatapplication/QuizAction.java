package com.logicoy.chatapplication;

import static com.logicoy.chatapplication.gui.ChatScreen.isChat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QuizAction implements ActionListener {

    private JTextField message;
    private JButton send;
    private JTextArea chatarea;
    private JTextField ipaddress;
    private JTextField targetport;
    WritableInGUI chatbox;

    public QuizAction(JTextField message, JButton send, JTextArea chatarea, JTextField ipaddress, JTextField targetport, WritableInGUI chatbox) {
        this.message = message;
        this.send = send;
        this.chatarea = chatarea;
        this.ipaddress = ipaddress;
        this.targetport = targetport;
        this.chatbox = chatbox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (message.getText().equalsIgnoreCase("abort")) {
            message.setText("");
            isChat = true;

            send.removeActionListener(this);
            return;

        } else if (!isChat) {

            if (Pattern.matches("[a-zA-Z]{3,20}", message.getText())) {
                chatarea.append("Hi, This is your Name" + System.lineSeparator());
            } else if (Pattern.matches("[789]{1}\\d{9}", message.getText())) {
                chatarea.append("Hi, This is your Phone number" + System.lineSeparator());
            } else if (Pattern.matches("[a-zA-Z0-9]+[._a-zA-Z0-9]*@[a-zA-Z0-9]{2,8}.[a-zA-Z.]{2,4}", message.getText())) {
                chatarea.append("Hi, This is your Email Id" + System.lineSeparator());
            } else if (Pattern.matches("[0-9]{6}", message.getText())) {
                chatarea.append("Hi, This is your SSN " + System.lineSeparator());
            } else if (Pattern.matches("^(https:\\/\\/||http:\\/\\/)+[a-z A-Z]+.[a-z A-Z]{2,3}", message.getText())) {
                chatarea.append("Hi, This is your URL" + System.lineSeparator());
            } else if (Pattern.matches("[a-zA-Z0-9]+.[A-Za-z]{3}", message.getText())) {
                chatarea.append("Hi, This is your Website" + System.lineSeparator());
            } else {
                chatarea.append("Please enter valid data " + System.lineSeparator());

            }

        }
    }
}
