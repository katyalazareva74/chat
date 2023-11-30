package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Server extends JFrame implements Listener {
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_POSX = 900;
    private static final int WINDOW_POSY = 100;
    JButton btnStart = new JButton("Start");
    JButton btnExit = new JButton("Stop");
    JTextArea textar = new JTextArea(10,20);
    ServerListener serverListener=new ServerLog(this);
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
                serverListener.start();
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                serverListener.stop();
            }
        });
        add(panserver, BorderLayout.NORTH);
        add(new JScrollPane(textar), BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void messageReceive(String text) {
        textar.append(text+"\n");
    }

}
