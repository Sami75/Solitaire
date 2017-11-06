import java.util.Scanner;

public class MenuSolitaire {

	
	
public void afficheMenu() {
		Jeu a = new Jeu();
		System.out.println();
		System.out.println("1. Piocher");
		System.out.println("2. Sélectionner la colonne 1");
		System.out.println("3. Sélectionner la colonne 2");
		System.out.println("4. Sélectionner la colonne 3");
		System.out.println("5. Sélectionner la colonne 4");
		System.out.println("6. Sélectionner la colonne 5");
		System.out.println("7. Sélectionner la colonne 6");
		System.out.println("8. Sélectionner la colonne 7");
		System.out.println("Quel action souhaitez vous faire ? Taper le numéros correspondant");
		
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		
		switch(r) {
		
		case 1 : 
				
				a.pioche();
				break;
		
		case 2 : 
				a.deplaceColonne();
				break;
		
		case 3 : 
				a.deplacePile();
				break;
		
		default : System.out.println("Veuillez entrer les numéros correspondant"); 
		//new MenuSolitaire();
		}
	}
}
