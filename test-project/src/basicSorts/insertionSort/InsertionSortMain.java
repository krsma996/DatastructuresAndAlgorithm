package basicSorts.insertionSort;

import java.util.Arrays;

public class InsertionSortMain {

	public static void main(String[] args) {
		// za insertion sort uvek za pocinjemo sa DRUGIM itemom u listi sto znaci
		// lista neka  { 4,2,6,5,1,3}
		// i ono sto uradimo sa time jeste da uzmemo { 2 } iz lsite tj DRUGI item po redu 
		// i poredimo ga sa prvim koji se nalazi u listi u smisli  AKO je 2 < 4 ODRADI SWAP
		//i tako sve u nedogled da ih swapujemo
		int niz[] = {2,4,3,6,5,1};
		
		insertionSortArray(niz);
		
		System.out.println(Arrays.toString(niz));

	}

	private static void insertionSortArray(int[] niz) {
		for(int i = 1;i< niz.length;i++) {
			int temp = niz[i]; //{ 4,2,6,5,1,3} sa ovim si rekao kad krene petlja pointer je na => 2 dakle na INDEXU od i a vrednost daje 2 
			int j = i - 1; // a ovaj ce da bude na => INDEX gore ce ce krene od 1 pa ce oduzme 1 i pokazivace na 0 tj prethodni
			//odradi swap klasican
			//j > -1 da ne bude out of bounds za -1
			while(j > -1 && temp < niz[j]) {
				niz[j+1] = niz[j]; // ovo prethodni gurne na sledeci
				niz[j] = temp; // a voaj sto je sledeci samo ga vrati nazad
				j--;
			}
			
		}
		
	}

}
