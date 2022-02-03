package Pratikum.Child;

import Pratikum.Parent.Kendaraan;

public class BMX extends Kendaraan {
    public BMX (String jumlahKursi, int jumlahRoda){
        super(jumlahKursi,jumlahRoda) ;

        System.out.println("Nama kendaraan = BMX");
        System.out.println("Jumlah Kursi   = "+ jumlahKursi);
        System.out.println("Jumlah Roda    = "+ jumlahRoda);
    }

}
