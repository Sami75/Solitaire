import java.util.Scanner;

public class MenuSolitaire {

	
	
public void afficheMenu() {
		Jeu a = new Jeu();
		System.out.println();
		System.out.println("1. Piocher");
		System.out.println("2. S�lectionner la colonne 1");
		System.out.println("3. S�lectionner la colonne 2");
		System.out.println("4. S�lectionner la colonne 3");
		System.out.println("5. S�lectionner la colonne 4");
		System.out.println("6. S�lectionner la colonne 5");
		System.out.println("7. S�lectionner la colonne 6");
		System.out.println("8. S�lectionner la colonne 7");
		System.out.println("Quel action souhaitez vous faire ? Taper le num�ros correspondant");
		
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
		
		default : System.out.println("Veuillez entrer les num�ros correspondant"); 
		//new MenuSolitaire();
		}
	}
}
