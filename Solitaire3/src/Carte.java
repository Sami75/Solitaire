
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
		if(num == 1) {
			String nom = "As de";
			return nom + forme;
		}
		else if(num == 11) {
			String nom = "Valet de";
			return nom + forme;
		}
		
		else if(num == 12) {
			String nom = "Dame de";
			return nom + forme;
		}
		
		else if(num == 13) {
			String nom = "Roi de";
			return nom + forme;
		}
		return num + forme;
	}
	
	
}
