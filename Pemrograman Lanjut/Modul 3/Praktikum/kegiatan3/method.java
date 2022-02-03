public class method {

    double input = 120 ;

    double b = Math.cbrt(input) ; // akar pangkat 3 >>>>> 5

    double c = Math.round(b) ; // angka dibulatkan >>>>> 5

    double d = c * c * c ; // perhitungan 

    void hasil(){

        if (d == input){
            System.out.println("angka sama");
        }

        else {
            System.out.println("angka tidak sama");
        }
    }

}


