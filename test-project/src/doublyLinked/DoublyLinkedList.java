package doublyLinked;
public class DoublyLinkedList {

	Node tail;
	Node head;
	int lenght;

	class Node {

		int value;
		Node next;
		Node previous;

		public Node(int value) {
			this.value = value;
		}
	}
	
	public DoublyLinkedList(int newValue) {
		Node newNode = new Node(newValue);
		this.tail = newNode;
		this.head = newNode;
		this.lenght++;
	}

	public void appendNode(int value) {
		Node appendedNode = new Node(value);
		if (this.head == null || this.tail == null) {
			head = appendedNode;
			tail = appendedNode;
		} else {
			tail.next = appendedNode;
			appendedNode.previous = tail;
			tail = appendedNode;
			lenght++;
		}
	}

	public Node removeLastNode() {
		if (lenght == 0) {
			return null;
		}
		Node temp = tail;
		if (lenght == 1) {
			head = null;
			tail = null;
		} else {
			tail = tail.previous;
			tail.next = null;
			temp.previous = null;
		}
		lenght--;
		return temp;

// MY SOLO APPROACH with WHILE LOOP
//		Node currentHead = this.head;
//		Node previous  = this.head;
//		if (head == null || tail == null) {
//			System.out.println("My linked list is Empty ");
//			return null;
//		}
//		while(currentHead.next !=null) {
//			previous = currentHead;
//			currentHead = currentHead.next;
//		}
//		
//		tail = previous;
//		tail.next = null;
//		currentHead = null;
//		lenght--;
//		
//		return currentHead;
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
		System.out.println("Lengt is: " + lenght);
		return lenght;
	}

}
