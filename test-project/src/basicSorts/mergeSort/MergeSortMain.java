package basicSorts.mergeSort;

import java.util.Arrays;

/*
 * Merge sort je dakle kada uzmemo neku list npr int niz[] = {2,3,4,5,6,7};
 * da bi smo odradili merge sort mi cemu tu listu da uzmemo i da je delimo sve vreme po pola
 * dok nedobijemo nesto tipa ovako {2} , {3}, {4} ... itd... dakle svaki item u listi je poseban lista za sebe i automacki je sortirana
 * kada ima 1 element
 * 
 * i onda kada kreces da ih spajas MErge radis swapovanje i sortiras ih sve dok nedobijes sortiranu listu na kraju
 * 
 * dakle delis sve po / 2 za listu
 * i onda se penjes spajas ih da dobijes sortiranu listu
  */
public class MergeSortMain {

	public static void main(String[] args) {
		int niz2[] = { 22, 12, 7, 155, 1243, 456 ,2, 44, 3, 43, 55, 12};
		System.out.println("----------------------- before");
		System.out.println(Arrays.toString(niz2));
		System.out.println("----------------------- after");
		System.out.println(Arrays.toString(mergeSort(niz2)));
	}

	public static int[] merge(int array1[], int array2[]) {
		int commbined[] = new int[array1.length + array2.length];
		int index = 0; // ovo ce biti index od combied[] array
		int i = 0; // ovo se koristi da se iterira 1 polovina
		int j = 0; // a ovo se koristi da se iterira 2 polovina
		//dakle fora je ovde sto ce da u toj listi COMBINED da ocekaje 1 po 1 element da bude sortiran
		//i moze se desi da array1 vise nema elemenete a array2 ima
		// i onda se posoebno za svaki while petlja opaljuje da vidi dal ima nesto u njima
		while (i < array1.length && j < array2.length) {
			// i < array1.length da li je prvi array1 prazan
			// j <i < array2.length da li je drugi array2 prazan
			if (array1[i] < array2[j]) {
				commbined[index] = array1[i];
	                index++;
	                i++;
			} else {
				commbined[index] = array2[j];
				index++;
				j++;
			}
		}
		// i onda ako ima nesto sto je ostalo u array1.lenght ti ih dodaj u combined
		while (i < array1.length) {
			commbined[index] = array1[i];
			index++;
			i++;
		}
		//a ako ima nesto u 2 array ti ih dodaj isto u combined
		// u smisli da su ostalo jos neki elementi da se ubace 
		while (j < array2.length) {
			commbined[index] = array2[j];
			index++;
			j++;
		}

		return commbined;
	}

	//ovo cepka listu na pola 
	// i onda od njih radi merge swapuje ih
	public static int[] mergeSort(int [] array) {
		 if (array.length == 1) return array; //vratice rezultat zadnjej vrednosti u call stacku pa ce krene da pop
	        int midIndex = array.length/2;
	        //ovde kazes copy mi array kreni od 0 do MIN index-a a to je polovina njegova zadnja
	        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
	        //a ovde od polove zadnje do duzine
	        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

	        //kad u callsteck rekuzivnom pozivu ima 1 vrednost i right isto ima 2 vrednost tad radi merge ovde ispod
	        return merge(left, right);
	}
}
