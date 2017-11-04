

import java.lang.Math; 
import java.util.ArrayList;


public class Jeu {
	private Tas c1;
	private Tas c2;
	private Tas c3;
	private Tas c4;
	private Tas c5;
	private Tas c6; 
	private Tas c7; 
	private Tas c8;

	public Jeu() {
		
		c1 = new Tas(1,"C1");
		c2 = new Tas(2,"C2");
		c3 = new Tas(3,"C3");
		c4 = new Tas(4,"C4");
		c5 = new Tas(5,"C5");
		c6 = new Tas(6,"C6");
		c7 = new Tas(7,"C7");
		c8 = new Tas(8,"Pioche");
		distribPique();
		distribCarreau();
		distribTrefle();
		distribCoeur();
		alea(c1);
		alea(c2);
		alea(c3);
		alea(c4);
		alea(c5);
		alea(c6);
		alea(c7);
		
		
	}
	
	public void distribPique(){
		
		String pique = "pique";
			for(int i = 1 ; i<= 10 ; i++) {
				String a = i + " " + pique;
				c8.add(a);
			}
		String valet = "valet pique";
		String dame = "dame pique";
		String roi = "roi pique";
		c8.add(valet);
		c8.add(dame);
		c8.add(roi);

	}
	
	public void distribCarreau(){
			
			String carreau = "carreau";
				for(int i = 1 ; i<= 10 ; i++) {
					String a = i + " " + carreau;
					c8.add(a);
				}
			String valet = "valet carreau";
			String dame = "dame carreau";
			String roi = "roi carreau";
			c8.add(valet);
			c8.add(dame);
			c8.add(roi);
	
		}
	public void distribTrefle(){
		
		String trefle = "trefle";
			for(int i = 1 ; i<= 10 ; i++) {
				String a = i + " " + trefle;
				c8.add(a);
			}
		String valet = "valet trefle";
		String dame = "dame trefle";
		String roi = "roi trefle";
		c8.add(valet);
		c8.add(dame);
		c8.add(roi);
	
	}
	public void distribCoeur(){
		
		String coeur = "coeur";
			for(int i = 1 ; i<= 10 ; i++) {
				String a = i + " " + coeur;
				c8.add(a);
			}
		String valet = "valet coeur";
		String dame = "dame coeur";
		String roi = "roi coeur";
		c8.add(valet);
		c8.add(dame);
		c8.add(roi);
	
	}
	
	public void alea(Tas a) {
		
		String m;
		
		for(int i = 0 ; i < a.getT() ; i++) {
			int al = (int)(Math.random()*(c8.size()));
			m = c8.get(al);
			a.add(m);
			c8.remove(al);
		}
	
	}
	
	public void afficheTas(Tas a) {
		for(int i = 0; i < a.size(); i++)
	    {
	      System.out.println(a.getNom() + " : " + a.get(i));
	    }
	}
	
	public void afficheJeu() {
		afficheTas(c1); 
		afficheTas(c2);
		afficheTas(c3);
		afficheTas(c4);
		afficheTas(c5);
		afficheTas(c6);
		afficheTas(c7);
		afficheTas(c8);
	}

	public static void main(String[] args){
		Jeu a = new Jeu();
		a.afficheJeu();
	}
	
	
}