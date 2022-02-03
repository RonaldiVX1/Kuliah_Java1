package Pratikum.Child;

import Pratikum.Parent.Kendaraan;

public class Toyota extends Kendaraan {
    public Toyota (String jenisMesin, String jumlahKursi, int jumlahRoda){
        super(jenisMesin,jumlahKursi,jumlahRoda) ;

        System.out.println("Nama kendaraan = Toyota");
        System.out.println("Jenis Mesin    = "+ jenisMesin);
        System.out.println("Jumlah Kursi   = "+ jumlahKursi);
        System.out.println("Jumlah Roda    = "+ jumlahRoda); 
    }
}

