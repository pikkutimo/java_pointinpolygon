
public class Piste {
	private int xKoordinaatti;
	private int yKoordinaatti;
	
	public Piste(int x, int y) {
		this.xKoordinaatti = x;
		this.yKoordinaatti = y;
	}
	
	public int getyKoordinaatti() {
		return yKoordinaatti;
	}

	public void setyKoordinaatti(int yKoordinaatti) {
		this.yKoordinaatti = yKoordinaatti;
	}

	public int getxKoordinaatti() {
		return xKoordinaatti;
	}

	public void setxKoordinaatti(int xKoordinaatti) {
		this.xKoordinaatti = xKoordinaatti;
	}

	public int[] haeKoordinaatit() {
		int[] koordinaatit =  {this.xKoordinaatti, this.yKoordinaatti};
		return koordinaatit;
	}
	
	
	@Override
	public String toString( ) {
		return "[" + String.valueOf(this.xKoordinaatti) + ", " + String.valueOf(this.yKoordinaatti) + "]";
	}
}
