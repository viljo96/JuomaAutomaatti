package juomaAutomaatti;

public class juomaAutomaatti {
	
	
public juomaAutomaatti() {
		teetä = 50;
		kahvia = 50;
		kaakaota = 50;
	}
	

		private int teetä;
		private int kahvia;
		private int kaakaota;
		
		

		public int getKahvia() {
			return kahvia;
		}
		public int getTeetä() {
			return teetä;
		}
		public int getKaakaota() {
			return kaakaota;
		}
		public void setKahvia(int kahvia) {
			this.kahvia = kahvia;
		}
		public void setTeetä(int teetä) {
			this.teetä=teetä;
		}
		public void setKaakaota (int kaakaota) {
			this.kaakaota = kaakaota;
		}
		public boolean onnistuuko() {
			int luku2 = (int)(Math.random() * 100+1);
			if (luku2<=25) {
				System.out.println("Ei onnistu, kiitos kuitenkin rahoista");
				return false;
			}
			else {
				return true;
			}
		}
		
		public void valmistaKahvi() {
			if (onnistuuko())
			if(kahvia>10) {
			this.kahvia = kahvia -10;
			System.out.println("Odota hetki, Kahvisi valmistuu. Kahvia jäljellä "+kahvia+" yksikköä");
			}
			else {
				System.out.println("Kahvia ei ole jäljellä. Täytä säiliö!");
			}
			
		}
		public void valmistaTee() {
			if (onnistuuko())
			if(teetä>10) {
			this.teetä = teetä -10;
			System.out.println("Odota hetki, Teesi valmistuu. Teetä jäljellä "+teetä+" yksikköä");
			}
			else {
				System.out.println("Teetä ei ole jäljellä. Täytä säiliö!");
			}
			
		}
		public void valmistaKaakao() {
			if (onnistuuko())
			if(kaakaota>10) {
			this.kaakaota = kaakaota -10;
			System.out.println("Odota hetki, Kaakaosi valmistuu. Kaakaota jäljellä "+kaakaota+" yksikköä");
		}
		else {
			System.out.println("Kaakaota ei ole jäljellä. Täytä säiliö!");
		}
		}


		
		public String tostring() {
			return"JuomaAutomaatti [kahvia=" + kahvia + ""
					+ ", teetä=" + teetä + ", kaakaota=" + kaakaota + "]";
			
		}
		
		
		
		
	
		
}
