import java.util.Scanner;

public class MenuSolitaire {
	
	private Jeu jeu;
	
	public MenuSolitaire(Jeu a) {
		jeu = a;
	}
	public void afficheMenu() {
		
		System.out.println();
		System.out.println("1. Piocher");
		System.out.println("2. Déplacement de la carte de la pioche vers une colonne");
		System.out.println("3. Déplacement de pile");
		System.out.println("Quel action souhaitez vous faire ? Taper le numéros correspondant");
		
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		
		switch(r) {
		
		case 1 : 
				
				jeu.piocher();
				break;
		
		case 2 : 
				jeu.piocheVersColonne();
				break;
		
		case 3 : 
				//a.deplacePile();
				break;
		
		default : System.out.println("Veuillez entrer les numéros correspondant"); 
		}
	}
}