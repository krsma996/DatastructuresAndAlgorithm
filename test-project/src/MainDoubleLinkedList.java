public class MainDoubleLinkedList {

	public static void main(String[] args) {
		DoublyLinkedList myDouble = new DoublyLinkedList(1);
		
		myDouble.appendNode(2);
		myDouble.appendNode(3);
		

		
//		myDouble.removeLastNode();
//		
//		myDouble.prependNode(456);
//		System.out.println(myDouble.get(2).value);
//		myDouble.remoFirstNode();
//		myDouble.remoFirstNode();
//		myDouble.remoFirstNode();
//		myDouble.remoFirstNode();
		
//		System.out.println(myDouble.set(1, 4500));
//		System.out.println(myDouble.set(2, 3500));
		
		System.out.println(myDouble.insert(1, 45));
		
		System.out.println("DELETED ! = " + myDouble.remove(1).value);
		System.out.println("DELETED ! = " + myDouble.remove(2).value);


		
		myDouble.getTail();
		myDouble.getHead();
		myDouble.getLenght();
		myDouble.printList();
		
	}

}
