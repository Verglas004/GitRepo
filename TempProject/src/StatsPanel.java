import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

@SuppressWarnings( "serial" )
public class StatsPanel extends CirclePanel
{
    int statBoxSize = 25;
    NumberPanel[] numPanel = new NumberPanel[6];
    String[] statName = {"STR", "DEX", "CON", "INT", "WIS", "CHA"};
    GridBagConstraints gbc = new GridBagConstraints();
    
    public StatsPanel(){
	setLayout(new GridBagLayout());
	setPreferredSize(new Dimension(400, 400));
	setBackground(Color.WHITE);
	init();
	setVisible(true);
    }
    
    public void init(){
	gbc.insets = new Insets(0, 0, 5, 0);
	setStatValues();
    }
    
    private void setStatValues(){
	gbc.gridx = 0;
	gbc.gridy = 0;
	
	for(int i = 0; i < numPanel.length; i++){
	    numPanel[i] = new NumberPanel(statBoxSize, statName[i]);
	    add(numPanel[i], gbc);
	    numPanel[i].addCounter();
	    gbc.gridy++;
	}
    }
}