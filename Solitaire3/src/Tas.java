

import java.util.ArrayList;

public class Tas extends ArrayList<String> {
	
	private int tailleMax;
	private String nomTas;
	private int cmp;
	
	public Tas(int t, String nom, int compt) {
		tailleMax = t;
		nomTas = nom;
		cmp = compt;
	}
	
	public int getT() {
		return tailleMax;
	}
	
	public String getNom() {
		return nomTas;
	}
	
	public void setPioche() {
		cmp = 0;
	}
	
	public void incrementTas() {
		if(cmp == this.size()-1)
			cmp = 0;
		else
			cmp++;
	}
	
	public int getCmp() {
		return cmp;
	}
}
