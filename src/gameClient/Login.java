package gameClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Login implements Runnable {
    static JTextField userText;
    static JTextField userNum;
    static int numId = -1;
    static int numGame = -1;
    private JMenuItem defaultId;
    private JMenuItem defaultNum;
    private JPanel panel;
    private JButton button;
    private boolean flag;
    private JFrame frame;

    public int getNum() {
        return numGame;
    }

    public int getId() {
        return numId;
    }

    public synchronized void user() {

        flag=false;
        frame = new JFrame("             Pokemon Login");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();

        panel.setLayout(null);

        JLabel temp= new JLabel();
        temp.setIcon(new ImageIcon("data/pok.png"));
        temp.setBounds(275, 70, 70, 70);
        panel.add(temp);
        frame.add(panel);

        JLabel id = new JLabel("          Id");
        id.setBounds(10, 20, 80, 25);
        id.setForeground(Color.RED.darker());
        id.setBackground(Color.gray.brighter());
        id.setOpaque(true);

        panel.add(id);

        frame.add(panel);

        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        userText.addKeyListener(new KeyAdapter() {
                                    public void keyPressed(KeyEvent ke) {
                                        String value = userText.getText();
                                        int l = value.length();
                                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                                            userText.setEditable(true);
                                        } else {
                                            userText.setEditable(false);
                                            //userText.setText("");

                                            userText.setText("* Enter only numeric digits(0-9)");

                                        }
                                    }
                                }
        );


        JLabel gameKey = new JLabel("   Key Game");
        gameKey.setBounds(10, 50, 80, 25);
        gameKey.setForeground(Color.RED.darker());
        gameKey.setBackground(Color.gray.brighter());
        gameKey.setOpaque(true);

        panel.add(gameKey);

        userNum = new JTextField();
        userNum.setBounds(100, 50, 165, 25);
        panel.add(userNum);

        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenu submenu = new JMenu("Default");
        //JMenuItem i1 = new JMenuItem("Item 1");
        defaultId = new JMenuItem("Default User Id");
        defaultNum= new JMenuItem("Default Key Game");

        //menu.add(i1);

        submenu.add(defaultId);
        submenu.add(defaultNum);
        menu.add(submenu);
        mb.add(menu);
        frame.setJMenuBar(mb);

        defaultId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==defaultId){
                   // userText.setEditable(false);
                    userText.setText("208196709");}
            }
        });

        defaultNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==defaultNum){
                    // userText.setEditable(false);
                    userNum.setText("1");}
            }
        });

        button = new JButton("Start Game");
        button.setBounds(120, 100, 120, 25);
        button.setForeground(Color.red.darker());
        button.setBackground(Color.PINK);
        panel.add(button);

        frame.setVisible(true);

       // button.addActionListener(new Login());

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if( userText.getText().length()==9){
                   numId=Integer.valueOf(userText.getText());
                   if( userNum.getText().length()>0 && userNum.getText().length()<=3) {
                       numGame = Integer.valueOf(userNum.getText());
                       flag=true;
                       frame.dispose();
                   }
               }
            }
        });
    }

    @Override
    public void run() {

        user();
       /* while (true) {
         //   if (userNum.getText().length() > 0 && userNum.getText().length() <= 3)
            if(flag){
            return;}
         *//*   System.out.println(getId());
            System.out.println(getNum());}*//*
        }*/
    }

    public boolean exit(){
        return flag;
    }


   /* @Override
    public void actionPerformed(ActionEvent e) {
        id=Integer.parseInt(userText.getText());
        num=Integer.parseInt(userNum.getText());

        id = Integer.valueOf(userText.getText());
        num = Integer.valueOf(userNum.getText());

        ///////////////make sure that the number is valid

        System.exit(0);
    }
*/

   }
