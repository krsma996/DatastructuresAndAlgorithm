
public class MainDoubleLinkedList {

	public static void main(String[] args) {
		DoublyLinkedList myDouble = new DoublyLinkedList(1);
		
		myDouble.appendNode(2);
		myDouble.appendNode(3);
		

		
		myDouble.removeLastNode();
		
		myDouble.getTail();
		myDouble.getHead();
		myDouble.getLenght();
		myDouble.printList();
	}

}
