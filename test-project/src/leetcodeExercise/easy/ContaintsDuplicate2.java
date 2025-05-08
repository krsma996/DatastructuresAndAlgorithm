package leetcodeExercise.easy;

import java.util.HashMap;
import java.util.Map;

public class ContaintsDuplicate2 {

	public static void main(String[] args) {
		int niz1[] = { 1, 2, 3, 1 };
		int niz2[] = { 1, 0, 1, 1 };
		int niz3[] = { 1, 2, 3, 1, 2, 3 };

		int k1 = 3;

		boolean containsDuplicate = containsNearbyDuplicate(niz2, k1);
		System.out.println(containsDuplicate);
	}

	/*
	 * /** U zadatku se traži da u nizu nums proveriš da li postoje duplikati koji
	 * su dovoljno blizu jedan drugom — tačnije, da li se isti broj pojavljuje dva
	 * puta unutar maksimalne udaljenosti k.
	 *
	 * Na primer, ako je niz {1, 2, 3, 4, 1} i prosleđeni k = 3, treba da proveriš
	 * da li se isti broj pojavljuje dva puta u okviru "prozora" dužine 3 (gledano
	 * po indeksima).
	 *
	 * U ovom primeru broj 1 se pojavljuje na indeksima 0 i 4, i pošto je njihova
	 * razlika 4, a 4 > 3, onda to **ne zadovoljava** uslov.
	 *
	 * Dakle, cilj je da pronađeš dva ista broja tako da je razlika između njihovih
	 * indeksa manja ili jednaka k.
	 */
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		// klasican base case
		if (nums.length == 0 || k == 0)
			return false;
		// klasicno pravljenje mape
		Map<Integer, Integer> maps = new HashMap<>();
		// iteriramo kroz niz nums
		for (int i = 0; i <= nums.length - 1; i++) {
			// uzimamo prvi broj u nizu
			int numInArray = nums[i];
			// i - maps.get(numInArray) <= k Proverava da li je broj u range za k
			// tako sto ce i koja je iteracija manje od vrednosti iz mape
			// a containts key tj ova mapa jednsavno sluzi za duplikate dakle pakujemo ako
			// nema
			// a ako ima duplikat proverimo da li je tacno u nizu
			if (maps.containsKey(numInArray) && i - maps.get(numInArray) <= k) {
				// i dok dodjemo do tog duplikata onda se radi uslov i vratice ti true
				return true;
			}
			maps.put(numInArray, i);
		}
		// Ako ceo niz proletimo onda znaci da mi nismo nasli duplikate u nizu najbilize
		// i nismo
		// uslov zadovoljili
		return false;
	}
}
