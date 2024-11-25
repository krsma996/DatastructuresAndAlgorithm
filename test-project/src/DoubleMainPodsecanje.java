
public class DoubleMainPodsecanje {

	public static void main(String[] args) {
		
		
		DoubleLinkedListPodsecanje doubleLinked  = new DoubleLinkedListPodsecanje(99);		
		
		
		doubleLinked.append(2);
		doubleLinked.append(23);
		doubleLinked.append(24);
		doubleLinked.append(222);
		doubleLinked.removeLast();
		doubleLinked.removeFirst();
		
		doubleLinked.prependNode(444);
		
		doubleLinked.printList();
		doubleLinked.getHead();
		doubleLinked.getTail();
		doubleLinked.getLenght();
		
	}

}
