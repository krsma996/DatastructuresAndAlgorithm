package leetcodeExercise.easy;

import java.util.Arrays;

public class RemoveElementMain {

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
