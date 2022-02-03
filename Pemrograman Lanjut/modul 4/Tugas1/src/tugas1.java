public class tugas1 {
    public static void main(String[] args) {
        getPanjang();
        getLebar();

        getLuas(getPanjang(), getLebar());
        Hasil();

    }

    private static void Hasil() {
        System.out.println(getLuas(getPanjang(), getLebar()));
    }

    private static int getLuas(int panjang, int lebar) {
        int luas = panjang * lebar;
        return luas;
    }

    public static int getLebar() {
        int lebar = 2;
        return lebar;
    }

    public static int getPanjang() {
        int panjang = 5;
        return panjang;
    }


}

