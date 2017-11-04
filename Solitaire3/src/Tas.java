

import java.util.ArrayList;

public class Tas extends ArrayList<String> {
	
	private int tailleMax;
	private String nomTas;
	
	public Tas(int t, String nom) {
		tailleMax = t;
		nomTas = nom;
	}
	
	public int getT() {
		return tailleMax;
	}
	
	public String getNom() {
		return nomTas;
	}
}
