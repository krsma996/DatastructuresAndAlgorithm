//FIFO 
// FIRST IN FIRST OUT
//Kao kad se ceka red za penziju 
//ili kao u wowu cekas que
public class QuePodsecanje {

	int lenght = 0;
	Node first;
	Node last;

	public QuePodsecanje(int value) {
		Node newNode = new Node(value);
		first = newNode;
		last = newNode;
		lenght++;
	}

	//kao kada dolaze ljudi i puni se red
	//dodaje se uvek na kraj reda
	public Node enque(int value) {
		Node newNode = new Node(value);
		if (first == null || last == null) {
			this.first = newNode;
			this.last = newNode;
		} else {
			last.next = newNode;
			last = newNode;		
		}
		lenght++;
		return newNode;
	}
//ko prvi uplati penziju on se brise iz reda
	// uvek prvi koji je dosao prvi ce i da izadje
	//FIFO
	public Node deque() {
		Node firstTemp = this.first;
		if (first == null || last == null) {
			System.out.println("List is null");
			return null;
		}else {
			first = first.next;
			firstTemp.next = null;
		}
		lenght--;
		return firstTemp;
	}

	class Node {

		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}

	}

	public int getLenght() {
		System.out.println("Lenght is = " + lenght);
		return lenght;
	}

	public Node getFirst() {
		if (first == null) {
			return null;
		}
		System.out.println("First value is = " + first.value);
		return first;
	}

	public Node getLast() {
		if (last == null) {
			return null;
		}
		System.out.println("Last value is = " + last.value);
		return last;
	}

	public void printList() {
		Node temp = this.first;

		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
}
