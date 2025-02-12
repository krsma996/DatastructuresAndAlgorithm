package dynamicProgramming;

public class DynamicProgrammingMain {

	public static void main(String[] args) {
		
		System.out.println(fib(40));
		System.out.println("\nCounter: " + counter);
		
	}
	
	
	static int counter = 0;
	Integer memo[] = new Integer[100];
	public static int fib(int n) {
		 counter++;
		if(n == 1 ||n == 0) {
			return n;
		}
		 return fib(n - 1) + fib(n - 2);
	}

}
