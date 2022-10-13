
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;

public class TestTools {

	
	private static final ExpectedException ExpectedException = null;
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	private Monikulmio epakuranttiMonikulmio;
	public ExpectedException exception = ExpectedException;
	
	/**
	 * Ennen jokaista testiä
	 */
	@Before
	public void setup() { 
		System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	/**
	 * Jokaisen testin jälkeen
	 */
	@After
	public void tearDown() {
		System.setOut(standardOut);
	}
	
	/**
	 * 
	 */
	@Test
	public void testMuunnaPisteeksiMuuntaaKurantinStringinPisteeksi() {
		String pisteTekstina = "1,2";
		Piste testiPiste = Tools.muunnaPisteeksi(pisteTekstina);

		assertAll(
				() -> assertEquals(1, testiPiste.getxKoordinaatti()),
				() -> assertEquals(2, testiPiste.getyKoordinaatti())
				);
	}
	
	/**
	 * Jos muunnaPisteeksi-metodi törmää epäkuranttiin Stringiin, heitetään IllegalArgumentException
	 */
	@Test
	public void testMuunnaPisteeksiTunnistaaEpakurantinStringin() {
		String pisteTekstina = "1,2,3";
		
		IllegalArgumentException heitto = assertThrows(IllegalArgumentException.class, () -> {
			Piste piste = Tools.muunnaPisteeksi(pisteTekstina);
		});
		
		assertEquals("Epakurantti string-argumentti.", heitto.getMessage());
	}
	
	/**
	 * 
	 */
	@Test
	public void testMuunnaPisteeksiOsaaPoistaaTyhjatMerkit() {
		String pisteTekstina = "1 , 2";
		Piste testiPiste = Tools.muunnaPisteeksi(pisteTekstina);

		assertAll(
			() -> assertEquals(1, testiPiste.getxKoordinaatti()),
			() -> assertEquals(2, testiPiste.getyKoordinaatti())
		);
	}
	
	/**
	 * 
	 */
	@Test
	public void testMuunnaPisteeksiTunnistaaVaaranMittaisenStringin() {
		
		IllegalArgumentException heitto = assertThrows(IllegalArgumentException.class, () -> {
			String pisteTekstina = "1,2,3";
        	Piste piste = Tools.muunnaPisteeksi(pisteTekstina);
		});
		
		assertEquals("Epakurantti string-argumentti.", heitto.getMessage());
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testMuunnaPisteeksiTunnistaaTyhjanStringin() {
		
		IllegalArgumentException heitto = assertThrows(IllegalArgumentException.class, () -> {
			String pisteTekstina = null;
        	Piste piste = Tools.muunnaPisteeksi(pisteTekstina);
		});
		
		assertEquals("String argumentti ei voi olla tyhja.", heitto.getMessage());
	}
	
	/**
	 * 
	 */
	@Test
	public void testTutkiPisteetTuottaaOikeanMittaisenListan() {
		Piste piste1 = new Piste(1, 1);
		Piste piste2 = new Piste(10, 10);
		ArrayList<Piste> koordinaatit = new ArrayList<Piste>();
		koordinaatit.add(piste1);
		koordinaatit.add(piste2);
		var tulokset = Tools.tutkiPisteet(koordinaatit, new Monikulmio(TestiTyokalu.haeSuorakulmionPisteet()));
		
		assertEquals(2, tulokset.size());
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testTutkiPisteetRaportoiEpakurantinMonikulmionJaLisaaTuloksiin() {
		epakuranttiMonikulmio = TestiTyokalu.muodostaEpakuranttiMonikulmio();
		ArrayList<Piste> koordinaatit = TestiTyokalu.haePisteenKoordinaatit();
		var tulokset = Tools.tutkiPisteet(koordinaatit, epakuranttiMonikulmio);
		
		assertEquals("Annetut pisteet eivat muodosta aitoa monikulmiota", tulokset.get(0));
	}
	
	/**
	 * 
	 */
	@Test
	public void testTutkiPisteetRaportoiEpakurantinMonikulmionJaTulostaaIlmoituksen() {
		epakuranttiMonikulmio = TestiTyokalu.muodostaEpakuranttiMonikulmio();
		ArrayList<Piste> koordinaatit = TestiTyokalu.haePisteenKoordinaatit();
		var tulokset = Tools.tutkiPisteet(koordinaatit, epakuranttiMonikulmio);
		
		assertEquals("Annetut pisteet eivat muodosta aitoa monikulmiota", outputStreamCaptor.toString()
			      .trim());
	}

}
