package leetcodeExercise.easy;

import java.util.Arrays;

public class ContainsDuplicate {

	public static void main(String[] args) {
		
		int nums1[]= {1,2,3,4,1};
		int nums2[]= {1,2,3};
		int nums3[]= {1,1,1,3,3,4,3,2,4,2};
		boolean containtsDuplicate = containsDuplicate(nums3);
		System.out.println(containtsDuplicate);
	}
	
	
	public static boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		int counterDuplicate = 0; //brojim duplikate
		int nextNumber = 0;// pokazivac niza na 0 krece
		for(int i = 1;i<=nums.length-1;i++) {
			// da li je taj broj jednak sledecem broju u nizu
			//ako gledamo nums1[] = to znaci da li je 1 == 2 NIJE necemo da brojimo
			if(nums[nextNumber] == nums[i]) {
				counterDuplicate++;			
			}
			nextNumber++; // Pomeramo se na sledeći broj u nizu
	        nums[nextNumber] = nums[i]; // Ažuriramo vrednost
		}
		//dakle counterDuplicate je kljucan sto znaci da 
		if(counterDuplicate == 0) {
			System.out.println("No Duplicates found");
			return false;
		}else {
			System.out.println("Duplicates found");
			return true;
		}
	}

}
