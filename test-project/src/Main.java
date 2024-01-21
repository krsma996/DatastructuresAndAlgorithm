
public class Main {

	public static void main(String[] args) {
		
		
		// What is big O ?

				/*
				 * Big O dakle Big O je poredjenje koda ( tako da se izrazim) matematicki bilo
				 * da se radi o vremenskom poredjenju(time complexitiy) ili poredjenju po
				 * prostoru koji zauzima da izvrsi taj kod ( Space complexity)
				 * 
				 * Ako bi kod 1 se izvrsio za 15 sekundi a uzeo mnogo memorijskog resursa ako po
				 * tome poredim to je onda ( Time Complexity ) Ako bi kod 2 se izvrsio za 45
				 * sekundi a uzeo manje memorijskog resursa ako po tome poredim to je onda (
				 * Space Complexity )
				 * 
				 */

				/*
				 * Kada se radi ov Space i Time complexity uvek se javljaju 3 grcka slova
				 * 
				 * Omega , Theta , Omicron (poznat kao big O)
				 * 
				 * ako imamo niz od 7 elementa {1,2,3,4,5,6,7} Omega je najbolji slucaj ako bi
				 * smo u nizu trazili 1 element Theta je osrednji ako bi smo trazili 4 Omicron
				 * je najgori slucaj kada trazimo zadnji element
				 * 
				 * a kada kazemo O(n) imamo npr for petlju
				 * 
				 * printNumber(10){ for(int i < 0; i<n; i++{ syso(i)
				 * 
				 * i na grafu kada bi prikazili donja linija je N a gornja je broj operacija
				 * koja se izvrsava u for petlji mi 10 puta izvrsavamo tu operaciju
				 * 
				 * pravilo "Drop the constant" je jedno od pravila koja se često koristi
				 * prilikom analize vremenske složenosti algoritama koristeći Big O notaciju.
				 * Suština ovog pravila je da se zanemare konstante i manji faktori prilikom
				 * izražavanja vremenske složenosti.
				 * 
				 * Na primer, ako imate algoritam koji zahteva 2n koraka, u Big O notaciji biste
				 * to izrazili kao O(n). S obzirom na to da konstanta 2 nije od suštinskog
				 * značaja prilikom analize rasta vremena izvršavanja u odnosu na veličinu
				 * ulaza, ona se jednostavno zanemaruje
				 * 
				 * 
				 * Notacija O(n^2) označava kvadratnu vremensku složenost Na primer, ako imate
				 * petlju koja prolazi kroz n elemenata i unutar nje još jednu petlju koja
				 * prolazi kroz isti skup elemenata, tada biste mogli reći da algoritam ima
				 * vremensku složenost O(n^2). To je često prisutno kod algoritama koji koriste
				 * dva ugnježdena prolaza kroz podatke, poput algoritma za sortiranje kao što je
				 * Bubble sort, Insertion sort ili Selection sort.
				 * 
				 * 
				 * ako imate jednu metodu koja sadrži tri for petlje, od kojih su dve ugnježdene
				 * (jedna unutar druge), i jednu posebnu for petlju, i ako analiza pokazuje da
				 * su ugnježdene petlje dominantnije u pogledu vremenske složenosti, onda možete
				 * zanemariti posebnu for petlju kada izražavate vremensku složenost algoritma
				 * koristeći Big O notaciju.
				 * 
				 * Na primer, ako su vremenske složenosti ugnježdenih petlji O(n^2) i O(n), a
				 * vremenska složenost posebne for petlje O(n), onda biste izrazili ukupnu
				 * vremensku složenost kao O(n^2 + n). Kada primenite pravilo
				 * "Drop the non-dominants", možete zanemariti manje dominantni član, tj. O(n),
				 * i izraziti vremensku složenost kao O(n^2), fokusirajući se na najdominantniji
				 * član.
				 * 
				 * Ovo je, naravno, opšti pristup i zavisi od konkretnog algoritma i analize
				 * performansi. Važno je razmotriti kako se algoritam ponaša u odnosu na
				 * veličinu ulaza i kako se različiti delovi algoritma doprinose vremenskoj
				 * složenosti
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * O(1): Vremenska složenost je konstantna i ne zavisi od veličine ulaza. To je
				 * najefikasnije vreme izvršavanja.
				 * 
				 * O(n): Vremenska složenost je linearna i raste proporcionalno sa veličinom
				 * ulaza n. Što je n veće, to je i vreme izvršavanja duže.
				 * 
				 * O(n^2): Vremenska složenost je kvadratna, što znači da vreme izvršavanja
				 * raste kvadratno u odnosu na veličinu ulaza. Ovaj tip vremenske složenosti je
				 * često prisutan kod algoritama sa dva ugnježdena prolaza kroz podatke.
				 * 
				 * O(log N) = Vremenska složenost O(log N) se odnosi na algoritme čije vreme
				 * izvršavanja raste logaritamski u odnosu na veličinu ulaza N. Ukljucuje
				 * Linearna pretraga(svaki element prolazimo da bi smo nasli vrednost) i Binarna (podeli i vladaj ) delimo listu na pola sto je mnogo dobro
				 */
				
		
		LinkedListNikola linkedListNikola = new LinkedListNikola(5);
		
		int broj1 = 15;
		int broj2 = 23;
		int broj3 = 150;
		
		
		linkedListNikola.appendNode(broj1);
		linkedListNikola.appendNode(broj2);
		linkedListNikola.appendNode(broj3);
		linkedListNikola.prependNode(124);
		linkedListNikola.prependNode(305);
		linkedListNikola.removeLastNode();
		linkedListNikola.removeLastNode();

		linkedListNikola.removeFirstItem();
		
		
		
		

		linkedListNikola.getHead();
		linkedListNikola.getTail();
		linkedListNikola.getLenght();
		linkedListNikola.printList();
		
		
		
		
		
		/*
		 * int numberToFizzBuzz = 100;
		 * 
		 * 
		 * 
		 * fizzBuzzNumber(numberToFizzBuzz);
		 */

	}

	static void fizzBuzzNumber(int numberToFizzBuzz) {
		
		for (int i = 0; i <= numberToFizzBuzz; i++) {
			if(i%3==0 && i%5==0) {
				System.out.println(i + " = " + " Fizz");
			}else if(i%5==0) {
				System.out.println(i + " = " +" Buzz");
			}else if(i%3==0) {
				System.out.println(i + " = " + " FizzBuzzBro!");
			}else {
				System.out.println( + i + " = " +" OVAJ NIJE DELJIV NI SA 3 nI sa 5");
			}
		}
		
	}

}
