public class rumus {
    int panjang = 2 ;
    int lebar   = 2;
    int tinggi  = 2 ;
    int luas;
    int volume ;

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
    
    // extract method membuat method baru
    public void perhitungan () {

        tampil();
    }

    // inline temp menyederhanakan
    public int luas (){    
        return luas = 2*(getLebar() + getPanjang() + getTinggi()) ; 
    }

    public int volume (){    
        return volume = getLebar() * getPanjang() * getTinggi() ; 
    }

    public void tampil (){
        System.out.println("Hasil dari luas adalah\t: "+luas());
        System.out.println("Hasil dari volume adalah: "+volume());
    }
}



