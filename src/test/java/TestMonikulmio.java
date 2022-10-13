

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


public class TestMonikulmio {
	
	/**
	 * 
	 */
	@Test
	public void testRakentajaLuoTyhjanMonikulmion() {
		Monikulmio monikulmio = new Monikulmio();
		
		assertEquals("Monikulmiossa ei ole pisteita.", monikulmio.toString());
	}
	
	/**
	 * 
	 */
	@Test
	public void testRakentajaLuoMonikulmionListasta() {
		Monikulmio suorakulmio = TestiTyokalu.muodostaSuorakulmio();
		String odotettuTuloste = "[5, 5] [55, 5] [55, 105] [5, 105] [5, 5]";
		
		assertEquals(odotettuTuloste, suorakulmio.toString());
	}
	
	/**
	 * 
	 */
	@Test
	public void testMonikulmioonVoiLisataPisteita() {
		Monikulmio suorakulmio = TestiTyokalu.muodostaSuorakulmio();
		Piste piste = new Piste(10,10);
		suorakulmio.lisaaPiste(piste);
		
		assertEquals("[5, 5] [55, 5] [55, 105] [5, 105] [5, 5] [10, 10]", suorakulmio.toString());
	}
	
	/**
	 * 
	 */
	@Test
	public void testMonikulmioIlmanPisteitaEiOleMonikulmio() {
		Monikulmio eiMonikulmio = new Monikulmio();
		
		assertEquals(false, eiMonikulmio.onkoMonikulmio());
	}
	
	/**
	 * 
	 */
	@Test
	public void testMonikulmioYhdellaPisteellaEiOleMonikulmio() {
		Monikulmio eiMonikulmio = new Monikulmio();
		Piste piste = new Piste(10,10);
		eiMonikulmio.lisaaPiste(piste);
		
		assertEquals(false, eiMonikulmio.onkoMonikulmio());
	}
	
	/**
	 * 
	 */
	@Test
	public void testMonikulmioKahdellaPisteellaEiOleMonikulmio() {
		Monikulmio eiMonikulmio = new Monikulmio();
		eiMonikulmio.lisaaPiste(new Piste(10, 10));
		eiMonikulmio.lisaaPiste(new Piste(12, 11));
		
		assertEquals(false, eiMonikulmio.onkoMonikulmio());
	}
	
	/**
	 * 
	 */
	@Test
	public void testMonikulmioKolmellaPisteellaEiOleMonikulmio() {
		Monikulmio eiMonikulmio = new Monikulmio();
		eiMonikulmio.lisaaPiste(new Piste(10, 10));
		eiMonikulmio.lisaaPiste(new Piste(12, 11));
		eiMonikulmio.lisaaPiste(new Piste(13, 12));
		
		assertEquals(false, eiMonikulmio.onkoMonikulmio());
	}
	
	/**
	 * 
	 */
	@Test
	public void testSuorakulmioOnMonikulmio() {
		Monikulmio suorakulmio = TestiTyokalu.muodostaSuorakulmio();
		
		assertEquals(true, suorakulmio.onkoMonikulmio());
	}
	
	/**
	 * 
	 */
	@Test
	public void testMonikulmioGetPisteet() {
		Monikulmio eiMonikulmio = new Monikulmio();
		eiMonikulmio.lisaaPiste(new Piste(10, 10));
		eiMonikulmio.lisaaPiste(new Piste(12, 11));
		eiMonikulmio.lisaaPiste(new Piste(13, 12));
		
		ArrayList<Piste> eiMonikulmionPisteet = eiMonikulmio.getPisteet();
		
		assertAll(
				() -> assertEquals(3, eiMonikulmionPisteet.size()),
				() -> assertEquals(10, eiMonikulmionPisteet.get(0).getxKoordinaatti()),
				() -> assertEquals(11, eiMonikulmionPisteet.get(1).getyKoordinaatti()),
				() -> assertEquals(13, eiMonikulmionPisteet.get(2).getxKoordinaatti())
				);
	}
	
	/**
	 * 
	 */
	@Test
	public void testKolmePistett‰EiMuodostaMonikulmiota() {
		Monikulmio epakuranttiMonikulmio = TestiTyokalu.muodostaEpakuranttiMonikulmio();
		
		assertEquals(false, epakuranttiMonikulmio.onkoMonikulmio());
	}
	
	/**
	 * 
	 */
	@Test
	public void testMonikulmiossaEnsimmaiseenJaViimeiseenPisteenOltavaIdenttisia() {
		// Muutin monikulmion m‰‰ritelm‰‰ siten, ett‰ ensimm‰isen ja viimeisen pisteen tulee olla identtisi‰
		Monikulmio epakuranttiMonikulmio = TestiTyokalu.muodostaEpakuranttiMonikulmio();
		
		assertEquals(false, epakuranttiMonikulmio.onkoMonikulmio());
	}
	
	/**
	 * 
	 */
	@Test
	public void testMonikulmiossaEnsimmainenJaViimeinenPistedenttisia() {
		// Muutin monikulmion m‰‰ritelm‰‰ siten, ett‰ ensimm‰isen ja viimeisen pisteen tulee olla identtisi‰
		Monikulmio suorakulmio = TestiTyokalu.muodostaSuorakulmio();
		
		assertEquals(true, suorakulmio.onkoMonikulmio());
	}
	/**
	 * 
	 */
	@Test
	public void testpisteenSijaintiSuhteessaSuorakulmioonTunnistaaPisteenReunaviivanPaalla() {
		Monikulmio suorakulmio = TestiTyokalu.muodostaSuorakulmio();		
		Piste piste = new Piste(10, 5);
		
		assertEquals("Piste [10, 5] on monikulmion reunaviivan paalla.", suorakulmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
	
	/**
	 * 
	 */
	@Test
	public void testpisteenSijaintiSuhteessaSuorakulmioonTunnistaaPisteenUlkopuolella() {
		Monikulmio suorakulmio = TestiTyokalu.muodostaSuorakulmio();
		Piste piste = new Piste(85, 150);
		
		assertEquals("Piste [85, 150] on monikulmion ulkopuolella.", suorakulmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
	
	/**
	 * 
	 */
	@Test
	public void testPisteenSijaintiSuhteessaSuorakulmioonTunnistaaPisteenSisalla() {
		Monikulmio suorakulmio = TestiTyokalu.muodostaSuorakulmio();
		Piste piste = new Piste(6, 6);
		
		assertEquals("Piste [6, 6] on monikulmion sisapuolella.", suorakulmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}

	/**
	 * 
	 */
	@Test
	public void testpisteenSijaintiSuhteessaKolmioonTunnistaaPisteenReunaviivanPaalla() {
		Monikulmio kolmio = TestiTyokalu.muodostaKolmio();
		Piste piste = new Piste(50, 5);
		
		assertEquals("Piste [50, 5] on monikulmion reunaviivan paalla.", kolmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
	
	/**
	 * 
	 */
	@Test
	public void testpisteenSijaintiSuhteessaKolmioonTunnistaaPisteenUlkopuolella() {
		Monikulmio kolmio = TestiTyokalu.muodostaKolmio();
		Piste piste = new Piste(1, 1);
		
		assertEquals("Piste [1, 1] on monikulmion ulkopuolella.", kolmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
	
	/**
	 * 
	 */
	@Test
	public void testPisteenSijaintiSuhteessaKolmioonTunnistaaPisteenSisalla() {
		Monikulmio kolmio = TestiTyokalu.muodostaKolmio();
		Piste piste = new Piste(50, 10);
		
		assertEquals("Piste [50, 10] on monikulmion sisapuolella.", kolmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testpisteenSijaintiSuhteessaSuunnikkaaseenTunnistaaPisteenReunaviivanPaalla() {
		Monikulmio suunnikas = TestiTyokalu.muodostaSuunnikas();
		Piste piste = new Piste(30, 55);
		
		assertEquals("Piste [30, 55] on monikulmion reunaviivan paalla.", suunnikas.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
	
	/**
	 * 
	 */
	@Test
	public void testpisteenSijaintiSuhteessaSuunnikkaaseenTunnistaaPisteenUlkopuolella() {
		Monikulmio suunnikas = TestiTyokalu.muodostaSuunnikas();
		Piste piste = new Piste(4, 4);
		
		assertEquals("Piste [4, 4] on monikulmion ulkopuolella.", suunnikas.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
	
	/**
	 * 
	 */
	@Test
	public void testPisteenSijaintiSuhteessaSuunnikkaaseenTunnistaaPisteenSisalla() {
		Monikulmio suunnikas = TestiTyokalu.muodostaSuunnikas();
		Piste piste = new Piste(30, 30);
		
		assertEquals("Piste [30, 30] on monikulmion sisapuolella.", suunnikas.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
	
	/**
	 *  Konkaavissa eli koverassa monikulmiossa jokin sis‰kulma on yli 180 astetta
	 */
	@Test
	public void testpisteenSijaintiSuhteessaKonkaaviinKuusiokulmioonTunnistaaPisteenReunaviivanPaalla() {
		Monikulmio konkaaviKuusikulmio = TestiTyokalu.muodostaKonkaaviKuusikulmio();
		Piste piste = new Piste(55, 55);
		
		assertEquals("Piste [55, 55] on monikulmion reunaviivan paalla.", konkaaviKuusikulmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}

	/**
	 * 
	 */
	@Test
	public void testpisteenSijaintiSuhteessaKonkaaviinKuusiokulmioonTunnistaaPisteenUlkopuolella() {
		Monikulmio konkaaviKuusikulmio = TestiTyokalu.muodostaKonkaaviKuusikulmio();
		Piste piste = new Piste(35, 5);
		
		assertEquals("Piste [35, 5] on monikulmion ulkopuolella.", konkaaviKuusikulmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}

	/**
	 * 
	 */
	@Test
	public void testPisteenSijaintiSuhteessaKonkaaviinKuusiokulmioonTunnistaaPisteenSisalla() {
		Monikulmio konkaaviKuusikulmio = TestiTyokalu.muodostaKonkaaviKuusikulmio();
		Piste piste = new Piste(56, 55);
		
		assertEquals("Piste [56, 55] on monikulmion sisapuolella.", konkaaviKuusikulmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
	
	/**
	 * Pentagrammi eli itsens‰ leikkaava viisikulmio
	 */
	@Test
	public void testpisteenSijaintiSuhteessaPentagrammiinTunnistaaPisteenReunaviivanPaalla() {
		Monikulmio pentagrammi = TestiTyokalu.muodostaPentagrammi();
		Piste piste = new Piste(100, 5);
		
		assertEquals("Piste [100, 5] on monikulmion reunaviivan paalla.", pentagrammi.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}

	/**
	 * 
	 */
	@Test
	public void testpisteenSijaintiSuhteessaPentagrammiinTunnistaaPisteenUlkopuolella() {
		Monikulmio pentagrammi = TestiTyokalu.muodostaPentagrammi();
		Piste piste = new Piste(135, 15);
		
		assertEquals("Piste [135, 15] on monikulmion ulkopuolella.", pentagrammi.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}

	/**
	 * 
	 */
	@Test
	public void testPisteenSijaintiSuhteessaPentagrammiinTunnistaaPisteenSisalla() {
		Monikulmio pentagrammi = TestiTyokalu.muodostaPentagrammi();
		Piste piste = new Piste(100, 60);
		
		assertEquals("Piste [100, 60] on monikulmion sisapuolella.", pentagrammi.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
}
