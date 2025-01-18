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
		System.out.println("------------------------------- BFS");
		System.out.println(tree1.DFSPreOrder());
		System.out.println("------------------------------- DFS PRE ORDER");
		System.out.println(tree1.DFSPreOrderRecursion());
		System.out.println("------------------------------- DFS PRE ORDER WITH RECURSION");	
		System.out.println(tree1.DFSPostOrderRecursion());
		System.out.println("------------------------------- DFS POST ORDER RECURSION");
		System.out.println(tree1.DFSPostOrder());
		System.out.println("------------------------------- DFST POST ORDER NORMAL");
	}

}
