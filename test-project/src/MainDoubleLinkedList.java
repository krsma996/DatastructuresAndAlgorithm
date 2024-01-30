
public class MainDoubleLinkedList {

	public static void main(String[] args) {
		DoublyLinkedList myDouble = new DoublyLinkedList(1);
		
		myDouble.appendNode(2);
		myDouble.appendNode(3);
		

		
		myDouble.removeLastNode();
		
		myDouble.prependNode(456);
		System.out.println(myDouble.get(2).value);
//		myDouble.remoFirstNode();
//		myDouble.remoFirstNode();
//		myDouble.remoFirstNode();
//		myDouble.remoFirstNode();
		myDouble.getTail();
		myDouble.getHead();
		myDouble.getLenght();
		myDouble.printList();
	}

}
