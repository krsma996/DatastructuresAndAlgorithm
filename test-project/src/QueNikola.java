public class QueNikola {

	int value;
	Node first;
	Node last;
	int lenght;

	public QueNikola(int value) {
		Node newNode = new Node(value);
		first = newNode;
		last = newNode;
		lenght++;
	}

	class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}

	}

	public void enque(int value) {
		Node newNode = new Node(value);
		if (first == null || last == null) {
			this.first = newNode;
			this.last = newNode;
		} else {
			this.last.next = newNode;
			this.last = newNode;
		}
		lenght++;
	}

	public Node deque() {
		Node temp = this.first;
		if (first == null || last == null) {
			System.out.println("List is null");
			return null;
		}else if(lenght == 1) {
			first = null;
			last  = null;
		}else {
			first = first.next;
			temp.next = null;
		}
		lenght--;
		System.out.println("Deleted = " +temp.value);
		return temp;
	}

	public void printList() {
		Node temp = first;
		while (temp != null) {
			System.out.println("Values in list = " + temp.value);
			temp = temp.next;
		}
	}

	public void getFirst() {
		if (first == null) {
			System.out.println("First: null");
		} else {
			System.out.println("First: " + first.value);
		}
	}

	public void getLast() {
		if (last == null) {
			System.out.println("Last is = null");
		} else {
			System.out.println("Last is = " + last.value);
		}
	}

	public int getLenght() {
		System.out.println("Lenght IS " + this.lenght);
		return lenght;
	}
}
