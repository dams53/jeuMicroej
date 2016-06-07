package microej.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.Font;
import ej.microui.display.GraphicsContext;
import ej.microui.event.Event;
import ej.microui.event.generator.Pointer;
import ej.microui.util.EventHandler;

public class Program extends Displayable implements EventHandler{

	String txtCouleur;
	int DimH;
	int DimV;
	int rectLargeur = 110;
	int rectHauteur = 50;
	int score = 0;
	List<String> couleurTextes = new ArrayList<String>();
	List<Integer> couleurs = new ArrayList<Integer>();
	List<Bouton> boutons = new ArrayList<Bouton>();
	private final Font font = Font.getFont(Font.LATIN, 26, Font.STYLE_PLAIN);

	public Program() {
		super(Display.getDefaultDisplay());
		Display disp = Display.getDefaultDisplay();
		DimH = disp.getWidth();
		DimV = disp.getHeight();
		couleurTextes.add("ROUGE");
		couleurTextes.add("VERT");
		couleurTextes.add("JAUNE");
		couleurTextes.add("BLEU");
		couleurs.add(Colors.RED);
		couleurs.add(Colors.GREEN);
		couleurs.add(Colors.YELLOW);
		couleurs.add(Colors.BLUE);
	}

	@Override
	public boolean handleEvent(int event) {
		if (Event.getType(event) == Event.POINTER)
		{
			if (Pointer.isClicked(event))
			{
				Pointer ptr = (Pointer)Event.getGenerator(event);
				boolean bool = false;
				for(Bouton bouton : boutons){
					if(bouton.verifDansRectangle(ptr.getX(), ptr.getY())){
						bool = true;
					}
				}
				if(bool){
					score++;
				}
				repaint();
				return true;
			}
		}
		return false;
	}

	@Override
	public void paint(GraphicsContext g) {
		// Set white background
		g.setColor(Colors.WHITE);
		g.fillRect(0, 0, DimH, DimV);
		
		g.setColor(Colors.NAVY);
		String str = "Score : " + score;
		g.setFont(font);
		g.drawString(str, 0, 0, 0);
		
		int x = DimH / 4;
		g.setColor(Colors.BLUE);
		g.fillRect(0 , DimV - 50, rectLargeur, rectHauteur);
		boutons.add(new Bouton(0, DimV-50, rectLargeur, rectHauteur, Colors.BLUE));
		g.setColor(Colors.RED);
		g.fillRect(x, DimV - 50, rectLargeur, rectHauteur);
		boutons.add(new Bouton(x, DimV-50, rectLargeur, rectHauteur, Colors.RED));
		g.setColor(Colors.YELLOW);
		g.fillRect(x * 2, DimV - 50, rectLargeur, rectHauteur);
		boutons.add(new Bouton(x*2, DimV-50, rectLargeur, rectHauteur, Colors.YELLOW));
		g.setColor(Colors.GREEN);
		g.fillRect(x * 3, DimV - 50, rectLargeur, rectHauteur);
		boutons.add(new Bouton(x*3, DimV-50, rectLargeur, rectHauteur, Colors.GREEN));
		
		Random rand = new Random();
		int randomCouleurs = rand.nextInt(couleurs.size());
		int randomCouleursTexte = rand.nextInt(couleurTextes.size());
		
		g.setColor(couleurs.get(randomCouleurs));
		g.setFont(font);
		g.drawString(couleurTextes.get(randomCouleursTexte), 150,100, GraphicsContext.HCENTER | GraphicsContext.VCENTER);
	}

	@Override
	public EventHandler getController() {
		return this;
	}

}
