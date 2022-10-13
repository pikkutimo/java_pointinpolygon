import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class TestTiedostoKasittelija {

    File polygoniTiedosto, pisteTiedosto;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @TempDir Path tilapaisHakemisto;
	    
    /**
     * @throws IOException
     */
    @BeforeEach
    void beforeEach() {
        assertTrue(Files.isDirectory(this.tilapaisHakemisto));
    }

    /**
     * @throws IOException
     */
    @Test
    public void testLuePolygoniTiedosto() throws IOException {
    	Path polygoniTiedosto = tilapaisHakemisto.resolve("testi_polygoni.txt");
    	List<String> polygoniRivit = Arrays.asList("50,5", "25,50", "75,50", "50,5");
    	Files.write(polygoniTiedosto, polygoniRivit);
    	var luettuTiedosto = TiedostoKasittelija.lueTiedosto(polygoniTiedosto);
    	
    	assertAll(
    			() -> assertEquals("50,5", luettuTiedosto.get(0).toString()),
    			() -> assertEquals("25,50", luettuTiedosto.get(1).toString()),
    			() -> assertEquals("75,50", luettuTiedosto.get(2).toString()),
    			() -> assertEquals("50,5", luettuTiedosto.get(3).toString()));
    }
    
    /**
     * @throws IOException
     */
    @Test
    public void testLuePisteTiedosto() throws IOException {
    	Path pisteTiedosto = tilapaisHakemisto.resolve("testi_pisteet.txt");
    	List<String> pisteRivit = Arrays.asList("50,5", "1,1", "50,10");
    	Files.write(pisteTiedosto, pisteRivit);
    	
    	var luettuTiedosto = TiedostoKasittelija.lueTiedosto(pisteTiedosto);
    	
    	assertAll(
    			() -> assertEquals("50,5", luettuTiedosto.get(0).toString()),
    			() -> assertEquals("1,1", luettuTiedosto.get(1).toString()),
    			() -> assertEquals("50,10", luettuTiedosto.get(2).toString()));
    }
    
    /**
     * 
     */
    @Test
    public void testTiedostonPuuttuminenLopettaaOhjelman() {
    	Path puuttuvaTiedosto = tilapaisHakemisto.resolve("pis.txt");
    	
    	assertThrows(IOException.class, () -> {
    		var luettuTiedosto = TiedostoKasittelija.lueTiedosto(puuttuvaTiedosto);
		});
    }
    
    
    /**
     * @throws IOException
     */
    @Test
    public void testKirjoittaSelvityksenValidilleMonikulmiolleJaYhdellePisteelle() throws IOException {
		Monikulmio kolmio = TestiTyokalu.muodostaKolmio();
		ArrayList<Piste> pisteet = new ArrayList<Piste>();
		
		pisteet.add(new Piste(50, 5));
		
		var tulokset = Tools.tutkiPisteet(pisteet, kolmio);
		File selvitysTiedosto = new File("testi_selvitys.txt");
		TiedostoKasittelija.kirjoitaTiedostoon(tulokset, selvitysTiedosto.toPath());
		String rivi = Files.readAllLines(selvitysTiedosto.toPath()).get(0);
		
		assertAll(
    			() -> assertTrue(selvitysTiedosto.exists()),
    			() -> assertEquals("Piste [50, 5] on monikulmion reunaviivan paalla.", rivi));

    }
    
    /**
     * @throws IOException
     */
    @Test
    public void testKirjoittaSelvityksenValidilleMonikulmiolleJaKahdellePisteelle() throws IOException {
		Monikulmio kolmio = TestiTyokalu.muodostaKolmio();
		ArrayList<Piste> pisteet = new ArrayList<Piste>();
		
		pisteet.add(new Piste(50, 5));
		pisteet.add(new Piste(1, 1));
		
		var tulokset = Tools.tutkiPisteet(pisteet, kolmio);
		File selvitysTiedosto = new File("testi_selvitys.txt");
		TiedostoKasittelija.kirjoitaTiedostoon(tulokset, selvitysTiedosto.toPath());
		String rivi = Files.readAllLines(selvitysTiedosto.toPath()).get(0);
		
		assertAll(
    			() -> assertTrue(selvitysTiedosto.exists()),
    			() -> assertEquals("Piste [50, 5] on monikulmion reunaviivan paalla.", rivi));

    }
    
    /**
     * @throws IOException
     */
    @Test
    public void testKirjoittaaSelvityksenEiValidilleMonikulmiolle() throws IOException {
		Monikulmio epakuranttiMonikulmio = TestiTyokalu.muodostaEpakuranttiMonikulmio();
		ArrayList<Piste> pisteet = new ArrayList<Piste>();

		pisteet.add(new Piste(50, 5));
		
		var tulokset = Tools.tutkiPisteet(pisteet, epakuranttiMonikulmio);
		File selvitysTiedosto = new File("testi_selvitys.txt");
		TiedostoKasittelija.kirjoitaTiedostoon(tulokset, selvitysTiedosto.toPath());
		String rivi = Files.readAllLines(selvitysTiedosto.toPath()).get(0);

		assertAll(
    			() -> assertTrue(selvitysTiedosto.exists()),
    			() -> assertEquals("Annetut pisteet eivat muodosta aitoa monikulmiota", rivi));
    }
    
    /**
     * @throws IOException
     */
    @Test
    public void testEiKirjoitaTiedostoonIlmanTuloksia() throws IOException {
    	System.setOut(new PrintStream(outputStreamCaptor));

		ArrayList<String> tulokset = new ArrayList<String>();
		File selvitysTiedosto = new File("testi_selvitys.txt");
		TiedostoKasittelija.kirjoitaTiedostoon(tulokset, selvitysTiedosto.toPath());
	
		assertAll(
    			() -> assertEquals(0, selvitysTiedosto.length()),
    			() -> assertEquals("Tiedosto tyhja, kirjoitus peruttu.", outputStreamCaptor.toString().trim()));
		
		System.setOut(standardOut);
    }
    
}
