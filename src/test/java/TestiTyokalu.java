import java.util.ArrayList;

public class TestiTyokalu {
	

	public static Monikulmio muodostaSuorakulmio() {
		final ArrayList<Piste> pisteet = new ArrayList<Piste>();
		pisteet.add(new Piste(5, 5));
		pisteet.add(new Piste(55, 5));
		pisteet.add(new Piste(55, 105));
		pisteet.add(new Piste(5, 105));
		pisteet.add(new Piste(5, 5));
		Monikulmio suorakulmio = new Monikulmio(pisteet);
		
		return suorakulmio;
	}
	
	public static ArrayList<Piste> haeSuorakulmionPisteet() {
		final ArrayList<Piste> pisteet = new ArrayList<Piste>();
		pisteet.add(new Piste(5, 5));
		pisteet.add(new Piste(55, 5));
		pisteet.add(new Piste(55, 105));
		pisteet.add(new Piste(5, 105));
		pisteet.add(new Piste(5, 5));
		
		return pisteet;
	}
	
	public static ArrayList<Piste> haePisteenKoordinaatit() {
		ArrayList<Piste> koordinaatit = new ArrayList<Piste>();
		Piste piste = new Piste(1,1);
		koordinaatit.add(piste);
		
		return koordinaatit;
	}
	
	public static Monikulmio muodostaEpakuranttiMonikulmio() {
		ArrayList<Piste >pisteet = new ArrayList<Piste>();
		pisteet.add(new Piste(5, 5));
		pisteet.add(new Piste(55, 5));
		pisteet.add(new Piste(15, 5));
		Monikulmio epakuranttiMonikulmio = new Monikulmio(pisteet);
		
		return epakuranttiMonikulmio;
	}
	
	public static Monikulmio muodostaKolmio() {
		ArrayList<Piste >pisteet = new ArrayList<Piste>();
		pisteet.add(new Piste(50, 5));
		pisteet.add(new Piste(25, 50));
		pisteet.add(new Piste(75, 50));
		pisteet.add(new Piste(50, 5));
		Monikulmio kolmio = new Monikulmio(pisteet);
		
		return kolmio;
	}
	
	public static Monikulmio muodostaSuunnikas() {
		ArrayList<Piste >pisteet = new ArrayList<Piste>();
		pisteet.add(new Piste(5, 5));
		pisteet.add(new Piste(10, 55));
		pisteet.add(new Piste(60, 55));
		pisteet.add(new Piste(60, 5));
		pisteet.add(new Piste(5, 5));
		Monikulmio suunnikas = new Monikulmio(pisteet);
		
		return suunnikas;
	}
	
	public static Monikulmio muodostaKonkaaviKuusikulmio() {
		ArrayList<Piste >pisteet = new ArrayList<Piste>();
		pisteet.add(new Piste(5, 5));
		pisteet.add(new Piste(55, 55));
		pisteet.add(new Piste(65, 105));
		pisteet.add(new Piste(75, 55));
		pisteet.add(new Piste(125, 5));
		pisteet.add(new Piste(65, 45));
		pisteet.add(new Piste(5, 5));
		Monikulmio konkaaviKuusikulmio = new Monikulmio(pisteet);
		
		return konkaaviKuusikulmio;
	}
	
	public static Monikulmio muodostaPentagrammi() {
		ArrayList<Piste>pisteet = new ArrayList<Piste>();
		pisteet.add(new Piste(100, 5));
		pisteet.add(new Piste(55, 155));
		pisteet.add(new Piste(155, 55));
		pisteet.add(new Piste(50, 55));
		pisteet.add(new Piste(125, 155));
		pisteet.add(new Piste(65, 45));
		pisteet.add(new Piste(100, 5));
		Monikulmio pentagrammi = new Monikulmio(pisteet);
		
		return pentagrammi;
	}
	
	public static ArrayList<String> muunnaPisteetTekstiksi(Monikulmio monikulmio) {
		ArrayList<String> tulos = new ArrayList<String>();
		
		for (var piste: monikulmio.getPisteet()) {
			tulos.add(piste.getxKoordinaatti() + "," + piste.getyKoordinaatti());
		}
		
		return tulos;
	}
}
