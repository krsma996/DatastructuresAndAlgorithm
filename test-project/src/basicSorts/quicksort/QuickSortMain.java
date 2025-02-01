package basicSorts.quicksort;

import java.util.Arrays;

public class QuickSortMain {

	public static void main(String[] args) {
		int array1[] = {4,2,3,6,5,8,7};
		int returnedIndex = pivot(array1, 0);
		System.out.println("Returned Index = " + returnedIndex);
		System.out.println(Arrays.toString(array1));
		System.out.println("-----------------------");
	}

	
	//fora je ovde sto se uzme prvi element niza 
	//i na osnou te vrednosti niza radi se swapovanje
	// swapIndex i pivot index su na 0 tj pocinju na indexu 0;
	// a kada se vrti petlja gurne se pokazivac desno za 1
	// i onda se radi porededjenje
	private static int pivot(int array1[],int pivotIndex) {
		int swapIndex = pivotIndex;
		for(int i = pivotIndex+1;i <= array1.length -1;i++) {
			//da li je 2 vrednost u nizu manja od prve vrednosti u nizu 
			//ako jeste radimo swap
			if(array1[i]<array1[pivotIndex]) {
				// guramo pokazivac 
				swapIndex++;
				// radimo swapovanje 
				// i je vrednost sledeca ( jer je poceo sa pivot + 1)
				// swapIndex je vrednost prethoda ( a ovaj debil krenuo od 0)
				swap(array1, swapIndex, i);
			}
		}
		// kada izvrsi swp swapovanje na kraju samo zamenimo pivotPocetni index sa swap indexom da ta vrednost s kojom
		// smo poredili sve vrednosti stavimo na sredinu
		 swap(array1, pivotIndex, swapIndex);
		return swapIndex;
	}
	
	// ovaj usrani swap je toliko cest u algoritmima da je to jebeno nevidjeno
	private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
