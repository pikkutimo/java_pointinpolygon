
import java.util.ArrayList;

/**
 * @author pikku
 * Pääohjelman apuohjelmat
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
		
        int x = Integer.parseInt(numerot[0]);
        int y = Integer.parseInt(numerot[1]);
        
        return new Piste(x, y);
	}
	
	/**
	 * @param koordinaatit
	 * @param monikulmio
	 * @return listauksen läpikäydyistä pisteitä ja niiden sijainnista suhteessa monikulmioon
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
