

public class balok {
    int panjang = 5 ;
    int lebar   = 5 ;
    int tinggi  = 5 ;


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

    void hasil(){
        Perhitungan ph = new Perhitungan();
        System.out.println("Hasil Luas Balok : "+ ph.luas());
        System.out.println("Hasil volume Balok : "+ ph.volume());
    }


}
