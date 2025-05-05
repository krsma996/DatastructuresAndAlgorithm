package leetcodeExercise.easy;

import java.util.Arrays;

public class RemoveElementMain {

	/*
	 * Ovde se isto trazi u zadataku da u IN-place obrises trazeni element 
	 * dakle ponovo direktno u listi samoj bez nove da se kreira tu da se brise
	 * 
	 * ako imas niz {3,22,2,22,3}
	 * ja kaze brisi 3 mora da vrati
	 * {22,2,22,2} bez ove troje u nizu
	 */
	public static void main(String[] args) {
		int niz1[] = {1,3,4,5,6};
		removeElement(niz1,4);
		System.out.println(Arrays.toString(niz1));
	}

	public static int removeElement(int[] nums, int val) {
			int nextIndex = 0;
			//pa nista samo ga preskoci
			//i onda samo postavlja vrednosti lepo na tu poziciju gde je obrisan 
			//kao da ga reindexira
	        for(int i =0;i<=nums.length - 1;i++){
	            if(nums[i] != val){
	            	nums[nextIndex] = nums[i];
	            	nextIndex++;
	            }
	        }
	        return nextIndex;
	}

}
