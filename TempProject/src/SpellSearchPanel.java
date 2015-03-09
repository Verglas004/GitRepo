import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BasicUtility.AutoCompletion;
import BasicUtility.ButtonUtility;
import BasicUtility.MyFrame;
import BasicUtility.PanelEvent;
import BasicUtility.PanelListener;

@SuppressWarnings("serial")
public class SpellSearchPanel  extends JPanel implements ActionListener, MouseListener{
	PanelListener panelListener;
	JButton homeButton = new JButton("Home");
	JButton searchButton = new JButton("Search");
	GridBagConstraints gbc;
	String[] columnNames, allColumnNames;
	Object[][] rowData = {{"", "", "", "", ""}};
	private DefaultTableModel dtm;
	JTable table;
	JLabel searchNameLabel, searchLevelLabel, searchClassLabel;
	JComboBox<String> nameComboBox, levelComboBox, classComboBox;
	PullSpellInfo spellInfo = new PullSpellInfo();
	ArrayList<Spell> spellList = spellInfo.getSpellList();
	
	
	public SpellSearchPanel(String searchFormType, PanelListener pl){
		panelListener = pl;
		setName("Spell Search");
		initComponents();
	}
	
	private String[] getColumnFromSpellList(int col){
		String[] temp = null;
		if(col == 0){
			temp = new String[spellList.size()];
			for(int i = 0; i < spellList.size(); i++){
				if(col == 0)
					temp[i] = spellList.get(i).getName();
			}
		}else if(col == 1)
			temp = ButtonUtility.levels;
		else if(col == 2)
			temp = ButtonUtility.classes;
		
		return temp;
	}
	
	private void initComponents(){
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		setLayout(new GridBagLayout());
		
		columnNames = ButtonUtility.spellColumnNames;
		dtm = new DefaultTableModel(null, columnNames);
		
		searchNameLabel = new JLabel();
		searchLevelLabel = new JLabel();
		searchClassLabel = new JLabel();
		table = new JTable(dtm);
		
		nameComboBox = new JComboBox<String>(getColumnFromSpellList(0));
		nameComboBox.insertItemAt("", 0);
		nameComboBox.setSelectedIndex(0);
		nameComboBox.addActionListener(this);
		nameComboBox.setEditable(true);
		
		levelComboBox = new JComboBox<String>(getColumnFromSpellList(1));
		levelComboBox.insertItemAt("", 0);
		levelComboBox.setSelectedIndex(0);
		levelComboBox.addActionListener(this);
		levelComboBox.setEditable(true);
		
		classComboBox = new JComboBox<String>(getColumnFromSpellList(2));
		classComboBox.insertItemAt("", 0);
		classComboBox.setSelectedIndex(0);
		classComboBox.addActionListener(this);
		classComboBox.setEditable(true);
		
		gbc.insets = new Insets(5, 0, 0, 5);
		
		searchNameLabel.setText("Spell Name");
		searchNameLabel.setBackground(Color.RED);
		searchNameLabel.setName("searchStreetLabel");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(searchNameLabel, gbc);
		
        searchLevelLabel.setText("Level Req.");
        searchLevelLabel.setBackground(Color.RED);
        searchLevelLabel.setName("searchLevelLabel");
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(searchLevelLabel, gbc);
        
        searchClassLabel.setText("Caster Class");
        searchClassLabel.setBackground(Color.RED);
        searchClassLabel.setName("searchClassLabel");
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(searchClassLabel, gbc);
        
        searchButton.setText("Search Spell List");searchButton.setName("searchButton");
        gbc.gridx = 3;
        gbc.gridy = 1;
        searchButton.addActionListener(this);
        add(searchButton, gbc);
        
        nameComboBox.setName("nameComboBox");
        AutoCompletion.enable(nameComboBox);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(nameComboBox, gbc);
        
        levelComboBox.setName("levelComboBox");
        AutoCompletion.enable(levelComboBox);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(levelComboBox, gbc);
        
        classComboBox.setName("classComboBox");
        AutoCompletion.enable(classComboBox);
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(classComboBox, gbc);
        
        gbc.gridx = 4;
		add(homeButton, gbc);
		homeButton.addActionListener(this);
		
		table = new JTable(dtm);
        table.setEnabled(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 7;
        gbc.insets = new Insets(10, 0, 10, 0);
        
		table.addMouseListener(this);
        
		table.getTableHeader().setReorderingAllowed(false);
        JScrollPane tableScroller = new JScrollPane(table);
        Dimension d = table.getPreferredSize();
        System.out.println(d.getWidth() + " " + d.getHeight());
        tableScroller.setPreferredSize(new Dimension(d.width*2, table.getRowHeight()*7));
        tableScroller.setName("tableScroller");
        add(tableScroller, gbc);        
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PanelEvent panelEvent = null;
		
		if (e.getSource() == homeButton){
			panelEvent = new PanelEvent(this, new BasicButtonPanel(panelListener, ButtonUtility.basicButtonLabels), "Home");
			panelListener.panelReceived(panelEvent);
		}
		else if(e.getSource() == searchButton){
			if(nameComboBox.getSelectedItem() != null && String.valueOf(nameComboBox.getSelectedItem()) != ""){
				searchByID(0, String.valueOf(nameComboBox.getSelectedItem()));
				
				nameComboBox.setSelectedItem("");
				levelComboBox.setSelectedItem("");
				classComboBox.setSelectedItem("");
			}
			if(levelComboBox.getSelectedItem() != null && String.valueOf(levelComboBox.getSelectedItem()) != ""){
				nameComboBox.setSelectedIndex(0);
				
				if(classComboBox.getSelectedItem() != null && String.valueOf(classComboBox.getSelectedItem()) != "")
					searchByID(String.valueOf(levelComboBox.getSelectedItem()), String.valueOf(classComboBox.getSelectedItem()));
				else
					searchByID(1, String.valueOf(levelComboBox.getSelectedItem()));
			}
			else if(classComboBox.getSelectedItem() != null && String.valueOf(classComboBox.getSelectedItem()) != ""){
				nameComboBox.setSelectedIndex(0);

				if(levelComboBox.getSelectedItem() != null && String.valueOf(levelComboBox.getSelectedItem()) != "")
					searchByID(String.valueOf(levelComboBox.getSelectedItem()), String.valueOf(classComboBox.getSelectedItem()));
				else
					searchByID(2, String.valueOf(classComboBox.getSelectedItem()));
			}else{
				MyFrame.statusBar.setStatus("No Record Found", Font.ITALIC, 15, Color.RED);
			}
		}
	}
	
	ArrayList<Spell> backgroundTable = new ArrayList<Spell>();
	
	public void searchByID(String levelValue, String classValue){
		if(dtm.getRowCount() != 0)
		{
			if (dtm.getRowCount() > 0) {
			    for (int i = dtm.getRowCount() - 1; i > -1; i--) {
			        dtm.removeRow(i);
			    }
			    backgroundTable.clear();
			}
		}
		
		
		for(int i = 0; i < spellList.size(); i++){
			if(spellList.get(i).getClassAvailability().contains(classValue) && spellList.get(i).getLevel() == Integer.parseInt(levelValue)){
				backgroundTable.add(spellList.get(i));
			}
		}
		
		for(int j = 0; j < backgroundTable.size(); j++){
			String[] temp = backgroundTable.get(j).spellInListForm();
			dtm.addRow(temp);
		}
		
		revalidate();
		repaint();
	}
	
	// 0 = name, 1 = level, 2 = class
	public void searchByID(int col, String searchValue){
		if(dtm.getRowCount() != 0)
		{
			if (dtm.getRowCount() > 0) {
			    for (int i = dtm.getRowCount() - 1; i > -1; i--) {
			        dtm.removeRow(i);
			    }
			    backgroundTable.clear();
			}
		}		
		
		for(int i = 0; i < spellList.size(); i++){
			if(col == 0){
				if(spellList.get(i).getName().equals(searchValue)){
					backgroundTable.add(spellList.get(i));
				}
			}
			else if(col == 1){
				if(spellList.get(i).getLevel() == Integer.parseInt(searchValue)){
					backgroundTable.add(spellList.get(i));
				}
			} else if(col == 2){
				if(spellList.get(i).getClassAvailability().contains(searchValue)){
					backgroundTable.add(spellList.get(i));
				}
			}
		}
		
		for(int j = 0; j < backgroundTable.size(); j++){
			String[] temp = backgroundTable.get(j).spellInListForm();
			dtm.addRow(temp);
		}
		
		revalidate();
		repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		JTable jTable =(JTable) e.getSource();
	    Point p = e.getPoint();
	    int row = jTable.rowAtPoint(p);
	    jTable.setRowSelectionInterval(row, row); //makes it look selected (whole row)
	    
	    if (e.getClickCount() == 2) {
	    	recordSelected(jTable);
	    }
	}
	
	private void recordSelected(JTable jTable){
		Spell curSpell = backgroundTable.get(jTable.getSelectedRow());
    	setUpSingleSpellUI(curSpell);
	}
	
	SingleSpellUI singleSpellPanel = null;
	
	private void setUpSingleSpellUI(Spell curSpell){
		if(singleSpellPanel != null){
			remove(singleSpellPanel);
			System.out.println("removed singleSpellPanel");
		}
		singleSpellPanel = new SingleSpellUI(curSpell);

		gbc.gridx = 0;
		gbc.gridy = 3;
		add(singleSpellPanel, gbc);
		revalidate();
		repaint();
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
