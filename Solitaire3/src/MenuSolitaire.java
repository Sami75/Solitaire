import java.util.Scanner;

public class MenuSolitaire {

	public MenuSolitaire() {
		System.out.println("Menu");
		System.out.println("1. Piocher");
		System.out.println("2. D�placer une carte dans une colonne");
		System.out.println("3. D�placer une carte dans une pile");
		System.out.println("Quel action souhaitez vous faire ? Taper le num�ros correspondant");
		
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		
		switch(r) {
		
		case 1 : new Pioche(); break;
		
		case 2 : new DeplaceCol(); break;
		
		case 3 : new DeplacePile(); break;
		
		default : System.out.println("Veuillez entrer les num�ros correspondant"); new MenuSolitaire();
		}
	}
		
}
