import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestiTyokalu {
	

	/**
	 * @return
	 */
	public static Monikulmio muodostaSuorakulmio() {
		ArrayList<String> pisteet = new ArrayList<String>();
		pisteet.add("5,5");
		pisteet.add("55,5");
		pisteet.add("55,105");
		pisteet.add("5,105");
		pisteet.add("5,5");
		Monikulmio suorakulmio = new Monikulmio(pisteet);
		
		return suorakulmio;
	}
	
	/**
	 * @return
	 */
	public static ArrayList<String> haeSuorakulmionPisteet() {
		ArrayList<String> pisteet = new ArrayList<String>();
		pisteet.add("5,5");
		pisteet.add("55,5");
		pisteet.add("55,105");
		pisteet.add("5,105");
		pisteet.add("5,5");
		
		return pisteet;
	}
	
	/**
	 * @return
	 */
	public static ArrayList<Piste> haePisteenKoordinaatit() {
		ArrayList<Piste> koordinaatit = new ArrayList<Piste>();
		Piste piste = new Piste(1,1);
		koordinaatit.add(piste);
		
		return koordinaatit;
	}
	
	/**
	 * @return
	 */
	public static Monikulmio muodostaEpakuranttiMonikulmio() {
		ArrayList<String>pisteet = new ArrayList<String>();
		pisteet.add("5,5");
		pisteet.add("55,5");
		pisteet.add("15,5");
		Monikulmio epakuranttiMonikulmio = new Monikulmio(pisteet);
		
		return epakuranttiMonikulmio;
	}
	
	/**
	 * @return
	 */
	public static Monikulmio muodostaKolmio() {
		ArrayList<String>pisteet = new ArrayList<String>();
		pisteet.add("50,5");
		pisteet.add("25,50");
		pisteet.add("75,50");
		pisteet.add("50,5");
		Monikulmio kolmio = new Monikulmio(pisteet);
		
		return kolmio;
	}
	
	/**
	 * @return
	 */
	public static Monikulmio muodostaSuunnikas() {
		ArrayList<String> pisteet = new ArrayList<String>();
		pisteet.add("5,5");
		pisteet.add("10,55");
		pisteet.add("60,55");
		pisteet.add("10,5");
		pisteet.add("5,5");
		Monikulmio suunnikas = new Monikulmio(pisteet);
		
		return suunnikas;
	}
	
	/**
	 * @return
	 */
	public static Monikulmio muodostaKonkaaviKuusikulmio() {
		ArrayList<String> pisteet = new ArrayList<String>();
		pisteet.add("5,5");
		pisteet.add("55,55");
		pisteet.add("65,105");
		pisteet.add("75,55");
		pisteet.add("125,5");
		pisteet.add("65,45");
		pisteet.add("5,5");
		Monikulmio konkaaviKuusikulmio = new Monikulmio(pisteet);
		
		return konkaaviKuusikulmio;
	}
	
	/**
	 * @return
	 */
	public static Monikulmio muodostaPentagrammi() {
		ArrayList<String> pisteet = new ArrayList<String>();
		pisteet.add("100,5");
		pisteet.add("55,155");
		pisteet.add("155,55");
		pisteet.add("50,55");
		pisteet.add("125,155");
		pisteet.add("65,45");
		pisteet.add("100,5");
		Monikulmio pentagrammi = new Monikulmio(pisteet);
		
		return pentagrammi;
	}
	
	/**
	 * @param monikulmio
	 * @return
	 */
	public static ArrayList<String> muunnaPisteetTekstiksi(Monikulmio monikulmio) {
		ArrayList<String> tulos = new ArrayList<String>();
		
		for (var piste: monikulmio.getPisteet()) {
			tulos.add(piste.getxKoordinaatti() + "," + piste.getyKoordinaatti());
		}
		
		return tulos;
	}
}
