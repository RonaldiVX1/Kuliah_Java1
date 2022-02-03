import java.util.Scanner;

public class tugasHari {

    public static void main(String[] args) {

        konversi konverter = new konversi();
        konverter.convert();
        konverter.tampil();


    }


}

class konversi {
    Scanner in = new Scanner(System.in);
    int hari ;
    int bulan;
    int tahun;

    void convert() {
        System.out.print("Jumlah Hari : ");
        this.hari = in.nextInt();

        this.tahun = hari / 365 ;
        this.bulan = ((hari / 30) % 12);
        hari = (hari % 365) % 30;
    }


    void tampil() {

        System.out.println("konversi hari : " + tahun + " Tahun " + bulan + " Bulan " + hari + " Hari");

    }

}