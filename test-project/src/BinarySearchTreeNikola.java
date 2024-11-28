/*
Binarno drvo (Binary Tree): Specifičan tip drveta gde svaki čvor ima najviše dva potomka, 
obično označena kao levi čvor (left node) i desni čvor (right node). 
Ovo je kao proširenje linked list strukture, gde čvorovi imaju dva pokazivača umesto jednog (ka levom i desnom čvoru).

Fleksibilnost strukture drveta: Ne postoji pravilo koje nalaže da drvo mora biti binarno. 
Na primer, čvor može imati proizvoljan broj povezanih čvorova (npr. 5, 10 ili čak 5000). 
To zavisi od specifičnih potreba implementacije.
 Međutim, binarna struktura je uobičajena zbog svoje jednostavnosti i efikasnosti u mnogim algoritmima.

Praktična primena binarnog drveta: Većina algoritama za rad sa drvećem, kao što su pretraga,
 umetanje i brisanje, zasniva se na binarnim strukturama jer su one optimalne za organizaciju podataka,
  posebno kada je drvo balansirano. Primeri uključuju binarna stabla pretrage (BST), AVL stabla i crveno-crna stabla.

Zaključak: Iako je praksa da svaki čvor u binarnom drvetu pokazuje na dva čvora (levi i desni),
 ništa te ne sprečava da implementiraš strukturu gde čvor može imati proizvoljan broj potomaka. 
 To otvara mogućnosti za druge tipove drveća, poput n-arnog drveta ili generalizovanih hijerarhijskih struktura.
 
 
 Dakle node koji krene od pocetka je PARENT node i on Ima Node Left i Node Right
 Sa leve strane su uvek manji brojevi od PARENTA a sa desne strane su Nodovi koji su VECI od parenta
 Posto da bi implementirao binary search tree svaki node mora da bude tako pozicioniran
 
 i UVEK POREDJENJE NODA KRECE OD VRHA DRVETA ako je npr PRVI NOD ( 47 )
 I TI SADA UBACUJES NOVI NOD KOJI JE 37 VIDECE DA LI JE 37 > 47 NIJE onda ide nA LEVU STRANU
 i ONDA UBACIS SLEDECI BROJ 57 -> poredi dali je 57 > 47 JESTE ONDA IDE NA DESNU STRANU 
 ITD... DAKLE IDE OD POCETKA PA POREDI DA IH SORTIRA
 
 JER UVEK JE SA DESNE STRANE VECE NEGO SA LEVE STRANE NODS TAKO SU POSTVLJENI !
 * 
 */
public class BinarySearchTreeNikola {

	Node root;

	/*
	 * Node newNode = new Node(value); root = newNode; ovaj pristup je ok da pilikom
	 * kreiranja objekta da ti se kreira poointer na root node sto je ok a i ne mora
	 * tako // nek bude praza za pocetak
	 * 
	 * a posto je root = null redundandt jer ti je vec gore u klasi root null sam po
	 * sebi i ne treba ti konstrutkor
	 * tako da ceo ovaj kurac mozes da zakomentarises
	 * 
	 * public BinarySearchTreeNikola() { root = null; }
	 */

	class Node {

		Node left;
		Node right;
		int value;

		public Node(int value) {
			this.value = value;
		}

	}
	
	/*
	 * Pseudo primer 
	 * Ako vec imamo neki tree ILI GA NEMAMo nije ni bitno kakva korake mi treba da uradimo da bi smo ubacili NODe u drvo
	 * 1) Kreiramo NODE ( nije ni korak al uvek ovo radis logicno)
	 *  if( newNode == temp) return false; u slucaju kada imamo da je neki broj vec postoji u drvetu 
	 * 2) if(left (ako je manje) right(ako je vece) postavicemo taj node na neku od ovih strana  | ova dva koraka se stalno vrte u drvetu
	 * 3.) ako je child NULL insertuj newNode ako nije pomeraj se dallje						 | ova dva koraka se stalno vrte u drvetu
	 *  dakle pseoudo kod bi bio nesto ovako 
	 *  
	 *  create newNode
	 *  if root == null then root = newNode;
	 *  temp = root;
	 *  while loop
	 *  if newNode == temp reurn false;
	 *  if(smaller go LEFT if bigger go RIGHT)
	 *  if( null  insertNewNode ELSE move to the next NODE)
	 */
	
	
	
	
	
	public Node insert (int value) {
		Node newNode = new Node(value);
		 // Ako je koren stabla prazan, postavi novi čvor kao koren
	    if (this.root == null) {
	        this.root = newNode;
	        return newNode;
	    }
		Node currentNode = this.root;
	     // Počni od korena
		while(currentNode !=null) {
			//ako su isti
			if(newNode.value == currentNode.value) {
				return newNode;
				
				//idi levo
			}else if(newNode.value < currentNode.value) {
				if(currentNode.left == null) {
					currentNode.left = newNode;	
					return newNode;
				}
				currentNode = currentNode.left;//nastavi levo					
				
				//idi desno
			}else if(newNode.value > currentNode.value) {
				if(currentNode.right == null) {
					currentNode.right = newNode;
					return newNode;
				}
				currentNode = currentNode.right; //nastavi desno
			}
		}
		return newNode;
	}
	
	public boolean contains(int value) {
		// znaci da je prazan i da ne sadrzi
		if (root == null)
			return false;
		// node ako kreiramo ovde cemo da kreiramo copy vrednost njegovu da proveravamo
		Node currentNode = this.root;
		while (currentNode != null) {
			if (value == currentNode.value) {
				// Pronađena vrednost
				System.out.println("It contains!");
				return true;
			} else if (value < currentNode.value) {
				// Idi u levo podstablo
				currentNode = currentNode.left;
			} else {
				// Idi u desno podstablo
				currentNode = currentNode.right;
			}
		}
		// Ako smo izašli iz petlje, vrednost nije pronađena
		System.out.println("There is no value in tree");
		return false;
	}
	
	
	public void printInOrder() {
        printInOrder(root);
    }
	public void printInOrder(Node node) {
	    if (node == null) {
	        return;
	    }
	    printInOrder(node.left); // Levo podstablo
	    System.out.print(node.value + " "); // Trenutni čvor
	    printInOrder(node.right); // Desno podstablo
	}

}
