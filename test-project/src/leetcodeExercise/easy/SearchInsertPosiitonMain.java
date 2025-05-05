package leetcodeExercise.easy;

public class SearchInsertPosiitonMain {

	/*
	 * Ovde se trazi da u ovom nizu pronadjes INDEX elementa ako postoji u listi
	 * a ako ne postoji da vidis de bi se on ubacio u kom tacnom mestu npr
	 * {1,2,3}  ako je target 3 treba da ti vrati index [2]
	 * a ako trazimo npr 4 a on ne postoji u nizu onda treba da ti vrati [3] index
	 */
	public static void main(String[] args) {
		int nums[] = { 1, 3, 5, 6 };
		int target = 5;
		int target2 = 2;

		int founded = searchInsert(nums, target2);
		System.out.println(founded);

	}

	public static int searchInsert2(int[] nums, int target) {
		for (int i = 0; i <= nums.length - 1; i++) {
			if (nums[i] >= target) {
				return i;
			}
		}
		return nums.length;
	}

	// oov je moje resenje
	public static int searchInsert(int[] nums, int target) {
		int index = 0;
		for (int i = 0; i <= nums.length-1; i++) {
			index++;
			if (nums[i] >= target) {
				return index-1;
			}
		}
		// a ako ga nije pronasao samo vrati tu duzinu nums.length
		// ili samo taj index na kom bi on bio
		return index;
	}

}
