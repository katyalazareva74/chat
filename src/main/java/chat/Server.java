package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Server extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 563;
    private static final int WINDOW_POSX = 900;
    private static final int WINDOW_POSY = 100;
    private boolean isServerWorking = false;
    JButton btnStart = new JButton("Start");
    JButton btnExit = new JButton("Stop");
    JTextArea textar = new JTextArea(10,20);
    Server(){
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Chat Server");
        setResizable(false);
        JPanel panserver = new JPanel(new GridLayout(1,1));
        panserver.add(btnStart);
        panserver.add(btnExit);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                isServerWorking=true;
                textar.append("Server started\n");
                setVisible(false);
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                isServerWorking=false;
                textar.append("Server stoped\n");
                System.exit(0);
            }
        });
        add(panserver, BorderLayout.CENTER);
        add(new JScrollPane(textar), BorderLayout.SOUTH);
        setVisible(true);
    }
}
