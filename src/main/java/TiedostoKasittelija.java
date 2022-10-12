import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TiedostoKasittelija {
	
	/**
	 * @param fileName
	 * @return palauttaa luetun tiedoston koordinaatit listana pisteitä
	 * @throws IOException 
	 */
	public static ArrayList<Piste> lueTiedosto(Path tiedostoPolku) throws IOException {
		
//		File tiedosto = new File(tiedostoNimi);
//		if (!tiedosto.exists()) {
//			System.out.println("Tiedosto " + tiedostoNimi + " puuttuu.");
//			throw new IOException("Tiedosto " + tiedostoNimi + " puuttuu.");
//		}
		
//		Path tiedostoPolku = tiedosto.toPath();
		List<String> rivit = Files.readAllLines(tiedostoPolku);
		
		ArrayList<Piste> tulos = new ArrayList<Piste>();
		for (var rivi : rivit) {
			tulos.add(Tools.muunnaPisteeksi(rivi));
		}
		
		return tulos;
	}
	
	public static void kirjoitaPisteitaTiedostoon(ArrayList<String> pisteet, Path tiedostopolku) throws IOException {
		Files.write(tiedostopolku, pisteet);
	}
	
//	public static ArrayList<Piste> lueTiedosto(String tiedostoNimi) throws IOException {
//		
//		File tiedosto = new File(tiedostoNimi);
//		if (!tiedosto.exists()) {
//			System.out.println("Tiedosto " + tiedostoNimi + " puuttuu.");
//			throw new IOException("Tiedosto " + tiedostoNimi + " puuttuu.");
//		}
//		
//		Path tiedostoPolku = tiedosto.toPath();
//		List<String> rivit = Files.readAllLines(tiedostoPolku);
//		
//		ArrayList<Piste> tulos = new ArrayList<Piste>();
//		for (var rivi : rivit) {
//			tulos.add(Tools.muunnaPisteeksi(rivi));
//		}
//		
//		return tulos;
//	}
//	
	/**
	 * Kirjoitttaa selvityksen tutkiPisteet-metodin tuloksen mukaisesti tiedostoon
	 * @param tulokset
	 * @param tiedostoNimi
	 * @throws IOException 
	 */
	public static void kirjoitaSelvitys(ArrayList<String> tulokset, File tiedosto) throws IOException {
		
		if (tulokset.size() == 0) {
			System.out.println("Tiedosto tyhja, kirjoitus peruttu.");
			return;
		}
		Files.write(tiedosto.toPath(), tulokset);
	}
}
