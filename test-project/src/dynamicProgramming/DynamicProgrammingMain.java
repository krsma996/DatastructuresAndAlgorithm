package dynamicProgramming;

public class DynamicProgrammingMain {

	public static void main(String[] args) {
		
		/*
		 * int n = 3;
		 * 
		 * System.out.println("\nFib of " + n + " = " + fib(n));
		 * 
		 * System.out.println("\nCounter: " + counter);
		 */
        
        int n2 = 3;
        System.out.println(classicFib(n2));
		
	}
	
	
	static int counter = 0;
	static Integer memo[] = new Integer[100];
	public static int fib(int n) {
		 counter++;
		 if(memo[n] !=null) {
			 return n;
		 }
		if(n == 1 || n == 0) {
			return n;
		}
		 memo[n]= fib(n - 1) + fib(n - 2);
		 return memo[n];
	}
	
	public static int classicFib(int n) {
		if(n <= 1) {
			return n;
		}else {
		return	classicFib(n -1) + classicFib(n - 2);
		}
	}

}
