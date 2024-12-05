package treeTraversal;

public class Test1Main {

	public static void main(String[] args) {
		
		TreeTraversal tree1 = new TreeTraversal();
		
		tree1.rInsert(47);
		tree1.rInsert(21);
		tree1.rInsert(76);
		tree1.rInsert(18);
		tree1.rInsert(27);
		tree1.rInsert(52);
		tree1.rInsert(82);
		
		System.out.println(tree1.BFS());
		System.out.println("-------------------------------");
		System.out.println(tree1.DFSPreOrder());
		System.out.println("-------------------------------");
		System.out.println(tree1.DFSPreOrderRecursion());
	}

}
