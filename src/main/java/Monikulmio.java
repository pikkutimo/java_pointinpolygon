
import java.util.ArrayList;
import java.util.Collections;

public class Monikulmio {
	
	private ArrayList<Piste> pisteet = new ArrayList<Piste>();
	
	public ArrayList<Piste> getPisteet() {
		return pisteet;
	}

	public Monikulmio() {
		// Tyhjä rakentantaja
	}
	
	public Monikulmio(ArrayList<Piste> koordinaatit) {
		this.pisteet = koordinaatit;
	}
	
	@Override
	public String toString() {
		if (this.pisteet.size() == 0) {
			return "Monikulmiossa ei ole pisteita.";
		}
		
		String tuloste = new String();
		
		for (var piste: this.pisteet) {
			tuloste = tuloste + piste.toString() + " ";
		}
		
		return tuloste.substring(0, tuloste.length() - 1);
	}
	
	public void lisaaPiste(Piste piste) {
		this.pisteet.add(piste);
	}
	
	public boolean onkoMonikulmio() {
		if (this.pisteet.size() < 3) {
			return false;
		}
		
		return true;
	}
	
	public int[] haeRajaavanLaatikonRajat() {
		ArrayList<Integer> xKoordinaatit = new ArrayList<Integer>();
		ArrayList<Integer> yKoordinaatit = new ArrayList<Integer>();
		
		for (var piste: this.pisteet) {
			xKoordinaatit.add(piste.getxKoordinaatti());
			yKoordinaatit.add(piste.getyKoordinaatti());
		}
		
		int maxKoordinaattiX = Collections.max(xKoordinaatit);
		int minKoordinaattiX = Collections.min(xKoordinaatit);
		int maxKoordinaattiY = Collections.max(yKoordinaatit);
		int minKoordinaattiY = Collections.min(yKoordinaatit);
		
		return new int[] {maxKoordinaattiX, minKoordinaattiX, maxKoordinaattiY, minKoordinaattiY};
	}
	
	public String pisteenSijaintiSuhteessaMonikulmioon(Piste piste) {
		
		// Jos piste sijaitsee laatikon ulkopuolella, se on monikulmionkin ulkopuolella
		int[] rajat = haeRajaavanLaatikonRajat();
		
		if (piste.getxKoordinaatti() < rajat[1] || piste.getxKoordinaatti() > rajat[0] || piste.getyKoordinaatti() < rajat[3] || piste.getyKoordinaatti() > rajat[2]) {
			return "Ulkopuolella";
		}
		
		return "Sisapuolella";
	}
}
