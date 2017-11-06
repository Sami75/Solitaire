

import java.util.ArrayList;

public class Tas {
	
	int cmp;
	private ArrayList<Carte> array;
	
	public Tas(int taille) {
		array = new ArrayList<Carte>();
	} 
	
	public void setPioche() {
		cmp = 0;
	}
	
	
	public void incrementTas() {
		if(cmp == this.array.size()-1)
			cmp = 0;
		else
			cmp++;
	}
	
	public int getCmp() {
		return cmp;
	}
}