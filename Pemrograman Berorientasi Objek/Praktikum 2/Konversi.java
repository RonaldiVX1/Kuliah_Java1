public class Konversi {

double KM,HM,DAM,M,DM,CM,MM, Panjang;





	
	double toKM (double Panjang){
		KM=Panjang/1000;
		return KM ;
	}
	double toHM (double Panjang){
		HM=Panjang/100;
		return HM ;
	}
	double toDAM (double Panjang){
		DAM=Panjang/10;
		return DAM ;
	}
	double toM (double Panjang){
		M = Panjang;
		return M ;
	}
	double toDM (double Panjang){
		DM=Panjang*10;
		return DM ;
	}
	double toCM (double Panjang){
		CM=Panjang*100;
		return CM ;
	}
	double toMM (double Panjang){
		MM=Panjang*1000;
		return MM ;
	}
	
	


}