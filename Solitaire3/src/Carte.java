
public class Carte {

	private int num;
	private String forme;
	
	public Carte(int numb, String formee) {
		num = numb;
		forme = formee;
	}
	
	public String getCarte() {
		return num + forme;
	}
	
	public String toString() {
		if(num == 11) {
			String nom = "Valet";
			return nom + forme;
		}
		return num + forme;
	}
	
	
}
