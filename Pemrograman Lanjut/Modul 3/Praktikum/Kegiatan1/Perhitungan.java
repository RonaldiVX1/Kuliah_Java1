
public class Perhitungan extends balok{
    int luas ;
    int volume ;

    public int volume(){
 
        return volume = getPanjang() * getLebar() * getTinggi();
    }
    
    public int luas(){

        return luas = 2*(panjang + lebar + tinggi);
    }
}

