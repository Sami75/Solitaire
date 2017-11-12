import java.util.ArrayList;

public class Pioche {
	
	private int cmp;
	private int taille;
	private ArrayList<Carte> array;
	
	public Pioche(int taillee) {
		taille = taillee;
		cmp = -1;
		array = new ArrayList<Carte>();
	} 
	
	public void addCarte(Carte a) {
		array.add(a);
	}
	
	public Carte getCarte(int i) {
		return array.get(i);
	}
	public Carte getCartePioche() {
		return array.get(cmp);
	}
	
	public void removeCarte(int i) {
		array.remove(i);
		taille -= 1;
	}
	
	public int getTaille() {
		return taille;
	}
	
	public void affichePioche() {
		if(vide()) {
			System.out.println("Pioche vide !");
			return;
		}
		if (cmp == -1)
			System.out.println("Pioche : Carte retournée");
		else
			System.out.println("Pioche : " + getCarte(cmp));
	}
	
	public void incPioche() {
		if(cmp == this.getTaille()-1 || cmp == this.getTaille())
			cmp = 0;
		else
			cmp++;
	}
	
	public ArrayList<Carte> getArray(){
		return array;
	}
	
	public boolean vide() {
		return(array.isEmpty());
	}
	
	public int getCmp() {
		return cmp;
	}
	
}