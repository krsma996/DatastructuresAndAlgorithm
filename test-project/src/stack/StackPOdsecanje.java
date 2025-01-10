package stack;



// Za stack kao teniska kutija za loptice
// PUSH i POP 
//LIFO -> LAST IN first OUT !
public class StackPOdsecanje {
	
	int value;
	int lenght = 0;
	Node top;
	
	public StackPOdsecanje(int value) {
		Node newNode = new Node(value);
		top = newNode;
		lenght++;
	}
	
	
	class Node{
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}
		
	}
	
	public Node push(int value) {
		Node newNode = new Node(value);
		if(top == null) {
			top = newNode;
		}
		newNode.next = top;
		top = newNode;
		lenght++;
		return newNode;
	}

	public Node pop() {
		Node topNode = this.top;
		if(top == null) {
			return null;
		}
		top = topNode.next;
		topNode = null;
		
		lenght--;
		return topNode;
		
	}

	public int getLenght() {
		System.out.println("Lenght if stack is = " + lenght);
		return lenght;
	}


	public Node getTop() {
		if(top == null) {
			System.out.println("There are no items in stack " );
			return null;
		}
		System.out.println("The top item is = " + top.value);
		return top;
	}
	
	public void printList() {
		Node tempNode = this.top;
		while(tempNode !=null) {		
			System.out.println(tempNode.value);
			tempNode = tempNode.next;
		}
	}

}
