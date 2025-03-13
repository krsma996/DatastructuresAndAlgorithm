package leetcodeExercise.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElements {
	
	
	public static void main(String[] args) {
		
		int array1[] = {1,1,1,2,2,2,2,2,1,3};
		int majorityElement = majorityElement(array1);
		
		
		System.out.println("It is " + majorityElement);
		
	}
	
	
	
	

	public static int majorityElement(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0;i<=nums.length-1;i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		int majorityNumber = nums[0];
        int maxCount = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                majorityNumber = entry.getKey();
            }
        }
		return majorityNumber;
	}
}