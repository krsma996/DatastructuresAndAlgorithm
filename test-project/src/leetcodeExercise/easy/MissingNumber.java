package leetcodeExercise.easy;

public class MissingNumber {

	public static void main(String[] args) {

		int array1[] = {3,0,1};
		
		int missingNumber = missingNumber(array1);
		
		System.out.println(missingNumber);
	}

	/*
	 * 1.) pa ovde je fora da se nadje u nizu broj koji je missing koji nedostaje
	 * dakle ako je niz 3,0,1 tipa kad bi se sortirao 0,1,3 fali ti 2 taj uzastopni broj da se 
	 * pronadje
	 * e sad ovo je ispod dole po formuli radjeno koje kaze
	 * 
	 * 1 iteracija 
	 * res jeste 3 = i je 0  - nums[i] jeste 3 sto znaci
	 * 3 + (0 - 3) = 3 - 3 = 0
	 * dakle bude posle 3 + (-3) = 0   res = je 0
	 * nums[0] je 3, pa oduzimamo 3 i res sada postaje 0
	 * 
	 * 2.) 2 iteracija ide ovako
	 * 0 + (1 - 0)  =  0 + 1 = 1
	 * res se sada 1
	 * 
	 * 3.) Iteracija je 
	 *  
	 *  1 + (2-1) = 1+1 = 2
	 *  
	 *  
	 *  i fali ti ta 2 na kraju
	 */
	public static int missingNumber(int[] nums) {

		int res = nums.length;

		for (int i = 0; i < nums.length; i++) {
			res += i - nums[i];
		}

		return res;
	}

}
