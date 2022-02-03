import java.util.Scanner;

public class Perulangan {
	
	public static void main(String[] args){
		
		
		Scanner Input = new Scanner(System.in);
		
		int n ;
		
		System.out.println	("Masukan nilai n : ");
		
		n = Input.nextInt();
		
		
	for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--)
        {
            for (int j = 1; j < i; j++)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
		
		
		
	}
	
	
	
}