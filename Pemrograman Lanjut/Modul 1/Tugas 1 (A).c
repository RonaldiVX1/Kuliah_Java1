#include <stdio.h>
#include <stdlib.h>

int main() 
{
	

	int arr[9]= {1,2,3,4,5,6,7,8,9} ;
	
	int i = 0 ; 
	int ganjil 	= 0 ;
	int genap 	= 0 ;
	int total	= 0 ;
	
	while(i < 9)
	{
		if (arr [i]%2 == 0) 
		{
			genap += arr[i];
		}
		else
		{
			ganjil +=arr[i] ;
		}
		total += arr[i] ;
		i++ ;
	}


printf("Jumlah Bilangan Ganjil = %i\n", ganjil) ;
printf("Jumlah Bilangan Genap = %i\n", genap) ;
printf("Total = %i\n", total) ;

	
	return 0;
}



