

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MonikulmioTest {

	private Monikulmio suorakulmio;
	private Monikulmio kolmio;
	
	@Before
	public void init() {
		ArrayList<Piste> pisteet = new ArrayList<Piste>();
		pisteet.add(new Piste(5, 5));
		pisteet.add(new Piste(55, 5));
		pisteet.add(new Piste(55, 105));
		pisteet.add(new Piste(5, 105));
		suorakulmio = new Monikulmio(pisteet);
	}
	
	@Test
	public void testRakentajaLuoTyhjanMonikulmion() {
		Monikulmio monikulmio = new Monikulmio();
		
		assertEquals("Monikulmiossa ei ole pisteita.", monikulmio.toString());
	}
	
	@Test
	public void testRakentajaLuoMonikulmionListasta() {
		
		String odotettuTuloste = "[5, 5] [55, 5] [55, 105] [5, 105]";
		
		assertEquals(odotettuTuloste, suorakulmio.toString());
	}
	
	@Test
	public void testMonikulmioonVoiLisataPisteita() {
		Piste piste = new Piste(10,10);
		Monikulmio monikulmio = new Monikulmio();
		monikulmio.lisaaPiste(piste);
		
		assertEquals("[10, 10]", monikulmio.toString());
	}

	@Test
	public void testPisteRajaavanLaatikonUlkopuolella() {
		int[] rajat = suorakulmio.haeRajaavanLaatikonRajat();
		
		assertEquals(55, rajat[0]);
		assertEquals(5, rajat[1]);
		assertEquals(105, rajat[2]);
		assertEquals(5, rajat[3]);
	}
	
	@Test
	public void onkoAitoMonikulmio() {
		
		Monikulmio testi = new Monikulmio();

		assertEquals(false, testi.onkoMonikulmio());
		assertEquals(true, suorakulmio.onkoMonikulmio());
		
		var suorakulmionPisteet = suorakulmio.getPisteet();
		assertEquals(4, suorakulmionPisteet.size());
		//assertEquals(true, suorakulmio.onkoMonikulmio());
	}
	
	@Test
	public void onkoPisteMonikulmionPaalla() {
		fail("Ei toteutusta");
	}
	
	@Test
	public void testOnkoPisteMonikulmionUlkopuolella() {
		Piste piste1 = new Piste(10,10);
		Piste piste2 = new Piste(1,1);
		
		assertEquals("Sisapuolella", suorakulmio.pisteenSijaintiSuhteessaMonikulmioon(piste1));
		assertEquals("Ulkopuolella", suorakulmio.pisteenSijaintiSuhteessaMonikulmioon(piste2));
		assertNotEquals(suorakulmio.pisteenSijaintiSuhteessaMonikulmioon(piste1), suorakulmio.pisteenSijaintiSuhteessaMonikulmioon(piste2));
	}
}