package leetcodeExercise.easy;

import java.util.HashMap;
import java.util.Map;

public class ContaintsDuplicate2 {

	public static void main(String[] args) {
		int niz1[] = {1,2,3,1};
		int niz2[] = {1,0,1,1};
		int niz3[] = {1,2,3,1,2,3};

		int k1=3;
		
		boolean containsDuplicate = containsNearbyDuplicate(niz2, k1);
		System.out.println(containsDuplicate);
	}

	
	/*
		Zadatak je malo retardiran ali poenta je ova njegova sta se trazi dakle: 
		1.) Treba da pronadje najblize duplikate i da uporedis da li su oni manji ili jednako od < k1 
		  a to k1 ti predstavlja kao neku duzinu njihovu 
		  
		  U sustini kako se resava ako imas niz {1,2,3,1}
		  
		  dakle ovde vidimo da su duplikati 1 na pocetku i 1 na kraju
		  
		  dakle index od 1 broja u nizu je 0 a od zadnjeg je 3 
		  
		  i kako da provers da li su oni u range ili su dovoljno blizu
		  
		  tako sto oduzmes im indexe njhivoe a ne vrednosti
		  
		  dakle 3 - 0 = 3   a ako je k1 bio 3 onda ce ti vrati true jer je 3 <= k 
	 */
	  public static boolean containsNearbyDuplicate(int[] nums, int k) {
		  //klasican base case
		  	if(nums.length == 0 || k == 0) return false;
		  	//klasicno pravljenje mape
		  	Map<Integer,Integer> maps = new HashMap<>();
		  	//iteriramo kroz niz nums
		  	for(int i = 0;i<=nums.length-1;i++) {
		  		//uzimamo prvi broj u nizu
		  		int numInArray = nums[i];
		  		//i pitamo ga DALI taj prvi broj vec postoji u mapi i DA LI Je index minus vrednost iz nummarray vece ili jednako tom k
		  		if(maps.containsKey(numInArray) && i - maps.get(numInArray) <= k ) {
		  			//i dok dodjemo do tog duplikata onda se radi uslov i vratice ti true
		  			return true;
		  		}
		  		//ako nije stavljamo ga u mapu
		  		maps.put(numInArray, i);
		  	}
		  	//Ako ceo niz proletimo onda znaci da mi nismo nasli duplikate u nizu najbilize i nismo
		  	//uslov zadovoljili
	        return false;
	    }
}
