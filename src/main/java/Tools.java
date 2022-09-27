
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Tools {

	public Tools() {
		// Tyhjä rakentaja
	}
	
	private static Piste muunnaPisteeksi(String rivi) {
		String[] numerot = rivi.split(",");
        int x = Integer.parseInt(numerot[0]);
        int y = Integer.parseInt(numerot[1]);
        return new Piste(x, y);
	}
	
	public static ArrayList<Piste> lueTiedosto(String fileName) {
		ArrayList<Piste> tulos = new ArrayList<Piste>();
		try (Scanner tiedostonLukija = new Scanner(Paths.get(fileName))) {

		    // luetaan tiedostoja kunnes kaikki rivit on luettu
		    while (tiedostonLukija.hasNextLine()) {
		        // luetaan yksi rivi
		        String rivi = tiedostonLukija.nextLine();
		        tulos.add(muunnaPisteeksi(rivi));
		    }
		} catch (Exception e) {
		    System.out.println("Virhe: " + e.getMessage());
		}
		
		return tulos;
	}
	
	public static ArrayList<String> tutkiPisteet(ArrayList<Piste> koordinaatit, Monikulmio monikulmio) {
		ArrayList<String> tulokset = new ArrayList<String>();
		
		for (var piste: koordinaatit) {
			tulokset.add(monikulmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
		}
		
		return tulokset;
	}
	
	public static void kirjoitaSelvitys(ArrayList<Piste> koordinaatit, ArrayList<String> tulokset, File tiedostoNimi) {
		
		try {
			BufferedWriter kirjoittaja = new BufferedWriter(new FileWriter(tiedostoNimi));
			
			for (var piste: koordinaatit) {
				kirjoittaja.write("[" + piste.toString() + "] - on polygonin sisällä.\n");
			}
			
			kirjoittaja.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
