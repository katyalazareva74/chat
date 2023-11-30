package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChatClient extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 563;
    private static final int WINDOW_POSX = 900;
    private static final int WINDOW_POSY = 100;
    JLabel lbLog = new JLabel("Введите логин: ");
    JTextField arLog = new JTextField();
    JLabel lbPass = new JLabel("Введите пароль: ");
    JPasswordField arPass = new JPasswordField();
    JLabel lbIp = new JLabel("Введите IP: ");
    JTextField arIp = new JTextField();
    JPanel panClient = new JPanel(new GridLayout(2 ,4));
    JButton btnsend = new JButton("Send");
    JButton btnstart = new JButton("Start");
    JButton btnexit = new JButton("Exit");
    JPanel panbott = new JPanel(new GridLayout(1,2));
    JPanel panChat = new JPanel(new GridLayout(1,2));
    JTextArea arChat = new JTextArea();
    JTextField message = new JTextField();
    InputOutput saveload= new SaveLoad();
    Server server;
    ChatClient(){
        String liststring[] = {"Grisha", "Masha", "Misha", "Sasha"};
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Chat Claient");
        setResizable(false);
        JList jList = new JList();
        jList.setListData(liststring);
        jList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jList.setVisibleRowCount(2);
        panbott.add(btnstart);
        panbott.add(btnexit);
        panClient.add(new JScrollPane(jList));
        panClient.add(lbLog);
        panClient.add(arLog);
        panClient.add(lbPass);
        panClient.add(arPass);
        panClient.add(lbIp);
        panClient.add(arIp);
        panClient.add(panbott);
        panChat.add(message);
        panChat.add(btnsend);
        message.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    arChat.append(jList.getSelectedValue()+": "+message.getText()+"\n");
                    saveload.savechat(jList.getSelectedValue()+": "+message.getText()+"\n");
                    message.setText("");
                }
            }
        });
        btnstart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // server=new Server();
                StringBuilder art=saveload.loadchat();
                arChat.insert(art.toString(), 0);
            }
        });
        btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.setVisible(true);
            }
        });
        btnsend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arChat.append(jList.getSelectedValue()+": "+message.getText()+"\n");
                saveload.savechat(jList.getSelectedValue()+": "+message.getText()+"\n");
                message.setText("");
            }
        });
        add(panClient, BorderLayout.NORTH);
        add(new JScrollPane(arChat), BorderLayout.CENTER);
        add(panChat, BorderLayout.SOUTH);
        setVisible(true);
    }
}
