
public class DoubleLinkedListPodsecanje {

	private Node head;
	private Node tail;
	private int lenght = 0;
	
	public DoubleLinkedListPodsecanje(int value) {
		Node newNode = new Node(value);
		this.head = newNode;
		this.tail = newNode;
		lenght++;
	}
	
	class Node {
		Node next;
		Node previous;
		int value;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	
	
	public void append(int value) {
		Node newNode = new Node(value);
		if(head == null || tail == null ) {
			head = newNode;
			tail = newNode;
			lenght++;
		}else {
			tail.next = newNode;
			newNode.previous = this.tail;
			tail = newNode;
			lenght++;
		}
	}

	
	public void printList() {
		Node temp = this.head;
		while(temp !=null) {
			System.out.println(temp.value);
			temp = temp.next;
			
			
		}
	}
	
	
	public Node getHead() {
		if(this.head== null) {
			System.out.println("Head is null bro");
			return null;
		}
		System.out.println("Head value is = " + this.head.value);
		return head;
	}


	public Node getTail() {
		if(this.tail == null) {
			System.out.println("Tail is null bro ");
		}
		System.out.println("Tail value is = " + this.tail.value);
		return tail;
	}


	public int getLenght() {
		System.out.println("Lenght of list is " + lenght);
		return lenght;
	}
	
	
	
	
}
