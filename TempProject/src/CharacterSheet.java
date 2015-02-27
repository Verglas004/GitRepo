import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CharacterSheet extends JFrame {
	private Character character;
	private boolean newCharacter;

	public CharacterSheet() {
		newCharacter = true;
		character = new Character();
		init(newCharacter);
		repaint();
		validate();
	}

	private void init(boolean newCharacter2) {
		setSize(new Dimension(750, 300));
		setTitle("Character Sheet");
		setVisible(true);

		add(new StatsPanel());
	}

	public CharacterSheet(Character character) {
		newCharacter = false;
		this.character = character;
		init(newCharacter);

		add(new StatsPanel());
	}
}
