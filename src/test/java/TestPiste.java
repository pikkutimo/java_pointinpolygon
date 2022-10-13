
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class TestPiste {
	
	private Piste piste;
	private int x;
	private int y;

	/**
	 * 
	 */
	@Before
	public void init() {
		x = 3;
		y = 4;
		piste = new Piste(x, y);
	}
	
	/**
	 * 
	 */
	@Test
	public void testHaeKoordinaatitX() {
		assertEquals(3, piste.haeKoordinaatit()[0]);
	}
	
	/**
	 * 
	 */
	@Test
	public void testHaeKoordinaatitY() {
		assertEquals(4, piste.haeKoordinaatit()[1]);
	}
	
	/**
	 * 
	 */
	@Test
	public void testSetxKoordinaatti() {
		int uusiXKoordinaatti = 10;
		piste.setxKoordinaatti(uusiXKoordinaatti);

		assertEquals(10, piste.haeKoordinaatit()[0]);
	}
	
	/**
	 * 
	 */
	@Test
	public void testSetyKoordinaatti() {
		int uusiYKoordinaatti = 10;
		piste.setyKoordinaatti(uusiYKoordinaatti);

		assertEquals(10, piste.haeKoordinaatit()[1]);
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetxKoordinaatti() {
		assertEquals(3, piste.getxKoordinaatti());
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetyKoordinaatti() {
		assertEquals(4, piste.getyKoordinaatti());
	}
	
	/**
	 * 
	 */
	@Test
	public void testPisteenTulostaminen() {
		String odotettuTuloste = "[3, 4]";

		assertEquals(odotettuTuloste, piste.toString());
	}

}
