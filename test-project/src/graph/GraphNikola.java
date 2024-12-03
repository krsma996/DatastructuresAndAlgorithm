package graph;
/*
 * 
 * Graph je samo jedna forma tree a tree su samo jedna forma LinkedListe ( sllucaj kod njih sto idu samo u 1 smeru)
 * 
 * Postoje 2 stvari vezano za grafove a to je :
 * Razlika između usmerenog i neusmerenog grafa
Neusmeren graf (undirected graph):

Svaka veza je dvosmerna: 
𝐶
→
𝐷
C→D podrazumeva i 
𝐷
→
𝐶
D→C.
Primer: Graf puteva gde možeš voziti u oba smera.

Usmeren graf:
Veze su jednosmerne: 
𝐶
→
𝐷
C→D ne znači 
𝐷
→
𝐶
D→C.
Primer: Graf protoka informacija ili saobraćaj gde su neki putevi jednosmerni.
 * 
 * Postoje 2 nacina kako da se reprezentuje grap a to su:
 * 1.) Adjencey Matrix => prevod :Matrica susednosti: dakle postoji slika na netu za to  nesto kao matrice sto si ucio na faxu
 	 Dobra za male, guste grafove; lako proveravaš vezu između čvorova.
	
 * 2.)Adjenceny List => Definicija: Lista gde svaki čvor ima svoju podlistu povezivanja.
 * Težine (weights) kod grafova dodaju još jednu dimenziju značaja odnosima između čvorova. 
 * Efikasnija za retke grafove (s manje grana); manje memorije troši.
 * 
 * 
 * 
 * Ako imamo bidirekcioni (neusmeren) graf, gde su svi čvorovi međusobno povezani, 
 * težine se koriste za predstavljanje "vrednosti" svake veze (grane). Evo šta to znači u praksi:
 * Weoghts:
 * Težine predstavljaju neki trošak ili prioritet:
 * 
 * Fora sa težinama u bidirekcionom grafu
	Težine predstavljaju neki trošak ili prioritet:
	Udaljenost između mesta (npr. čvorovi su gradovi, a težine su kilometri).
	Cena putovanja (npr. avionske karte).
	Vreme potrebno da se pređe sa jednog čvora na drugi.
	
	
	! Težine (weights) nisu nešto što dolazi "automatski" – 
	njih definišeš ti ili se određuju prema nekoj logici specifičnoj za problem koji rešavaš. 
	Evo kako možeš pristupiti tome
	
	1.) Ručno definisanje težina: Kada je poznato unapred: Ako znaš šta graf predstavlja (npr. udaljenosti između gradova),
	 	težine unosiš ručno na osnovu stvarnih podataka
	 	Primer: Ako graf prikazuje puteve između gradova, težine su rastojanja (u km). Ručno unosiš da je težina između  A i B = { 10 }, 
	 																											a između   A i C ={ 15 }.	
	 																											
	2.)Ako težine zavise od nekog pravila: Na primer, možeš koristiti formulu da automatski izračunaš težine.Formula={weight = udaljenost/brzina};
	
	3.)Randomizacija => ako nasumicno testiras simulaciju ili eksperiment mozes da testiras da vidsi kako algoritmi rade.
	
	
	Kako znamo koje tezine ti da koristis ?
	1.) Zavisno od problema koji se resavaju (Ako se pravi graf gradova tezine bi bile rastojanja ili troskovi)	
		-Ako pravimo graf za analizu drustvenih mreza , tezine mogu biti broj interakcija 
	2.)Priroda podataka: POnekad su tezine direktno deo podataka (npr. u mapi gradova imas tabelu udeljenosti).
	
	3.)Ako pokusavas da pronadjes najeftiniji put->tezine bi trebalo da budu troskovi.
	 	- A ako zelis najkraci put tezine su udaljenosti
	 	
	 	
	 	Sta kad nemas tezine ?
	 	Ako nema tezine i ne zahteva se precizni podaci;
	 	-Sve tezine staviti na 1: Ovo znaci da je bitno samo koliko koraka treba za prelazak
	 	
	 	
	 	
	Dakle, težine zavise od konteksta problema i obično se definišu ili ručno ili prema pravilima/formulama koje postaviš ti!
	
	OVDE RADIMO SA ADJENCY LIST ! nmg se drkam sa adjency matrix
	 																											
	 																											
 */

import java.util.ArrayList;
import java.util.HashMap;

public class GraphNikola {
	
	//Pokusavamo da napravimo ovo u grap preko adjency List
	// A = [];  A je KEY a [] je lista values
	//posto radimo sa hashMapom to je key value pairs
	private HashMap<String, ArrayList<String>> adjList = new HashMap<>();
	
	
	public boolean addVertex(String vertex) {
		//Which means that vertex is not in grafh
		if(adjList.get(vertex) == null) {
			adjList.put(vertex, new ArrayList<String>());
			return true;
		}
		return false;
		
	}
	
	public boolean addEdge(String vertex1,String vertex2) {
		//ako ti je key A daje ti vrednost liste
		//Ako vertex1 i vertex2 postoje samo ce tada dodati
		if(adjList.get(vertex1) !=null && adjList.get(vertex2)!=null) {
			adjList.get(vertex1).add(vertex2); // A = {B}
			adjList.get(vertex2).add(vertex1); // B = {A}
			return true;
		}
		return false;
	
	}
	
	//ovo je samo one ivice tj linije koje su povezane one se briseu NDOE ostaje i dalje tu
	public boolean removeEdge(String vertex1,String vertex2) {
		if(adjList.get(vertex1) !=null && adjList.get(vertex2)!=null) {
			adjList.get(vertex1).remove(vertex2);
			adjList.get(vertex2).remove(vertex1);
			return true;
		}
		return false;
	}

	
	// a kada birsemo vertex KAO Da brisemo CEO NODE i moras nejgove ivece isto da obrises na kome je on bio povezan
	public boolean removeNode(String node) {
		//that means that our node or vertex is not in graph
		//NEMAGA NE POSTOJI
		if(adjList.get(node) == null) {
			return false;
		}
		//deluje zbunjujce al kad se hvata preko hashMape po key on ti da values a tebi je values u ovom slcuaju lista
		for(String otherVertex :adjList.get(node)) {
			//ovo ce ti vrati arrayList i mozes metode da koristsi
			//krenuce od prvog a to je A={A,B,C,D} ovo D se brise iz ove ivice
			//pa ide onda do B a to je B={B,C,D} dakle lupam dajem primere nekog grafa obbrisace D 
			// i tako pobrise sve koi imaju D konekciju ocisti ivice
			adjList.get(otherVertex).remove(node);
		}
		// a onda kad ih obrise onda on obrise ceo node taj njegov
		adjList.remove(node);
		return true;
	}
	
	
	
	
	
	public void pringGraph() {
		System.out.println(adjList);
	}
}
