package Heaps;

public class HeapNikolaMain {

	public static void main(String[] args) {
		HeapNikola heap1 = new HeapNikola();
		heap1.insert(100);
		heap1.insert(23);
		heap1.insert(33);
		heap1.insert(44);
		
		heap1.insert(1222);
		
		heap1.remove();
		System.out.println(heap1.getHeaps());
	}

}
