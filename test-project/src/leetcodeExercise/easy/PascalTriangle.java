package leetcodeExercise.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		int rowsNum = 5;
		List<List<Integer>> generatedNums = generate(rowsNum);
		System.out.println(Arrays.asList(generatedNums));

	}

	// tebi je kod paskalovog trougla svaki sledeci u nizu rezultat tj sum dva broja
	// prethodna
	// dakle ako dobijes [5] da je num Rows sto znaci da ide ovako
	// [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
	// a ako je 1 = [1];
	// dakle ovde u zadatku kaze da se generise paskalov trougao bazirano na sumu 2
	// broja
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if (numRows <= 0)return result; // Edge case
		
		result.add(new ArrayList<>()); // Prvi red je uvek [1]
		result.get(0).add(1);

		for (int i = 1; i < numRows; i++) {
			List<Integer> prev = result.get(i - 1); // Uzimamo prethodni red
			List<Integer> newRow = new ArrayList<>();
			newRow.add(1); // Svaki red počinje sa 1
			//prvi uslov se nece izvrsiti  je moj ( j pocinje od 1 ) a size nije veci j < nije veci od 1 dakle 1 < 1 nije tacno
			for (int j = 1; j < prev.size(); j++) {
				//sadasnji plus prethnodi
				newRow.add(prev.get(j) + prev.get(j - 1)); // Zbir dva broja iznad
				// i ovde ce da doda taj broj 2 u listi
			}
			// kada odradi rezultat na kraju svaki red zavrsi sa 1 
			//pa ce da doda na kraju taj 1 
			newRow.add(1); // Svaki red završava sa 1
			result.add(newRow);
		}
		return result;
	}

}
