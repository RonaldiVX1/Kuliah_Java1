#include <stdio.h>

int find (int x, int arr)
{
	int i = 1 ;
	
	while(i < 10)
	{
		if (arr == x)
		{
			return 1 ;
		}
		return 0 ;
	}
	
}


int main()
{
	int x ;
	int arr[] = {1,2,3,4,5,6,7,8,9} ;
	
	scanf("Masukan angka : %i",&x);
	find(x,arr);
	if (find(x,arr) == -1) 
	{
		puts ("angka ada di array!");
	}
	else
	{
		puts ("Anka tidak ada di array!") ;
	}
	
	return 0;
}	
	

