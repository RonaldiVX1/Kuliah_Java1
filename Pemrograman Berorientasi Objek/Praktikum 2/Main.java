import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
		
        int Jari  ;
		double Panjang;


		
		
		
		
		do{
			
			System.out.println("1.Konversi Panjang");
			System.out.println("2.Kalkulator Luas dan Keliling Lingkaran");
			System.out.println("3.Exit") ;
			System.out.print("Pilih : ");
			char Menu ;
			Menu = Input.next().charAt(0);
			
			switch(Menu){
				case '1' :
				
					System.out.print("Masukan Panjang : ");
					Panjang = Input.nextDouble() ;
					
					
				Konversi A = new Konversi();
				
				System.out.println("Konversi KM \t: "+A.toKM(Panjang));
				System.out.println("Konversi HM \t: "+A.toHM(Panjang));
				System.out.println("Konversi DAM \t: "+A.toDAM(Panjang));
				System.out.println("Konversi M \t: "+A.toM(Panjang));
				System.out.println("Konversi DM \t: "+A.toDM(Panjang));
				System.out.println("Konversi CM \t: "+A.toCM(Panjang));
				System.out.println("Konversi MM \t: "+A.toMM(Panjang));
				
				
					break ;
				case '2' :
				
					System.out.print("Masukan jari-jari : ");
					Jari = Input.nextInt();
					
					System.out.println("Pilih Penghitungan ");
					System.out.println("1. Keliling ");
					System.out.println("2. Luas ");
					System.out.print("Pilih :");
					char MenuLingkaran ;
					MenuLingkaran = Input.next().charAt(0);
					
					
					Lingkaran B = new Lingkaran();	
					
					switch(MenuLingkaran){
						
						
						
					case '1' :
					
						System.out.println("Hasil Keliling : "+B.ToKeliling(Jari));
						break ;
					case '2' :
						
						System.out.println("Hasil Luas: " +B.ToLuas(Jari));
					
					break; 
					}
	
				
				break ;
				case '3' :
				
					return;
				
				
				
				
				
			}
			
			
			
			
			
		}while(9>0) ;
			
			
		

			
	}
}