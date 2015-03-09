import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;


@SuppressWarnings("serial")
public class SingleSpellUI extends JPanel{
	GridBagConstraints gbc;
	JTextField spellTextField;
	JTextPane spellTextPane;
	Spell spell;
	
	public SingleSpellUI(Spell spell){
		this.spell = spell;
		initComponents();
	}
	
	private void initComponents(){
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		setLayout(new GridBagLayout());
		
		JLabel spellName = new JLabel("<html><b><font size=5>" + spell.getName() + "</font></b></html>");
		JLabel levelReqPlusSchool = new JLabel("<html><i>" + spell.getLevel() + "-" + spell.getSchool() + "</i></html>");
		
		JLabel castingTimeLabel = new JLabel("<html><b>Casting Time: </b>" + spell.getCastingTime() + "</html>");
		JLabel componentsLabel = new JLabel("<html></b>Components: </b>" + spell.getComponents() + "</html>");
		JLabel pageLabel = new JLabel("<html></b>Page #: </b>" + spell.getPg() + "</html>");
		
		String spellText = customizeSpellText(spell.getDescription());
		
		JTextPane spellTextPane = new JTextPane();
		spellTextPane.setContentType("text/html");
		spellTextPane.setText(spellText);
		
		JScrollPane textScroller = new JScrollPane(spellTextPane);
        Dimension d = spellTextPane.getPreferredSize();
        System.out.println(d.getWidth() + " " + d.getHeight());
        textScroller.setPreferredSize(new Dimension(450, 180));
        textScroller.setName("tableScroller");
        
		gbc.gridx = 0;
        gbc.gridy = 0;
        add(spellName, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(levelReqPlusSchool, gbc);
        //insets bottom
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(castingTimeLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(componentsLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(pageLabel, gbc);
        //insets bottom
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(textScroller, gbc);
	}

	private String customizeSpellText(String spellText){
		String temp = spellText.replace("\n", "<br></br><br></br>");
		temp = temp.replace("At Higher Levels.", "<b>At Higher Levels.</b>");		
		
		return temp;
	}
}
