import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;

public class SanaKirja {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException  {
		String[] suomi= {"kissa", "koira","hevonen", "auto", "vene"};
		String[] englanti= {"cat","dog","horse","car","boat"};
		
		HashMap<String, String> parit = new HashMap<>();
		parit.put(suomi[0],englanti[0]);
		parit.put(suomi[1],englanti[1]);
		parit.put(suomi[2],englanti[2]);
		parit.put(suomi[3],englanti[3]);
		parit.put(suomi[4],englanti[4]);
		for (int i = 0; i < suomi.length; i++) {
			parit.put(suomi[i], englanti[i]);
		}
		
		String seuraava="";
		String seuraava2="";
		String seuraava3="";
		Scanner lukija= new Scanner(System.in);
		Iterator<Entry<String, String>> ite = parit.entrySet().iterator();
		while (ite.hasNext()) {
			HashMap.Entry<String, String> alkio = (HashMap.Entry<String, String>) ite.next();
		}
		
		XMLDecoder decoder = null;
		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("K��nn�s.xml")));
		}catch (FileNotFoundException e) {
			FileOutputStream tiedosto = new FileOutputStream("K��nn�s.xml");
			XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(tiedosto));
			enc.writeObject(parit);
			enc.close();
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("K��nn�s.xml")));
		}
		parit = (HashMap<String, String>) decoder.readObject();
		System.out.print("Sanakirjan sis�lt�: ");
		System.out.println(parit);
		while(seuraava!=null){
			System.out.println("Mink� sanan k��nn�ksen haluat tiet��? (tyhj� sana lopettaa)");
			 seuraava=lukija.nextLine();
				
			 if (seuraava.equals("")) {
					System.out.print("Ohjelma lopetetaan, kiitos k�ynnist�!");
					System.exit(0);
			 }
					if (seuraava.equals("kaikki")) {
						System.out.println("K��nn�kset:");
						Iterator<Entry<String, String>> it = parit.entrySet().iterator();
						while (it.hasNext()) {
							HashMap.Entry<String, String> alkio = (HashMap.Entry<String, String>) it.next();
							System.out.println(alkio.getKey() + " = " + alkio.getValue());
						}
						System.out.println();
					}
				
			 if (seuraava.equals("tallenna")){
					FileOutputStream tiedosto = new FileOutputStream("K��nn�s.xml");
					XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(tiedosto));
					enc.writeObject(parit);
					enc.close();

					
					System.out.println("K��nn�kset tallennettu!");
					System.out.println();
				}
			
			if(parit.containsKey(seuraava)) {
				System.out.print("Sanan\"" + seuraava+"\"k��nn�s on \""+parit.get(seuraava)+"\"\n");
			}
			if(seuraava.equals("lis��")) {
			while(seuraava2!=null &&seuraava3!=null) {
				if(seuraava.equals("lis��")){
					
				System.out.println("Sana alkukielell�? (tyhj� lopettaa)");
			seuraava2=lukija.nextLine();
			if(seuraava2.equals("")) {
				break;
			}
			System.out.println("Sanan k��nn�s? (tyhj� lopettaa)");
			seuraava3=lukija.nextLine();
			if(seuraava3.equals("")) {
				
			}
			
			}
				parit.put(seuraava2, seuraava3);
			}
			
		
	}
			if(!parit.containsKey(seuraava) && !seuraava.equals("lis��")&& !seuraava.equals("tallenna")&& !seuraava.equals("kaikki")) {
				System.out.println("Sanalle \""+seuraava+" \"ei l�ytynyt k��nn�st�");
			}

}
}
}
