import java.util.Arrays;
import java.util.Scanner;

public class tugas3 {

    static Scanner input = new Scanner(System.in);
    static int data[] = {-80, -50, 0, 40, 0, -30, 90, 70, 89, 50, -55};

    public static void main(String[] args) {

        urut();
        rasio();

    }

    public static void urut() {
        Arrays.sort(data);
        System.out.printf("Data setelah diurutkan : %s", Arrays.toString(data));
        System.out.println("\n----------------------------------------------------");
    }


    public static void rasio() {
        double negatif = 0;
        double zero = 0;
        double positif = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0)
                negatif++;
            else if (data[i] == 0)
                zero++;
            else if (data[i] > 0)
                positif++;
        }

        System.out.println("\nPositif\t: " + positif / data.length);
        System.out.println("Zero\t: " + zero / data.length);
        System.out.println("Negatif\t: " + negatif / data.length);
    }


}
