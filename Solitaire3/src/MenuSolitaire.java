import java.util.Scanner;

public class MenuSolitaire {

public void afficheMenu() {
		Jeu a = new Jeu();
		System.out.println();
		System.out.println("1. Piocher");
		System.out.println("2. D�placement de carte");
		System.out.println("3. D�placement de pile");
		System.out.println("Quel action souhaitez vous faire ? Taper le num�ros correspondant");
		
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		
		switch(r) {
		
		case 1 : 
				
				//a.pioche();
				break;
		
		case 2 : 
				//a.deplaceColonne();
				break;
		
		case 3 : 
				//a.deplacePile();
				break;
		
		default : System.out.println("Veuillez entrer les num�ros correspondant"); 
		}
	}
}
