/* 
 * øving 7 oppgave 10.9.1 side 345
 * Lag en tegning av en "Smiley", legg tegningen først i en applikasjon, deretter i en applet.
*/
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
//
//class Vindu extends JFrame {
//  	public Vindu(String tittel) {
//    		setTitle(tittel);
//    		setSize(1680, 1100); // bredde, høyde
//    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//   	 	Tegning tegningen = new Tegning();
//    		add(tegningen);
//  	}
//}
//
//class Tegning extends JPanel {
//	public void paintComponent(Graphics smiley) {
//	 	super.paintComponent(smiley);  // husk denne!
//
//		Font skrift = new Font("Comic sans ms" , Font.BOLD , 40);
//	     	smiley.setFont(skrift);
//		smiley.drawString("MFW java.lang.NullPointerException", 500, 300);
//		Color himmel = new Color(120,200,255);
//		Color hode = new Color(255,220,175);
//		Color øyne = new Color(150,255,200);
//
//		setBackground(himmel);
//		//Hode
//		smiley.setColor(hode);
//		smiley.fillOval(720, 370, 250, 250);
//
//		//Øyne
//		smiley.setColor(Color.white); //Venstre
//		smiley.fillOval(800, 450, 40, 40);
//		smiley.setColor(øyne);
//		smiley.fillOval(812, 465, 20, 20);
//		smiley.setColor(Color.black);
//		smiley.fillOval(818, 470, 10, 10);
//
//		smiley.setColor(Color.white); //Høyre
//		smiley.fillOval(880, 450, 40, 40);
//		smiley.setColor(øyne);
//		smiley.fillOval(892, 465, 20, 20);
//		smiley.setColor(Color.black);
//		smiley.fillOval(898, 470, 10, 10);
//
//		//Øyenbryn
//		smiley.drawArc(760 , 445 , 100 , 50, 50 ,50);  //plassering fra venstre, plassering fra topp, bredde, høyde, startvinkel(0 er rett høyre), sluttvinkel (fra startpunkt)
//		smiley.drawArc(840 , 445 ,100 , 50, 50 , 40);
//
//		//Munn
//		smiley.drawArc(750 , 520 ,200 , 50, 0 , -160);
//  	}
//}
//public class SmileyApplet extends JApplet {
//  	public void init(){
//    	 	Vindu smil = new Vindu("Robert the Retard");
//    	 	smil.setVisible(true);
//  	}
//}