package com.company;

import java.util.Random;

public class Soal {
}
class MethodSoal{
    static int methodSoal_1(int jumlah, int x1, int x2){
        for(int i=1;i<=jumlah;i++){
            if(i%2!=0){
                x1+=2;
            }
            if(i%2==0){
                x2*=2;
            }
        }
        if(jumlah%2==0){
            return x2*2;
        }else{
            return x1+2;
        }
    }
    static int methodSoal_2(int x1, int x2){
        return x1*(x1+x2);
    }
    static int methodSoal_3(int jumlahOrang){
        int jumlahSalaman=0;
        for(int i = (jumlahOrang-1);i>0;i--){
            jumlahSalaman+=i;
        }
        return jumlahSalaman;
    }
    static int methodSoal_4(int randomNumber){
        int totalJumlah=0;
        int totalTemp=0;
        String stringRandomNumber=String.valueOf(randomNumber);
        for(int i=0;i<4;i++){
            if(stringRandomNumber.charAt(i)=='6'){
                totalTemp++;
            }else if(stringRandomNumber.charAt(i)=='8'){
                totalTemp+=2;
            }else if(stringRandomNumber.charAt(i)=='9'){
                totalTemp++;
            }else if(stringRandomNumber.charAt(i)=='0'){
                totalTemp++;
            }
        }
        return totalJumlah+=totalTemp;
    }
    static int methodSoal_5(int jumlah, int x1, int tambah){
        for(int i=1;i<=jumlah+1;i++){
            x1+=tambah;
            tambah+=2;
        }
        return x1;
    }
    static int methodSoal_6(int jumlah, int x1){
        for(int i=3;i<=(jumlah+4);i++){
            if(i%2==1){
                x1+=2;
            }else if(i%2==0){
                x1*=2;
            }
        }
        return x1;
    }
    static int methodSoal_7(int jumlah, int x1, int tambah){
        for(int i=1;i<=jumlah+1;i++){
            x1+=tambah;
            tambah*=2;
        }
        return x1;
    }
    static int methodSoal_8(int x1, int n){
        return x1*n;
    }
    static int methodSoal_9(int adik){
        return adik;
    }
    static int methodSoal_10(int x1, int x2){
        return (x1*x1)+(x2*x2);
    }
}
class TextSoal{
    static String textSoal_1(int jumlah, int x1, int x2){
        String deretAngka = x1+" "+x2+" ";
        for(int i=1;i<=jumlah+1;i++){
            if(i%2!=0){
                x1+=2;
                deretAngka+=x1+" ";
            }
            if(i%2==0){
                x2*=2;
                deretAngka+=x2+" ";
            }
        }
        return String.format("""
                        Diketahui deret angka berikut\n\n%s K\n\nMaka berapakah nilai K ?\n
                        """,
                deretAngka);
    }
    static String textSoal_2(int jumlah,int x1,int x2){
        Random random = new Random();
        int contoh1= random.nextInt(4)+2;
        int contoh2= random.nextInt(4)+2;
        String deretAngka=contoh1+" + "+contoh2+" = "+contoh1*(contoh1+contoh2)+"\n";

        for(int i=0;i<jumlah;i++){
            contoh1= random.nextInt(4)+2;
            contoh2= random.nextInt(4)+2;
            deretAngka+=contoh1+" + "+contoh2+" = "+contoh1*(contoh1+contoh2)+"\n";
        }
        deretAngka+=x1+" + "+x2+" = K\n";

        return String.format("""
                Kalo misalkan ada pola penjumlahan kayak gini :\n\n%s\nNilai K berapa hayooo ?
                """,deretAngka);
    }
    static String textSoal_3(int jumlahOrang){
        return String.format("""
                Misalkan ada suatu acara. Di acara tersebut, 
                akan ada %d jumlah orang.Nah setiap orang akan
                bersalaman dengan semua orang sebanyak SATU
                kali saja. Kalau begitu, ada berapa kali salaman 
                yang terjadi ?""",jumlahOrang);
    }
    static String textSoal_4(int randomNumber){
        Random random = new Random();

        int contoh_1=random.nextInt(8888)+1000;
        int contoh_2=random.nextInt(8888)+1000;
        int contoh_3=random.nextInt(8888)+1000;
        int contoh_4=random.nextInt(8888)+1000;

        String contohAngka = String.format(
                "%d = %d\n%d = %d\n%d = %d\n%d = %d\n%d = K",contoh_1,
                MethodSoal.methodSoal_4(contoh_1),
                contoh_2,
                MethodSoal.methodSoal_4(contoh_2),
                contoh_3,
                MethodSoal.methodSoal_4(contoh_3),
                contoh_4,
                MethodSoal.methodSoal_4(contoh_4),
                randomNumber
        );

        return String.format(
                "Kalo misalkan ada angka seperti ini\n\n%s\n\nNilai K berapa hayooo ?",contohAngka
        );
    }
    static String textSoal_5(int jumlah, int x1, int tambah){
        String deretAngka = Integer.toString(x1)+" ";
        for(int i=1;i<=jumlah;i++){
            x1+=tambah;
            deretAngka+= x1 + " ";
            tambah+=2;
        }
        return String.format("""
                Ada angka-angka kaya gini
                
                %s X
                
                Nah sekarang, yuk cari nilai X !""",deretAngka);
    }
    static String textSoal_6(int jumlah, int x1){
        String deretAngka=x1+" ";
        for(int i=3;i<=(jumlah+3);i++){
            if(i%2==1){
                x1+=2;
                deretAngka+=x1+" ";
            }else if(i%2==0){
                x1*=2;
                deretAngka+=x1+" ";
            }
        }
        return String.format("""
                Nah kali ini ada angka dengan susunan kayak gini
                
                %s P
                
                Lalu P nilainya berapa dong ?""",deretAngka);
    }
    static String textSoal_7(int jumlah, int x1, int tambah){
        String deretAngka = x1+" ";
        for(int i=1;i<=jumlah;i++){
            x1+=tambah;
            tambah*=2;
            deretAngka+=x1+" ";
        }
        return String.format("""
                Kalo ada deretan kaya gini 
                
                %s R
                
                Nah berarti nilai R berapa yaaa ?""",deretAngka);
    }
    static String textSoal_8(int jumlah, int x1, int n){
        String deretAngka=String.format("Hari 1 = %d permen\n",x1);
        int param=x1;

        for(int i=1;i<=jumlah;i++){
            deretAngka+=String.format("Hari %d = %d permen\n",i+1,x1+=param);
        }

        return String.format("""
                Sebuah mesin dalam pabrik permen dalam 
                jenjang berikut
                
                %s
                Maka jumlah permen yang yang diproduksi 
                pada hari ke %d adalah ?""",deretAngka,n);
    }
    static String textSoal_9(int perempuan, int adik){
        return String.format("""
                Dalam sebuah keluarga, terdapat %d anak perempuan
                yang masing - masing memiliki %d adik laki - laki
                
                Maka berapakah jumlah anak laki - laki
                dalam keluarga ?""",perempuan,adik);
    }
    static String textSoal_10(int x1, int x2, int x3, int x4){
        String deretAngka = String.format("""
                (%d) (%d) (%d)
                (%d) (%d) (%d)
                (%d) (%d) (K)"""
                ,x1+=2,x2+=2,(x1*x1)+(x2*x2),
                x3,x4,(x2*x2)+(x3*x3),
                x1-=2,x2-=2);

        return String.format("""
                %s
                
                Nilai dari K adalah""",deretAngka);
    }
}