
import java.util.ArrayList;
import java.util.Collections;



/**
 * @author pikku
 * Monikulmio on v‰hint‰‰n kolmen pisteen muodostama suorasivuinen ja suljettu tasokuvio
 */

public class Monikulmio {
	
	
	/**
	 * Monikulmion kulmien koordinaatit
	 */
	private ArrayList<Piste> pisteet = new ArrayList<Piste>();
	
	/**
	 * @return
	 */
	public ArrayList<Piste> getPisteet() {
		return pisteet;
	}
	
	/**
	 * @param koordinaatit
	 */
	public Monikulmio(ArrayList<String> koordinaatit) {
		var muunnetutPisteet = Tools.muunnaPisteListaksi(koordinaatit);
		this.pisteet = muunnetutPisteet;
	}
	
	/**
	 * 
	 */
	public Monikulmio() {
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 */
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
	
	/**
	 * @param piste
	 */
	public void lisaaPiste(Piste piste) {
		this.pisteet.add(piste);
	}
	
	/**
	 * @return
	 */
	public boolean onkoMonikulmio() {
		if (this.pisteet.size() < 4) {
			return false;
		}
		
		int ensimmainenX = this.pisteet.get(0).getxKoordinaatti();
		int ensimmainenY = this.pisteet.get(0).getyKoordinaatti();
		int viimeinenX = this.pisteet.get(this.pisteet.size() - 1).getxKoordinaatti();
		int viimeinenY = this.pisteet.get(this.pisteet.size() - 1).getyKoordinaatti();
		
		if (ensimmainenX != viimeinenX || ensimmainenY != viimeinenY) {
			return false;
		}
		
		return true;
	}

	/**
	 * Ratkaisumetodi lokakuussa 2018 julkaistusta artikkelista
	 * <a href="https://www.researchgate.net/publication/328261365_Optimal_Reliable_Point-in-Polygon_Test_and_Differential_Coding_Boolean_Operations_on_Polygons">Optimal Reliable Point-in-Polygon Test andDifferential Coding Boolean Operations on Polygons</a>
	 * @param piste
	 * @return
	 */
	public String pisteenSijaintiSuhteessaMonikulmioon(Piste piste) {
		String tulos = "Piste " + piste.toString() + " on monikulmion ";
		int k = 0, f = 0;
		int pisteenX = piste.getxKoordinaatti();
		int pisteenY = piste.getyKoordinaatti();
		
		final int muodonPituus = this.pisteet.size() - 1;
		
		var u1 = this.pisteet.get(0).getxKoordinaatti() - pisteenX;
		var v1 = this.pisteet.get(0).getyKoordinaatti() - pisteenY;
		
		var nykyinenPiste = this.pisteet.get(0);
		
		for (int index = 0; index < muodonPituus; index++) {
			
			var seuraavaPiste = this.pisteet.get(index + 1);
			var v2 = seuraavaPiste.getyKoordinaatti() - pisteenY;

            if ((v1 < 0 && v2 < 0) || (v1 > 0 && v2 > 0)) {
                nykyinenPiste = seuraavaPiste;
                v1 = v2;
                u1 = nykyinenPiste.getxKoordinaatti() - pisteenX;
                continue;
            }

            var u2 = seuraavaPiste.getxKoordinaatti() - pisteenX;

            if (v2 > 0 && v1 <= 0) {
                f = (u1 * v2) - (u2 * v1);
                if (f > 0) {
                	k = k + 1;
                }
                else if (f == 0) {
                	return tulos + "reunaviivan paalla.";
                }
            } else if (v1 > 0 && v2 <= 0) {
                f = (u1 * v2) - (u2 * v1);
                if (f < 0) 
                	k = k + 1;
                else if (f == 0)
                	return tulos + "reunaviivan paalla.";
            } else if (v2 == 0 && v1 < 0) {
                f = (u1 * v2) - (u2 * v1);
                if (f == 0) 
                	return tulos + "reunaviivan paalla.";
            } else if (v1 == 0 && v2 < 0) {
                f = u1 * v2 - u2 * v1;
                if (f == 0) 
                	return tulos + "reunaviivan paalla.";
            } else if (v1 == 0 && v2 == 0) {
                if (u2 <= 0 && u1 >= 0) {
                    return tulos + "reunaviivan paalla.";
                } else if (u1 <= 0 && u2 >= 0) {
                    return tulos + "reunaviivan paalla.";
                }
            }
            nykyinenPiste = seuraavaPiste;
            v1 = v2;
            u1 = u2;
		}
		
		if (k % 2 == 0)
			tulos += "ulkopuolella.";
		else
			tulos += "sisapuolella.";
		
		
		return tulos;
	}
}
