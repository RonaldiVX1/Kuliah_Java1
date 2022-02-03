import java.util.Scanner;
public class Fungsi {
    Scanner Input = new Scanner(System.in); 
	
	String noHP ,tempnoHP, PulsaInput;
	String[] pulsa = {"5000", "10000","50000","100000","200000"};
	String Kode = "08" ;
	

void login(){
		System.out.print("Masukan Nomor HP : ");
		noHP = Input.nextLine() ;
		ceknoHP() ;
		daftarPulsa();
	}

void ceknoHP(){
	int n = noHP.length() ;
	if (n<12){
				System.out.println("No Anda kurang dari 12 digit ");
			login() ;
			}
	else if (n>12) { 
			
				System.out.println("No Anda lebih dari 12 digit ");
			login();
			}
			else{
				tempnoHP = noHP.substring(0, 2);
				if(tempnoHP.equals(Kode)){
			
					System.out.println("");
				
				}else{
					
					System.out.println("Nomor yg anda Masukan Salah");
					login();
				}
			}
	}
void daftarPulsa(){
		System.out.print("Daftar Pulsa :\n");
		for (int i = 0;i < pulsa.length ; i++){
		System.out.println((i+1)+". "+ pulsa[i]) ;
			}
	System.out.print("\nMasukan Nominal Pulsa : ");
	PulsaInput = Input.nextLine() ;
	cekPulsa();
	}	
	
void cekPulsa(){
		for (int i = 0;i < pulsa.length ; i++){
		if	(PulsaInput.equals(pulsa[i])){
			System.out.print("\n=====================================");
			System.out.print("\nMantap Jiwa");
			berhasil();
			}
			
		}
		System.out.print("\nPULSA TIDAK ADA \n");
		daftarPulsa();
	}	
void berhasil(){
	System.out.print("\nPembelian Pulsa Berhasil \n");
	System.exit(0);
	}	
	
}

