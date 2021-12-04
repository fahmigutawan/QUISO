package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends  JFrame{
    private JPanel mainMenu;
    private JPanel subPanelMenu;
    private JButton btnStart;
    private JButton btnAbout;
    private JButton btnExit;
    private JPanel panelTitle;

    private String tentangKami;

    public MainMenu(String title){
        super(title);
        this.setSize(640,480);
        this.setResizable(false);
        this.setContentPane(mainMenu);
        this.setLocationRelativeTo(null);

        //preload
        setButtonSize(256,40);
        setTentangKami();

        //action
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new MainSoal("Soal");
                jFrame.setVisible(true);
                dispose();
            }
        });
        btnAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getParent(),getTentangKami(),"Tentang Kami",JOptionPane.PLAIN_MESSAGE);
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    private void setButtonSize(int width,int height){
        this.btnStart.setPreferredSize(new Dimension(width,height));
        this.btnAbout.setPreferredSize(new Dimension(width,height));
        this.btnExit.setPreferredSize(new Dimension((width/4),height));
    }
    private void setTentangKami(){
        this.tentangKami = """
                Aplikasi Quiso adalah sarana pembelajaran nalar dan logika bagi \"HAMPIR\" semua kalangan usia.
                                
                Aplikasi ini dibuat oleh KELOMPOK 5, untuk memenuhi tugas Mata Kuliah Pemrograman Dasar
                                
                CARA KERJA :
                1. Aplikasi akan pick random number
                2. Random number dicocokkan sehingga menampilkan soal yang sesuai
                3. Setiap jawaban benar, akan menambah poin
                                
                *Yang terakhir, terima kasih Pak Fais <3 <3 atas kuliah tanpa beban dan tegang sama sekali, kami jadi sangat mudah paham terhadap materi""";
    }
    private String getTentangKami(){
        return this.tentangKami;
    }
}
