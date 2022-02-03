package Pratikum;

public class Company {

    String nama     ;
    String cabang   ; // tak terhingga
    String karyawan ; // tak terhingga
    String saham    ;
    int jumlahCabang ;
    int jumlahKaryawan ;

    // constructor pertama (normal)
    Company (String nama, int jumlahCabang, int jumlahKaryawan, String saham){
        this.nama           = nama ;
        this.jumlahCabang   = jumlahCabang;
        this.jumlahKaryawan = jumlahKaryawan ;
        this.saham          = saham ;

        System.out.println("Nama Perusahaan\t: "+ nama);
        System.out.println("Jumlah Cabang\t: "+ jumlahCabang);
        System.out.println("Jumlah Karyawan\t: "+ jumlahKaryawan);
        System.out.println("Harga Saham\t: "+ saham);
    }

    // constructor kedua (Gojek) jumlah karyawan
    Company (String nama, int jumlahCabang, String karyawan, String saham){
        this.nama           = nama ;
        this.jumlahCabang   = jumlahCabang;
        this.karyawan       = karyawan ;
        this.saham          = saham ;

        System.out.println("Nama Perusahaan\t: "+ nama);
        System.out.println("Jumlah Cabang\t: "+ jumlahCabang);
        System.out.println("Jumlah Karyawan\t: "+ karyawan);
        System.out.println("Harga Saham\t: "+ saham);
    }


    // constructor ketiga (Indomaret) jumlah cabang
    Company (String nama, String jumlahCabang, int jumlahKaryawan, String saham){
        this.nama           = nama ;
        this.cabang         = jumlahCabang;
        this.jumlahKaryawan = jumlahKaryawan ;
        this.saham          = saham ;

        System.out.println("Nama Perusahaan\t: "+ nama);
        System.out.println("Jumlah Cabang\t: "+ jumlahCabang);
        System.out.println("Jumlah Karyawan\t: "+ jumlahKaryawan);
        System.out.println("Harga Saham\t: "+ saham);
    }
    

    // constructor keempat (Kelontong) no saham
    Company (String nama, int jumlahCabang, int jumlahKaryawan){
        this.nama           = nama ;
        this.jumlahCabang   = jumlahCabang;
        this.jumlahKaryawan = jumlahKaryawan ;


        System.out.println("Nama Perusahaan\t: "+ nama);
        System.out.println("Jumlah Cabang\t: "+ jumlahCabang);
        System.out.println("Jumlah Karyawan\t: "+ jumlahKaryawan);

    }

    void line (){

        System.out.println("--------------------------------------");
        System.out.println();
    }
}
