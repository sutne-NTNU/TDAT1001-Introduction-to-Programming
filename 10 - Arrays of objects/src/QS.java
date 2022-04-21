import java.io.*;
import static javax.swing.JOptionPane.*;
public class QS{
	public static void main(String[] args) throws IOException {
		
		Student[] studenter = new Student[0];
		Oppgaveoversikt klient = new Oppgaveoversikt(studenter);
		
		//Henter ut alle studentene fra txt dokumentet og oppretter et nytt Student objekt med riktig navn og antOppgaver
	     	FileReader lesStudent = new FileReader("studenter.txt");
	     	BufferedReader leser = new BufferedReader(lesStudent);
		String student = leser.readLine();
		while(student != null){
			String[] studentSplit = student.split(",");
			int oppgStudent = Integer.parseInt(studentSplit[1]);
			klient.nyStudent(studentSplit[0], oppgStudent);
			student = leser.readLine();
		}
		leser.close();
		
		
		
		System.out.println("antall studenter: 	" + klient.antStudenter());
		
		boolean loop = true;
		while(loop){
			final String[] VALG = { "Avslutt" , "Legg til Student" , "Endre poeng for student" , "Sjekk student", "Print alle studenter"};
			int valg = showOptionDialog(null, "Hva Ønsker du aa gjore?", "Valg av operasjoner", 1, PLAIN_MESSAGE, null, VALG, VALG[0]);
			switch (valg){
				case 4:	//sjekk alle studenter
					System.out.println("\n\nAntall studenter: " + klient.antStudenter());
					System.out.println(klient);
					break;
				case 3:	//Sjekk oppgaver for en student
					boolean sjekkStudent = true;
					while(sjekkStudent){
						studenter = klient.getStudenter();
						final String[] SJEKK = klient.getNavnStudenter();
						Object navnObjekt = showInputDialog(null, "Hvilken student vil du sjekke?", "Valg av operasjoner", DEFAULT_OPTION, null , SJEKK, SJEKK[0]);
						String navnStudent = (String) navnObjekt;
						int indeks = -1;
						for(int i = 0; i < klient.antStudenter(); i++){
							if(studenter[i].getNavn().equals(navnStudent)){
								indeks = i;
							}
						}
						
						if(indeks < 0){
							sjekkStudent = false;
						}else{
							System.out.println(klient.antOppgaver(indeks));
						}
					}
					break;
				case 2:	//endre antall oppgaver
					boolean endrePoeng = true;
					while(endrePoeng){
						studenter = klient.getStudenter();
						int forrige = 0;
						final String[] ENDRE = klient.getNavnStudenter();
						Object navn2Objekt = showInputDialog(null, "Hvem vil du endre oppgaver for?", "Valg av operasjoner", DEFAULT_OPTION, null , ENDRE, ENDRE[forrige]);
						String navn2Student = (String)navn2Objekt;
						int indeks2 = -1;
						for(int i = 0; i < klient.antStudenter(); i++){
							if(studenter[i].getNavn().equals(navn2Student)){
								indeks2 = i;
							}
						}
						forrige = indeks2;
						if(indeks2 < 0){
							endrePoeng = false;
						}else{
							String endringLest = showInputDialog(null, "Hvor mange poeng skal legges til (trekkes ifra)?");
							int endring = Integer.parseInt(endringLest);
							klient.endreAntOppg(indeks2, endring);
							System.out.println(klient.antOppgaver(indeks2));
						}
					}
					break;
				case 1:	//Legg til student
					String navn = showInputDialog(null, "Skriv inn studentens navn:");
					String oppgaverLest = showInputDialog(null, "Hvor mange oppgaver har studenten gjort?");
					int oppg = Integer.parseInt(oppgaverLest);
					klient.nyStudent(navn, oppg);
					break;
				default:
					loop = false;
			}
		}
		try{
			FileWriter skrivStudenter = new FileWriter("studenter.txt", false);
			PrintWriter skriver = new PrintWriter(new BufferedWriter(skrivStudenter));
			studenter = klient.getStudenter();
			for(int i = 0; i < studenter.length; i++){
				skriver.println(studenter[i].getNavn() +"," + studenter[i].getAntOppg());
			}
			skriver.close();
		}catch(Exception e){
			System.out.println("Noe gikk feil ved skriving til fil");
		}
	}
}