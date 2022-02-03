

public class hasilBalok {
    int panjang = 10 ;
    int lebar   = 10 ;
    int tinggi  = 10 ;


    void setPanjang(int panjang){
        this.panjang = panjang ;
    }

    void setLebar(int lebar){
        this.lebar = lebar ;
    }

    void setTinggi(int tinggi){
        this.tinggi = tinggi ;
    }


    int getPanjang(){
        return panjang;
    }

    int getLebar(){
        return lebar ;
    }

    int getTinggi(){
        return tinggi;
    }

    void total(){
        Perhitungan ph = new Perhitungan();
        //System.out.println("Hasil Luas Balok : "+ ph.luas(panjang, lebar, tinggi));
        //System.out.println("Hasil volume Balok : "+ ph.volume(panjang, lebar, tinggi));
		System.out.println("\nIni adalah method total dari class hasilBalok ");
    }


}
