import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Scanner;

public  class trial {
   static Scanner input = new Scanner(System.in);
   static ArrayList inNumber = new ArrayList();
   static ArrayList inString = new ArrayList();
   static String inputuser;
   static String loopuser;
   static boolean loop = true;

    public static void main(String[] args) {
        perulangan();
    }

    public static void perulangan(){

       while (loop){
           System.out.printf("masukan : ");
           inputuser = input.nextLine();

           if (isNumeric(inputuser)){
               inNumber.add(inputuser);
           }else {
               inString.add(inputuser);
           }

           System.out.printf("ulang? : ");
           loopuser = input.nextLine();
           if(loopuser.equals("Y")){
               loop = false;
           }

       }
        System.out.println(inString);
       System.out.println(inNumber);
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
