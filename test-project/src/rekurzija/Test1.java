package rekurzija;

public class Test1 {

	public static void main(String[] args) {
		
		
		BstRekurzija tree1 = new BstRekurzija();
		tree1.rInsert(122);
		tree1.rInsert(22);
		tree1.rInsert(33);
		tree1.rInsert(44);
		tree1.rInsert(55);
		
		
		
		tree1.rDelete(44);
		
		tree1.printInOrder();
		
		
	//	System.out.println(saberi(1));
	//		System.out.println(factoriel(4));
	}

	public static int saberi(int n) {
		if(n == 10) {
			return n;
		}else {
		return	 saberi(n + 1);
		}

		
	}
	
	public static int factoriel(int n) {
		if(n == 1) {
			return 1;
		}
		return n*factoriel(n-1);
	}
}
