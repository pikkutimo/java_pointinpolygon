import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class TestMonikulmioTiedostosta {

	@TempDir Path tilapaisHakemisto;
	
	/**
	 * @throws IOException 
	 * 
	 */
	@BeforeEach
	public void setUp() throws IOException {
		ArrayList<Piste> vertailuPisteet = new ArrayList<Piste>();
		vertailuPisteet.add(new Piste(10, 5));
		vertailuPisteet.add(new Piste(85, 5));
		vertailuPisteet.add(new Piste(6, 6));
		
		Monikulmio pisteet = new Monikulmio();
		var pisteetTekstina = TestiTyokalu.muunnaPisteetTekstiksi(pisteet);
		Path pisteTiedosto = tilapaisHakemisto.resolve("testi_pisteet.txt");
		
		
		TiedostoKasittelija.kirjoitaPisteitaTiedostoon(pisteetTekstina, pisteTiedosto);
	}
	
	@Test
	public void testVertailuPisteetLuettavissaTiedostosta() {
		Path pisteTiedosto = tilapaisHakemisto.resolve("testi_pisteet.txt");
		
		assertTrue(Files.exists(pisteTiedosto), "Tiedoston tulisi olla olemassa.");
	}
	
//	/**
//	 * @throws IOException
//	 */
//	@Test
//	public void testRakentajaMuodostaaSuorakulmionJaPisteenTiedostostaJaSuorittaaVertailun() throws IOException {
//		Monikulmio suorakulmioTiedostosta = TestiTyokalu.muodostaSuorakulmio();
//		var suorakulmionKoordinaatit = TestiTyokalu.muunnaPisteetTekstiksi(suorakulmioTiedostosta);
//		Path polygoniTiedosto = tilapaisHakemisto.resolve("polygoni.txt");
//		TiedostoKasittelija.kirjoitaPisteitaTiedostoon(suorakulmionKoordinaatit, polygoniTiedosto);
//		
//		
//		
//		
//	}
}
