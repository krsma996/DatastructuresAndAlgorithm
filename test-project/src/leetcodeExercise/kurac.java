package leetcodeExercise;

import java.util.ArrayList;

public class kurac {

	public static void main(String[] args) {

		ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();
		ArrayList<String> singleList = new ArrayList<String>();
		singleList.add("hello");
		singleList.add("world");
		listOLists.add(singleList);
		

		for(String strings : singleList) {
			System.out.println(strings);
		}
		
		for(ArrayList<String> strings : listOLists) {
			System.out.println(strings);
		}
	}
}
