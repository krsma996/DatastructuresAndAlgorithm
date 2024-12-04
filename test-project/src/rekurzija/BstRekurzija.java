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

	private Node rInsert(Node currentNode, int value) {

		if (currentNode == null)
			return new Node(value);
		if (currentNode.value == value) {
			return currentNode;
		}
		if (value < currentNode.value) {
			currentNode.left = rInsert(currentNode.left, value);
		} else {
			currentNode.right = rInsert(currentNode.right, value);
		}
		return currentNode;
	}

	public Node rInsert(int value) {
		root = rInsert(root, value);
		return root;
	}

	// a ovo govno se stalno poziva rekuzivno
	// i pozivace se sve dok se uslov neki ispuni ( a to je exit strategy tvoj)
	private boolean rContains(Node currentNode, int value) {
		if (currentNode == null) {
			System.out.println("Ne sadrzi ");
			return false;
		}
		if (currentNode.value == value)
			return true;

		if (value < currentNode.value) {
			return rContains(currentNode.left, value);
		} else {
			return rContains(currentNode.right, value);
		}

	}

	// ovu si pozvao tamo u main
	public boolean rContains(int value) {
		return rContains(root, value);
	}

	
	
	
	private Node rDelete(Node currentNode, int value) {
		if (currentNode == null) {
			System.out.println("Ne postoji taj usrani element koji pokusavas da obrises cigansturo glupa programerska!");
			return null;
		}
		// dakle if i else if ovde samo guraju rekurziju dok se nenadje pravi Node koji
		// treba da se obrise a dole u
		// else blocku mora da se odluci sta ce se de	siti ako pronadjemo taj usrani node
		// za brisanje
		// 4 stavke moraju da se ispune
		// game dev !!!!!!!!!!!!!!!!!!!!!!!!!!!!
		if (value < currentNode.value) {
			 currentNode.left = rDelete(currentNode.left,value); // ovde ce da vrati is skroz dole else bloka rezultat ako pronadjemo
		} else if (value > currentNode.value) {
			 currentNode.right = rDelete(currentNode.right,value); // i ovde isto
			// 4 stvari ovde moraju da se paze
			// 1) ili je leaf node u smislu nema childrena ispod
			// 2) ili mozda ima samo 1 children desno
			// 3) ili mozda ima samo 1 children levo
			// 4) ili ih mozda ima i levo i desno ( u ovom slucaju ces morati da nadjes
			// minimalnu vrednost njegovog childrena i samo da ga zamenis
		} else {
			//1) slucaj kad je leaf node nema ni levo ni desno dakle nasli smo ono sto brisemo
			if (currentNode.left == null && currentNode.right == null) {
				//zasto samo null vratimo ?
				// pa ako nema ni levo node i ndesno node i kazaace samo preko rekurzije gore u if da je current.left = null;
				//prosto cega obrisati tako
				return null;
			//2) slucaj kad je left node null tj brisemo sa leve strane
			// i zasto bas ovako ? jer ces ti taj trenutni node npr ako imas 22 i a children je 23 
			// ti sa ovim si rekao ispod dole da je trenutni node koji pokazuje na 22 biti jednako 23 
			// i onda ce da ode gore u call stack a pre toga je pozvao PARENT node jer odatle krece
			// i onda ce parent node da pokazuje na taj 23 CURRENT NODE  a 22 pokazuje na prazno i bice garbage collected
			
			}else if(currentNode.left == null) {
				return currentNode.right;
			//3.) isto vazi i sa slucaj 2 
			}else if(currentNode.right == null) {
				return  currentNode.left;
			}  else {
	            // Nađi najmanji čvor u desnom podstablu
	            Node minNode = findMin(currentNode.right);
	            // Zameni trenutni čvor sa minimalnim
	            currentNode.value = minNode.value;
	            // Obriši minimalni čvor iz desnog podstabla
	            // i ponoco ce celu funkciju da pozove i videce dal taj cvor nema left value GORNJI uslov ce da ga obrise postavice ga na null
	            //i tako ga obrise
	            currentNode.right = rDelete(currentNode.right, minNode.value);
	        }
	    }

	    return currentNode;
	}

	public Node rDelete(int value) {
		return rDelete(root, value);
	}
	
	//ova kurceva metoda ce gurati sve sa leve strane jer je to neko pravilo
	//a sa leve strane su uvek najmanji brojevi
	//dakle najmanji cvor je najlevlji u stablu
	private Node findMin(Node node) {
	    while (node.left != null) {
	        node = node.left;
	    }
	    return node;
	}
	

	public void printInOrder() {
		printInOrder(root);
	}

	public void printInOrder(Node node) {
		// exit case
		if (node == null) {
			return;
		}
		printInOrder(node.left); // Levo podstablo
		System.out.print(node.value + " "); // Trenutni čvor
		printInOrder(node.right); // Desno podstablo
	}
}
