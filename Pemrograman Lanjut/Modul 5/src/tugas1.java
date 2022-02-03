import java.util.Scanner;

public class tugas1 {
    static int[] data = {-80, -50, 0, 40, 0, -30, 90, 70, 89, 50, -55};
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        urut();
        cari();


    }

    public static void urut() {
        int tempurut;
        System.out.print("Urutan Data : ");
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j < data.length; j++) {
                if (data[j] < data[i]) {
                    tempurut = data[i];
                    data[i] = data[j];
                    data[j] = tempurut;
                }
            }
            System.out.print(data[i] + ", ");
        }
        System.out.println("");
    }


    public static void cari() {
        System.out.printf("masukan angka yang ingin dicari : ");
        int caridata = input.nextInt();
        int hasil = 0;
        boolean berhasil = false;

        for (int c = 0; c < data.length; c++) {
            if (caridata == data[c]) {
                System.out.println("Angka " + caridata + " berada di Index array " + (c + 1));
                berhasil = true;
            }
        }

        if (!berhasil) {
            System.out.printf("data tidak ditemukan");
        }
    }
}
