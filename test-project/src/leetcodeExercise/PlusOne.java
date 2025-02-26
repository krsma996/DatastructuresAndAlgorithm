package leetcodeExercise;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		int digits[] = { 9, 9, 9 };
		int rezult[] = plusOne(digits);
		System.out.println(Arrays.toString(rezult));
		
	}

	public static int[] plusOne(int[] digits) {
		for(int i = digits.length -1;i>=0;i--) {
			//ako je zazdnaj cifra u nizu manja od 9
			// vrati samo tu cifru sa uvecanjim 1
			if(digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			//ovde ako se desi da ti je samo poslednja cifra 9
			// ti je stavi da ona bude nula
			// a kada se ona iterira ponovo
			// druga ce ti se uvecati za 1 npr 139  = ovu 9 ce da stavi na 0
			// a ovu 3 ce da uveca za 1 
			// i vratice ti
			digits[i] = 0;
		}
		// a ovo je slucaj samo ako su svi 9 9 9
		// onda ce da prevrti sve i postaviti digits[i] = 0; koji ce biti na 0 0 0
		// aonda ce duzinu da uveca za jedan 
		digits = new int[digits.length +1];
		// i na prvoj poziciji da stavi 1 i bude 1,0,0,0
		digits[0] =1;
		return digits;	
		
	}

}
