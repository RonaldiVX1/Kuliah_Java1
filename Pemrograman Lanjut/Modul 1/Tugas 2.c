#include <stdio.h>
#include <string.h>

char NIM[50],tempNIM[12],Kode[9]={'1','0','3','7','0','3','1','1'};
int cek=0;

int main(){

   do{
   	  printf("Masukan NIM Anda : ");    
  	  scanf("%s", NIM);
   	
   if(strlen(NIM) < 15)
    {
        printf("NIM yang anda masukan kurang dari 15 angka\n");
        continue ;
    }
    else if(strlen(NIM) > 15)
    {
        printf("NIM yang anda masukan lebih dari 15 angka\n");
        continue ;
    }
    
	strncpy(tempNIM,&NIM[4],8);
	printf("%s",tempNIM);
    cek = strcmp(Kode,tempNIM);
    
	if(cek==0){
        printf("NIM %s adalah Mahasiswa Informatika\n",NIM);
        break ;
    }
	else{
        printf("NIM yang dimasukkan Bukan NIM Informatika\n");
    }
    
	}while(9>0);
    
	
	return 0;
    }

