package leetcodeExercise.easy;

import java.util.Arrays;

public class MoveAllZeroesToEnd {

	public static void main(String[] args) {
		int nums1[] = {0,1,0,3,12};
		int nums2[] = {0};
		int nums3[] = {1,0,1};
		moveZeroes(nums3);
		System.out.println(Arrays.toString(nums3));

	}
	
	
	public static void moveZeroes(int[] nums) {	
		int prevoisNum = 0;
		for(int i = 0;i<=nums.length-1;i++) {
			//da li je broj koji je trenutni u nizu razlicit od 0
			//ako jeste npr dobijes 1 onda udje i odradi klasican swap
			if (nums[i] != 0)  {
				//dakle ovde se radi klasicno swapovanje
			    int temp = nums[prevoisNum];
		        nums[prevoisNum] = nums[i];
		        nums[i] = temp;  
		    	prevoisNum++;
			}	
			
		}
    }

}
