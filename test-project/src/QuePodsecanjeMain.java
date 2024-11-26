
public class QuePodsecanjeMain {

	public static void main(String[] args) {
		QuePodsecanje que = new QuePodsecanje(1);
		que.enque(2);
		que.enque(3);
		que.enque(4);
		que.enque(5);
		que.deque();
		que.deque();
		que.getFirst();
		que.getLast();
		que.printList();

	}

}
