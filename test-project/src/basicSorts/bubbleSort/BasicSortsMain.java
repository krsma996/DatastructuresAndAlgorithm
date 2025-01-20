package basicSorts.bubbleSort;

public class BasicSortsMain {

    public static void main(String[] args) {
        
        int array1[] = { 64, 34, 25, 12, 22, 11, 90 };
        
        int temp = 0;
        boolean swapped;

        for (int i = 0; i < array1.length - 1; i++) { // Ispravljen uslov
        	swapped = false;
        	for(int j = 0; j < array1.length - 1;j++) {
        		if(array1[j] > array1[j+1]) {
        			temp = array1[j];
        			array1[j] = array1[j + 1];
        			array1[j + 1] = temp;     			
        		}
        		if (!swapped) { // Ako nije bilo zamena, niz je sortiran
                    break;
                }
        	}
        }

        printArray(array1, array1.length);
    }

    static void printArray(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
