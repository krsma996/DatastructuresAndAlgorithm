package leetcodeExercise.easy;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String args[]) {
		int niz1[] = { 11, 22, 22, 33, 33, 11, 44, 5, 6, 7, 11 };
		removeDuplicates(niz1);
		System.out.println(Arrays.toString(niz1));

	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int indexNext = 1;
		for (int i = 1; i <= nums.length - 1; i++) {
			// dali je trenutni nije jednak ovom prethnodnom
			// tj dali si razliciti
			// ako jesu
			if (nums[i] != nums[i - 1]) {
				// broj koji je razlicit stavlja se na mesti prethodnog
				// tj stavljamo ga nums[i] a on ti je prethnodni
				nums[indexNext] = nums[i];
				indexNext++;
				// jer ti ovaj gura pri svakog iteraciji ka sledecem
				// i tamo gde je duplikat on ce ga zameni samo
				// u sustini tacno taj broj na kom je duplikat se zamenjuje brojem koji je
				// razlicit
			}
		}
		return indexNext;
	}

	/*
	 * [1, 1, 2, 2, 3]
	 * 
	 * 
	 * Start: indexNext = 1
	 * 
	 * i=1: 1 == 1 → duplikat → ništa i=2: 2 != 1 → nums[1] = 2 → indexNext=2 [1, 2,
	 * 2, 2, 3]
	 * 
	 * i=3: 2 == 2 → duplikat → ništa i=4: 3 != 2 → nums[2] = 3 → indexNext=3 [1, 2,
	 * 3, 2, 3]
	 * 
	 */
}
