	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;
	public class Yhteys {
	



		public static void main(String args[])  {
			
		try {
				//luodaan tietokantayhteys
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7268345","sql7268345", "SJS@Burns88");
				
				//Statement-olio, joka keskustelee tietokantaan
				Statement stmt = (Statement) con.createStatement();
				
				//Luodaan tulosjoukko, johon sijoitetaan kyselyn tulos
				ResultSet rs = stmt.executeQuery("SELECT * FROM kirjat");
				
				while(rs.next())
					System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
				
				if (con != null) {
					System.out.println("Yhteys on muodostettu!");
				}
				con.close();
			
				
				//varaudutaan virheisiin
		}catch (Exception e) {
			System.out.println("Tapahtui virhe!");
			System.out.println(e);
		}
	}
	}

