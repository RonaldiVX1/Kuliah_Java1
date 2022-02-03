
public class Perhitungan extends balok{
    int luas ;
    int volume ;

    public int volume(int panjang, int lebar, int tinggi){

        volume = panjang * lebar * tinggi;
        return volume ;
    }
    
    public int luas(int panjang, int lebar, int tinggi){

        luas = 2*(panjang + lebar + tinggi);
        return luas;
    }
}

