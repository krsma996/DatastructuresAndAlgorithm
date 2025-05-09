package leetcodeExercise.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {
		int nums[] = { 0, 1, 2, 4, 5, 7 };
		List<String> summaryNumbs = summaryRanges(nums);
		System.out.println(Arrays.toString(summaryNumbs.toArray()));
	}
	/*
	 * Uzastopni brojevi su oni gde je razlika između susednih brojeva tačno 1.
	 *
	 * Praktično, samo tražimo gde se niz prekida i tu završavamo opseg, pa
	 * nastavljamo novi.
	 *
	 * Poenta zadatka je zapravo jednostavna – imamo niz npr: 0, 1, 2, 4, 5, 7
	 *
	 * Kada se for petlja vrti, tražimo brojeve koji **nisu** uzastopni – to znači da
	 * brojevi koji idu redom jedan za drugim (npr. 0,1,2) čine uzastopni niz.
	 * Kada dođe do 4 (iza 2 je 4, a ne 3), tu se niz prekida.
	 *
	 * U rezultatu treba da ispišemo sledeće:
	 * - "0->2" jer su 0,1,2 uzastopni
	 * - "4->5" jer su 4,5 uzastopni
	 * - "7" jer je to samostalan broj bez uzastopnih
	 *
	 * 2.) Drugi primer:
	 * Ulaz: [1, 2, 3, 4, 5, 100, 101, 102, 200]
	 * Rezultat: ["1->5", "100->102", "200"]
	 * Objašnjenje:
	 * - Brojevi od 1 do 5 su uzastopni
	 * - 100 do 102 su uzastopni
	 * - 200 je samostalan broj
	 */

	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		if (nums.length == 0)
			return result; // Ako je niz prazan

		int start = nums[0]; // Pocetni broj opsega

		for (int i = 1; i <= nums.length; i++) {
			// Ako smo na kraju niza ili broj nije uzastopan
			if (i == nums.length || nums[i] != nums[i - 1] + 1) {
				// Ako je opseg samo jedan broj
				if (start == nums[i - 1]) {
					result.add(start + "");
				} else {
					result.add(start + "->" + nums[i - 1]);
				}
				// Pocetak novog uzastopnog broja mora start promenljiva da se azurira
				if (i < nums.length) {
					start = nums[i];
				}
			}
		}
		return result;
	}
}
