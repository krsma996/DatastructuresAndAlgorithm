
public class Main {

	public static void main(String[] args) {
		
		
	
		
		LinkedListNikola linkedListNikola = new LinkedListNikola(5);
		
		int broj1 = 15;
		int broj2 = 23;
		int broj3 = 150;
		
		
		linkedListNikola.appendNode(broj1);
		linkedListNikola.appendNode(broj2);
		linkedListNikola.appendNode(broj3);
	//	linkedListNikola.prependNode(124);
	//	linkedListNikola.prependNode(305);
		

//		linkedListNikola.removeLastNode();
//		linkedListNikola.removeLastNode();
//
//		linkedListNikola.removeFirstItem();
		
//		linkedListNikola.get(3);
		
		linkedListNikola.set(0, 888);
		

		linkedListNikola.insert(1, 987);
		
		
		linkedListNikola.getHead();
		linkedListNikola.getTail();
		linkedListNikola.getLenght();
		linkedListNikola.printList();
		
		
		
		
		
		/*
		 * int numberToFizzBuzz = 100;
		 * 
		 * 
		 * 
		 * fizzBuzzNumber(numberToFizzBuzz);
		 */

	}

	static void fizzBuzzNumber(int numberToFizzBuzz) {
		
		for (int i = 0; i <= numberToFizzBuzz; i++) {
			if(i%3==0 && i%5==0) {
				System.out.println(i + " = " + " Fizz");
			}else if(i%5==0) {
				System.out.println(i + " = " +" Buzz");
			}else if(i%3==0) {
				System.out.println(i + " = " + " FizzBuzzBro!");
			}else {
				System.out.println( + i + " = " +" OVAJ NIJE DELJIV NI SA 3 nI sa 5");
			}
		}
		
	}

}
