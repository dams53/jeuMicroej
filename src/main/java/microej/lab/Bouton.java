package microej.lab;

import ej.microui.event.generator.Pointer;

public class Bouton {

	int origineX, origineY;
	int hauteur, largeur;
	int couleur;
	
	public Bouton(int origineX, int origineY, int hauteur, int largeur, int couleur) {
		super();
		this.origineX = origineX;
		this.origineY = origineY;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.couleur = couleur;
	}
	public int getOrigineX() {
		return origineX;
	}
	public void setOrigineX(int origineX) {
		this.origineX = origineX;
	}
	public int getOrigineY() {
		return origineY;
	}
	public void setOrigineY(int origineY) {
		this.origineY = origineY;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getCouleur() {
		return couleur;
	}
	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}
	
	public boolean verifDansRectangle(int x, int y){
//		System.out.println("("+x+","+y+") [ "+origineX+","+origineY+"] " + "h:" + hauteur + " l:" + largeur +  " " + x < largeur + origineX && x > origineX && y > origineY && y < hauteur + origineY);
		return true;
//		return x < largeur + origineX && x > origineX && y > origineY && y < hauteur + origineY;
	}
	
}
