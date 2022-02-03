import java.io.*;
import java.util.*;
import java.util.regex.*;


/**
 * @author Ronaldi_
 * @version 16.0.1
 */


public class Modul {

    static ArrayList inNumber = new ArrayList(); // array untuk menyimpan data berupa angka
    static ArrayList inString = new ArrayList(); // array untuk menyimpan data berupa String
    static String inputdata; // inputan user
    static String userloop; // input yang digunakan user untuk melakukan perulangan
    static boolean loop = true; // boolean untuk perulangan
    static Scanner input = new Scanner(System.in); // deklarasi scanner

    /**
     * Program yang berfungsi untuk menyimpan inputan dalam user kedalam array
     * Setelah itu array ditulis ke dalam file dan ditampilkan.
     *
     * @param args tidak digunakan
     * @return nothing ~
     */


    public static void main(String[] args) {

        //pemanggilan method ke main untuk dieksekusi
        setdata();
        getdata();
    }

    /**
     * method ini berfungsi untuk melakukan perulangan, input data, dan menulis inputan user kedalam File
     *
     * @return nothing ~
     * @throws Exception kalau inputan user tidak sesuai
     * @Exception IOException kalau terjadi error pada file
     * @Exception Exception jika input salah
     */

    public static void setdata() {

        while (loop) {
            try {
                System.out.printf("Masukan Data : ");
                inputdata = input.nextLine(); //input data

                // percabangan untuk melakukan pengecekan terhadap inputan user
                if (CheckNumber(inputdata)) {

                    inNumber.add(inputdata);
                    //menulis data ke dalam file notepad.txt
                    try {
                        FileWriter numberdata = new FileWriter("NumberData.txt", true);
                        if (inNumber.isEmpty()) {
                            numberdata.close();
                        } else {
                            numberdata.write(inNumber + "\n");
                            numberdata.close();
                        }
                        // menghapus isi array
                        inNumber.clear();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                } else if (StringContainsNumber(inputdata)) {
                    // pengengecekan jika input user terdapat String dan angka
                    System.out.println("Data yang anda masukan mengandung String dan Angka ");
                } else if (inputdata.isBlank()) {
                    // pengecekan jika inputan user kosong
                    System.out.println("Data tidak boleh kosong !!");
                } else {
                    inString.add(inputdata);
                }
            } catch (Exception e) {
                System.out.println("Error dengan pesan : " + e.getMessage());
            }


            //menulis data ke dalam file notepad.txt
            try {
                FileWriter stringdata = new FileWriter("StringData.txt", true);
                if (inString.isEmpty()) {
                    stringdata.close();
                } else {
                    stringdata.write(inString + "\n");
                    stringdata.close();
                }
                // menghapus isi array
                inString.clear();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            looping();
        }
    }

    /**
     * method yang digunakan untuk user menentukan apakah menambah data atau tidak (looping)
     *
     * @return nothing
     * @throws Exception jika input salah
     */

    public static void looping() {
        System.out.printf("Masukan data lagi? (Y/N) : ");

        try {
            userloop = input.nextLine(); // input untuk perulangan

            // percabangan untuk mengecek inputan user untuk melakukan looping
            if (userloop.equals("Y")) {
                loop = true;
            } else if (userloop.equals("N")) {
                loop = false;
            } else {
                throw new Exception("Masukan anda salah!!");
            }
        } catch (Exception e) {
            System.out.println("error dengan pesan : " + e.getMessage());
            looping();
        }


    }

    /**
     * method yang digunakan untuk membaca data dari File
     *
     * @Exception FileNotFoundException jika file tidak ditemukan maka akan terjadi error
     * @greturn nothing ~
     */

    public static void getdata() {
        try {
            // membaca file
            File readAngka = new File("NumberData.txt");
            Scanner Scandata = new Scanner(readAngka);

            System.out.println("Data Angka : ======================= ");

            // cetak isi file
            while (Scandata.hasNextLine()) {
                String data = Scandata.nextLine();
                System.out.println(data);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        }


        try {
            // membaca file
            File readString = new File("StringData.txt");
            Scanner Scandata = new Scanner(readString);

            System.out.println("\nData String: ======================= ");

            // cetak isi file
            while (Scandata.hasNextLine()) {
                String data = Scandata.nextLine();
                System.out.println(data);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        }
    }

    /**
     * Method ini digunakan untuk merubah String menjadi double
     *
     * @param string digunakan untuk diubah menjadi double
     * @return false = jika String tidak berupa angka
     */

    public static boolean CheckNumber(String string) {

        if (string == null) {
            return false;
        }

        // exception untuk merubah String menjadi double
        try {
            double d = Double.parseDouble(string);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    /**
     * method digunakan untuk mencari apakah di dalam parameter String terdapat pola angka atau tidak.
     *
     * @param dataPembanding adalah inputan user yang digunakan untuk mencari pola angka
     * @return false = jika di String data tidak ditemukan pola angka (0-9)
     */


    public static boolean StringContainsNumber(String dataPembanding) {

        Pattern angka = Pattern.compile("[0-9]"); // pola angka 0-9
        Matcher data = angka.matcher(dataPembanding); // mencocokan dataPembanding dengan pola

        return data.find(); // mengembalikan nilai dari data
    }
}




