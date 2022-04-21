import static javax.swing.JOptionPane.*;
public class Klientprogram{
	public static void main(String[] args){
		
		Person olaN = new Person("Ola", "Nordmann" , 1987);
		ArbTaker ola = new ArbTaker(olaN, 2010, 528491, 45000, 40);
		
		System.out.println("Personalia:	" + ola.getPersonalia());
		System.out.println("Ansatt siden:	" + ola.getAnsettelsesÅr());
		System.out.println("ArbNummer:	" + ola.getArbtakerNr());
		System.out.println("Maanedslonn: 	" + ola.getMaanedsLonn() + " kr.");
		System.out.println("Skatt:	 	" + ola.getSkatteProsent()+"%");
		
		System.out.println("\nNavn: 			" + ola.getNavn());
		System.out.println("Alder: 			" + ola.getAlder());
		System.out.println("År som ansatt: 		" + ola.aarAnsatt());
		System.out.println("Ansatt mer enn 5 aar? 	" + ola.ansattLengerEnn(5));
		System.out.println("Ansatt mer enn 10 aar? 	" + ola.ansattLengerEnn(10));
		System.out.println("Bruttolonn: 		" + ola.bruttoLonn() + " kr.");
		System.out.println("Skattetrekk i aaret: 	" + ola.skatteTrekk() + " kr.");
		System.out.println("Nettolonn:   		" + ola.nettoLonn()+ " kr. ");
		System.out.println("Skattetrekk i Desember:	" + ola.skatteTrekk("Desember") + " kr. \n\n");
		
		boolean loop = true;
		while(loop){
			
			final String[] VALG = { "Avslutt" , "Endre Variabler" , "Printe ut variabler"};
			int valg = showOptionDialog(null, "Hva Ønsker du aa gjore?", "Valg av operasjoner", 1, PLAIN_MESSAGE, null, VALG, VALG[0]);
			switch (valg){

				case 1:
					boolean endre = true;
					while(endre){
						
						final String[] ENDRE = { "Tilbake" , "Endre Ansattnummer" , "Endre maanedslonn" , "Endre Skatt" };
						int endreValg = showOptionDialog(null, "Hva vil du gjore?", "Valg av operasjoner", 0, PLAIN_MESSAGE, null, ENDRE, ENDRE[0]);
						switch(endreValg){
							case 0:
								endre = false;
								break;
							case 1:
								String nyttNrLest = showInputDialog(null, "Nytt ansattnummer:");
								int nyttNr = Integer.parseInt(nyttNrLest);
								ola.setArbtakerNr(nyttNr);
								System.out.println("Nytt Ansattnummer: " + ola.getArbtakerNr());
								break;
							case 2:
								String nyLonnLest = showInputDialog(null, "Ny maanedslonn:"); 
								int nyLonn = Integer.parseInt(nyLonnLest);
								ola.setMaanedslonn(nyLonn);
								System.out.println("Ny maanedslonn: " + ola.getMaanedsLonn() + " kr.");
								break;
							case 3:
								String nySkattLest = showInputDialog(null, "Ny skatteprosent: ");
								int nySkatt = Integer.parseInt(nySkattLest);
								ola.setSkatteProsent(nySkatt);
								System.out.println("Ny skatteprosent: " + ola.getSkatteProsent());
								break;
							default:
								endre = false;
								break;
						}
					}
					break;

				case 2:
					boolean printe = true;
					while(printe){
						final String[] PRINTE = { "Tilbake" , "Print alle metoder" , "Print maanedslonn" , "Sjekk skatt (maaned)"};
						int printeValg = showOptionDialog(null, "Hva vil du gjore?", "Valg av operasjoner", 0, PLAIN_MESSAGE, null, PRINTE, PRINTE[0]);
					
						switch (printeValg){
							case 0:
								printe = false;
								break;
							case 1:
								System.out.println("\n\nPersonalia:	" + ola.getPersonalia());
								System.out.println("Ansatt siden:	" + ola.getAnsettelsesÅr());
								System.out.println("ArbNummer:	" + ola.getArbtakerNr());
								System.out.println("Maanedslonn: 	" + ola.getMaanedsLonn() + " kr.");
								System.out.println("Skatt:	 	" + ola.getSkatteProsent()+"%");
								
								System.out.println("\nNavn: 			" + ola.getNavn());
								System.out.println("Alder: 			" + ola.getAlder());
								System.out.println("År som ansatt: 		" + ola.aarAnsatt());
								System.out.println("Ansatt mer enn 5 aar? 	" + ola.ansattLengerEnn(5));
								System.out.println("Ansatt mer enn 10 aar? 	" + ola.ansattLengerEnn(10));
								System.out.println("Bruttolonn: 		" + ola.bruttoLonn() + " kr.");
								System.out.println("Skattetrekk i aaret: 	" + ola.skatteTrekk() + " kr.");
								System.out.println("Nettolonn:   		" + ola.nettoLonn()+ " kr. ");
								System.out.println("Skattetrekk i Desember:	" + ola.skatteTrekk("Desember") + " kr.\n\n");
								break;
							case 2:
								System.out.println("Maanedslonn: 	" + ola.getMaanedsLonn() + " kr.");
								break;
							case 3: 
								String maaned = showInputDialog(null, "For hvilken maaned vil du sjekke Skattetrekket?");
								System.out.println("Skattetrekket i " + maaned + " er: " + ola.skatteTrekk(maaned) + " kr.");
								break;
							default:
								printe = false;
								break;
						}
					}
					break;

				default:
				loop = false;
			}
		}
	}
}