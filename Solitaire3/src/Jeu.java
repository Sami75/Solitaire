import java.lang.Math; 
import java.util.ArrayList;
import java.util.Scanner;


public class Jeu {
	
	private Tas[] tableau;
	private Pioche pioche;
	
	public Jeu() {
		
		Tas a;
		tableau = new Tas[7];
		for (int i = 1 ; i < tableau.length+1 ; i++) {
			String g = "Tas";
			a = new Tas(i);
			a.setNom( g + i );
			tableau[i-1] = a;
			//System.out.println(a.getNom() + " est de taille " + a.getTaille());
		}
		pioche = new Pioche(52);
	}
	
	public void affTas(Tas a){
		a.afficheTas();
	}
	
	public Tas[] getTableau() {
		return tableau;
	}
	
	public Tas getTas(int i) {
		return tableau[i];
	}
	
	
	public void initPioche() {
	
		for(int j = 1 ; j < 14 ; j++) {
			pioche.addCarte(new Carte(j," Pique "));
			pioche.addCarte(new Carte(j," Coeur "));
			pioche.addCarte(new Carte(j," Trefle"));
			pioche.addCarte(new Carte(j,"Carreau"));
			//Retenir les différents espaces !
		}	
	}
	
	public void alea() {
		
		Carte m;
		for(int i = 0 ; i < tableau.length ; i++) {
			for (int j = 0 ; j < tableau[i].getTaille(); j++) {
				int al = (int)(Math.random()*(pioche.getTaille()));
				m = pioche.getCarte(al);
				tableau[i].addCarte(m);
				pioche.removeCarte(al);
				if(j == tableau[i].getTaille()-1)
					m.setVisible();
			}
		}
		for(Carte c : pioche.getArray()) {
			c.setVisible();
		}
	
	}

	public void affichePioche() {
		pioche.affichePioche();
	}
	
	public void piocher() {
		pioche.incPioche();
		
	}
	
	public void afficheJeu() {
		for(int t=1; t<8 ;t++) {
			System.out.print("|     Colonne " + t + "    |");
		}
		System.out.println();
		int maxTaille = tableau[0].getTaille();
		for(int l = 0 ; l < tableau.length ; l++) {
			maxTaille = Math.max(maxTaille,tableau[l].getTaille());
		}
		for(int i=0;i<maxTaille;i++) {
			for(int j=0;j<tableau.length;j++) {
				if(tableau[j].getTaille()<i+1) {
					System.out.print("|                  |");
				}
				else{
					//if(i == tableau[j].getTaille()-1)
					{
					System.out.print("|"+tableau[j].getCarte(i)+"|");
					}
//					else{
//						System.out.print("|   Carte inconnue   |");
//					}
				}
				
			}
			System.out.println();
		}
		affichePioche();
	}
	
	
	public void piocheVersColonne() {
		System.out.println("Vers quelle colonne voulez vous déplacer votre carte ? ! Entrez le numéro de colonne");
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();

		if(verifNum(pioche.getCartePioche(),tableau[r-1].getCarte(tableau[r-1].getTaille()-1)) && verifCouleur(pioche.getCartePioche(),tableau[r-1].getCarte(tableau[r-1].getTaille()-1))) {
			tableau[r-1].incTaille();
			tableau[r-1].addCarte(pioche.getCartePioche());
			pioche.removeCarte(pioche.getCmp());
			System.out.println("Votre carte a bien été ajoutée a la colonne " + r);
		}
		else
			System.out.println("Le déplacement n'est pas possible !");
	}
	
	
	public boolean verifNum(Carte choix, Carte destination) {
		
		return choix.getNum() - destination.getNum() == -1;

	}
	
	public boolean verifCouleur(Carte choix, Carte destination) {
		if(choix.getForme() == " Trefle" || choix.getForme() == " Pique ") 
			return destination.getForme() == "Carreau" || destination.getForme() == " Coeur ";
		else 
			return destination.getForme() == " Pique " || destination.getForme() == " Trefle";
		
	}
	
	
	public static void main(String[] args){
		
		Jeu jeu = new Jeu();
		MenuSolitaire menu = new MenuSolitaire(jeu);
		jeu.initPioche();
		jeu.alea();
		jeu.afficheJeu();
		
		
		System.out.println("|             ||                 ||               ||            ||");
		//a.affichePioche();
		//System.out.println();
		//a.pioche();
		
		
		while(true) {
			
			menu.afficheMenu();
			jeu.afficheJeu();
			
		}
		
	}
}