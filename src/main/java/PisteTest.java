
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class PisteTest {
	
	int x = 3;
	int y = 4;
	
	@Test
	public void testHaeKoordinaatitX() {
		final Piste piste = new Piste(x,y);
		assertEquals(x, piste.haeKoordinaatit()[0]);
		assertEquals(y, piste.haeKoordinaatit()[1]);
	}
	
	@Test
	public void testPisteenTulostaminen() {
		final Piste piste = new Piste(x,y);
		String odotettuTuloste = "[3, 4]";
		String tuloste = piste.toString();
		assertEquals(odotettuTuloste, tuloste);
	}

}
