import java.util.Scanner;
import java.util.Arrays;

public class tugas2 {
    static Scanner input = new Scanner(System.in);
    static int data[] = {-80, -50, 0, 40, 0, -30, 90, 70, 89, 50, -55};
    static int urut ;

    public static void main(String[] args) {
        urut();
        cari();

    }

    public static void urut() {
        Arrays.sort(data);
        System.out.printf("Data setelah diurutkan : %s", Arrays.toString(data));

//        System.out.println(String.valueOf(data[2]));
//        System.out.println(data[2] + 30);

    }

    public static void cari() {
        System.out.print("\nmasukan angka yang ingin dicari : ");
        int caridata = input.nextInt();
        int tempdata = Arrays.binarySearch(data, caridata);

        if (tempdata < 0 ){
            System.out.println("Angka tidak ada");
        }else {
            System.out.println("angka " + caridata + " berada di index " + (tempdata+1));
        }

    }

}
