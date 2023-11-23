package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ChatClaient extends JFrame {
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
    JPanel panClaient = new JPanel(new GridLayout(2 ,4));
    JButton btnsend = new JButton("Send");
    JButton btnstart = new JButton("Start");
    JButton btnexit = new JButton("Exit");
    JPanel panbott = new JPanel(new GridLayout(1,2));
    JPanel panChat = new JPanel(new GridLayout(1,2));
    JTextArea arChat = new JTextArea();
    JTextField message = new JTextField();
    Server server;
    ChatClaient(){
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
        panClaient.add(new JScrollPane(jList));
        panClaient.add(lbLog);
        panClaient.add(arLog);
        panClaient.add(lbPass);
        panClaient.add(arPass);
        panClaient.add(lbIp);
        panClaient.add(arIp);
        panClaient.add(panbott);
        panChat.add(message);
        panChat.add(btnsend);
        message.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    arChat.append(jList.getSelectedValue()+": "+message.getText()+"\n");
                    savechat(jList.getSelectedValue()+": "+message.getText()+"\n");
                    message.setText("");
                }
            }
        });
        btnstart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server = new Server();
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                loadchat();
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
                savechat(jList.getSelectedValue()+": "+message.getText()+"\n");
                message.setText("");
            }
        });
        add(panClaient, BorderLayout.NORTH);
        add(new JScrollPane(arChat), BorderLayout.CENTER);
        add(panChat, BorderLayout.SOUTH);
        setVisible(true);
    }
    private void savechat(String str){
        try(FileWriter fw = new FileWriter("data.txt", true)){
            fw.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadchat(){
        try(FileReader fr = new FileReader("data.txt"); Scanner sc = new Scanner(fr)) {
            while (sc.hasNextLine()){
                arChat.append(sc.nextLine()+"\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
