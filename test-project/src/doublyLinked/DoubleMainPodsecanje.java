package doublyLinked;

public class DoubleMainPodsecanje {

	public static void main(String[] args) {
		
		
		DoubleLinkedListPodsecanje doubleLinked  = new DoubleLinkedListPodsecanje(99);		
		
		
		doubleLinked.append(2);
		doubleLinked.append(3);
		doubleLinked.append(4);
		doubleLinked.append(5);

		System.out.println("GET CALLED RETURN = " + doubleLinked.get(0).value);
		doubleLinked.set(3, 333);
		doubleLinked.insert(3, 1005);

		
		doubleLinked.printList();
		doubleLinked.getHead();
		doubleLinked.getTail();
		doubleLinked.getLenght();
		
	}

}
