package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinishPage extends JFrame {
    private JPanel finishPage;
    private JButton btnMainMenu;
    public JLabel labelNilai;
    private JLabel labelUcapan;
    private JButton btnRepeat;
    private JButton btnExit;

    //load nilai
    public int jumlahBenar;

    public FinishPage(String title){
        super(title);
        this.setSize(640,480);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setContentPane(finishPage);

        //preload
        setButtonSize(90,40);
        btnMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new MainMenu("MAIN MENU");
                jFrame.setVisible(true);
                dispose();
            }
        });
        btnRepeat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new MainSoal("SOAL");
                jFrame.setVisible(true);
                dispose();
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    //setter
    private void setButtonSize(int width,int height){
        this.btnExit.setPreferredSize(new Dimension((width/4),height));
        this.btnMainMenu.setPreferredSize(new Dimension(width,height));
        this.btnRepeat.setPreferredSize(new Dimension(width,height));
    }
}