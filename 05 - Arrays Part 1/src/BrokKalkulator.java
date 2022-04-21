
/* 
Øving 5, Oppgave 6.10.2 Side 207
Regning med brøk
*/
import static javax.swing.JOptionPane.*;

public class BrokKalkulator {
	public static void main(String[] args) {

		String telaLest = showInputDialog(null, "Teller A:");
		int tela = Integer.parseInt(telaLest);
		String nevaLest = showInputDialog(null, "Nevner A:");
		if (nevaLest == null) {
			Brok a = new Brok(tela);
		}
		int neva = Integer.parseInt(nevaLest);
		Brok a = new Brok(tela, neva);

		int i = 0;
		do {
			String operatorLest = showInputDialog(null,
					"Hva vil du gjøre med de to brøkene\ngyldige Input er '+' , '-' , '*' og '/'");
			char operator = operatorLest.charAt(0);

			String telbLest = showInputDialog(null, "Teller B:");
			int telb = Integer.parseInt(telbLest);
			String nevbLest = showInputDialog(null, "Nevner B:");
			int nevb = Integer.parseInt(nevbLest);
			Brok b = new Brok(telb, nevb);

			switch (operator) {
				case '+':
					a.pluss(b);
					i++;
					break;
				case '-':
					a.minus(b);
					i++;
					break;
				case '*':
					a.gange(b);
					i++;
					break;
				case '/':
					a.dele(b);
					i++;
					break;
				default:
					;
					System.out.println("Ugyldig Verdi for operator: prøv på nytt");
			}
		} while (i == 0);
	}
}