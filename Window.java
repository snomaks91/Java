package Lesson_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame {

    public Window() {
        setTitle("Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancel");
        JPanel jPanel = new JPanel(new GridLayout(1,2));
        jPanel.add(ok);
        jPanel.add(cancel);
        add(jPanel, BorderLayout.SOUTH);
        JTextArea pole = new JTextArea();
        add(pole, BorderLayout.NORTH);
        pole.setEditable(false);
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame win = new JFrame();
                win.setTitle("Window2");
                JButton save = new JButton("save");
                win.setBounds(400,400,400,400);
                JTextField text = new JTextField();
                win.add(save, BorderLayout.SOUTH);
                win.add(text, BorderLayout.NORTH);
                win.setVisible(true);
                save.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        pole.setText("");
                        StringBuilder s = new StringBuilder(text.getText());
                        for (int i = 0; i < s.length(); i++) {
                            if (s.charAt(i) == ' ') {
                                pole.setText(pole.getText() + "\n");
                            } else {
                                pole.setText(pole.getText() + s.charAt(i));
                            }
                        }
                        win.dispose();
                    }
                });
            }
        });
        setVisible(true);
    }
}
