import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import BasicUtility.ButtonUtility;
import BasicUtility.PanelEvent;
import BasicUtility.PanelListener;


public class SpellSearchPanel  extends JPanel implements ActionListener, MouseListener{
	PanelListener panelListener;
	JButton homeButton = new JButton("Home");
	GridBagConstraints gbc;
	
	
	public SpellSearchPanel(String searchFormType, PanelListener pl){
		panelListener = pl;
		setName("Spell Search");
		initComponents();
	}
	
	private void initComponents(){
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		setLayout(new GridBagLayout());
		
		//TODO check out basicsearch form for ideas
		
		
		add(homeButton, gbc);
		homeButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PanelEvent panelEvent = null;
		
		if (e.getSource() == homeButton)
			panelEvent = new PanelEvent(this, new BasicButtonPanel(panelListener, ButtonUtility.basicButtonLabels), "Home");

		panelListener.panelReceived(panelEvent);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		/*JTable jTable =(JTable) e.getSource();
	    Point p = e.getPoint();
	    int row = jTable.rowAtPoint(p);
	    jTable.setRowSelectionInterval(row, row); //makes it look selected (whole row)
	    
	    if (e.getClickCount() == 2) {
	    	recordSelected(jTable);
	    }*/
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
