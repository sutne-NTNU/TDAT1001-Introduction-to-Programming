/*
* Øving 8 frist 8. oktober
* Oppgave 8.16.1 side 283
*/

public class NyString{
	private String tekst;
	
	public NyString(String tekst){
		this.tekst = tekst;
	}
	public String forkortForste(){   //beholder kun første bokstavene i hvert ord (etter mellomrom)
		String forsteBokstaver = "";
		String[] ord = tekst.split(" ");
		for(int i = 0; i < ord.length; i++){
			forsteBokstaver += ord[i].charAt(0);
		}
		return forsteBokstaver;
	}
	
	public String removeChar(char tegn){  //fjerner en gitt bokstav fra teksttreng
		String removeChar = "";
		for(int i =0; i < tekst.length(); i++){
			if(tegn != tekst.charAt(i)){
				removeChar += tekst.charAt(i);
			}
		}
		return removeChar;
	}
	
	//Testklient
	public static void main(String[] args){
		String testTekst = ("Denne setningen kan forkortes");
		NyString test = new NyString(testTekst);
		
		if(test.forkortForste().equals("Dskf")){
			System.out.println("1: forkortForste()	= OK");
		}else{ 
			System.out.println("1: forkortForste() = Error");
		} 
		
		if(test.removeChar('e').equals("Dnn stningn kan forkorts")){
	
			System.out.println("2: removeChar()		= OK");
		}else{ 
			System.out.println("2: removeChar() 		= Error");
		}
	}
}