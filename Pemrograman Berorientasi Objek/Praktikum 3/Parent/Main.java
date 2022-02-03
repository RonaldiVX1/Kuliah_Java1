package Pratikum.Parent;

import Pratikum.Child.BMX;
import Pratikum.Child.Toyota;

public class Main {
    public static void main(String[] args) {
        BMX     a1 = new BMX    ("1 Pengemudi", 2);
        a1.line ();
        Toyota  b1 = new Toyota ("Mesin 700cc Transmisi Otomatis ","1 Pengemudi & 3 Penumpang", 4) ;
        b1.line ();
    }
    

}
