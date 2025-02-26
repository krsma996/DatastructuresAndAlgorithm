package leetcodeExercise.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSumBolji {

	public static void main(String[] args) {
		int  nums[] = {3,2,4};
		int target = 6;
		int[] rezultTarget = twoSum(nums, target);
		
		  if (rezultTarget.length == 2) {
	            System.out.println("Indexes: " + rezultTarget[0] + ", " + rezultTarget[1]);
	        } else {
	            System.out.println("No solution found.");
	        }
	}
	
	public static int[] twoSum(int[] nums, int target) {   
		Map<Integer,Integer> result = new HashMap<>();
		for(int i = 0; i < nums.length;i++) {
			int resultNumber = target - nums[i];
			if(result.containsKey(resultNumber)) {
				return new int[]{result.get(resultNumber), i};
			}
			result.put(nums[i], i);
		}
		return null;
		
    }
	

}


