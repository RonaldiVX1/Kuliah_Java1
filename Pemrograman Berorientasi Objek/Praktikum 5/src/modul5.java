import java.io.*;
import java.util.*;


public class modul5 {
    static Scanner input = new Scanner(System.in);
    static int menu;
    static boolean loop = true;

    public static void main(String[] args) throws Exception {

        System.out.println("Daftar Rekap Nilai SMP SUKAMAJU");
        System.out.println("=================================");
        System.out.println("1.Membaca Rekap Nilai Terakhir");
        System.out.println("2.Menulis Rekap Nilai Siswa");
        System.out.println("3.Reset Data Rekap Nilai");
        System.out.println("4.Exit");

        menu();

    }

    public static void menu() throws Exception{

        do {
            System.out.println("\n-----------");
            System.out.printf("\nMasukan Menu : ");
            menu = input.next().charAt(0);
            input.nextLine();


            switch (menu) {
                default:
                    System.err.println("\nKesalahan dalam input menu\n");

                    menu();

                case '1':
                    String data;

                    File myFile = null;
                    try {
                        // membaca file
                        myFile = new File("RekapNilai.txt");
                        Scanner fileReader = new Scanner(myFile);

                        // cetak isi file
                        System.out.println("\nRekap Nilai -------------------");
                        while (fileReader.hasNextLine()) {
                            data = fileReader.nextLine();
                            System.out.println(data);
                        }

                    } catch (FileNotFoundException e) {
                        System.err.println("Error dengan pesan : Terjadi kesalahan file data tidak ada\n");
                        System.out.printf("");
                        System.out.printf("");
                        menu();
                    } finally {
                        System.out.println("\n");
                    }

                    break;

                case '2':
                    int n = 0;
                    System.out.printf("Masukan Jumlah data : ");
                    try {
                         n  = input.nextInt();

                    }catch (Exception e){
                        System.err.println("\n Error dengan pesan : data tidak valid");
                        System.out.printf("");
                        System.out.printf("");
                        menu();
                    }

                    RekapNilai a[] = new RekapNilai[n];
                    for (int i = 0; i < n; i++) {
                        a[i] = new RekapNilai();
                        try {
                            a[i].getNama();
                        }catch (Exception e){
                            System.err.printf(e.getMessage());
                            System.out.printf("");
                            System.out.printf("");
                            menu();
                        }

                        try {
                            a[i].getMatkul();
                        }catch (Exception e){
                            System.err.println(e.getMessage());
                            System.out.printf("");
                            System.out.printf("");
                            menu();
                        }
//                        a[i].getNilai();
                        try {
                            a[i].getNilai();
                        }catch (InputMismatchException e){
                            System.err.println(e.getMessage());
                            System.err.println("Error dengan pesan : Nilai yang anda masukan salah");
                            System.out.printf("");
                            System.out.printf("");
                            menu();
                        }
                    }
                    int j = 0;
                    do {
                        FileWriter fileWriter = new FileWriter("RekapNilai.txt", true); // menambahkan data
                        fileWriter.write("Nama\t\t: " + a[j].setNama() + "\n");
                        fileWriter.write("Mata Kuliah\t: " + a[j].setMatkul() + "\n");
                        fileWriter.write("Nilai\t\t: " + a[j].setNilai() + "\n");
                        fileWriter.write("\n");
                        fileWriter.close();
                        j++;
                    } while (j < n);

//                for (int j = 0; j < n; j++) {
//                    FileWriter fileWriter = new FileWriter("RekapNilai.txt");
//                    fileWriter.write("Nama\t\t: " + a[j].setNama()+"\n");
//                    fileWriter.write("Mata Kuliah\t: " + a[j].setMatkul()+"\n");
//                    fileWriter.write("Nilai\t\t: " + a[j].setNilai()+"\n");
//                    fileWriter.write(" ");
//                    fileWriter.close();
//                }

                    System.out.println("\nFile sudah ditulis!");
                    break;

                case '3':

                    FileWriter fileWriter = new FileWriter("RekapNilai.txt");
                    fileWriter.write("");
                    fileWriter.close();

                    System.out.println("");
                    System.out.println("------  Data berhasil dihapus ------");
                    break;
                case '4':
                    loop = false;


            }
        }while (loop);
    }
}



class RekapNilai {


    private int nilai;
    private String matkul;
    private String nama;


    public void getNilai() throws InputMismatchException {
        Integer var = null;
        System.out.printf("Masukan Nilai : ");
        Scanner input = new Scanner(System.in);
        this.nilai = input.nextInt();

        if (nilai < 0) {
            throw new InputMismatchException("\nError dengan pesan : Nilai tidak bisa minus");
        } else if (nilai > 100) {
            throw new InputMismatchException("\nError dengan pesan : Nilai tidak bisa lebih dari 100");
        }


    }



    public int setNilai() {
        return nilai;
    }

    public void getMatkul() throws Exception {
        System.out.printf("Masukan Mata Kuliah : ");
        Scanner input = new Scanner(System.in);
        this.matkul = input.nextLine();
        if (matkul == null) {
                throw new Exception("\nError dengan pesan : Mata Kuliah tidak Boleh Kosong\n");
            } else if (matkul.isBlank()) {
                throw new Exception("\nError dengan pesan : Mata Kuliah tidak boleh Kosong\n");
            }else if (isNumeric(matkul)) {
                throw new Exception("\nError dengan pesan : Mata Kuliah tidak boleh angka\n");
        }


    }

    public String setMatkul() {
        return matkul;
    }

    public void getNama() throws Exception {
        System.out.printf("\nMasukan Nama Siswa : ");
        Scanner input = new Scanner(System.in);
        this.nama = input.nextLine();

        if (nama == null) {
            throw new Exception("\nError dengan pesan : Nama tidak Boleh Kosong\n");
        } else if (nama.isBlank()) {
            throw new Exception("\nError dengan pesan : Nama tidak boleh Kosong\n");
        }else if (isNumeric(nama)) {
            throw new Exception("\nError dengan pesan : Nama tidak boleh angka\n");
        }

    }

    public String setNama() {
        return nama;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


}

