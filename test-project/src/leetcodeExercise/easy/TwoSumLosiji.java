package leetcodeExercise.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSumLosiji {

	public static void main(String[] args) {
		
		int  nums[] = {2,5,5,11};
		int target = 10;
		int[] rezultTarget = twoSum(nums, target);
		
		  if (rezultTarget.length == 2) {
	            System.out.println("Indexes: " + rezultTarget[0] + ", " + rezultTarget[1]);
	        } else {
	            System.out.println("No solution found.");
	        }
	}
	
	public static int[] twoSum(int[] nums, int target) {   
		for(int i =0;i<=nums.length - 1;i++){        
			for(int j = i +1;j<=nums.length -1 ;j++) {
				if(nums[i] + nums[j] == target) {
					return new int[] {i,j};
				}
			}
        }
		return new int[0];       
    }

}
