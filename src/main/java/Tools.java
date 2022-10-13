
import java.util.ArrayList;

/**
 * @author pikku
 * P‰‰ohjelman apuohjelmat
 */
public class Tools {
	
	/**
	 * @param rivi
	 * @return
	 */
	public static Piste muunnaPisteeksi(String rivi) {
		if (rivi == null) {
			throw new IllegalArgumentException("String argumentti ei voi olla tyhja.");
		}
		
		String[] numerot = rivi.split(",");
		
		if (numerot.length != 2) {
			throw new IllegalArgumentException("Epakurantti string-argumentti.");
		}
		
        int x = Integer.parseInt(numerot[0].trim());
        int y = Integer.parseInt(numerot[1].trim());
        
        return new Piste(x, y);
	}
	
	/**
	 * @param koordinaatit
	 * @return
	 */
	public static ArrayList<Piste> muunnaPisteListaksi(ArrayList<String> koordinaatit) {
		ArrayList<Piste> pisteet = new ArrayList<Piste>();
		for (var koordinaatti: koordinaatit) {
			pisteet.add(Tools.muunnaPisteeksi(koordinaatti));
		}
		
		return pisteet;
	}
	
	/**
	 * @param koordinaatit
	 * @param monikulmio
	 * @return listauksen l‰pik‰ydyist‰ pisteit‰ ja niiden sijainnista suhteessa monikulmioon
	 */
	public static ArrayList<String> tutkiPisteet(ArrayList<Piste> koordinaatit, Monikulmio monikulmio) {
		ArrayList<String> tulokset = new ArrayList<String>();
		final String epakurantti = "Annetut pisteet eivat muodosta aitoa monikulmiota";
		
		if (monikulmio.onkoMonikulmio()) {
			for (var piste: koordinaatit) {
				tulokset.add(monikulmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
			}
		} else {
			tulokset.add(epakurantti);
			System.out.println(epakurantti);	
		}
		
		return tulokset;
	}
	
}
