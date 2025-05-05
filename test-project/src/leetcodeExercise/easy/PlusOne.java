package leetcodeExercise.easy;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		int digits[] = { 9, 9, 9 };
		int digits2[] = {1,2,3};
		int rezult[] = plusOne(digits2);
		System.out.println(Arrays.toString(rezult));
		
	}

	/*
	 * Fora je zadatka posto je leetcode kretenski ubacio objasnjenje 
	 * da taj broj npr koji je u nizu {1,2,3} treba da se inkremetira za 1 
	 * da ti ispise {1,2,4} kao da se posmatra kao 1 broj u smisli int broj1 = 123
	 * pa kao da si ga inkrementirao za 1 da bude 124 i onda 1 i 2 i 4 ubacis u niz kako god
	 * 
	 * Dakle posmatramo ih kao jednu celinu koju inkrementiramo
	 * Trik je kad imas 999
	 * e onda moras da pravis 1000
	 */
	public static int[] plusOne(int[] digits) {
		for(int i = digits.length -1;i>=0;i--) {
			//ako je zazdnaj cifra u nizu manja od 9
			// vrati samo tu cifru sa uvecanjim 1
			if(digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			//ovde dolazi ako nam je niz 9 9 9 ako gore if fejluje da odradi
			//i onda znamo da ocekujemo 1000
			// i zato kazemo da je digits 0 
			// i onda ako imam 999 mi dobijemo 000
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
