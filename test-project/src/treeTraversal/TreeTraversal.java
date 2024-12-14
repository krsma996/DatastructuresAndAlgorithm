package treeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * Tree traversal je proces obilaska svakog čvora u drvetu, 
 * gde se vrednosti svakog čvora dodaju u ArrayList, koji se zatim vraća kao rezultat.
 * 
 * Ovo se može postići različitim tehnikama kao što su:
1.) Preorder traversal (čvor -> levo podstablo -> desno podstablo)
2.) Inorder traversal (levo podstablo -> čvor -> desno podstablo)
3.) Postorder traversal (levo podstablo -> desno podstablo -> čvor)
3.) Level-order traversal (redosled nivoa, koristeći red).
------------------------------------------------------------------------------------------------------
1.)
Breath First Search je kada krenemo od root pa idemo levo pa desno pokpimo root childrene pa onda dole levo pokupimo childrene 
pa desno dole childrene  i tako do kraja . Dakle Root- Siblings (Levi -> Siblings pa onda Desni -> Siblings) svaki sused i childovi 
BFS funkcioniše tako što kreće od početnog čvora (ili korena stabla) i prelazi sve njegove neposredne susede, 
zatim prelazi na susede tih suseda, i tako dalje, dok se svi čvorovi ne posete
2.)
Depth First Search je kada krenemo skrooz levo na stablu i najevli moguci 
i onda se penjamo polako kupimo njegove parente i siblinge pa tako sve do
root-a gore pa onda od ROOT-a koji je 1 krenemo ponovo u dubinu sa desne strane najlevlje 
i isto od child pa njegov parent koji su povezani pa tako sve 
u krug do vrha. Dakle krece iz dubine pa do vrha



BFS -> Cemo implementirati pomocu QUe i Deque algoritma u kom smislu
Početak: Red = [47]
Obradiš 47, njegovi children (21, 76) idu u red.
Red postaje: [21, 76]
Sledeći korak:
deque 21: Obradiš 21, njegovi children (13, 44) idu u red.
Red postaje: [76, 13, 44]
Zatim:
deque 76: Obradiš 76, njegovi children se dodaju (ako postoje).
Red postaje: [13, 44, <children_of_76>]
I proces se nastavlja na ovaj način: uzmeš prvi čvor iz reda, obradiš ga, 
dodaš njegove children u red i ponavljaš dok svi čvorovi ne budu posećeni.

 */
public class TreeTraversal {

	Node root;

	class Node {

		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}

	}

	public Node rInsert(int value) {
		root = rInsert(root, value);
		return root;
	}

	public boolean rContains(int value) {
		return rContains(root, value);
	}

	public Node rDelete(int value) {
		return rDelete(root, value);
	}

	public List<Integer> BFS(){
		Node currentNode = this.root;
		Queue<Node> que = new LinkedList<Node>();
		List<Integer> result = new ArrayList<>();
		
		que.add(currentNode);
		
		while(que.size() > 0) {
			currentNode = que.remove();
			result.add(currentNode.value);
			if(currentNode.left != null) {
				que.add(currentNode.left);
			}
			if(currentNode.right !=null) {
				que.add(currentNode.right);
			}			
		}
		return result;		
	}
	
	// 1.) nacin jeste samo da se zameni umesto que ide stack
	public List<Integer> DFSPreOrder(){
		Node currentNode = this.root;
		List<Integer> results = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		
		stack.push(currentNode);
		
		while(stack.size() > 0 ) {
		currentNode = stack.pop();
			results.add(currentNode.value);

			   // Prvo dodajte desno, pa levo
	        if (currentNode.right != null) {
	            stack.push(currentNode.right);
	        }
	        if (currentNode.left != null) {
	            stack.push(currentNode.left);
	        }
		}
		
		return results;
	}

	//u javi jedini nacin da metoda koja ima u sebi drugu metodu deklarisanu jeste 
	//da se napravi usrana klasa u njoj 
	 public ArrayList<Integer> DFSPreOrderRecursion() {
	      
		 ArrayList<Integer> results = new ArrayList<>();
	        class Traverse {
	        	//u samom konstrutkoru klase se izvrsava ovo
	            Traverse(Node currentNode) {
	                results.add(currentNode.value);
	                if (currentNode.left != null) {
	                    new Traverse(currentNode.left);
	                }
	                if (currentNode.right != null) {
	                    new Traverse(currentNode.right);
	                }
	            }
	        }
	        // mora se ovako pozove da bi se konstruktor klase pozvao
	        new Traverse(root);
	        return results;
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

	private Node rDelete(Node currentNode, int value) {
		if (currentNode == null) {
			System.out
					.println("Ne postoji taj usrani element koji pokusavas da obrises cigansturo glupa programerska!");
			return null;
		}
		if (value < currentNode.value) {
			currentNode.left = rDelete(currentNode.left, value);
		} else if (value > currentNode.value) {
			currentNode.right = rDelete(currentNode.right, value);
		} else {
			if (currentNode.left == null && currentNode.right == null) {
				return null;
			} else if (currentNode.left == null) {
				return currentNode.right;
			} else if (currentNode.right == null) {
				return currentNode.left;
			} else {
				Node minNode = findMin(currentNode.right);
				currentNode.value = minNode.value;
				currentNode.right = rDelete(currentNode.right, minNode.value);
			}
		}

		return currentNode;
	}

	private Node findMin(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

}
