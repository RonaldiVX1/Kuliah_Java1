import java.util.Scanner;

public class Tugas2{
	
	public static void main(String[] args) {
		Scanner Input = new Scanner(System.in);
	
		String NIM , tempNIM;
		String Kode = "10370311" ;
		
		
		
		do{
			
			System.out.print("Masukan NIM Anda : ");
			NIM = Input.nextLine();
			int n = NIM.length()  ;
			
			if (n<15){
				System.out.println("NIM Anda kurang dari 15 digit ");
			
			}
			else if (n>15) { 
			
				System.out.println("NIM Anda lebih dari 15 digit ");
			
			}
			else{
				tempNIM  = NIM.substring(4, 12);
				System.out.println(tempNIM) ;
				if(tempNIM.equals(Kode)){
			
					System.out.println("NIM "+NIM +" Adalah Mahasiswa Informatika ");
					break ;
				
				}else{
					
					System.out.println("NIM "+NIM +" Adalah BUKAN Mahasiswa INFORMATIKA ");
				}
			}
			
		} while (9>0) ;
  
   }
	 
}
