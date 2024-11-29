package hashTable;

import java.util.List;

public class HashMain {

	public static void main(String[] args) {
		Hash hash = new Hash();
		
	
		hash.set("Nikola", 12);
		hash.set("Nissan", 0);
		hash.set("Cajic", 2);
		hash.set("Patkica", 22);
		hash.set("Tomovic", 23);
		
		hash.set("tile", 344);
		hash.set("nails", 555);
		hash.set("lumber", 066);
		
		hash.printHash();
		System.out.println(hash.get("Nikola"));
		List<String> keys = hash.keys();
		for (String string : keys) {
			System.out.println(string);
		}
}
	
}
