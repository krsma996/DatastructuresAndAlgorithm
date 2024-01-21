
public class LinkedListNikola {

	private Node head;
	private Node tail;
	private int lenght;

	public LinkedListNikola(int newValue) {
		Node newNode = new Node(newValue);
		head = newNode;
		tail = newNode;
		lenght = 1;
	}

	class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}

	}

	public void appendNode(int value) {
		Node newNode = new Node(value);
		if (head == null || tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		lenght++;
	}

	public Node removeLastNode() {
		Node nextHead = head;
		Node pre = head;
		if (head == null || tail == null) {
			System.out.println("My linked list is Empty ");
			return null;
		}
		while (nextHead.next != null) {
			pre = nextHead;
			nextHead = nextHead.next;
		}
		this.tail = pre;
		this.tail.next = null;
		lenght--;

		if (lenght == 0) {
			this.head = null;
			this.tail = null;
		}
		return nextHead;
	}

	
	public void prependNode(int newNode) {
		Node prependedNode = new Node(newNode);
		if(head == null || tail == null) {
			head = prependedNode;
			tail = prependedNode;
			lenght = 1;
		}else {
			prependedNode.next = head;
			this.head = prependedNode;			
			lenght++;
			
		}
	}
	
	public Node removeFirstItem() {
		Node temp = head;
		if(head == null || tail == null) {
			System.out.println("List is empty ");
			return null;
		}
		head = temp.next;
		System.out.println("I REMOVED " + temp.value);
		temp.next = null;
		lenght--;
		return temp;
	}
	
	
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println("Vales in List is = " + temp.value);
			temp = temp.next;
		}
	}

	public void getHead() {
		if (head == null) {
			System.out.println("Head: null");
		} else {
			System.out.println("Head: " + head.value);
		}
	}

	public void getTail() {
		if (tail == null) {
			System.out.println("Tail: null");
		} else {
			System.out.println("Tail: " + tail.value);
		}
	}

	public int getLenght() {
		System.out.println("Lenght = " + lenght);
		return lenght;
	}

}
