package trees;
public class TreeNikolaMain {

	public static void main(String[] args) {
			
		BinarySearchTreeNikola treeBinary = new BinarySearchTreeNikola();
		treeBinary.insert(2);
		treeBinary.insert(5);
		treeBinary.insert(15);
		treeBinary.insert(15);
		
		System.out.println("Root is " + treeBinary.root.value);
		treeBinary.contains(0);
		treeBinary.printInOrder();
	}

}
