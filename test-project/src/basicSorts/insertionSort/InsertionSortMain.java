package basicSorts.insertionSort;

public class InsertionSortMain {

	public static void main(String[] args) {
		
		int niz1 [] = {33,22,12,45,1233,444,1};
		
		
		selectionSort(niz1);
		
		for (int i : niz1) {
			System.out.println(i);
		}
		
	}

	private static void selectionSort(int[] niz1) {
		for(int i=0;i<niz1.length;i++) {
			int minIndex = i;
			//trazi minimalni index
			for(int j = i + 1;j < niz1.length;j++) {
				if(niz1[j] < niz1[minIndex]) {
					minIndex = j;
				}
			}
			//ovde radi swap klasican
			if(i != minIndex) {
				int temp = niz1[i];
				niz1[i] = niz1[minIndex];
				niz1[minIndex] = temp;
				
			}
		}
		
	}
}
