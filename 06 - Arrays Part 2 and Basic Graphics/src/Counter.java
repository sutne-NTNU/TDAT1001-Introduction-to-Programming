/* 
 * Øving 6. oppgave 7.8.1 side 230
 * tabell av forkomster av tilfeldige tall
*/
public class Counter {
	public static void main(String[] args) {
		int tall = 0;
		int[] antall = new int[10];
		java.util.Random random = new java.util.Random();
		for (int i = 0; i < 10000; i++) {
			tall = random.nextInt(10);
			antall[tall]++;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(i + ": " + antall[i]);
		}
	}
}
