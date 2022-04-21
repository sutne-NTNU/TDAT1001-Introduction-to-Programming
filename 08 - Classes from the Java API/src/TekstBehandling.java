public class TekstBehandling{
	private static String tekst;
	private String[] ord;
	private String[] setning;
	
	public TekstBehandling(String tekst){
		this.tekst = tekst;
		String tekstRen = tekst.replaceAll("[.?:;*+-/!]", "");
		this.ord = tekstRen.split(" ");
		setSetning(tekst.split("[.?!:;]"));
	}
	public void setOrd(String[] ord){
		this.ord = ord;
	}
	public void setSetning(String[] setning){
		this.setning = setning;
	}
	public int antallOrd(){
		return ord.length;
	}
	public double ordLengde(){
		double ordLengde = 0.0;
		for(int i = 0; i < ord.length; i++){
			ordLengde += ord[i].length();
		}
		ordLengde /= ord.length;
		
		int temp = (int)(ordLengde*100.0);	//forkorter til 2 desimaler
		ordLengde = ((double)temp)/100.0;
		return ordLengde;
	}
	public double ordPerSetning(){
		double ordPerSetning = 1.0;
		for(int i = 0; i < setning.length; i++){
			for(int j = 0; j < setning[i].length(); j++){
				if(' ' == setning[i].charAt(j)){
						ordPerSetning ++;
				}	
			}
		}
		ordPerSetning /= setning.length;
		
		int temp = (int)(ordPerSetning*100.0);	//forkorter til 2 desimaler
		ordPerSetning = ((double)temp)/100.0;
		
		return ordPerSetning;
	}
	public void byttOrd(String gammelt, String nytt){
		this.tekst = tekst.replaceAll(gammelt , nytt);
	}	
	public static String getTekst(){
		return tekst;
	}
	public static String getUpperCaseTekst(){
		String uTEKST = tekst.toUpperCase();
		return uTEKST;
	}
	
	
	//Testklient
	public static void main(String[] args){
		String tekst = "Denne teksten har 41 ord, hvert ord har ca 4,04 bokstaver. I tilleg til dette er det gjennomsnittlig 8,19 ord i hver setning. Men klarer du å endre noe i denne teksten? Ja? Da kan du endre ordet 'ord' til 'hytter'.";			
		TekstBehandling test = new TekstBehandling(tekst);
		System.out.println("\n" + getTekst());
		System.out.println("\nDet er totalt 5 metoder som testes");
			if(test.antallOrd() == 41){
				System.out.println("1: antallOrd()		= OK");
			}else{ 
				System.out.println("1: antallOrd()		= Error");
			} 
			if(test.ordLengde() == 4.04){
				System.out.println("2: ordLengde()		= OK");
			}else{ 
				System.out.println("2: ordLengde()		= Error");
			}
			if(test.ordPerSetning() == 8.19){
				System.out.println("3: ordPerSetning()	= OK");
			}else{ 
				System.out.println("3: ordPerSetning()	= Error");
			}
			test.byttOrd("ord","hytter");
			System.out.println("\n"+getUpperCaseTekst());
	}
}