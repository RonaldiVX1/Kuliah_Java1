package Pratikum.Parent;

public class Kendaraan {
    public String mesin ;
    public String kursi;
    public int roda ;

        // Jumlah parameter beda
        // public dan protected bisa diakses di child
    public Kendaraan (String jenisMesin, String jumlahKursi, int jumlahRoda){
        this.mesin = jenisMesin ; // Pembeda
        this.kursi = jumlahKursi;
        this.roda  = jumlahRoda ;

    }
        // public dan protected bisa diakses di child
    protected Kendaraan (String jumlahKursi, int jumlahRoda){

        this.kursi = jumlahKursi;
        this.roda  = jumlahRoda ;
    }


    public void line (){
        System.out.println("--------------------------");
    }

}
