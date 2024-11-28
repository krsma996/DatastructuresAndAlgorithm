package stack;
public class StackNikola {
	
	int value;
	Node top;
	int height;

	public StackNikola(int value) {
		Node stackNode = new Node(value);
		top = stackNode;
		height = 1;
	}

	class Node {
		int value;
		Node next;
		public Node(int value) {
			this.value = value;
		}
		
	}
	
	public void push(int value) {
		Node newNode = new Node(value);
		if(top == null) {
			top = newNode;
		}else {
			newNode.next = top;
			top = newNode;
		}
		
		height++;
	}
	
	public Node pop() {
		Node tempTop = this.top;
		if(top == null) {
			System.out.println("Stack is nul");
			return null;
		}else {
			top = tempTop.next;
			tempTop = null;		
		}
		height--;
		return tempTop;
	}
	
	public void printList() {
		Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
	}
	
	public void getTop() {
		if (top == null) {
			System.out.println("Top: null");
		} else {
			System.out.println("Top: " + top.value);
		}
	}

	public int getHeight() {
		System.out.println("HEIGHT IS " + this.height);
		return height;
	}
}
