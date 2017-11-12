import java.util.ArrayList;

public class Tas {
	String nom;
	int taille;
	int cmp;
	private ArrayList<Carte> array;
	
	public Tas(int taillee) {
		taille = taillee;
		array = new ArrayList<Carte>();
	} 
	
	
	public int getTaille() {
		return taille;
	}
	
	public void afficheTas() {
		for (int i = 0 ; i < this.taille; i++) {
			System.out.println("|" + array.get(i) + " | ");
		}
	}
	
	public void setNom(String a) {
		nom = a;
	}
	public String getNom() {
		return nom;
	}
	public Carte getCarte(int i) {
		return array.get(i);
	}
	public void removeCarte(int i) {
		array.remove(i);
		taille -= 1;
	}
	
	public boolean vide() {
		return(array.isEmpty());
	}
	
	public void addCarte(Carte a) {
		array.add(a);
	}
	
	public void incTaille() {
		taille++;
	}
	public void decTaille() {
		taille--;
	}
	public void majVisible() {
		if(taille > 0)
			getCarte(taille-1).setVisible();
	}
}
	

