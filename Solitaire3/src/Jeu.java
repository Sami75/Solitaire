import java.lang.Math; 
import java.util.ArrayList;
import java.util.Scanner;


public class Jeu {
	
	private Tas[] tableau;
	private Pioche pioche;
	private Pile[] pile;
	
	public Jeu() {
		
		Tas a;
		Pile b;
		tableau = new Tas[7];
		pile = new Pile[4];
		for(int i = 0 ; i < pile.length ; i++) {
			b = new Pile(0);
			pile[i] = b;
		}
		pile[2].setType(" Coeur ");
		pile[3].setType(" Pique ");
		pile[1].setType(" Trefle");
		pile[0].setType("Carreau");
		
		
		for (int i = 1 ; i < tableau.length+1 ; i++) {
			String g = "Tas";
			a = new Tas(i);
			a.setNom( g + i );
			tableau[i-1] = a;
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
					System.out.print("|"+tableau[j].getCarte(i)+"|");
				}
				
			}
			System.out.println();
		}
		affichePioche();

		System.out.println();
		for(int i = 1 ; i <= pile.length ; i++)
			System.out.print("|      Pile " + i + "      |");
		System.out.println();
		System.out.print("|      Carreau     |");
		System.out.print("|      Trefle      |");
		System.out.print("|      Coeur       |");
		System.out.print("|      Pique       |");
		System.out.println();


		
		for(int i = 0; i < 4; i++) {
			if(pile[i].vide()) {
				System.out.print("|                  |");
			}
			else
				System.out.print("|" + pile[i].getCarte(pile[i].getTaille()-1) + "|");
		}
		System.out.println();
	}
	
	
	public void piocheVersColonne() {
		System.out.println("Vers quelle colonne voulez vous déplacer votre carte ? ! Entrez le numéro de colonne");
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		
		if(pioche.getCmp() == -1) {
			System.out.println("Vous n'avez pas encore piocher, veuillez piocher avant de vouloir déplacer la carte!");
			return;
		}
		if( r > 7 || r < 1) {
			System.out.println("La colonne " + r + " n'existe pas, il n'y a que 7 colonnes !");
			return;
		}
		if(tableau[r-1].vide()) {
			if(pioche.getCartePioche().getNum() == 13) {
				tableau[r-1].incTaille();
				tableau[r-1].addCarte(pioche.getCartePioche());
				System.out.println("Votre carte " + pioche.getCartePioche() + " a bien été ajoutée a la colonne " + r);
				pioche.removeCarte(pioche.getCmp());
				if(pioche.getCmp() == pioche.getTaille()) {
					pioche.incPioche();
				}
			}
			else
				System.out.println("Le déplacement n'est pas possible : La carte n'est pas un roi !");
		}
		else {
			if(verifNum(pioche.getCartePioche(),tableau[r-1].getCarte(tableau[r-1].getTaille()-1))) {
				if(verifCouleur(pioche.getCartePioche(),tableau[r-1].getCarte(tableau[r-1].getTaille()-1))) {
					tableau[r-1].incTaille();
					System.out.println("Votre carte " + pioche.getCartePioche());
					tableau[r-1].addCarte(pioche.getCartePioche());
					System.out.println("Votre carte " + pioche.getCartePioche() + " a bien été ajoutée a la colonne " + r);
					pioche.removeCarte(pioche.getCmp());
					if(pioche.getCmp() == pioche.getTaille()) {
						pioche.incPioche();
					}
				}
				else
					System.out.println("Le déplacement n'est pas possible : Les types ne correspondent pas !");
			}
			else
				System.out.println("Le déplacement n'est pas possible : Les numéros ne correspondent pas !");
		}

		
}
	
	public void colonneVersColonne() {
		
		System.out.println("Depuis quelle colonne voulez vous prendre la carte ? ! Entrez le numéro de colonne");
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		
		System.out.println("Dans quelle colonne voulez vous mettre la carte ? ! Entrez le numéro de colonne");
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		
		if( r > 7 || r < 1) {
			System.out.println("La colonne " + r + " n'existe pas, il n'y a que 7 colonnes !");
			return;
		}
		
		if( m > 7 || m < 1) {
			System.out.println("La colonne " + m + " n'existe pas, il n'y a que 7 colonnes !");
			return;
		}
		
		if(tableau[r-1].vide()) {
			System.out.println("Il n'y a pas de cartes dans la colonne " + r);
			return;
		}
		if(tableau[m-1].vide()) {
			if(tableau[r-1].getCarte(tableau[r-1].getTaille()-1).getNum() == 13) {
				tableau[m-1].incTaille();
				tableau[m-1].addCarte(tableau[r-1].getCarte(tableau[r-1].getTaille()-1));
				tableau[r-1].removeCarte(tableau[r-1].getTaille()-1);
				if(tableau[r-1].getTaille() > 0) {
					tableau[r-1].majVisible();
				}
				System.out.println("Votre carte a bien été ajoutée a la colonne " + r);
			}
			else
				System.out.println("Le déplacement n'est pas possible : La carte n'est pas un roi !");
		}
		else {
			if(verifNum(tableau[r-1].getCarte(tableau[r-1].getTaille()-1),tableau[m-1].getCarte(tableau[m-1].getTaille()-1))){
				if(verifCouleur(tableau[r-1].getCarte(tableau[r-1].getTaille()-1),tableau[m-1].getCarte(tableau[m-1].getTaille()-1))) {
					tableau[m-1].incTaille();
					tableau[m-1].addCarte(tableau[r-1].getCarte(tableau[r-1].getTaille()-1));
					tableau[r-1].removeCarte(tableau[r-1].getTaille()-1);
					if(tableau[r-1].getTaille() > 0) {
						tableau[r-1].majVisible();
					}
					System.out.println("Votre carte a bien été déplacée vers la colonne " + m);
				}
				else
					System.out.println("Le déplacement n'est pas possible : Le type ne correspond pas");	
			}
			else
				System.out.println("Le déplacement n'est pas possible : Le numéro ne correspond pas");
			}
		}

	public void multipleVersColonne() {
		
		System.out.println("Depuis quelle colonne voulez vous prendre les cartes ? ! Entrez le numéro de colonne");
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		
		System.out.println("Dans quelle colonne voulez vous mettre les cartes ? ! Entrez le numéro de colonne");
		Scanner ss = new Scanner(System.in);
		int d = sc.nextInt();
		
		System.out.println("Combien de cartes voulez vous prendre ? ! Entrez le nombre");
		Scanner s = new Scanner(System.in);
		int nb = s.nextInt();
		
		if(  c > 7 || c < 1) {
			System.out.println("La colonne " + c + " n'existe pas, il n'y a que 7 colonnes !");
			return;
		}
		
		if(  d > 7 || d < 1) {
			System.out.println("La colonne " + d + " n'existe pas, il n'y a que 7 colonnes !");
			return;
		}
		
		if(tableau[c-1].getTaille() < nb) {
			System.out.println("Il n'y a pas assez de cartes;");
			return;
		}
		
		if(!tableau[c-1].getCarte(tableau[c-1].getTaille()-1-(nb-1)).estVisible()) {
			System.out.println("Vous ne pouvez pas déplacer de cartes inconnues");
			return;
		}
		if(tableau[d-1].vide()) {
			
			if(tableau[c-1].getCarte(tableau[c-1].getTaille()-1-(nb-1)).getNum() == 13) {
				if(tableau[c-1].getTaille() >= nb) {
					tableau[c-1].getCarte(tableau[c-1].getTaille()-1-(nb-2)).setVisible();
					for(int i = nb ; i > 0; i--) {
						tableau[d-1].incTaille();
						tableau[d-1].addCarte(tableau[c-1].getCarte(tableau[c-1].getTaille()-1-(i-1)));
						tableau[c-1].removeCarte(tableau[c-1].getTaille()-1-(i-1));
					}
					System.out.println("Vos cartes ont bien été ajoutées a la colonne " + d);
						if(tableau[c-1].getTaille() > 0) {
							tableau[c-1].majVisible();
						
					}
				}
				else 
					System.out.println("Il n'y a pas assez de cartes dans la colonne " + c + " !");
			}
			else
				System.out.println("Le déplacement n'est pas possible : la carte n'est pas un roi !");
			
		}
		else {
			if(verifNum(tableau[c-1].getCarte(tableau[c-1].getTaille()-1-(nb-1)),tableau[d-1].getCarte(tableau[d-1].getTaille()-1))) {
			
				if(verifCouleur(tableau[c-1].getCarte(tableau[c-1].getTaille()-1-(nb-1)),tableau[d-1].getCarte(tableau[d-1].getTaille()-1))) {
				
					for(int i = nb ; i > 0; i--) {
						tableau[d-1].incTaille();
						tableau[d-1].addCarte(tableau[c-1].getCarte(tableau[c-1].getTaille()-1-(i-1)));
						tableau[c-1].removeCarte(tableau[c-1].getTaille()-1-(i-1));
					} 	
					if(tableau[c-1].getTaille() > 0) {
							tableau[c-1].majVisible();
					}
					System.out.println("Votre carte a bien été déplacée vers la colonne " + d);
				}
				else
					System.out.println("Le déplacement n'est pas possible : Le type ne correspond pas");
			}
			else
				System.out.println("Le déplacement n'est pas possible : Le numéro ne correspond pas");
		}
	}
	
	public void colonneVersPile() {
		
		System.out.println("Depuis quelle colonne voulez vous prendre la carte ? ! Entrez le numéro de colonne");
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		
		System.out.println("Dans quelle pile voulez vous mettre la carte ? ! Entrez le numéro de pile");
		Scanner s = new Scanner(System.in);
		int d = s.nextInt();
		
		if(  c > 7 || c < 1) {
			System.out.println("La colonne " + c + " n'existe pas, il n'y a que 7 colonnes !");
			return;
		}
		
		if( d > 4 || d < 1) {
			System.out.println("La pile " + d + " n'existe pas, il n'y a que 4 piles !");
			return;
		}
		
		if(pile[d-1].vide()) {
			if(tableau[c-1].getCarte(tableau[c-1].getTaille()-1).getNum() == 1) {
				if(verifCouleur2(tableau[c-1].getCarte(tableau[c-1].getTaille()-1),pile[d-1])) {
					pile[d-1].incTaille();
					pile[d-1].addCarte(tableau[c-1].getCarte(tableau[c-1].getTaille()-1));
					tableau[c-1].removeCarte(tableau[c-1].getTaille()-1);
					if(tableau[c-1].getTaille() > 0) {
						tableau[c-1].majVisible();
					}
					System.out.println("Votre carte a bien été ajoutée a la pile " + c);
				}
				else
					System.out.println("Le déplacement est impossible : Votre carte n'est pas du bon type! ");
			}
			else
				System.out.println("Le déplacement n'est pas possible : La carte n'est pas un as!");
		}
		else {
			if(verifNum2(tableau[c-1].getCarte(tableau[c-1].getTaille()-1),pile[d-1].getCarte(pile[d-1].getTaille()-1))){
				if(verifCouleur2(tableau[c-1].getCarte(tableau[c-1].getTaille()-1),pile[d-1])) {
					pile[d-1].incTaille();
					pile[d-1].addCarte(tableau[c-1].getCarte(tableau[c-1].getTaille()-1));
					tableau[c-1].removeCarte(tableau[c-1].getTaille()-1);
					if(tableau[c-1].getTaille() > 0) {
						tableau[c-1].majVisible();
					}
					System.out.println("Votre carte a bien été déplacée vers la pile " + d);
				}
				else
					System.out.println("Le déplacement n'est pas possible : Le type ne correspond pas");	
			}
			else
				System.out.println("Le déplacement n'est pas possible : Le numéro ne correspond pas");
			}
	}
	
	public void piocheVersPile() {
		
		System.out.println("Dans quelle pile voulez vous mettre la carte ? ! Entrez le numéro de colonne");
		Scanner s = new Scanner(System.in);
		int d = s.nextInt();
		if(d > pile.length || d < 0) {
			System.out.println("Déplacement impossible, Il n'y a que 4 piles");
			return;
		}
		if(pile[d-1].vide()) {
			if(pioche.getCartePioche().getNum() == 1) {
				if(verifCouleur2(pioche.getCartePioche(),pile[d-1])) {
					pile[d-1].incTaille();
					pile[d-1].addCarte(pioche.getCartePioche());
					System.out.println("Votre carte " + pioche.getCartePioche() + " a bien été ajoutée a la pile " + d);
					pioche.removeCarte(pioche.getCmp());
					if(pioche.getCmp() == pioche.getTaille()) {
						pioche.incPioche();
					}
				}
				else System.out.println("Le déplacement n'est pas possible : La carte n'est pas du bon type !");
			}
			else
				System.out.println("Le déplacement n'est pas possible : La carte n'est pas un as !");
		}
		else {
			if(verifNum2(pioche.getCartePioche(),pile[d-1].getCarte(pile[d-1].getTaille()-1))) {
				if(verifCouleur2(pioche.getCartePioche(),pile[d-1])) {
					pile[d-1].incTaille();
					pile[d-1].addCarte(pioche.getCartePioche());
					System.out.println("Votre carte " + pioche.getCartePioche() + " a bien été ajoutée a la pile " + d);
					pioche.removeCarte(pioche.getCmp());
					if(pioche.getCmp() == pioche.getTaille()) {
						pioche.incPioche();
					}
				}
				else
					System.out.println("Le déplacement n'est pas possible : Les types ne correspondent pas !");
			}
			else
				System.out.println("Le déplacement n'est pas possible : Les numéros ne correspondent pas !");
		}
		
	}
	
	public void pileVersColonne() {
		
		System.out.println("Depuis quelle pile voulez vous prendre la carte ? ! Entrez le numéro de pile");
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		
		System.out.println("Dans quelle colonne voulez vous mettre la carte ? ! Entrez le numéro de colonne");
		Scanner s = new Scanner(System.in);
		int d = s.nextInt();
		
		if(  c > 7 || c < 1) {
			System.out.println("La colonne " + c + " n'existe pas, il n'y a que 7 colonnes !");
			return;
		}
		
		if( d > 4 || d < 1) {
			System.out.println("La pile " + d + " n'existe pas, il n'y a que 4 piles !");
			return;
		}
		
		if(tableau[d-1].vide()) {
			if(pile[c-1].getCarte(pile[c-1].getTaille()-1).getNum() == 13) {
					tableau[d-1].incTaille();
					tableau[d-1].addCarte(pile[c-1].getCarte(pile[c-1].getTaille()-1));
					pile[c-1].removeCarte(pile[c-1].getTaille()-1);
					System.out.println("Votre carte a bien été ajoutée a la colonne " + d);
				
			}
			else
				System.out.println("Le déplacement n'est pas possible : La carte n'est pas un roi!");
		}
		else {
			if(verifNum(pile[c-1].getCarte(pile[c-1].getTaille()-1),tableau[d-1].getCarte(tableau[d-1].getTaille()-1))){
				if(verifCouleur(pile[c-1].getCarte(pile[c-1].getTaille()-1),tableau[d-1].getCarte(tableau[d-1].getTaille()-1))) {
					tableau[d-1].incTaille();
					tableau[d-1].addCarte(pile[c-1].getCarte(pile[c-1].getTaille()-1));
					pile[c-1].removeCarte(pile[c-1].getTaille()-1);
					System.out.println("Votre carte a bien été déplacée a la colonne " + d);
				}
				else
					System.out.println("Le déplacement n'est pas possible : Le type ne correspond pas");	
			}
			else
				System.out.println("Le déplacement n'est pas possible : Le numéro ne correspond pas");
			}
	}
	
	public boolean verifNum(Carte choix, Carte destination) {
		
		return choix.getNum() - destination.getNum() == -1;

	}
	
	public boolean verifNum2(Carte choix, Carte destination) {
		
		return choix.getNum() - destination.getNum() == 1;

	}
	
	public boolean verifCouleur(Carte choix, Carte destination) {
		if(choix.getForme() == " Trefle" || choix.getForme() == " Pique ") 
			return destination.getForme() == "Carreau" || destination.getForme() == " Coeur ";
		else 
			return destination.getForme() == " Pique " || destination.getForme() == " Trefle";
		
	}
	
	public boolean verifCouleur2(Carte choix, Pile destination) {
		return choix.getForme() == destination.getType();
	}
	
	public boolean finDeJeu() {
		boolean tabVide = true;
		for(int i = 0; i < tableau.length ; i++) {
			if(!tableau[i].vide())
				tabVide = false;
		}
		return(tabVide && pioche.vide());
			
	}
	
	public static void main(String[] args){
		
		Jeu jeu = new Jeu();
		MenuSolitaire menu = new MenuSolitaire(jeu);
		jeu.initPioche();
		jeu.alea();
		jeu.afficheJeu();
		
		while(!jeu.finDeJeu()) {
			
			menu.afficheMenu();
			jeu.afficheJeu();
			
		}
		
		System.out.println("BRAVO VOUS AVEZ REUSSI A TERMINER LE SOLITAIRE ! ! ! ");
		
	}
}