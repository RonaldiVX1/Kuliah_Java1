package sample;

public class JadwalKuliah {

    String mataKuliah;
    String hari;
    String jam;
    String GKB;
    String ruangan;
    String dosen;


    public JadwalKuliah(){

        this.hari = "";
        this.mataKuliah = "";
        this.jam = "";
        this.GKB = "";
        this.ruangan = "";
        this.dosen = "";

    }

    public JadwalKuliah(String hari, String jam, String mataKuliah, String GKB, String ruangan, String dosen){

        this.hari = hari;
        this.mataKuliah = mataKuliah;
        this.jam = jam;
        this.GKB = GKB;
        this.ruangan = ruangan;
        this.dosen = dosen;

    }


    public String getMataKuliah() {
        return mataKuliah;
    }
    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getGKB() {
        return GKB;
    }

    public void setGKB(String GKB) {
        this.GKB = GKB;
    }

    public String  getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }










}
