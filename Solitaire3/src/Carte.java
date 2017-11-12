public class Carte {

	private boolean visible;
	private int num;
	private String forme;
	
	public Carte(int numb, String formee) {
		num = numb;
		forme = formee;
		visible = false;
	}
	
	public String toString() {
		String vn = num + forme;
		switch(num) {
		case 1:
			vn = "  As  de " + forme+"  ";
			break;
		case 11:
			vn = " Valet de " + forme+ " ";
			break;
		case 12: 
			vn = "  Dame de " + forme+ " ";
			break;
		case 13: 
			vn = "  Roi  de " + forme+" ";
			break;
		case 2: 
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			vn ="   " + num + "  de " + forme + "  ";
			break;
		case 10:
			vn = "   " + num + "  de " + forme + " ";
			break;
		}
		if(visible)
			return vn;
		else
			return "  Carte inconnue  ";
	}
	
	public int getNum() {
		return num;
	}
	
	public void setVisible() {
		visible = true;
	}
	public boolean estVisible() {
		return visible;
	}
	
	public String getForme() {
		return forme;
	}

	
	
}