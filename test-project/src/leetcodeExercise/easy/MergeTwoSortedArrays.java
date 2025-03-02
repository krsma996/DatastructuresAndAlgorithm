package leetcodeExercise.easy;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int array1[] = { 55, 22, 3,0,0,0 };
		int array2[] = { 2, 5, 6 };

		//int rezUltArray[] = merge(array1, array2);
		merge(array1, 3, array2, 3);
		
		for(int i = 0;i<=array1.length-1;i++) {
			System.out.println(array1[i]);
		}
		

	}

	private static int[] merge22(int[] array1, int[] array2) {
		// novi niz koji ce da ima 6 elemenata
		int rezult[] = new int[array1.length + array2.length];
		// index je za nizove
		int nexIndex = 0;
		for (int i = 0; i <= array1.length - 1; i++) {
			rezult[nexIndex] = array1[i];
			nexIndex++;
		}

		for (int j = 0; j <= array2.length - 1; j++) {
			rezult[nexIndex] = array2[j];
			nexIndex++;

		}

		return rezult;
	}

	/*
	 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
	 * order, and two integers m and n, representing the number of elements in nums1
	 * and nums2 respectively.
	 * 
	 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
	 * 
	 * The final sorted array should not be returned by the function, but instead be
	 * stored inside the array nums1. To accommodate this, nums1 has a length of m +
	 * n, where the first m elements denote the elements that should be merged, and
	 * the last n elements are set to 0 and should be ignored. nums2 has a length of
	 * n.
	 */

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
	    int lastElementNum1 = m - 1; // poslednji element u nums1 (korisni deo)
	    int lastElementNum2 = n - 1; // poslednji element u nums2
	    int lastIndexNums1 = m + n - 1; // poslednji indeks u nums1

	    while (lastElementNum2 >= 0) {
	    	//if kaze sve dok vrtimo elementa u indexima poslednje veci od 0
	    	//i onda radimo nekakvu vrstu sortiranja dali je broj iz nums1 niza na tom indexu njegova vrednost veca od nums2
	        if (lastElementNum1 >= 0 && nums1[lastElementNum1] > nums2[lastElementNum2]) {
	        	// poslednji vrednost u nums1 ce biti jednaka tom istooj vrednosti u num1 sto znaci stavljamo ga na pravo mesto
	            nums1[lastIndexNums1--] = nums1[lastElementNum1--];
	        } else {
	        	//poslednja vrednost u nums1 ce biti jednaka vrednosti iz nums2
	            nums1[lastIndexNums1--] = nums2[lastElementNum2--];
	        }
	    }
	}


}
