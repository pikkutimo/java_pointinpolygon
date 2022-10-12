
/**
 * @author pikku
 *
 */
public class Piste {
	private int xKoordinaatti;
	private int yKoordinaatti;
	
	/**
	 * @param x
	 * @param y
	 */
	public Piste(int x, int y) {
		this.xKoordinaatti = x;
		this.yKoordinaatti = y;
	}
	
	/**
	 * @return
	 */
	public int getyKoordinaatti() {
		return yKoordinaatti;
	}

	/**
	 * @param yKoordinaatti
	 */
	public void setyKoordinaatti(int yKoordinaatti) {
		this.yKoordinaatti = yKoordinaatti;
	}

	/**
	 * @return
	 */
	public int getxKoordinaatti() {
		return xKoordinaatti;
	}

	/**
	 * @param xKoordinaatti
	 */
	public void setxKoordinaatti(int xKoordinaatti) {
		this.xKoordinaatti = xKoordinaatti;
	}

	/**
	 * @return
	 */
	public int[] haeKoordinaatit() {
		int[] koordinaatit =  {this.xKoordinaatti, this.yKoordinaatti};
		return koordinaatit;
	}
	
	
	@Override
	public String toString( ) {
		return "[" + String.valueOf(this.xKoordinaatti) + ", " + String.valueOf(this.yKoordinaatti) + "]";
	}
}
