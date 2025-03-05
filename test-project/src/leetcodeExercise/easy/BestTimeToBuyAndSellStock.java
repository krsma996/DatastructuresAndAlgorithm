package leetcodeExercise.easy;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		int prices[] = { 7, 5, 1, 3, 6, 4 };
		int maxProfit = maxProfit(prices);
		System.out.println(maxProfit);

	}

	/*
	 * Dat je niz prices, gde je prices[i] cena određene akcije na i-ti dan.
	 * 
	 * Tvoj cilj je da maksimizuješ profit tako što ćeš izabrati jedan dan za
	 * kupovinu akcije i neki drugi, kasniji dan za prodaju te akcije.
	 * 
	 * Vrati maksimalan profit koji možeš ostvariti ovom transakcijom. Ako nije
	 * moguće ostvariti nikakav profit, vrati 0.
	 */
	public static int maxProfit(int[] prices) {
		int minimum = prices[0];
		int maxProfit = 0;
		for(int i = 1;i<=prices.length -1;i++) {
			if(prices[i] < minimum) {
				minimum = prices[i];
			}else if(prices[i] - minimum > maxProfit) {
				maxProfit = prices[i] - minimum;
			}
		}
		return maxProfit;
	}
	
	//ovde je trik da nadjemo koji nam je maximum i koji nam je minimum  i da ih oduzemmo i da dobijemo
	// najveci moguci profit
	// i da iz tog niza oduzmemo i dobijamo maximalni profit
	public static int maxProfit2(int [] prices) {
		if(prices == null || prices.length <2)return 0;
		int buy=prices[0];//prvi element
		int maxProfit =0;
		// ovde krecemo od i = 1 jer nema potrebe da se poredi sam sa sobom nece biti greska
		// al nema potrebe
		for(int i =1;i<=prices.length-1;i++) {
			//maxProfit je jednax MathMax kaze za taj ( maxProfit, razlika izmedju trenutnog u nizu i buy)
			//1 iteracija ce biti 1-7 = -6 stavice da bude 0 i tako u krug dok nenadje maximum
			maxProfit = Math.max(maxProfit, prices[i] - buy);	
			// a min ovde ce da bude ako je prvi 5 posto je gore u nizu prvi i =1 a i list je to 5
			//pa ce stavi njega da buy bude = 5
			// i sve dok nenadje min vrednost buy ce ostati 5 a kad dodje gore do niza broj 1
			// stavlja ga na 1
			buy = Math.min(buy, prices[i]);
		}		
		return maxProfit;
	}
}
