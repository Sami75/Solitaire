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
		System.out.println("3. Déplacement d'une carte de la pioche vers une pile");
		System.out.println("4. Déplacement d'une carte d'une colonne vers une autre colonne");
		System.out.println("5. Déplacement de plusieurs carte d'une colonne vers une autre colonne");
		System.out.println("6. Déplacement d'une carte d'une colonne vers une pile");
		System.out.println("7. Déplacement d'une carte d'une pile vers une colonne");
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
				jeu.piocheVersPile();	
				break;
		
		case 4 :
				jeu.colonneVersColonne();	
				break;
				
		case 5 : 
				jeu.multipleVersColonne();
				break;
			
		case 6: 
				jeu.colonneVersPile();
				break;
				
		case 7 :
				jeu.pileVersColonne();
				break;
				
		default : System.out.println("Veuillez entrer les numéros correspondant"); 
		}
	}
}