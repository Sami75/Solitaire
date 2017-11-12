import java.util.ArrayList;

public class Pile {
	private String type;
	int taille;
	int cmp;
	private ArrayList<Carte> array;
	
	public Pile(int taillee) {
		taille = taillee;
		array = new ArrayList<Carte>();
	} 
	
	public String getType() {
		return type;
	}
	
	public void removeCarte(int i) {
		array.remove(i);
		taille -= 1;
	}
	
	public void setType(String a) {
		type = a;
	}
	
	public boolean vide() {
		return(array.isEmpty());
	}
	
	public int getTaille() {
		return taille;
	}
	
	public Carte getCarte(int i) {
		return array.get(i);
	}
	
	public void addCarte(Carte a) {
		array.add(a);
	}
	
	public void incTaille() {
		taille++;
	}
}
