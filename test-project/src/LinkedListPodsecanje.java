public class LinkedListPodsecanje {

	private Node head;
	private Node tail;
	private int length = 0;
	
	public LinkedListPodsecanje(int value) {
		Node newNode = new Node(value);
		this.head = newNode;
		this.tail = newNode;
		this.length++;
	}
	
	 class Node {
		int value;
		Node next;
		public Node(int value) {
			this.value = value;
		}
	}

//append na kraj niza
//head ostaje uvek na pocetku
	 //tail se mrda svaki put kad se ubaci jebeni novi node
	 public void append(int value) {
		 Node newNode = new Node(value);
		 if(this.head == null || this.tail == null) {
			 this.head = newNode;
			 this.tail = newNode;
		 }else {
			 this.tail.next = newNode;
			 tail = newNode;
			 
		 }
		 length++;
	 }
	 
	 //ova je zajebana
	 public Node removeLastNode() {
		 Node tempNode = this.head;
		 Node prethodniNode = this.head;
		 if(this.head == null || this.tail == null) {
			 System.out.println("List is fucking null");
			return null;
		 }else {
			 while(tempNode.next != null) {
				 prethodniNode = tempNode;
				 tempNode = prethodniNode.next;
			 }	 
			 this.tail = prethodniNode;
			 this.tail.next = null;
			 length--;
			if(length == 0) {
				this.head = null;
				this.tail = null;
				length = 0;
			}
		 }
		 System.out.println("This shit is deleted from list = " + tempNode.value);
		return tempNode;//for now
	 }
	 
	 
	 
	 public void prepend(int value) {
		 Node newNode = new Node(value);
		 if(this.head == null || this.tail == null) {
			 this.head = newNode;
			 this.tail = newNode;
		 }else {
			 newNode.next = head;
			 head = newNode;
			
		 }	
		 length++;
	 }
	 
	 
	 public Node removeFirstNode() {
		 Node firstNode = this.head;
		 if(this.head == null || this.tail == null) {
			 System.out.println("List is fucking null");
			 return null;
		 }else {
			this.head = firstNode.next;
			firstNode.next = null;
			length--;
			if(length == 0) {
				this.head = null;
				this.tail = null;
			}
			 return firstNode;
		 }
	 }
	
	 
	 
	 public Node get(int index) {
		 Node tempNode = this.head;		 
		 if(index <0 || index>= length) {
			 System.out.println("Cannot be less than zero or greater than bound of lenght");
				return null;
		 }
		 for (int i = 0; i < index; i++) {
			    tempNode = tempNode.next;
			}

		 return tempNode;
	 }
	 
	 
	 public boolean set(int index, int value) {
		 Node tempNode = get(index);
		 if(tempNode !=null) {
			 tempNode.value = value;
			 return true;
		 }else {
			 System.out.println("Failovo si");
			 return false;
		 }
		 
	 }
	 
	 /*
	  * insert a new node over a partical node
	 */
	 public boolean insert(int index, int value) {
		 Node newNode = new Node(value);
		 if (index < 0 || index > length) return false;
		 if(index == 0) {
			 prepend(value);
			 return true;
		 }else if( index == length) {
			 append(value);
			 return true;
		 }else{
			 Node previousNode = get(index - 1);
			 Node currentNode = previousNode.next;
			 previousNode.next = newNode;
			 newNode.next = currentNode;
			 length++;
			 return true;
		 } 
	 }
	 
	 
		public Node remove(int index) {
			if (index < 0 || index > length) {
				return null;
			}	
			if (index == 0) {
				return removeFirstNode();
			}
			if (index == length - 1) {
				return removeLastNode();
			}
			Node previousNode = get(index - 1);
			Node currentNode = previousNode.next;
			previousNode.next = currentNode.next;
			currentNode.next = null;
			length--;
			return currentNode;
		}
	 
	 
	 public void reverse() {	 
		 Node tempNode = this.head;
		 this.head = this.tail;
		 this.tail = tempNode;
		 
		 Node sledbeniNode = tempNode.next;
		 Node prethodniNode = null;
		 
		 for(int i = 0 ; i < length; i++) {
			 sledbeniNode = tempNode.next;
			 		tempNode.next = prethodniNode;
			 		prethodniNode = tempNode;
			 		tempNode = sledbeniNode;
		 }	 
	 }
	 


	public Node getHead() {
		if(this.head == null) {
			System.out.println("Head is null");
			return null;
		}else {
			System.out.println("Head value is = " + this.head.value);
			return head;
		}
	}



	public Node getTail() {
		if(this.tail == null) {
			System.out.println("Tail is null");
			return null;
		}else {
			System.out.println("Tail value is = " + this.tail.value);
			return tail;
		}	
	}


 
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println("printList called = " + temp.value);
			temp = temp.next;
		}
	}

	public int getLenght() {
		System.out.println("Lenght = " + length);
		return length;
	}
	
	
	
}
