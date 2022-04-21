/*
 *	leser saldo fra saldo.txt
 *	forteller saldo til bruker
 *	gir bruker muligheten til å legge in/ta ut penger (OptionDialog) (vise ny saldo for hver transaksjon?)
 *	Alle transaksjoner skal lagres i transaksjoner.txt (kun fra siste bruk av kontoen, betyr at dokumentet "opprettes" når klientprogrammet starter (overskriver))
 *	Dersom summen av transaksjoner gjør at saldoen blir under null, skal transaksjonene forkastes, og saldo forblir det samme
 *	ny saldo skal lagres i dokumentet saldo.txt
 */

import java.io.*;

import static javax.swing.JOptionPane.*;

public class Konto {
    public static void main(String[] args) throws IOException {

        FileReader leseSaldo = new FileReader("src/11 - /saldo.txt");
        BufferedReader leser = new BufferedReader(leseSaldo);
        String saldoLest;
        if ((saldoLest = leser.readLine()) == null){
            saldoLest = "0.0";
        }
        ;
        leser.close();
        double saldo = Double.parseDouble(saldoLest);
        showMessageDialog(null, "Du har følgende saldo: " + saldo);

        FileWriter skriveTransaksjoner = new FileWriter("transaksjonsHistorikk.txt", true);
        PrintWriter transaksjonSkriver = new PrintWriter(new BufferedWriter(skriveTransaksjoner));
        transaksjonSkriver.println("Start saldo: " + saldo);
        boolean velge = true;
        while (velge) {
            final String[] VALG = {"Avslutt", "Innskudd", "Uttak"};
            int valg = showOptionDialog(null, "Hva ønsker du å gjøre?", "saldo: " + saldo, 0, PLAIN_MESSAGE, null, VALG, VALG[0]);
            switch (valg) {
                case 2: //Ta ut penger
                    String uttakLest = showInputDialog(null, "Hvor mye ønsker du å ta ut?");
                    double uttak = Double.parseDouble(uttakLest);

                    transaksjonSkriver.println("U	" + uttak);
                    saldo -= uttak;
                    break;
                case 1: //Legg til penger
                    String innskuddLest = showInputDialog(null, "Hvor mye ønsker du å sette inn?");
                    double innskudd = Double.parseDouble(innskuddLest);

                    transaksjonSkriver.println("I	" + innskudd);
                    saldo += innskudd;
                    break;
                default: //avlsutter programmet
                    velge = false;
            }
        }
        if (saldo >= 0) {
            transaksjonSkriver.println("SluttSaldo: " + saldo + "\n\n");
            transaksjonSkriver.close();
            FileWriter skrivSaldo = new FileWriter("saldo.txt", false);
            PrintWriter saldoSkriver = new PrintWriter(new BufferedWriter(skrivSaldo));
            saldoSkriver.println(saldo);
            saldoSkriver.close();
        } else {
            throw new IllegalArgumentException("Disse uttakene er ikke mulig, snakk med oss om et lån!");
        }
    }
}