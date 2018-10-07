package juomaAutomaatti;

import java.util.Scanner;

public class JuomaKone2 {
	

	public static void main(String[] args) {
		Scanner lukija = new Scanner(System.in);
		
		
		juomaAutomaatti omakone = new juomaAutomaatti();
		System.out.println("*******JuomaAutomaatti*******\n\n"
				+ " 1.kahvi\n"
				+ " 2.tee\n"
				+ " 3.kaakao\n"
				+ " 4.lopeta\n\n"
				+ " ***********************" );
		int luku1 = 0;
		while(luku1!=4) {
			luku1=lukija.nextInt();
		System.out.println("*******JuomaAutomaatti*******\n\n"
				+ " 1.kahvi\n"
				+ " 2.tee\n"
				+ " 3.kaakao\n"
				+ " 4.lopeta\n\n"
				+ " ***********************" );
		 if(luku1 == 1 ) {
			omakone.valmistaKahvi();
		 }
		else if(luku1 == 2) {
			omakone.valmistaTee();
		}
		else if(luku1 == 3) {
			omakone.valmistaKaakao();
			
		}
		else if (luku1 == 4){
			System.out.println("lopetetaan");
			break;
		}		 
	
		
		
		 
		
	
		}
}
}
