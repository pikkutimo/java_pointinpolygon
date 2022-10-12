import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
	
	/**
	 *  Käytetyt vakiot
	 */
	public static final String PISTE_TIEDOSTONIMI = "src/main/resources/pisteet.txt";
	public static final String POLYGONI_TIEDOSTONIMI = "src/main/resources/polygoni.txt";
	public static final String SELVITYS_TIEDOSTONIMI = "selvitys.txt";
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException { 
		
		// Luetaan tiedostot ja luodaan monikulmio ja taulukko pisteistä
		Path polygoniTiedosto = Paths.get(POLYGONI_TIEDOSTONIMI);
		Monikulmio monikulmio = new Monikulmio(TiedostoKasittelija.lueTiedosto(polygoniTiedosto));
		Path pisteTiedosto = Paths.get(PISTE_TIEDOSTONIMI);
		ArrayList<Piste> pisteKoordinaatit = TiedostoKasittelija.lueTiedosto(pisteTiedosto);
		
		// Varsinainen laskeva osuus, joka tutkii pisteiden suhdetta monikulmioon ja palauttaa selvityksen esim arrayList<String>
		// ArrayList sisältäisi taulukon, jossa jokaista pistettä kohden mainitaan koordinaatit ja onko se suhteessa monikulmioon
		// ulkopuolella, viivalla vai sisäpuolella
		var tulokset = Tools.tutkiPisteet(pisteKoordinaatit, monikulmio);
		
		// Luodaan selvitys
		final File selvitysTiedosto = new File(SELVITYS_TIEDOSTONIMI);
		
		// Kirjoitetaan selvitys tiedostoon
		TiedostoKasittelija.kirjoitaSelvitys(tulokset, selvitysTiedosto);
	}
	

}
