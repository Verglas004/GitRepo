import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import BasicUtility.ButtonUtility;
import BasicUtility.PanelEvent;
import BasicUtility.PanelListener;


public class BasicButtonPanel extends JPanel implements ActionListener{
	JButton[] buttons;
	PanelListener panelListener;
	GridBagConstraints gbc;
	
	public BasicButtonPanel(PanelListener p, String[] labels){
		buttons = new JButton[labels.length];
		panelListener = p;
		setName("Home");
		gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		
		gbc.gridx = 0;
		gbc.insets = new Insets(0, 0, 30, 0);
		
		if(labels == ButtonUtility.basicButtonLabels){
			for(int i = 0; i < ButtonUtility.basicButtonLabelBreakDown.length; i++){
				gbc.gridy = i;
				add(setUpButtonPanel(ButtonUtility.basicButtonLabelBreakDown[i]), gbc);
			}
		}
	}
	
	public JPanel setUpButtonPanel(String[] labels){
		JPanel temp = new JPanel();
		temp.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		Dimension d = new Dimension(175, 175);
		temp.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5, true));
		JButton b;
		
		for(int i = 0; i < labels.length; i++){
			String text = "<html><b>" + labels[i].replaceAll(" ", "<br>") + "</b></html>";
			b = new JButton(text);
			b.setName(labels[i]);
			b.setLayout(new BorderLayout());
			b.setForeground(Color.WHITE);
			b.setBorder(BorderFactory.createLineBorder(getBackground(), 5, true));
			b.addActionListener(this);
			
			try {
				b.setIcon(new ImageIcon(ImageIO.read(getClass().getResource(labels[i].toLowerCase() + ".png"))));
			} catch (IOException e) {
				System.out.println(labels[i] + " isn't a valid image");
			}
			b.setVerticalTextPosition(SwingConstants.BOTTOM);
		    b.setHorizontalTextPosition(SwingConstants.CENTER);
			g.gridx = i%5;
			
			if(i % 5 == 0)
				g.gridy++;
			
			b.setPreferredSize(d);
			temp.add(b, g);
		}
		
		return temp;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e){
		PanelEvent panelEvent = null;
		JButton source = (JButton)e.getSource();
		
		if(source.getName().equals("Spell Search"))
			panelEvent = new PanelEvent(this, new SpellSearchPanel("spellSearch", panelListener), source.getName());
		/*else if(source.getLabel().equals("IMP Dashboard"))
			panelEvent = new PanelEvent(this, new BasicButtonPanel(panelListener, ButtonUtility.infrastructureButtonLabels), "infrastructure");
		else if (e.getSource() == homeButton)
			panelEvent = new PanelEvent(this, new MainSwitchBoard(panelListener), "mainswitchboard");
		else
			panelEvent = new PanelEvent(this, new BasicSearchForm(source.getName(), panelListener), source.getName());
		*/
		panelListener.panelReceived(panelEvent);
	}
}
