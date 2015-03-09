import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings( "serial" )
public class NumberPanel extends JPanel implements ActionListener
{
    private JNumberField valueField;
    String statName;
    private JNumberField modifierField;
    
    private JLabel statNameLabel;
    private JButton bottomButton, topButton;
    private GridBagConstraints gbc;
    private int size;
    private int arrowSize;
    
    public NumberPanel(int size, String statName) {
	this.statName = statName;
	setLayout(new GridBagLayout());
	setName(statName);
	init(size);
	setVisible(true);
    }

    private void init(int size) {
	this.size = size;
	gbc = new GridBagConstraints();
	setValueField(size);
	gbc.insets = new Insets(0, 10, 0, 0);
	setNameField(size);
	setModifierField(size);
	arrowSize = size/2;
	//setButtons(arrowSize);
    }
    
    public void setEditable(boolean isEditable){
	valueField.setEditable(isEditable);
    }

    public void addCounter() {	
	gbc = new GridBagConstraints();
	ImageIcon temp;
	Image img;
	//topButton = new JButton(new ImageIcon(((new ImageIcon("/Green_Arrow_Up.png")).getImage()).getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH)));
	topButton = new JButton();
	topButton.setPreferredSize(new Dimension(arrowSize, arrowSize));
	try{
	    img = ImageIO.read(getClass().getResource("Red_Arrow_Down.png"));
	    Image resizedImage = img.getScaledInstance(arrowSize, arrowSize, 0);
	    temp = new ImageIcon(resizedImage);
	    
	    topButton.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("Green_Arrow_Up.png"))));
	} catch (IOException e) {
		System.out.println("Not a valid image");
	}
	topButton.setVisible(true);
		
	gbc.gridy = 0;
	gbc.gridx = 1;
	add(topButton, gbc);
		
	//bottomButton = new JButton(new ImageIcon(((new ImageIcon("Red_Arrow_Down.png")).getImage()).getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH)));
	bottomButton = new JButton();
	bottomButton.setPreferredSize(new Dimension(arrowSize, arrowSize));
	
	try{
	    img = ImageIO.read(getClass().getResource("Red_Arrow_Down.png"));
	    Image resizedImage = img.getScaledInstance(arrowSize, arrowSize, 0);
	    temp = new ImageIcon(resizedImage);
	    
	    bottomButton.setIcon(temp);
	} catch (IOException e) {
		System.out.println("Not a valid image");
	}
	bottomButton.setVisible(true);
	
	gbc.gridy = 1;
	gbc.gridx = 1;
	gbc.anchor = GridBagConstraints.PAGE_END;
	gbc.gridheight = 2;
	add(bottomButton, gbc);
	
	topButton.addActionListener(this);
	bottomButton.addActionListener(this);
    }

    private void setValueField(int size) {
	// TODO 10 is what I'm defaulting right now
	valueField = new JNumberField(0, 30);
	valueField.setInt(0);
	valueField.setPreferredSize(new Dimension(size, size));
	valueField.setHorizontalAlignment(SwingConstants.LEFT);
	valueField.setFont(new Font("Harlow Solid Italic", Font.BOLD, size - size/3));
	valueField.setBackground(Color.WHITE);

	valueField.setVisible(true);
	valueField.setEditable(false);

	gbc.gridy = 0;
	gbc.gridx = 0;
	gbc.fill = GridBagConstraints.VERTICAL;
	// gbc.ipady = 40; //make this component tall
	gbc.weighty = 0.0;
	gbc.gridheight = 3;
	add(valueField, gbc);
    }
    
    private void setNameField(int size){
	statNameLabel = new JLabel(statName);
	gbc.gridy = 0;
	gbc.gridx = 2;
	add(statNameLabel, gbc);
    }
    
    private void setModifierField(int size) {
	// TODO 10 is what I'm defaulting right now
	modifierField = new JNumberField(-30, 30);
	modifierField.setInt(0);
	modifierField.setPreferredSize(new Dimension(size, size));
	modifierField.setHorizontalAlignment(SwingConstants.LEFT);
	modifierField.setFont(new Font("Harlow Solid Italic", Font.BOLD, size - size/3));

	modifierField.setVisible(true);
	modifierField.setEditable(false);

	gbc.gridy = 0;
	gbc.gridx = 3;
	gbc.fill = GridBagConstraints.VERTICAL;
	// gbc.ipady = 40; //make this component tall
	gbc.weighty = 0.0;
	gbc.gridheight = 3;
	add(modifierField, gbc);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
	if( e.getSource() == topButton ) {
	    //int value = Integer.parseInt(valueField.getText());
	    int value = valueField.getInt();
	    value++;
	    valueField.setInt(value);
	    modifierField.setInt(DnDMath.getModifierValue(value));
	} else if( e.getSource() == bottomButton ) {
	    //int value = Integer.parseInt(valueField.getText());
	    int value = valueField.getInt();

	    if( value > 0 )
		value--;

	    valueField.setInt(value);
	    modifierField.setInt(DnDMath.getModifierValue(value));
	}
    }
}
