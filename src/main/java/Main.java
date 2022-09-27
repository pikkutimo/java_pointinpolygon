import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String pisteTiedostoNimi = "src/main/resources/pisteet.txt";
		final String polygoniTiedostoNimi = "src/main/resources/polygoni.txt";
		final File selvitysTiedosto = new File("selvitys.txt"); 
		
		// Luetaan tiedostot ja luodaan monikulmio ja taulukko pisteistä
		Monikulmio monikulmio = new Monikulmio(Tools.lueTiedosto(polygoniTiedostoNimi));
		ArrayList<Piste> pisteKoordinaatit = Tools.lueTiedosto(pisteTiedostoNimi);
		
		var tulokset = Tools.tutkiPisteet(pisteKoordinaatit, monikulmio);
		
		Tools.kirjoitaSelvitys(pisteKoordinaatit, tulokset, selvitysTiedosto);
	}
	

}
