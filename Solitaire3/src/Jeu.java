

import java.lang.Math; 
import java.util.ArrayList;
import java.util.Scanner;


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
		
		c1 = new Tas(1,"C1",0);
		c2 = new Tas(2,"C2",0);
		c3 = new Tas(3,"C3",0);
		c4 = new Tas(4,"C4",0);
		c5 = new Tas(5,"C5",0);
		c6 = new Tas(6,"C6",0);
		c7 = new Tas(7,"C7",0);
		c8 = new Tas(8,"Pioche",0);
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
			for(int i = 1 ; i<= 9 ; i++) {
				String a = i + " " + pique + "      ";
				c8.add(a);
			}
		int i = 10;
		String a = i + " " + pique + "     ";
		c8.add(a);
		String valet = "valet pique  ";
		String dame = "dame pique   ";
		String roi = "roi pique    ";
		c8.add(valet);
		c8.add(dame);
		c8.add(roi);

	}
	
	public void distribCarreau(){
			
		String carreau = "carreau";
			for(int i = 1 ; i<= 9 ; i++) {
				String a = i + " " + carreau + "    ";
				c8.add(a);
			}
		int i = 10;
		String a = i + " " + carreau + "   ";
		c8.add(a);
		String valet = "valet carreau";
		String dame = "dame carreau ";
		String roi = "roi carreau  ";
		c8.add(valet);
		c8.add(dame);
		c8.add(roi);
	
		}
	public void distribTrefle(){
		
		String trefle = "trefle";
			for(int i = 1 ; i<= 9 ; i++) {
				String a = i + " " + trefle + "     ";
				c8.add(a);
			}
		int i = 10;
		String a = i + " " + trefle + "    ";
		c8.add(a);
		String valet = "valet trefle ";
		String dame = "dame trefle  ";
		String roi = "roi trefle   ";
		c8.add(valet);
		c8.add(dame);
		c8.add(roi);
	
	}
	public void distribCoeur(){
		
		String coeur = "coeur";
			for(int i = 1 ; i<= 9 ; i++) {
				String a = i + " " + coeur + "      ";
				c8.add(a);
			}
		int i = 10;
		String a = i + " " + coeur + "     ";
		c8.add(a);
		String valet = "valet coeur  ";
		String dame = "dame coeur   ";
		String roi = "roi coeur    ";
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
	      System.out.print( a.get(i) + " ");
	    }
		System.out.println(" ");
	}
	
	public void afficheVraiTas(Tas a) {
		int i = 0;
		System.out.print(a.get(i) + " - - ");
	}
	
	public void afficheJeu() {
		//afficheTas(c1); 
//		afficheTas(c2);
//		afficheTas(c3);
//		afficheTas(c4);
//		afficheTas(c5);
//		afficheTas(c6);
//		afficheTas(c7);
		//afficheTas(c8);
		Tas[] tab = new Tas[7];
		tab[0] = c1;
		tab[1] = c2;
		tab[2] = c3;
		tab[3] = c4;
		tab[4] = c5;
		tab[5] = c6;
		tab[6] = c7;
		for(int i=0;i<7;i++) {
			for(int j=0;j<tab.length;j++) {
				if(tab[j].size()<i+1) {
					System.out.print("|               |");
				}
//				else if(i < tab.length){
//					System.out.print("|Carte inconnue |");
//				}
				else{
					if(i == tab[j].size()-1)
					{
					System.out.print("|"+tab[j].get(i)+"  |");
					}
					else{
						System.out.print("|Carte inconnue |");
					}
				}
				
			}
			System.out.println();
		}
		
	}

	public void afficheVraiJeu() {
		afficheVraiTas(c1);
		afficheVraiTas(c2);
		afficheVraiTas(c3);
		afficheVraiTas(c4);
		afficheVraiTas(c5);
		afficheVraiTas(c6);
		afficheVraiTas(c7);
	}
	public void afficheVraiPioche() {
		System.out.println("Pioche : " + c8.get(0));
	}
	
	public void affichePioche() {
		for(int i = 0; i < c8.size(); i++)
	    {
	      System.out.print( c8.get(i) + " ");
	    }
	}
	public void pioche() {
		
		System.out.println("Pioche : " + c8.get(c8.getCmp()));
		c8.incrementTas();
	}
	
	public void deplacePile() {
		System.out.println("Déplacer vers pile");
	}
	
	public void deplaceColonne() {
		
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		
	}
	
	
	
	
	public static void main(String[] args){
		MenuSolitaire b = new MenuSolitaire();
		Jeu a = new Jeu();
		a.afficheJeu();
		System.out.println();
		//a.affichePioche();
		//System.out.println();
		//a.pioche();
		
		
		while(true) {
			
			b.afficheMenu();
			a.afficheJeu();
		
		}
		
	}
}