import javax.swing.JPanel;


@SuppressWarnings( "serial" )
public class StatsPanel extends JPanel
{
    NumberPanel[] numPanel = new NumberPanel[6];
    
    public StatsPanel(){
	init();
	setVisible(true);
    }
    
    public void init(){
	for(int i = 0; i < numPanel.length; i++){
	    numPanel[i] = new NumberPanel();
	    add(numPanel[i].getName() + i, numPanel[i]);
	}
    }
}
