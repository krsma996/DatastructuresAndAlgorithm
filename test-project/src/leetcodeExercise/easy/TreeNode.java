package leetcodeExercise.easy;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	
	
	public void printInOrder(TreeNode node) {
	    if (node == null) {
	        return;
	    }
	    printInOrder(node.left); // Levo podstablo
	    System.out.print(node.val + " "); // Trenutni čvor
	    printInOrder(node.right); // Desno podstablo
	}
}
