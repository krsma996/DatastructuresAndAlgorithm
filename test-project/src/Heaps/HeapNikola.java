package Heaps;

import java.util.ArrayList;
import java.util.List;

/*
 * Heaps su posebna vrsta binarnih stabala koja imaju specifična pravila o rasporedu čvorova. 
 *
 * Da, na prvi pogled mogu izgledati kao obična binarna stabla, ali postoje ključne razlike koje im daju snagu za određene primene
 * 
 * Svako drvo zavisi od speicifcne implementacije
 * Razlike između heap-a i običnog binarnog stabla:
   1.) Raspored Cvorova - U binarnom stablu nema stroge pravilnosti o rasporedu vrednosti, 
   	  dok u heap-u postoji striktno pravilo o veličini između roditelja i potomaka (max ili min heap svojstvo)
 
   2.) Forma Stabla - Binarno stablo može biti bilo koje forme (ne mora biti kompletno). Heap uvek ima oblik kompletnog binarnog stabla
   
   3.) Heaps mogu imati duplikate (nije pravilo), dok kod običnih binarnih stabala raspored često zavisi od jedinstvenosti vrednosti.
   
   
   Primena heapo-va 
   1.) Priorty ques - Heaps su efikasan način za implementaciju prioriteta (insert i extract operacije u (O(logn));
   2.) Heap sort - Koristi heap za sortiranje niza u O(n log n);
   3.) Algoritmi grafova - Primiv i Djikstirn algoritam koriste heap za efikasno odredjivanje minimuma
   
   
   Glavne razlike Heapa i Obicnog BST tj binary search tree
   
   RASPORED: BST ( Levo su manji , a desno su veci)   						   HEAP : Roditelj veći/manji od potomaka.
   BALANSIRANJE: BST ( Može biti neuravnoteženo (osim ako je balansirano).     HEAP: Uvek kompletno binarno stablo
   Forma Stable: BST: Proizvoljna cesto neizbalansirana         			   HEAP: UVEK JE KOMPLETNO !
   
   BST: NAMENJEN ZA PRETRAGU IZBALANSIRANO O(log n )            			   HEAP Nije namenjen za pretragu, fokus na O(1) minimum i maksimum 
   Duplikati  Obicno ne podrzava                        					   HEAP: Moze imati duplikate
   
   
   Zašto je heap koristan? Koristan je za ove stvari 
   
   1.)Pronalaženje maksimuma/minimuma: Ovo je O(1) jer je koren čvora uvek najveći (ili najmanji).
   2.) Ubacivanje i uklanjanje: Efikasno u O(log n) zbog "heapify" operacija.
   3.) Sortiranje (Heap Sort): Heap se koristi za sortiranje niza u O ( n log n ).
   
   
   Heap ima labavije pravilo (samo roditelj u odnosu na potomke), dok BST ima strogo pravilo (levo manje, desno veće).
   Heap je specijalizovan za prioritetne operacije, dok je BST bolji za pretragu i organizaciju podataka.
   
 *
 */
public class HeapNikola {

	
	private List<Integer> heaps;

	//Constructor init
	public HeapNikola() {
		this.heaps = new ArrayList<>();
	}
	
	
	public void insert(int value) {	
		heaps.add(value);
		int currentIndex = heaps.size() - 1;// daje ti index od tog zadnjeg sto si dodao
		
		//samo ako vrednost od currentValeu veci od parent curent value 
		//tad mozemo da okinemo while loop
		//heaps.get(currentValue) vraca ti vrednost na tom indexu
		//prvi uslov kaze trenutni index veci od 0  i trenitna vrednost od tog indexa veca od parenta njegovo
		//ako jeste to mora da se swapuje
		while (currentIndex > 0 && heaps.get(currentIndex) > heaps.get(parent(currentIndex))) {
			swap(currentIndex, parent(currentIndex));
			currentIndex = parent(currentIndex);
		}	
	}
	
	//uvek remove radimo sa vrha bez obzira dal je on minimum ili maximum
	//tako je pravilo u heapu i posto brises sa vrha a to je O(1);
	//ostalo ti je da odradis stavis sledeci koji je najvice na vrh a to je ili zadnji desni ili zadnji levi
	// drvo uvek mora da bude kompletno kod HEAPA	
	public Integer remove () {
		if(heaps.isEmpty()) {
			return null;
		}
		if(heaps.size() == 1) {
			return heaps.remove(0);
		}
		
		/*
		 * heaps.size() - 1 – dobija indeks poslednjeg elementa u listi heaps.
			heaps.remove(heaps.size() - 1) – uklanja i vraća poslednji element iz liste.
			heaps.set(0, ...) – postavlja (ili zamenjuje) element na poziciji 0 (prvi element) u listi sa elementom koji je došao iz remove metode.
		 */
		heaps.set(0, heaps.remove(heaps.size() - 1));
		sinkDown(0);//rucno mu prosledis root index koji se nalazi na 0
		return heaps.get(0); // 
	}
	
	private void sinkDown(int index) {
		int maxIndex = index; //pointer na index tj trenutni maximumim tj onaj prvi najveci na usranom heapu
		while(true) {
			/*
			 * Left Child i Right Child metode ne odlucju da li taj index koji vracaju da li je ustvari validan index u HEAPU!
			 * Jer ti ako obrises prvi root element gore , i sad kad se on vrti u while petlji dole
			 * on ce da odradi swap prvi put najnormalnije sve i ti kad bi opet krenuo da kliknes remove
			 * mozda se desi da element ima levu stranu i to je ok al on je manji od parenta a npr hoce da pogleda u desnu stranu
			 * on ce videti da je prazan da ne postoji
			 * 
			 * zato leftChild i rightChild ne vracaju validan index u drvetu moras dodatni uslov da mu kazes dole
			 */
			int leftChild = leftChild(index); //dohvatas levi Element od tog maximuma
			int rightChild = rightChild(index); // dohvatas desni Element od tog maximuma

			// 1.) Dali je leftChild index manji od duzine heapa I dali je vrednost leftChilda veca od od mAX indexa
			// ovaj uslov ako se neispunjava ide na sledeci if dole
			if(leftChild < heaps.size() && heaps.get(leftChild) > heaps.get(maxIndex)) {
				maxIndex = leftChild;
			}
			
			if(rightChild < heaps.size() && heaps.get(rightChild) > heaps.get(maxIndex)) {
				maxIndex = rightChild;
			}
			
			if(maxIndex != index) {
				swap(index, maxIndex);
				index = maxIndex;
			}else {
				return;
			}
		}
		
	}
	
	//trazimo levi node od parent noda
	private int leftChild(int index) {
		return 2 * index +1;
	}
	
	//trazimo desni node od parent noda
	private int rightChild(int index) {
		return 2 * index + 2;
	}
	//trazimo parent node od children nodova 
	private int parent (int index ) {
		return (index - 1 ) / 2;
	}
	//metoda zamene sto znaci u heapu mora da parenti budu veci od childrena i ako se desi da je children veci od parenta ide SWAP
	//i ok je da imaju duplikate nista sporno takvo je neko pravilo za heapove
	private void swap(int index1, int index2) {
		int temp1 = heaps.get(index1); // Sačuvaj vrednost sa index1
	    heaps.set(index1, heaps.get(index2)); // Postavi vrednost sa index2 na index1
	    heaps.set(index2, temp1);// Postavi sačuvanu vrednost na index2
	}


	
	//return a copy of list heaps
	public List<Integer> getHeaps() {
		return new ArrayList<>(heaps);
	}
}
