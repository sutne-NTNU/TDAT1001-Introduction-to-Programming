import static javax.swing.JOptionPane.*;
public class TekstBehandlingKlient{
		public static void main(String[] args){
			String tekst = showInputDialog(null, "Skriv tekst som skal behandles her:");
			TekstBehandling klient = new TekstBehandling(tekst);
			System.out.println(tekst);
			
			String gammelt = showInputDialog(null, "Hvis du vil bytte ut et ord i teksten skriv det ordet du vil bytte her:");
			String nytt = showInputDialog(null, "Skriv det nye ordet her:");
			klient.byttOrd(gammelt, nytt);
			System.out.println("\n\nDette er den nye teksten:\n" + klient.getTekst());
			
			System.out.println("\nAntall ord i teksten: " + klient.antallOrd());
			System.out.println("Gjennomsnittlig antall ord per setning: " + klient.ordPerSetning());
			System.out.println("Gjennomsnittlig lengde på ordene i teksten: " + klient.ordLengde() + " bokstaver");
			
			
		}
}