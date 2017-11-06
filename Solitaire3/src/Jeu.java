import java.lang.Math; 
import java.util.ArrayList;
import java.util.Scanner;


public class Jeu {
	
	private ArrayList<Tas> t1;

	private ArrayList<Carte> a;
	
	public Jeu() {
		
		t1 = new ArrayList<Tas>();
		a = new ArrayList<Carte>();
		
		/*alea(c1);
		alea(c2);
		alea(c3);
		alea(c4);
		alea(c5);
		alea(c6);
		alea(c7);*/
		
		
	}
	
	public void ajoutCarte() {
	
		for(int j = 1 ; j <= 12 ; j++) {
			a.add(new Carte(j,"Pique"));
			a.add(new Carte(j,"Coeur"));
			a.add(new Carte(j,"Trefle"));
			a.add(new Carte(j,"Carreau"));
		}
		for(int i = 0 ; i <= a.size(); i++) {
			System.out.println(a.get(i));
		}
		
	}
	
	/*public void alea(Tas a) {
		
		String m;
		
		for(int i = 0 ; i < a.t ; i++) {
			int al = (int)(Math.random()*(c8.array.size()));
			m = c8.array.get(al);
			a.array.add(m);
			c8.remove(al);
		}
	
	}*/
	/*public void afficheTas(Tas a) {
		
		for(int i = 0; i < a.size(); i++)
	    {
	      System.out.print( a.get(i) + " ");
	    }
		System.out.println(" ");
	}*/
	
	/*public void afficheVraiTas(Tas a) {
		int i = 0;
		System.out.print(a.get(i) + " - - ");
	}*/
	
	/*public void afficheJeu() {
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
	*/

	/*public void afficheVraiJeu() {
		afficheVraiTas(c1);
		afficheVraiTas(c2);
		afficheVraiTas(c3);
		afficheVraiTas(c4);
		afficheVraiTas(c5);
		afficheVraiTas(c6);
		afficheVraiTas(c7);
	}*/
		
	/*public void afficheVraiPioche() {
		System.out.println("Pioche : " + c8.get(0));
	}*/
	
	/*public void affichePioche() {
		for(int i = 0; i < c8.size(); i++)
	    {
	      System.out.print( c8.get(i) + " ");
	    }
	}*/
	/*public void pioche() {
		
		System.out.println("Pioche : " + c8.get(c8.getCmp()));
		c8.incrementTas();
	}
	
	public void deplacePile() {
		System.out.println("Déplacer vers pile");
	}
	
	public void deplaceColonne() {
		
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		
	}*/
	
	
	
	
	public static void main(String[] args){
		MenuSolitaire b = new MenuSolitaire();
		Jeu a = new Jeu();
		//a.afficheJeu();
		a.ajoutCarte();
		System.out.println();
		//a.affichePioche();
		//System.out.println();
		//a.pioche();
		
		
		while(true) {
			
			//b.afficheMenu();
			//a.afficheJeu();
		
		}
		
	}
}