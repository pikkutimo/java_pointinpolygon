
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class ToolsTest {

	
	@Rule
	public TemporaryFolder tilapaisHakemisto = new TemporaryFolder();

	private String luettavaTiedosto = "src/test/resources/testi.txt";
	private ArrayList<Piste> pisteet;
	
	@Before
	public void init() { 
		pisteet = Tools.lueTiedosto(luettavaTiedosto);
	}
	
	@Test
	public void testLueTiedostoPystyyLukemaanEnsimmaisenRivin() {
		
		assertEquals(1, pisteet.get(0).getxKoordinaatti());
		assertEquals(2, pisteet.get(0).getyKoordinaatti());
		assertEquals(3, pisteet.get(1).getxKoordinaatti());
		assertEquals(4, pisteet.get(1).getyKoordinaatti());
	}
	
	@Test
	public void testTutkiPisteet() {
		Piste piste1 = new Piste(1, 1);
		Piste piste2 = new Piste(10, 10);
		ArrayList<Piste> koordinaatit = new ArrayList<Piste>();
		koordinaatit.add(piste1);
		koordinaatit.add(piste2);
		var tulokset = Tools.tutkiPisteet(koordinaatit, new Monikulmio(pisteet));
		
		assertEquals(2, tulokset.size());
		
	}
	
	@Test
	public void testKirjoitaSelvitys() throws IOException {
		File testiHakemisto = tilapaisHakemisto.newFolder("Testihakemisto");
        File testiKirjoitettavaTiedosto = tilapaisHakemisto.newFile("testi.txt");
		ArrayList<String> tulokset = new ArrayList<String>();
		Tools.kirjoitaSelvitys(pisteet, tulokset, testiKirjoitettavaTiedosto);
		
		assertTrue(testiHakemisto.exists());
		assertTrue(testiKirjoitettavaTiedosto.exists());
		
	}
}
