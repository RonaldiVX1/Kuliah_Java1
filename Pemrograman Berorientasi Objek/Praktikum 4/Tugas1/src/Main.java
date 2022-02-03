
abstract class BangunRuang{
     abstract double getLuasPermukaan();
     abstract double getVolume();
}

class Balok extends BangunRuang{
    int panjang,lebar,tinggi;

    Balok (int Panjang, int Lebar, int Tinggi){
        this.panjang= Panjang;
        this.lebar  = Lebar;
        this.tinggi = Tinggi;
    }

    @Override
    public double getLuasPermukaan() {
        return 2*(panjang*lebar+panjang*tinggi+lebar*tinggi);
    }

    @Override
    public double getVolume() {
        return panjang*lebar*tinggi;
    }

    void hasil(){
        System.out.printf("Bangun Ruang Balok\n\n" + "panjang\t: "+ panjang + "\nlebar\t: "+ lebar+"\ntinggi\t: "+ tinggi);
        System.out.println("\n\nLuas Permukaan\t:"+getLuasPermukaan()+"\nVolume\t\t\t:"+getVolume());

    }
}

class Tabung extends BangunRuang{
    int jari, tinggi;

    Tabung (int Jari, int Tinggi){
        this.jari   = Jari;
        this.tinggi = Tinggi;
    }

    @Override
    public double getLuasPermukaan() {

        return (2*3.14*jari*tinggi)+(2*3.14*jari*jari);
    }

    @Override
    public double getVolume() {

        return 3.14*jari*jari*tinggi;
    }

    void hasil(){

        System.out.println("Bangun Ruang Tabung\n");
        System.out.println("jari-jari\t: " + jari + "\n" + "tinggi\t\t: " + tinggi +"\n");
        System.out.println("Luas Permukaan\t: " + getLuasPermukaan() + "\nVolume\t\t\t: "+ getVolume());

    }
}


public class Main {

    public static void main(String[] args) {

    Balok a = new Balok(2,5,7);
    a.hasil();
    System.out.println("----------------------------------------------");
    Tabung b= new Tabung(10,12);
    b.hasil();

    }
}
