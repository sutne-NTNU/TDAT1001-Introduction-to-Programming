/*
* Øving 9 oppgave 11.10.1 side 386
*/
public class ArbTaker{
	private final Person personalia;
	private final int ansettelsesÅr;
	private int arbtakerNr;
	private int maanedsLonn;
	private double skatteProsent;
	
	private static java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
	private static final int aarstall = kalender.get(java.util.Calendar.YEAR);
	
	public ArbTaker(Person personalia, int ansettelsesÅr, int arbtakerNr, int maanedsLonn, double skatteProsent){
		this.personalia = new Person(personalia.getFornavn(), personalia.getEtternavn(), personalia.getFodselsaar());
		this.ansettelsesÅr = ansettelsesÅr;
		this.arbtakerNr = arbtakerNr;
		this.maanedsLonn = maanedsLonn;
		this.skatteProsent = skatteProsent;
	}
	public void setArbtakerNr(int nyttNummer){
		this.arbtakerNr = nyttNummer;
	}
	public void setMaanedslonn(int nyLonn){
		this.maanedsLonn = nyLonn;
	}
	public void setSkatteProsent(double nySkatt){
		this.skatteProsent = nySkatt;
	}
	
	
	public String toString(){
		return personalia + "   " + ansettelsesÅr;
	}
	public Person getPersonalia(){
		return personalia;
	}
	public int getAnsettelsesÅr(){
		return ansettelsesÅr;
	}
	public int getArbtakerNr(){
		return arbtakerNr;
	}
	public int getMaanedsLonn(){
		return maanedsLonn;
	}
	public double getSkatteProsent(){
		return skatteProsent;
	}
	
	
	public double skatteTrekk(String maaned){
		String maanedTest = maaned.toLowerCase();
		double skatteTrekkMaaned = getMaanedsLonn() * getSkatteProsent()/100;
		switch (maanedTest){
			case "juni":
				skatteTrekkMaaned = 0;
				break;
			case "desember":
				skatteTrekkMaaned /= 2;
				break;
		}
		return skatteTrekkMaaned;
	}
	public double skatteTrekk(){
		double skatteTrekk = 10.5* getMaanedsLonn() * getSkatteProsent() / 100;
		return skatteTrekk;
	}
	public int bruttoLonn(){
		int bruttoLonn = 12 * getMaanedsLonn();
		return bruttoLonn;
	}
	public double nettoLonn(){
		double nettoLonn = 12 * getMaanedsLonn() - skatteTrekk();
		return nettoLonn;
	}
	public String getNavn(){
		String navn = personalia.getEtternavn() + ", " + personalia.getFornavn();
		return navn;
	}
	public int getAlder(){
		int alder = aarstall - personalia.getFodselsaar();
		return alder;
	}
	public int aarAnsatt(){
		int aarAnsatt= aarstall - getAnsettelsesÅr();
		return aarAnsatt;
	}
	public boolean ansattLengerEnn(int aar){
		boolean test = true;
		if( aar > aarAnsatt()){
			test = false;
		}
		return test;
	}

	//Testklient
	public static void main(String[] args){
		
		Person olaN = new Person("Ola", "Nordmann" , 1987);
		ArbTaker ola = new ArbTaker(olaN, 2010, 1, 45000, 40);
		Person kariD = new Person("Kari", "Danskmann" , 1993);
		ArbTaker kari = new ArbTaker(kariD, 2015, 2, 42000, 35.5);
		
		System.out.println("Personalia:	" + ola.getPersonalia());
		System.out.println("Ansatt siden:	" + ola.getAnsettelsesÅr());
		System.out.println("ArbNummer:	" + ola.getArbtakerNr());
		System.out.println("Maanedslonn: 	" + ola.getMaanedsLonn() + " kr.");
		System.out.println("Skatt: 		" + ola.getSkatteProsent()+"%");
		
		System.out.println("\nNavn: 			" + ola.getNavn());
		System.out.println("Alder: 			" + ola.getAlder());
		System.out.println("År som ansatt: 		" + ola.aarAnsatt());
		System.out.println("Ansatt mer enn 5 aar? 	" + ola.ansattLengerEnn(5));
		System.out.println("Ansatt mer enn 10 aar? 	" + ola.ansattLengerEnn(10));
		System.out.println("Bruttolonn: 		" + ola.bruttoLonn() + " kr.");
		System.out.println("Skattetrekk i aaret: 	" + ola.skatteTrekk() + " kr.");
		System.out.println("Nettolonn:   		" + ola.nettoLonn()+ " kr. ");
		System.out.println("Skattetrekk i Desember:	" + ola.skatteTrekk("Desember") + " kr.\n\n");
		
		
		System.out.println("Personalia:	" + kari.getPersonalia());
		System.out.println("Ansatt siden:	" + kari.getAnsettelsesÅr());
		System.out.println("ArbNummer:	" + kari.getArbtakerNr());
		System.out.println("Maanedslonn: 	" + kari.getMaanedsLonn() + " kr.");
		System.out.println("Skatt: 		" + kari.getSkatteProsent()+"%");
		
		System.out.println("\nNavn: 			" + kari.getNavn());
		System.out.println("Alder: 			" + kari.getAlder());
		System.out.println("År som ansatt: 		" + kari.aarAnsatt());
		System.out.println("Ansatt mer enn 5 aar? 	" + kari.ansattLengerEnn(5));
		System.out.println("Ansatt mer enn 10 aar? 	" + kari.ansattLengerEnn(10));
		System.out.println("Bruttolonn: 		" + kari.bruttoLonn() + " kr.");
		System.out.println("Skattetrekk i aaret: 	" + kari.skatteTrekk() + " kr.");
		System.out.println("Nettolonn:   		" + kari.nettoLonn()+ " kr. ");	
		System.out.println("Skattetrekk i Desember:	" + kari.skatteTrekk("Desember") + " kr.\n\n");
	}
}