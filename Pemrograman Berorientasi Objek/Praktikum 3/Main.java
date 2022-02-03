package Pratikum;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Perusahaan Pertama: ---------------");
        Company perusahaan1 = new Company("Juara", 5, 75, "30000/lembar") ;
        perusahaan1.line();
        // perusahaan1.display("Juara", 5, 75, "30000");
        

        System.out.println("Perusahaan Kedua: ---------------");
        Tokopedia perusahaan2 = new Tokopedia("Tokopedia", 1, 350, "8500/lembar") ;
        // perusahaan1.display("Juara", 5, 75, "30000");
        perusahaan2.line();

        System.out.println("Perusahaan Ketiga: ---------------");
        Gojek perusahaan3  = new Gojek("Gojek", 25 , "Tak terhingga", "75000/lembar"); 
        // perusahaan2.display("Gojek", 25 , "Tak terhingga", "75000");
        perusahaan3.line();

        System.out.println("Perusahaan Keempat: ---------------");
        Indomaret perusahaan4 = new Indomaret("Indomaret", "Tak Terhingga Sampai Pelosok Negeri", 2500, "2000/lembar") ;
        perusahaan4.line();

        System.out.println("Perusahaan Kelima: ---------------");
        Kelontong perusahaan5 = new Kelontong("Toko Kelontong", 1, 5) ;
        perusahaan5.line();


    }
}
