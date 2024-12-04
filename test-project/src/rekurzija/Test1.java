package rekurzija;

public class Test1 {

	public static void main(String[] args) {
		
		
		BstRekurzija tree1 = new BstRekurzija();
		tree1.rInsert(1);
		tree1.rInsert(2);
		tree1.rInsert(3);
		tree1.rInsert(4);
		tree1.rInsert(5);
		
		tree1.printInOrder();
		
		
		
	
		
		
	//	System.out.println(saberi(1));
	}

	public static int saberi(int n) {
		if(n == 10) {
			return n;
		}else {
		return	 saberi(n + 1);
		}

		
	}
}
