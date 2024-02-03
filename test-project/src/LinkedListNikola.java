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

	public Node get(int index) {
		Node temp= this.head;
		if(index <0 || index>= lenght) {
			System.out.println("Invalid " + index);
			return null;
		}
		for(int i = 0; i<=index; i++) {
			temp = temp.next;
		}
		System.out.println("Returned element " + temp.value);
		return temp;
		
	}
	
	public boolean set(int index, int value) {
		if (index < 0 || index >= lenght) {
			System.out.println("IMPOSSIBLE !!!" + index);
			return false;
		}
		Node temp = get(index);
		if(temp != null) {
			temp.value = value;
			return true;
		}

		return false;
	}
	
	/*
	 * insert a new node over a partical node
	 */
	public boolean insert(int index,int value) {
		Node newNode = new Node(value);
		if(index <0 || index > lenght) {
			System.out.println("Invalid " + index);
			return false;
		}
		if(index == 0) {
			prependNode(value);
			return true;
		}
		if(lenght == index) {
			appendNode(value);
			return true;
		}
		//ovo vraca node prethodni od indexa dakel dodje npr do 5 elementa on ce ti vrati 4
		Node temp = get(index - 1);
		//moj novi node ce da pokazuje ka sledecem
		newNode.next = temp.next;
		//ovaj node na tom indexu ce da pokazuje na tom novom node
		temp.next = newNode;
		lenght++;
		return true;
	}
	
	public boolean remove(int index) {
		if(index <0 || index > lenght) {
			System.out.println("INVALIDDDDDD!!!!!!!!!" + index);
			return false;
		}	
		if(index == 0) {
			removeFirstItem();
			return true; 
		}
		if(lenght == index - 1) {
			removeLastNode();
			return true;
		}
		Node prev = get(index -1);
		Node temp = prev.next;	
		prev.next = temp.next;
		temp.next = null;
		lenght --;
		return true;	
	}
	
	public void reverse() {
		Node tempHead = this.head;
		head = tail;
		tail = tempHead;
		
		Node prethodniNode = null;
		Node sledbeniNode = tempHead.next;
		
		for(int i = 0; i< lenght; i++) {
			sledbeniNode = tempHead.next;
					tempHead.next = prethodniNode;
					prethodniNode = tempHead; 
					tempHead = sledbeniNode;
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
		System.out.println("Lenght = " + lenght);
		return lenght;
	}

}
