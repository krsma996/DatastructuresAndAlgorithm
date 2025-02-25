package leetcodeExercise;

public class SearchInsertPosiitonMain {

	public static void main(String[] args) {
		int nums[] = { 1, 3, 5, 6 };
		int target = 5;
		int target2 = 2;

		int founded = searchInsert(nums, target);
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
		return nums.length;
	}

}
