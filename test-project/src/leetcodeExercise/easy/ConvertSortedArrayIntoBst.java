package leetcodeExercise.easy;

public class ConvertSortedArrayIntoBst {

	public static void main(String[] args) {
		int nums[] = { 22, 33, 1, 225, 67, 78, 93 };
		TreeNode bst = sortedArrayToBST(nums);
		bst.printInOrder(bst);
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	private static TreeNode helper(int[] nums, int left, int right) {
		if (left > right)return null;
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, left, mid - 1);
		root.right = helper(nums, mid + 1, right);
		return root;
		/*
		 Dakle u sustini ovde se radi rekuzvini pristup jer je mnogo laksi nego iterativni pristup
		 sto znaci
		 1.) kada pozove prvi put bice 
		 if(0 > 6) nije ide dalje
		 int mid = (left + right) / 2; sto znaci
		   ( 0 +6 ) / 2 = 3 
		   root(3) = 255 vrednost iz niza
		   pozovi na 255 levo podstablo
		   root.left = helper(nums, left, 2); 3-1 
		   
		 2.)
		  	if(0 > 2) nije ide dalje
		 	kada pozove drugi put sam sebe na levom podstablu
		 	int mid = ( 0 + 2)/2 =1
		 	root(1) = 33;
		 	 root.left = helper(nums, left, 0);  1 - 1
		 	 
		  3.) if(0 > 0) nije ide dalje
		  	opet zove sebe u levom podstablu
		  	int mid ( 0 + 0 ) /2 = 0;
		  	root(0) = 22; 
		  	Poziva se levo podstablo helper(nums, 0, -1 ). 0 - 1  = -1 
		  	
		  4.) if(0 > -1)
		  		tacno je vracamo null;
		  	Ovo znači da levi podgrana čvora 22 ne postoji. 
		  	To je kraj za levo podstablo 22, 
		  	tako da se vraćamo na prethodni poziv, gde je bio kreiran 22
			i onda na toj 22 pozivamo njegovo DESNO STABLO
		  	
		  	5.) dakle za 22 je bilo ovo zadnji poziv  
		  		int mid ( 0 + 0 ) /2 = 0;
		  		
		  		bice da je mid 1 ovde
		  		i tako pici 
		  		root.right = helper(nums, 1, right); 0 +1 je 1
		  		
		  		
		  		i tako ide sve i pravi binarno stablo od obicnog niza 
		  		uzima se srednja vrednost nejgova se izracunava
		  		i onda trazimo pozicije i pozivamo rekuzivno sve dok left > 0 i tad null vratimo
		  		pa onda idemo za desnu stranu
		  		i sve dok left>right tad stajemo i popujemo ceo stack i dobijemo drvo 
		  	
		 */
	}

}
