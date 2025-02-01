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
		int commbined[] = new int[array1.length + array2.length]; // rezultat na kraju koji vraca sortiranu listu
		int index = 0; // ovo ce biti index od combied[] array
		int i = 0; // ovo se koristi da se iterira 1 polovina
		int j = 0; // a ovo se koristi da se iterira 2 polovina
		//dakle fora je ovde sto ce da u toj listi COMBINED da ocekaje 1 po 1 element da bude sortiran
		//i moze se desi da array1 vise nema elemenete a array2 ima
		// i onda se posoebno za svaki while petlja opaljuje da vidi dal ima nesto u njima
		
		// ovo se vrti kada se jedno od ove 2 liste nebude prazna
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
		// a kada bude prazna onda proletimo posebno sa leve
		// i onda ako ima nesto sto je ostalo u array1.lenght ti ih dodaj u combined
		while (i < array1.length) {
			commbined[index] = array1[i];
			index++;
			i++;
		}
		
		// i onda prevrtimo posebno sa desne
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
		 if (array.length == 1) return array; //kada se poziva rekuzivno  i kada duzina bude bila 1 e onda ce poceti da POP iz call stacka sve vrednosti
	        
		 // uzece niz koji mu je prosledjen i podelice duzinu na pola
		 	int midIndex = array.length/2;
		 	// ovde od te polovine ce da kopira vrednosti u niz left i rekuznivno ce se pozivati
	        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
	        // kad zavrsi levu stranu onda ide i cepka desnu stranu i kopira vrednosti  i isto ce se rekuzivno pozivati
	        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));
	        
	        // a ovde ce da radi swapovanje
	        return merge(left, right);
	}
}
