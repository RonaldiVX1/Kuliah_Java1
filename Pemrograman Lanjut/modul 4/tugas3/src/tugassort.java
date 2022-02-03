import java.util.Scanner;//iscan

public class tugassort {

    static int Jumlah_Data;
    static int[] Data;
    static int Tempdata;
    static int i = 0;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        jumlahData();
        arrayData();
        Urutan();

    }

    public static void jumlahData() {//psv
        System.out.print("Masukkan Jumlah Data = ");
        Jumlah_Data = input.nextInt();
        Data = new int[Jumlah_Data];
        System.out.println(" ");
    }

    public static void arrayData() {//psv
        while (i < Jumlah_Data) {
            System.out.print("Masukkan data ke-" + (i + 1) + " = ");
            Tempdata = input.nextInt();
            Data[i] = Tempdata;
            i++;
        }
    }


    public static void Urutan() {
        /* Pengurutan dengan cara Bubble Sort */
        System.out.println(" ");
        System.out.print("Hasil : ");
        int urutan;
        for (int a = 0; a < Jumlah_Data; a++) {
            for (int b = a; b < Jumlah_Data; b++) {
                if (Data[b] < Data[a]) {
                    urutan = Data[a];
                    Data[a] = Data[b];
                    Data[b] = urutan;
                }
            }
            System.out.print(Data[a] + ", ");
        }
        System.out.println(" ");
    }

}

