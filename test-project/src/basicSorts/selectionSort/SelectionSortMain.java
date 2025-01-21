package basicSorts.selectionSort;

public class SelectionSortMain {

	public static void main(String[] args) {
		
		int niz1 [] = {33,22,12,45,1233,444,1};
		
		// SWAPOVANJE SE RADI po INDEXU !! min INDEX !
		
		selectionSort(niz1);
		
		for (int i : niz1) {
			System.out.println(i);
		}
		
	}

	//za selection sortj e fora da uzmes minimalni index A NE VALUE dakle index
	// i da na osnovu njihove vrednosti radis SWAP
	// if(niz1[j] < niz1[minIndex] kaze da VREDNOST na tom nizu J manja od vrednosti na minIndexu
	// ako jeste radimo swap INDEXA njihovih
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
			// u slucaju samo ako se desi da dobije neki index koji je npr na 2 a i jeste najmanja vrednsot njega 
			// da i za njega odradi swap nsita vise
			if(i != minIndex) {
				int temp = niz1[i];
				niz1[i] = niz1[minIndex];
				niz1[minIndex] = temp;
				
			}
		}
		
	}
}
