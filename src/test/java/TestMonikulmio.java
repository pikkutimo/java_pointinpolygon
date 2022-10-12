

import static org.junit.Assert.assertEquals;

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
	public void testSuorakulmioOnMonikulmio() {
		Monikulmio suorakulmio = TestiTyokalu.muodostaSuorakulmio();
		
		assertEquals(true, suorakulmio.onkoMonikulmio());
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
		
		assertEquals("Piste " + piste.toString() + " on monikulmion reunaviivan paalla.", suorakulmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
	
	/**
	 * 
	 */
	@Test
	public void testpisteenSijaintiSuhteessaSuorakulmioonTunnistaaPisteenUlkopuolella() {
		Monikulmio suorakulmio = TestiTyokalu.muodostaSuorakulmio();
		Piste piste = new Piste(85, 150);
		
		assertEquals("Piste " + piste.toString() + " on monikulmion ulkopuolella.", suorakulmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
	
	/**
	 * 
	 */
	@Test
	public void testPisteenSijaintiSuhteessaSuorakulmioonTunnistaaPisteenSisalla() {
		Monikulmio suorakulmio = TestiTyokalu.muodostaSuorakulmio();
		Piste piste = new Piste(6, 6);
		
		assertEquals("Piste " + piste.toString() + " on monikulmion sisapuolella.", suorakulmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}

	/**
	 * 
	 */
	@Test
	public void testpisteenSijaintiSuhteessaKolmioonTunnistaaPisteenReunaviivanPaalla() {
		Monikulmio kolmio = TestiTyokalu.muodostaKolmio();
		Piste piste = new Piste(50, 5);
		
		assertEquals("Piste " + piste.toString() + " on monikulmion reunaviivan paalla.", kolmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
	
	/**
	 * 
	 */
	@Test
	public void testpisteenSijaintiSuhteessaKolmioonTunnistaaPisteenUlkopuolella() {
		Monikulmio kolmio = TestiTyokalu.muodostaKolmio();
		Piste piste = new Piste(1, 1);
		
		assertEquals("Piste " + piste.toString() + " on monikulmion ulkopuolella.", kolmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
	
	/**
	 * 
	 */
	@Test
	public void testPisteenSijaintiSuhteessaKolmioonTunnistaaPisteenSisalla() {
		Monikulmio kolmio = TestiTyokalu.muodostaKolmio();
		Piste piste = new Piste(50, 10);
		
		assertEquals("Piste " + piste.toString() + " on monikulmion sisapuolella.", kolmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testpisteenSijaintiSuhteessaSuunnikkaaseenTunnistaaPisteenReunaviivanPaalla() {
		Monikulmio suunnikas = TestiTyokalu.muodostaSuunnikas();
		Piste piste = new Piste(30, 55);
		
		assertEquals("Piste " + piste.toString() + " on monikulmion reunaviivan paalla.", suunnikas.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
	
	/**
	 * 
	 */
	@Test
	public void testpisteenSijaintiSuhteessaSuunnikkaaseenTunnistaaPisteenUlkopuolella() {
		Monikulmio suunnikas = TestiTyokalu.muodostaSuunnikas();
		Piste piste = new Piste(4, 4);
		
		assertEquals("Piste " + piste.toString() + " on monikulmion ulkopuolella.", suunnikas.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
	
	/**
	 * 
	 */
	@Test
	public void testPisteenSijaintiSuhteessaSuunnikkaaseenTunnistaaPisteenSisalla() {
		Monikulmio suunnikas = TestiTyokalu.muodostaSuunnikas();
		Piste piste = new Piste(30, 30);
		
		assertEquals("Piste " + piste.toString() + " on monikulmion sisapuolella.", suunnikas.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
	
	/**
	 *  Konkaavissa eli koverassa monikulmiossa jokin sis‰kulma on yli 180 astetta
	 */
	@Test
	public void testpisteenSijaintiSuhteessaKonkaaviinKuusiokulmioonTunnistaaPisteenReunaviivanPaalla() {
		Monikulmio konkaaviKuusikulmio = TestiTyokalu.muodostaKonkaaviKuusikulmio();
		Piste piste = new Piste(55, 55);
		
		assertEquals("Piste " + piste.toString() + " on monikulmion reunaviivan paalla.", konkaaviKuusikulmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}

	/**
	 * 
	 */
	@Test
	public void testpisteenSijaintiSuhteessaKonkaaviinKuusiokulmioonTunnistaaPisteenUlkopuolella() {
		Monikulmio konkaaviKuusikulmio = TestiTyokalu.muodostaKonkaaviKuusikulmio();
		Piste piste = new Piste(35, 5);
		
		assertEquals("Piste " + piste.toString() + " on monikulmion ulkopuolella.", konkaaviKuusikulmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}

	/**
	 * 
	 */
	@Test
	public void testPisteenSijaintiSuhteessaKonkaaviinKuusiokulmioonTunnistaaPisteenSisalla() {
		Monikulmio konkaaviKuusikulmio = TestiTyokalu.muodostaKonkaaviKuusikulmio();
		Piste piste = new Piste(57, 57);
		
		assertEquals("Piste " + piste.toString() + " on monikulmion sisapuolella.", konkaaviKuusikulmio.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
	
	/**
	 * Pentagrammi eli itsens‰ leikkaava viisikulmio
	 */
	@Test
	public void testpisteenSijaintiSuhteessaPentagrammiinTunnistaaPisteenReunaviivanPaalla() {
		Monikulmio pentagrammi = TestiTyokalu.muodostaPentagrammi();
		Piste piste = new Piste(100, 5);
		
		assertEquals("Piste " + piste.toString() + " on monikulmion reunaviivan paalla.", pentagrammi.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}

	/**
	 * 
	 */
	@Test
	public void testpisteenSijaintiSuhteessaPentagrammiinTunnistaaPisteenUlkopuolella() {
		Monikulmio pentagrammi = TestiTyokalu.muodostaPentagrammi();
		Piste piste = new Piste(135, 15);
		
		assertEquals("Piste " + piste.toString() + " on monikulmion ulkopuolella.", pentagrammi.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}

	/**
	 * 
	 */
	@Test
	public void testPisteenSijaintiSuhteessaPentagrammiinTunnistaaPisteenSisalla() {
		Monikulmio pentagrammi = TestiTyokalu.muodostaPentagrammi();
		Piste piste = new Piste(100, 60);
		
		assertEquals("Piste " + piste.toString() + " on monikulmion sisapuolella.", pentagrammi.pisteenSijaintiSuhteessaMonikulmioon(piste));
	}
}
