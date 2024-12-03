package rekurzija;

public class Test1 {

	public static void main(String[] args) {
		
		System.out.println(saberi(1));
	}

	public static int saberi(int n) {
		if(n == 10) {
			return n;
		}else {
		return	 saberi(n + 1);
		}

		
	}
}
