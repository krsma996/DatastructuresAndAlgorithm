package leetcodeExercise.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {

	public static void main(String[] args) {
		int rowsNum = 3;
		List<Integer> generatedNums = generateRow(rowsNum);
		System.out.println(Arrays.asList(generatedNums));
	}

	public static List<Integer> generateRow(int rowIndex) {
		List<Integer> result = new ArrayList<>();
		if (rowIndex < 0)return result; // Edge case
		
		result.add(1); // Prvi element uvek 1
		for (int i = 1; i <= rowIndex; i++) {
			// Kreiraj novu listu koja će sadržati sledeći red
			List<Integer> newRow = new ArrayList<>();
			newRow.add(1); // Početak reda je uvek 1

			// Popunjavaj red sa zbirima prethodnih elemenata
			//i isto kao i kod prethodnog usranog paskala nece ti prvi put obraditi unutrasnju
			//jer je i = 1 i nije veci od size tek kada ubaci drugu 1 e onda ulazi i
			//ubacuje ti rezultate
			for (int j = 1; j < result.size(); j++) {
				//ovde ce dodati rezultat
				newRow.add(result.get(j) + result.get(j - 1));
			}

			newRow.add(1); // Kraj reda je uvek 1
			//ta result ce biti new row
			result = newRow; // Zameni prethodni red sa novim
		}
		return result;
	}
}