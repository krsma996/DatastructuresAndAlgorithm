package linkedList;

public class MainPodsecanje {

	public static void main(String[] args) {
		
		LinkedListPodsecanje list = new LinkedListPodsecanje(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.prepend(22);
		list.prepend(33);
		
		list.removeFirstNode();
		list.removeLastNode();
		list.prepend(1);
		list.insert(4, 225);
		System.out.println("Value from get = " + list.get(4).value);
		list.set(4, 4333);
		list.insert(4, 225);
		
		list.remove(1);
		
		list.printList();
		list.reverse();
		System.out.println("----------------------------");
		list.printList();
		list.getLenght();
		/*
		 * list.getHead(); list.getTail(); list.getLenght();
		 */

	}

}
