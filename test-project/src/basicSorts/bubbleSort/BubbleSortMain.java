package basicSorts.bubbleSort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSortMain {

	public static void main(String[] args) {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(12);
		lista.add(33);
		lista.add(4);
		lista.add(55);
		
		int temp = 0;
	        for (int i = 0; i < lista.size() - 1; i++) {
	            for (int j = 0; j < lista.size() - 1 - i; j++) {
	                if (lista.get(j) > lista.get(j + 1)) {
	                    temp = lista.get(j);
	                    lista.set(j, lista.get(j+1));
	                    lista.set(j + 1, temp);
	                }
	            }
	        }
		
		for (Integer integer : lista) {
			System.out.println(integer);
		}
	}
}
