import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TiedostoKasittelija {
	
	/**
	 * @param fileName
	 * @return palauttaa luetun tiedoston koordinaatit listana
	 * @throws IOException 
	 */
	public static ArrayList<String> lueTiedosto(Path tiedostoPolku) throws IOException {;
		List<String> rivit = Files.readAllLines(tiedostoPolku);

		
		return new ArrayList<String>(rivit);
	}
	
	
	/**
	 * @param pisteet
	 * @param tiedostopolku
	 * @throws IOException
	 */
	public static void kirjoitaPisteitaTiedostoon(ArrayList<String> pisteet, Path tiedostopolku) throws IOException {
		Files.write(tiedostopolku, pisteet);
	}
	
	/**
	 * Kirjoitttaa selvityksen tutkiPisteet-metodin tuloksen mukaisesti tiedostoon
	 * @param tulokset
	 * @param tiedostoNimi
	 * @throws IOException 
	 */
	public static void kirjoitaTiedostoon(ArrayList<String> tulokset, Path tiedostoPolku) throws IOException {
		
		if (tulokset.size() == 0) {
			System.out.println("Tiedosto tyhja, kirjoitus peruttu.");
			return;
		}
		
		Files.write(tiedostoPolku, tulokset);
	}
}
