
public class QueNikolaMain {

	public static void main(String[] args) {
		
		QueNikola myQue = new QueNikola(1);
		
		myQue.enque(2);
		myQue.enque(3);
		myQue.enque(4);
		
		myQue.deque();
		myQue.deque();
		
		myQue.getLenght();
		myQue.getLast();
		myQue.getFirst();
		myQue.printList();

	}

}
