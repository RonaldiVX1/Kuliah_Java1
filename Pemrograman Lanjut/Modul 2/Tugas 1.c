#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char noHp[12];
char pulsa [5][10] = {"5000", "10000","50000","100000","200000"};
char pulsaInput[5] ;
// Tambahan
char Kode[2] = {'0','8'} ;
char tempNomor[12];

void login();
void cekNomorHp();
void cekPulsa();
void berhasil();
void daftarPulsa();

int main()
{
	login();
	return 0;
}

void login(){
	printf("Masukan Nomor HP : ");
	gets(noHp);
	cekNomorHp();
	daftarPulsa();
	cekPulsa();
}

void cekNomorHp(){
	strncpy	(tempNomor,&noHp[0],2);

	if(strlen(noHp) > 12)
	{		
		printf("Nomor HP anda lebih dari 12 angka\n");
				login();
	}
			
	else if(strlen(noHp) < 12)
	{
			printf("Nomor HP anda kurang dari 12 angka\n");
				login();
	}	
	do
		{
		if (strcmp(Kode,tempNomor)== 0){
			
			break ;
		}
		else
		{
			printf("Nomor yg anda Masukan Salah\n");
			login();
		}
		}while(9>0);	
}


void cekPulsa(){
	int i ;
	for (i=0;pulsa[1][i] != '\0'; i++){
		if (strcmp(pulsaInput,pulsa[i])==0)
		{
			printf("Mantap Jiwa");
			berhasil();
		}
	}
	printf("\nPULSA TIDAK ADA \n\n");
	daftarPulsa();
	
}

void berhasil (){
	printf("\nSelamat transaksi berhasil\n");
	exit(EXIT_SUCCESS);
}

void daftarPulsa() {
	int i ;
	printf("\nDaftar Pulsa : \n");
	for (i=0;pulsa[1][i] != '\0'; i++){
		printf("%d. %s\n", i+1, pulsa[i]);
	}
	printf("\nMasukan Nominal Pulsa : ");
	gets(pulsaInput);
	cekPulsa() ;
}
