package SQLTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class testSQL {

	public ArrayList<Person> hentPersoner() {
		ArrayList<Person> personer = new ArrayList<Person>();
		String password = "BFy970Wo";
		String brukernavn = "sivertut";
		String url = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/" + brukernavn + "?user=" + brukernavn + "&password="
				+ password;
		try {
			Connection con = DriverManager.getConnection(url);
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM person ORDER BY fornavn");

			while (res.next()) {
				personer.add(new Person(res.getString("fornavn"), res.getString("etternavn"), res.getInt("persnr")));
				/*
				 * System.out.println(res.getInt("persnr"));
				 * System.out.println(res.getString("fornavn"));
				 * System.out.println(res.getString("etternavn"));
				 */
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return personer;
	}

	public class Person {
		private String fornavn;
		private String etternavn;
		private int persNr;

		public Person(String fornavn, String etternavn, int persNr) {
			this.etternavn = etternavn;
			this.fornavn = fornavn;
			this.persNr = persNr;
		}

		public String getFornavn() {
			return fornavn;
		}

		public void setFornavn(String fornavn) {
			this.fornavn = fornavn;
		}

		public String getEtternavn() {
			return etternavn;
		}

		public void setEtternavn(String etternavn) {
			this.etternavn = etternavn;
		}

		public int getPersNr() {
			return persNr;
		}

		public void setPersNr(int persNr) {
			this.persNr = persNr;
		}

		public String toString() {
			return "Navn: " + fornavn + " " + etternavn + "\nPersNr: " + persNr;
		}

	}

	public static void main(String args[]) throws Exception {
		ArrayList<Person> personer = new testSQL().hentPersoner();
		for (Person pers : personer) {
			System.out.println("\n" + pers);
		}

	}
}
