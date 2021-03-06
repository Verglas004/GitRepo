import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CharacterSheet extends JPanel {
	private Character character;
	private boolean newCharacter;
	
	public CharacterSheet() {
		newCharacter = true;
		character = new Character();
		init(newCharacter);
		repaint();
		validate();
	}

	private void init(boolean newCharacter) {
		setSize(new Dimension(750, 300));
		setName("Character Sheet");
		setVisible(true);

		//TODO stats panel here
		//add(new StatsPanel());
		add(new SpellsPanel());
	}

	public CharacterSheet(Character character) {
		newCharacter = false;
		this.character = character;
		init(newCharacter);

		add(new StatsPanel());
	}
}
