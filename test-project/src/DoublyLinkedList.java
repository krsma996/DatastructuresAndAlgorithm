import java.util.Iterator;

public class DoublyLinkedList {

	Node tail;
	Node head;
	int lenght;

	public DoublyLinkedList(int newValue) {
		Node newNode = new Node(newValue);
		this.tail = newNode;
		this.head = newNode;
		this.lenght++;
	}
	
	public Node get(int index) {
		Node temp = this.head;
		if(index < 0 || index >= lenght ) {
			System.out.println("No its not possible my friend");
			return null;
		}
		if(index < lenght/2) {
			for(int i = 0; i<=index;i++) {
				temp = temp.next;
			}
		}else {
			temp = tail;
			for(int j = lenght-1; j >=index;j--) {
				temp = temp.previous;
			}
		}
//		Kao iz single linked liste ovo ce da radi lepo 
// WHAT IS THE MOST EFFICENT WAY TO ACCCES THE ELEMENTS ??
// imas pointer od taila koji ti pokazuje za nazad sto znaci listu podeli na pola 
// a ako ti je index veci od polovine e onda ces poceti od kraja petlje tj od taila 
//		for(int i = 0; i<=index; i++) {
//			temp = temp.next;
//		}
//		System.out.println("Returned element " + temp.value);
		return temp;
		
		
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
		}
		lenght++;
	}

	public void prependNode(int value) {
		Node prependedNode = new Node(value);
		if(head == null || tail == null) {
			head = prependedNode;
			tail = prependedNode;
			lenght = 1;
		}else {
			prependedNode.next = this.head;
			this.head.previous = prependedNode;
			head = prependedNode;
		}
		lenght++;
	}
	
	public Node remoFirstNode() {
		if(lenght == 0) {
			throw new IndexOutOfBoundsException("Out of bound buddy");
		}
		Node temp = head;
		if (lenght == 1) {
			head = null;
			tail = null;
		}else {
			head = head.next;
			head.previous = null;
			temp.next = null;	
		}		
		lenght--;
		return temp;
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

	class Node {

		int value;
		Node next;
		Node previous;

		public Node(int value) {
			this.value = value;
		}
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
