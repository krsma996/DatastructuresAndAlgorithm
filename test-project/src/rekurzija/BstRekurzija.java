package rekurzija;

public class BstRekurzija {
	
	Node root;

	class Node {
		
		int value;
		Node left;
		Node right;

		public Node(int value) {
			super();
			this.value = value;
		}

	}
	
	private Node rInsert(Node currentNode,int value) {
		
		if(currentNode == null) return new Node(value);	
		if(currentNode.value == value) {
			return currentNode;
		}
		if(value < currentNode.value) {
			 currentNode.left = rInsert(currentNode.left, value);
		}else {
			 currentNode.right = rInsert(currentNode.right,value);
		}
		return currentNode;
		
	}
	
	public Node rInsert(int value) {
		root = rInsert(root, value);
		return root;
	}


	public boolean contains(int value) {
		// znaci da je prazan i da ne sadrzi
		if (root == null)return false;
		// node ako kreiramo ovde cemo da kreiramo copy vrednost njegovu da proveravamo
		Node currentNode = this.root;
		while (currentNode != null) {
			if (value == currentNode.value) {
				// Pronađena vrednost
				System.out.println("It contains!");
				return true;
			} else if (value < currentNode.value) {
				// Idi u levo podstablo
				currentNode = currentNode.left;
			} else {
				// Idi u desno podstablo
				currentNode = currentNode.right;
			}
		}
		System.out.println("There is no value in tree");
		return false;
	}
	
	// a ovo govno se stalno poziva rekuzivno
	//i pozivace se sve dok se uslov neki ispuni ( a to je exit strategy tvoj)
	private boolean rContains(Node currentNode, int value) {
		if(currentNode == null) {
			System.out.println("Ne sadrzi ");
			return false;
		}
		if(currentNode.value == value) return true;
		
		if(value < currentNode.value) {
			return rContains(currentNode.left,value);
		}else  {
			return rContains(currentNode.right, value);
		}

	}
	
	//ovu si pozvao tamo u main
	public boolean rContains(int value) {
		return rContains(root, value);
	}
	
	
	
	public void printInOrder() {
        printInOrder(root);
    }
	public void printInOrder(Node node) {
		//exit case
	    if (node == null) {
	        return;
	    }
	    printInOrder(node.left); // Levo podstablo
	    System.out.print(node.value + " "); // Trenutni čvor
	    printInOrder(node.right); // Desno podstablo
	}
}
