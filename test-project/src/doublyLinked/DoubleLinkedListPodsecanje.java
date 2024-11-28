package doublyLinked;
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
	
	
	
	public Node append(int value) {
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
		return newNode;
	}

	
	public Node removeLast() {
		Node tempNode = this.tail;
		if(lenght == 0) {
			head = null;
			tail = null;
		}
		tail = tail.previous;
		tail.next = null;
		tempNode.previous = null;
		lenght--;
		
		return tempNode;
		
	}
	
	public Node removeFirst() {
		Node currentNode = this.head;
		if (head == null || tail == null) {
			System.out.println("My linked list is Empty ");
			return null;
		}
		head = head.next;
		head.previous = null;
		currentNode.next = null;
		lenght--;
		if(lenght == 0) {
			head = null;
			tail = null;
		}
		return currentNode;
	}
	
	   public void prepend(int value) {
	        Node newNode = new Node(value);
	        if(lenght == 0) {
	            head = newNode;
	            tail = newNode;
	        } else {
	            newNode.next = head;
	            head.previous = newNode;
	            head = newNode;
	        }
	        lenght++;
	    }
	
	
	
	public Node get(int index) {
		Node currentNode = this.head;
		if (index < 0 || index >= lenght) {
			System.out.println("Invalid get value you pussy shit");
			return null;
		}
		if (index < lenght / 2) {
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.next;
			}

		} else {
			currentNode = this.tail;
			for (int j = lenght - 1; j > index; j--) {
				currentNode = currentNode.previous;
			}
		}
		return currentNode;
	}
	
	
	public boolean set(int index,int value) {
		Node getNode = get(index);
		if(getNode !=null) {
			getNode.value = value;
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean insert(int index,int value) {
		 if (index < 0 || index > lenght)return false;
		Node newNode = new Node(value);
		if(index == 0) {
			 prepend(value);
			 return true;
		}
		if(index == lenght - 1) {
			 append(value);
			 return true;
		}
		
		Node previousNode = get(index -1);
		Node currentNode = previousNode.next;
		previousNode.next = newNode;
		newNode.previous = previousNode;	
		newNode.next = currentNode;
		currentNode.previous = newNode;
		lenght++;
		return true;
	}
	
	public Node remove(int index) {
		if (index < 0 || index > lenght)
			return null;

		if (index == 0) {
			return removeFirst();
		}
		if (index == lenght - 1) {
			return removeLast();
		}
		Node currentNode = get(index);
		Node previousNode = currentNode.previous;
		Node nextNode = currentNode.next;
		
		previousNode.next = nextNode;
		nextNode.previous = previousNode;
		
		currentNode.next = null;
		currentNode.previous = null;
		
		lenght--;
		if (lenght == 0) {
			this.head = null;
			this.tail = null;
		}
		return currentNode;
	}
	
	
	public void printList() {
		Node temp = this.head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;

		}
	}

	public Node getHead() {
		if (this.head == null) {
			System.out.println("Head is null bro");
			return null;
		}
		System.out.println("Head value is = " + this.head.value);
		return head;
	}

	public Node getTail() {
		if (this.tail == null) {
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
