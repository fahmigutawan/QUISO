package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class MainSoal extends JFrame{
    private JPanel mainSoal;
    private JProgressBar progressBar;
    private JTextField jawabanUser;
    private JButton btnNext;
    private JButton btnKembali;
    private JTextArea textSoal;

    private int jumlahSoal;
    private int progresSoal=0;
    private int jawabanFinal;
    public static int jumlahBenar;
    private int maxSoal;
    private ArrayList arrRandomNumber = new ArrayList();
    final Parameter param = new Parameter();

    public MainSoal(String title){
        super(title);
        this.setSize(640,480);
        this.setResizable(false);
        this.setContentPane(mainSoal);
        this.setLocationRelativeTo(null);

        //preload
        jawabanUser.setText("");
        textSoal.setEditable(false);
        setButtonSize(50,32);
        setMaxSoal(10);
        setJumlahSoal(8);
        setArrRandomNumber(arrRandomNumber(getJumlahSoal()));
        this.progressBar.setMinimum(0);
        this.progressBar.setMaximum(getJumlahSoal());

        //set soal dan jawaban pertama
        resetJawabanUser();
        setProgresSoal(1);
        setProgressBar(getProgresSoal());
        setTextSoal(getTextSoal((int)getArrRandomNumber().get(getProgresSoal()-1)));
        setJawabanFinal(getJawabanSoal((int)getArrRandomNumber().get(getProgresSoal()-1)));

        //action
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!jawabanUser.getText().equals("")){
                    setProgresSoal(1);
                    //cek benar soal sebelumnya
                    if(getJawabanUser().equals(Integer.toString(getJawabanFinal()))){
                        setJumlahBenar(1);
                    }

                    //cek jumlah soal, jika sudah max maka akan ke nilai
                    if(getProgresSoal()==getJumlahSoal()){
                        FinishPage finishPage = new FinishPage("FINISH");
                        finishPage.labelNilai.setText(String.valueOf((double)(getJumlahBenar()*(100f/8))));
                        finishPage.setVisible(true);
                        dispose();
                    }else{
                        //set soal selanjutnya
                        setTextSoal(getTextSoal((int)getArrRandomNumber().get(getProgresSoal())));

                        //set jawaban selanjutnya
                        setJawabanFinal(getJawabanSoal((int)getArrRandomNumber().get(getProgresSoal())));

                        setProgressBar(getProgresSoal());
                        //reset jawaban
                        resetJawabanUser();
                        System.out.println(getJumlahBenar());
                    }
                }else{
                    JOptionPane.showMessageDialog(getParent(),"JAWABAN ANDA MASIH KOSONG !","TUNGGU DULU",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setProgresSoal(0);
                setJumlahSoal(0);
                setProgressBar(0);
                jumlahBenar=0;
                JFrame jFrame = new MainMenu("QUISO");
                jFrame.setVisible(true);
                dispose();
            }
        });
    }

    //setter
    public void setButtonSize(int width,int height){
        this.btnNext.setPreferredSize(new Dimension(width,height));
        this.btnKembali.setPreferredSize(new Dimension((width/2),height));
        this.jawabanUser.setPreferredSize(new Dimension((width*2),height));
        this.jawabanUser.setCaretColor(Color.WHITE);
    }
    public void setJumlahSoal(int jumlahSoal){
        this.jumlahSoal = jumlahSoal+1;
    } //harus dipanggil pertama kali
    public void setProgresSoal(int pertambahanProgres){
        this.progresSoal+=pertambahanProgres;
    }
    public void setArrRandomNumber(ArrayList arrRandomNumber){
        this.arrRandomNumber = arrRandomNumber;
    }
    public void setTextSoal(String textSoal){
        this.textSoal.setText(textSoal);
    }
    public void setJawabanFinal(int jawabanSoal){
        this.jawabanFinal=jawabanSoal;
    }
    public void setProgressBar(int progressBar){
        this.progressBar.setValue(progressBar);
    }
    public void setJumlahBenar(int tambahBenar){
        this.jumlahBenar+=tambahBenar;
    }
    public void setMaxSoal(int maxSoal){
        this.maxSoal = maxSoal;
    }

    //getter
    public int getJumlahSoal(){
        return this.jumlahSoal;
    }
    public int getProgresSoal(){
        return this.progresSoal;
    }
    public ArrayList getArrRandomNumber(){
        return this.arrRandomNumber;
    }
    private String getTextSoal(int nomor){
        if(nomor==1){
            return TextSoal.textSoal_1(param.soal1_jumlah,param.soal1_x1,param.soal1_x2);
        }else if(nomor==2){
            return TextSoal.textSoal_2(param.soal2_jumlah,param.soal2_x1,param.soal2_x2);
        }else if(nomor==3){
            return TextSoal.textSoal_3(param.soal3_jumlahOrang);
        }else if(nomor==4){
            return TextSoal.textSoal_4(param.soal4_randomNumber);
        }else if(nomor==5){
            return TextSoal.textSoal_5(param.soal5_jumlah,param.soal5_x1,param.soal5_tambah);
        }else if(nomor==6){
            return TextSoal.textSoal_6(param.soal6_jumlah,param.soal6_x1);
        }else if(nomor==7){
            return TextSoal.textSoal_7(param.soal7_jumlah,param.soal7_x1,param.soal7_tambah);
        }else if(nomor==8){
            return TextSoal.textSoal_8(param.soal8_jumlah,param.soal8_x1,param.soal8_n);
        }else if(nomor==9){
            return TextSoal.textSoal_9(param.soal9_perempuan,param.soal9_adik);
        }else{
            return TextSoal.textSoal_10(param.soal10_x1,param.soal10_x2,param.soal10_x3,param.soal10_x4);
        }
    }
    private int getJawabanSoal(int nomor){
        if(nomor==1){
            return MethodSoal.methodSoal_1(param.soal1_jumlah,param.soal1_x1,param.soal1_x2);
        }else if(nomor==2){
            return MethodSoal.methodSoal_2(param.soal2_x1,param.soal2_x2);
        }else if(nomor==3){
            return MethodSoal.methodSoal_3(param.soal3_jumlahOrang);
        }else if(nomor==4){
            return MethodSoal.methodSoal_4(param.soal4_randomNumber);
        }else if(nomor==5){
            return MethodSoal.methodSoal_5(param.soal5_jumlah,param.soal5_x1,param.soal5_tambah);
        }else if(nomor==6){
            return MethodSoal.methodSoal_6(param.soal6_jumlah,param.soal6_x1);
        }else if(nomor==7){
            return MethodSoal.methodSoal_7(param.soal7_jumlah,param.soal7_x1,param.soal7_tambah);
        }else if(nomor==8){
            return MethodSoal.methodSoal_8(param.soal8_x1,param.soal8_n);
        }else if(nomor==9){
            return MethodSoal.methodSoal_9(param.soal9_adik);
        }else{
            return MethodSoal.methodSoal_10(param.soal10_x1,param.soal10_x2);
        }
    }
    private int getJawabanFinal(){
        return this.jawabanFinal;
    }
    public int getJumlahBenar(){
        return this.jumlahBenar;
    }
    public String getJawabanUser(){
        return this.jawabanUser.getText().trim();
    }
    public int getMaxSoal(){
        return this.maxSoal;
    }

    //unique method
    public int randomNumber(){
        Random random = new Random();
        return random.nextInt(getMaxSoal());
    }
    public ArrayList arrRandomNumber(int jumlahSoal){
        ArrayList arrRandomNumberSoal = new ArrayList<Integer>();
        int angka = randomNumber();
        for(int i=1;i<=jumlahSoal;i++){
            while(arrRandomNumberSoal.contains(angka)){
                angka=randomNumber();
            }
            arrRandomNumberSoal.add(angka);
        }
        return arrRandomNumberSoal;
    }
    public void resetJawabanUser(){
        this.jawabanUser.setText("");
    }
}
//parameter soal
class Parameter{
    Random random = new Random();
    //soal1
    public int soal1_jumlah;
    public int soal1_x1;
    public int soal1_x2;

    //soal2
    public int soal2_jumlah;
    public int soal2_x1;
    public int soal2_x2;

    //soal3
    public int soal3_jumlahOrang;

    //soal4
    public int soal4_randomNumber;

    //soal 5
    public int soal5_jumlah;
    public int soal5_x1;
    public int soal5_tambah;

    //soal 6
    public int soal6_jumlah;
    public int soal6_x1;

    //soal 7
    public int soal7_jumlah;
    public int soal7_x1;
    public int soal7_tambah;

    //soal 8
    public int soal8_jumlah;
    public int soal8_x1;
    public int soal8_tambah;
    public int soal8_n;

    //soal 9
    public int soal9_perempuan;
    public int soal9_adik;

    // soal 10
    public int soal10_x1;
    public int soal10_x2;
    public int soal10_x3;
    public int soal10_x4;

    public Parameter(){
        this.soal1_jumlah =random.nextInt(3)+3;;
        this.soal1_x1 = random.nextInt(8)+2;
        this.soal1_x2 = random.nextInt(10)+2;
        this.soal2_jumlah = 2;
        this.soal2_x1 = random.nextInt(5)+2;
        this.soal2_x2 = random.nextInt(5)+2;
        this.soal3_jumlahOrang = random.nextInt(4)+3;
        this.soal4_randomNumber = random.nextInt(8888)+1000;
        this.soal5_jumlah=random.nextInt(2)+3;
        this.soal5_x1=random.nextInt(5)+2;
        this.soal5_tambah=random.nextInt(4)+2;
        this.soal6_jumlah=random.nextInt(2)+3;
        this.soal6_x1=random.nextInt(5)+3;
        this.soal7_jumlah=random.nextInt(2)+3;
        this.soal7_x1=random.nextInt(5)+2;
        this.soal7_tambah=random.nextInt(4)+1;
        this.soal8_jumlah=2;
        this.soal8_tambah=random.nextInt(10)+2;
        this.soal8_x1=random.nextInt(20)+4;
        this.soal8_n=random.nextInt(4)+4;
        this.soal9_perempuan=random.nextInt(6)+2;
        this.soal9_adik=random.nextInt(5)+2;
        this.soal10_x1=random.nextInt(8)+2;
        this.soal10_x2=random.nextInt(8)+2;
        this.soal10_x3=random.nextInt(8)+2;
        this.soal10_x4=random.nextInt(8)+2;
    }
}