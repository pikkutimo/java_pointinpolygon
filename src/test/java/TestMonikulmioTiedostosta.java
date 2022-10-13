import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;


public class TestMonikulmioTiedostosta {

	@TempDir
	File tilapaisHakemisto;
	
	private File pisteTiedosto, polygoniTiedosto, selvitysTiedosto;
	private List<String> vertailupisteet;
	ArrayList<String> vertailupisteetTiedostoon;
	Path testiPolygoniTiedosto, testiPisteTiedosto;

	/**
	 * @throws IOException
	 */
	@Test
	public void testTilapaisHakemistoonKirjoitettuTiedostoOnLuettavissa() throws IOException { 
	    pisteTiedosto = new File(tilapaisHakemisto, "testi_pisteet.txt");
	    List<String> vertailupisteet = Arrays.asList("10,5");
	    ArrayList<String> a1 = new ArrayList<String>(vertailupisteet);
	    
	    TiedostoKasittelija.kirjoitaTiedostoon(a1, pisteTiedosto.toPath());

	    ArrayList<Piste> luetutPisteet = Tools.muunnaPisteListaksi(TiedostoKasittelija.lueTiedosto(pisteTiedosto.toPath()));
	    
	    assertEquals(luetutPisteet.get(0).toString(), "[10, 5]");
	}
	
	/**
	 * @throws IOException
	 */
	@Test
	public void testTiedostostaLuettuSuorakulmiojaPisteetSelvitysKirjoitetaan() throws IOException {
		
		pisteTiedosto = new File(tilapaisHakemisto, "testi_pisteet.txt");
		vertailupisteet = Arrays.asList("10,5", "85,150", "6,6");
	    vertailupisteetTiedostoon = new ArrayList<String>(vertailupisteet);
	    TiedostoKasittelija.kirjoitaTiedostoon(vertailupisteetTiedostoon, pisteTiedosto.toPath());
	    
		polygoniTiedosto = new File(tilapaisHakemisto, "testi_polygoni.txt");
		var suorakulmio = TestiTyokalu.muodostaSuorakulmio();
		var suorakulmionPisteetTekstina = TestiTyokalu.muunnaPisteetTekstiksi(suorakulmio);
		TiedostoKasittelija.kirjoitaTiedostoon(suorakulmionPisteetTekstina, polygoniTiedosto.toPath());
		
		testiPolygoniTiedosto = polygoniTiedosto.toPath();
		var kirjoitettuMonikulmio = new Monikulmio(TiedostoKasittelija.lueTiedosto(testiPolygoniTiedosto));
		testiPisteTiedosto = pisteTiedosto.toPath();
		var kirjoitetutPisteKoordinaatit = Tools.muunnaPisteListaksi(TiedostoKasittelija.lueTiedosto(testiPisteTiedosto));
		
		var testiSelvitys = Tools.tutkiPisteet(kirjoitetutPisteKoordinaatit, kirjoitettuMonikulmio);
		selvitysTiedosto = new File(tilapaisHakemisto, "testi_selvitys.txt");
		TiedostoKasittelija.kirjoitaTiedostoon(testiSelvitys, selvitysTiedosto.toPath());
		
		var kirjoitettuTulos = TiedostoKasittelija.lueTiedosto(selvitysTiedosto.toPath());
		
		assertAll(
				() -> assertEquals(kirjoitettuTulos.size(), 3),
				() -> assertTrue(polygoniTiedosto.exists(), "Polygonitiedosto on olemassa"),
				() -> assertTrue(pisteTiedosto.exists(), "Pistetiedosto on olemassa"),
				() -> assertTrue(selvitysTiedosto.exists(), "Selvitystiedosto on olemassa"),
				() -> assertEquals(kirjoitettuTulos.get(0), "Piste [10, 5] on monikulmion reunaviivan paalla."),
				() -> assertEquals(kirjoitettuTulos.get(1), "Piste [85, 150] on monikulmion ulkopuolella."),
				() -> assertEquals(kirjoitettuTulos.get(2), "Piste [6, 6] on monikulmion sisapuolella.")
				);
	}
	
	
	/**
	 * @throws IOException
	 */
	@Test
	public void testTiedostostaLuettuKolmiojaPisteetSelvitysKirjoitetaan() throws IOException {
		
		pisteTiedosto = new File(tilapaisHakemisto, "testi_pisteet.txt");
		vertailupisteet = Arrays.asList("50,5", "1,1", "50,10");
	    vertailupisteetTiedostoon = new ArrayList<String>(vertailupisteet);
	    TiedostoKasittelija.kirjoitaTiedostoon(vertailupisteetTiedostoon, pisteTiedosto.toPath());
	    
		polygoniTiedosto = new File(tilapaisHakemisto, "testi_kolmio.txt");
		var kolmio = TestiTyokalu.muodostaKolmio();
		var kolmionPisteetTekstina = TestiTyokalu.muunnaPisteetTekstiksi(kolmio);
		TiedostoKasittelija.kirjoitaTiedostoon(kolmionPisteetTekstina, polygoniTiedosto.toPath());
		
		testiPolygoniTiedosto = polygoniTiedosto.toPath();
		var kirjoitettuMonikulmio = new Monikulmio(TiedostoKasittelija.lueTiedosto(testiPolygoniTiedosto));
		testiPisteTiedosto = pisteTiedosto.toPath();
		var kirjoitetutPisteKoordinaatit = Tools.muunnaPisteListaksi(TiedostoKasittelija.lueTiedosto(testiPisteTiedosto));
		
		var testiSelvitys = Tools.tutkiPisteet(kirjoitetutPisteKoordinaatit, kirjoitettuMonikulmio);
		selvitysTiedosto = new File(tilapaisHakemisto, "testi_selvitys.txt");
		TiedostoKasittelija.kirjoitaTiedostoon(testiSelvitys, selvitysTiedosto.toPath());
		
		var kirjoitettuTulos = TiedostoKasittelija.lueTiedosto(selvitysTiedosto.toPath());
		
		assertAll(
				() -> assertEquals(kirjoitettuTulos.size(), 3),
				() -> assertTrue(polygoniTiedosto.exists(), "Polygonitiedosto on olemassa"),
				() -> assertTrue(pisteTiedosto.exists(), "Pistetiedosto on olemassa"),
				() -> assertTrue(selvitysTiedosto.exists(), "Selvitystiedosto on olemassa"),
				() -> assertEquals("Piste [50, 5] on monikulmion reunaviivan paalla.", kirjoitettuTulos.get(0)),
				() -> assertEquals("Piste [1, 1] on monikulmion ulkopuolella.", kirjoitettuTulos.get(1)),
				() -> assertEquals("Piste [50, 10] on monikulmion sisapuolella.", kirjoitettuTulos.get(2))
				);
	}
	
	/**
	 * @throws IOException
	 */
	@Test
	public void testTiedostostaLuettuSuunnikasjaPisteetSelvitysKirjoitetaan() throws IOException {
		
		pisteTiedosto = new File(tilapaisHakemisto, "testi_pisteet.txt");
		vertailupisteet = Arrays.asList("30,55", "4,4", "30,30");
	    vertailupisteetTiedostoon = new ArrayList<String>(vertailupisteet);
	    TiedostoKasittelija.kirjoitaTiedostoon(vertailupisteetTiedostoon, pisteTiedosto.toPath());
	    
		polygoniTiedosto = new File(tilapaisHakemisto, "testi_suunnikas.txt");
		var suunnikas = TestiTyokalu.muodostaSuunnikas();
		var suunnikkaanPisteetTekstina = TestiTyokalu.muunnaPisteetTekstiksi(suunnikas);
		TiedostoKasittelija.kirjoitaTiedostoon(suunnikkaanPisteetTekstina, polygoniTiedosto.toPath());
		
		testiPolygoniTiedosto = polygoniTiedosto.toPath();
		var kirjoitettuMonikulmio = new Monikulmio(TiedostoKasittelija.lueTiedosto(testiPolygoniTiedosto));
		testiPisteTiedosto = pisteTiedosto.toPath();
		var kirjoitetutPisteKoordinaatit = Tools.muunnaPisteListaksi(TiedostoKasittelija.lueTiedosto(testiPisteTiedosto));
		
		var testiSelvitys = Tools.tutkiPisteet(kirjoitetutPisteKoordinaatit, kirjoitettuMonikulmio);
		selvitysTiedosto = new File(tilapaisHakemisto, "testi_selvitys.txt");
		TiedostoKasittelija.kirjoitaTiedostoon(testiSelvitys, selvitysTiedosto.toPath());
		
		var kirjoitettuTulos = TiedostoKasittelija.lueTiedosto(selvitysTiedosto.toPath());
		
		assertAll(
				() -> assertEquals(kirjoitettuTulos.size(), 3),
				() -> assertTrue(polygoniTiedosto.exists(), "Polygonitiedosto on olemassa"),
				() -> assertTrue(pisteTiedosto.exists(), "Pistetiedosto on olemassa"),
				() -> assertTrue(selvitysTiedosto.exists(), "Selvitystiedosto on olemassa"),
				() -> assertEquals("Piste [30, 55] on monikulmion reunaviivan paalla.", kirjoitettuTulos.get(0)),
				() -> assertEquals("Piste [4, 4] on monikulmion ulkopuolella.", kirjoitettuTulos.get(1)),
				() -> assertEquals("Piste [30, 30] on monikulmion sisapuolella.", kirjoitettuTulos.get(2))
				);
	}
	
	/**
	 * @throws IOException
	 */
	@Test
	public void testTiedostostaLuettuKonkaaviKuusikulmiojaPisteetSelvitysKirjoitetaan() throws IOException {
		
		pisteTiedosto = new File(tilapaisHakemisto, "testi_pisteet.txt");
		vertailupisteet = Arrays.asList("55,55", "35,5", "54,54", "1, 1");
	    vertailupisteetTiedostoon = new ArrayList<String>(vertailupisteet);
	    TiedostoKasittelija.kirjoitaTiedostoon(vertailupisteetTiedostoon, pisteTiedosto.toPath());
	    
		polygoniTiedosto = new File(tilapaisHakemisto, "testi_suunnikas.txt");
		var konkaaviKuusikulmio = TestiTyokalu.muodostaSuunnikas();
		var konkaavinKuusikulmionPisteetTekstina = TestiTyokalu.muunnaPisteetTekstiksi(konkaaviKuusikulmio);
		TiedostoKasittelija.kirjoitaTiedostoon(konkaavinKuusikulmionPisteetTekstina, polygoniTiedosto.toPath());
		
		testiPolygoniTiedosto = polygoniTiedosto.toPath();
		var kirjoitettuMonikulmio = new Monikulmio(TiedostoKasittelija.lueTiedosto(testiPolygoniTiedosto));
		testiPisteTiedosto = pisteTiedosto.toPath();
		var kirjoitetutPisteKoordinaatit = Tools.muunnaPisteListaksi(TiedostoKasittelija.lueTiedosto(testiPisteTiedosto));
		
		var testiSelvitys = Tools.tutkiPisteet(kirjoitetutPisteKoordinaatit, kirjoitettuMonikulmio);
		selvitysTiedosto = new File(tilapaisHakemisto, "testi_selvitys.txt");
		TiedostoKasittelija.kirjoitaTiedostoon(testiSelvitys, selvitysTiedosto.toPath());
		
		var kirjoitettuTulos = TiedostoKasittelija.lueTiedosto(selvitysTiedosto.toPath());
		
		assertAll(
				() -> assertEquals(kirjoitettuTulos.size(), 4),
				() -> assertTrue(polygoniTiedosto.exists(), "Polygonitiedosto on olemassa"),
				() -> assertTrue(pisteTiedosto.exists(), "Pistetiedosto on olemassa"),
				() -> assertTrue(selvitysTiedosto.exists(), "Selvitystiedosto on olemassa"),
				() -> assertEquals("Piste [55, 55] on monikulmion reunaviivan paalla.", kirjoitettuTulos.get(0)),
				() -> assertEquals("Piste [35, 5] on monikulmion ulkopuolella.", kirjoitettuTulos.get(1)),
				() -> assertEquals("Piste [54, 54] on monikulmion sisapuolella.", kirjoitettuTulos.get(2)),
				() -> assertEquals("Piste [1, 1] on monikulmion ulkopuolella.", kirjoitettuTulos.get(3))
				);
	}
	
	/**
	 * @throws IOException
	 */
	@Test
	public void testTiedostostaLuettuPentagrammijaPisteetSelvitysKirjoitetaan() throws IOException {
		
		pisteTiedosto = new File(tilapaisHakemisto, "testi_pisteet.txt");
		vertailupisteet = Arrays.asList("100,5", "135,15", "100,60");
	    vertailupisteetTiedostoon = new ArrayList<String>(vertailupisteet);
	    TiedostoKasittelija.kirjoitaTiedostoon(vertailupisteetTiedostoon, pisteTiedosto.toPath());
	    
		polygoniTiedosto = new File(tilapaisHakemisto, "testi_pentagrammi.txt");
		var pentagrammi = TestiTyokalu.muodostaPentagrammi();
		var pentagramminPisteetTekstina = TestiTyokalu.muunnaPisteetTekstiksi(pentagrammi);
		TiedostoKasittelija.kirjoitaTiedostoon(pentagramminPisteetTekstina, polygoniTiedosto.toPath());
		
		testiPolygoniTiedosto = polygoniTiedosto.toPath();
		var kirjoitettuMonikulmio = new Monikulmio(TiedostoKasittelija.lueTiedosto(testiPolygoniTiedosto));
		testiPisteTiedosto = pisteTiedosto.toPath();
		var kirjoitetutPisteKoordinaatit = Tools.muunnaPisteListaksi(TiedostoKasittelija.lueTiedosto(testiPisteTiedosto));
		
		var testiSelvitys = Tools.tutkiPisteet(kirjoitetutPisteKoordinaatit, kirjoitettuMonikulmio);
		selvitysTiedosto = new File(tilapaisHakemisto, "testi_selvitys.txt");
		TiedostoKasittelija.kirjoitaTiedostoon(testiSelvitys, selvitysTiedosto.toPath());
		
		var kirjoitettuTulos = TiedostoKasittelija.lueTiedosto(selvitysTiedosto.toPath());
		
		assertAll(
				() -> assertEquals(kirjoitettuTulos.size(), 3),
				() -> assertTrue(polygoniTiedosto.exists(), "Polygonitiedosto on olemassa"),
				() -> assertTrue(pisteTiedosto.exists(), "Pistetiedosto on olemassa"),
				() -> assertTrue(selvitysTiedosto.exists(), "Selvitystiedosto on olemassa"),
				() -> assertEquals("Piste [100, 5] on monikulmion reunaviivan paalla.", kirjoitettuTulos.get(0)),
				() -> assertEquals("Piste [135, 15] on monikulmion ulkopuolella.", kirjoitettuTulos.get(1)),
				() -> assertEquals("Piste [100, 60] on monikulmion sisapuolella.", kirjoitettuTulos.get(2))
				);
	}
}
