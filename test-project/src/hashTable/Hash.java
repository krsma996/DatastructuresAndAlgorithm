package hashTable;

import java.util.ArrayList;
import java.util.List;

/*
 * Kada kažemo da je hash deterministički, to znači da će ista 
 * ulazna vrednost uvek proizvoditi isti izlaz (hash vrednost) 
 * kada se koristi isti hash algoritam.

Ključne karakteristike:
Predvidljivost: Ako uneseš isti podatak više puta u 
hash funkciju, rezultat će uvek biti isti.

Primer: hash("Hello") će uvek vratiti istu vrednost, recimo 12345,
 dok god koristiš isti algoritam.
Konzistentnost: Rezultat zavisi isključivo od ulaza,
 bez uticaja spoljašnjih faktora (npr. vremena ili mesta izvršavanja).

Primena: Determinističnost je ključna u situacijama gde se hash koristi za:

Proveru podudaranja (npr. za lozinke ili fajlove).
Brzu pretragu u strukturama podataka kao što su hash tabele.
Kriptografiju, gde hash mora biti konzistentan za proveru integriteta podataka.

Da hash nije determenisticki to znaci da bi ulazna vrednost uvek proizvodila drugaciji rezultat
tj njene izlaze sto bi unistilo pouzdanost a pretragu ,autentifikaciju itd...

--------- HASH METODA se uvek izracunava na KEY u key-value par

Hash funkcija → Izračuna indeks iz ključa.
Indeks → Pokazuje na mesto u nizu gde se čuva key-value par.
Ovo omogućava brzi pristup, često sa O(1) vremenskom složenošću za pretragu i unos.

Hash metoda na ključevima:

Kada dodajemo par key-value u mapu (npr. HashMap u Javi), ključ (key) prolazi kroz hash funkciju.
Hash funkcija izračunava hash vrednost za taj ključ.
Mapiranje na adresu:

Dobijena hash vrednost se koristi za određivanje mesta (indeksa) u internoj strukturi (obično niz) gde će taj par key-value biti smešten.
Pristup podacima:

Kada tražimo vrednost preko ključa, hash funkcija se ponovo poziva na ključ da pronađe indeks i brzo locira odgovarajući par.

--------------COLLISONS----------------------------------------------------------------------------
E sad cesti problemi u HashMapama su COLLISONS i postoji nekoliko nacina kako se resavaju
1.) Separate Chaining -> to je kad na istoj adresi stavimo 2 vrednosti
2.) Linear Probing -> Trazi od mesta do mesta da vidi koje su prazne i onda ih stavi tu ( OPEN ADRESSING )


-> RADIMO SEPARETE CHAINGNG  -> to  je kad imamo vise vrednosti na 1 adresi
a na nacin koji cemo to raditi je je da imamo LINKED LISTU na svakoj od tih adresa 
Linked Lista je cest slucaj implementiranja separate chaingnin i stavljanja visestrukih stavki na odredjenoj adresi

 */
public class Hash {
	
	private int size = 7;
	private Node [] dataMap;
	
	public Hash() {
		this.dataMap = new Node[size];
		
	}
	
	class Node {
		private String key;
		private int value;
		private Node next;
		
		public Node(String key, int value) {
			this.key = key;
			this.value = value;
		}	
	}
	
	
	
	private int hash(String key) {
		
		int hash = 0;
		char [] charKeys = key.toCharArray();
		for(int i = 0; i< charKeys.length;i++) {
			int asciValue = charKeys[i];
			//mnozimo svaki character u nizu sa asci vrednoscu i sa prostim brojem
			//moze bilo koji prost broj nije ni bitno
			//i onda od tog rezultata trazimo da node van opsega niza dataMap.lenght u mom slucaju je 6 al on moze biti i veci nije ni bitnos
			// i onda za svaki charater mi dobijamo hash key UVEK ISTI !
			hash = ( hash + asciValue * 23) % dataMap.length;
		}
		return hash;
	}
	
	public void set(String key,int value) {
		int index = hash(key);
		Node newNode = new Node(key, value);
		if(dataMap[index] == null) {
			dataMap[index] = newNode;
		}else {
			//pointer na prvi node  u nizu
			Node temp = dataMap[index];
			while(temp.next !=null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		
	}
	
	public int get(String key) {
		int index = hash(key);
		Node tempNode = this.dataMap[index];
		if(tempNode !=null) {
			return tempNode.value;
		}
		return 0;
	}
	
	public List<String> keys() {
		List<String> allkeys = new ArrayList<>();
		Node []tempNodes = this.dataMap;
		for(int i = 0;i < tempNodes.length;i++) {
			Node tempNode = this.dataMap[i];
			if(tempNode !=null) {
				allkeys.add(tempNode.key);
				tempNode = tempNode.next;
			}
		}
		return allkeys;
	}
	
	public void printHash() {
		Node []tempNodes = this.dataMap;
		for(int i = 0;i < tempNodes.length;i++) {
			System.out.println(i + ":");
			Node temp = dataMap[i];
			while(temp !=null) {
				System.out.println("{ " + temp.key + " = " + temp.value + " }");
				temp = temp.next;
			}
		}
	}

}
