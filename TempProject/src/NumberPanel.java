import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class NumberPanel extends JPanel implements ActionListener {
	private JTextField valueField;
	private JButton bottomButton, topButton;
	private GridBagConstraints gbc;

	public NumberPanel() {
		setLayout(new GridBagLayout());
		setName("Num");
		init();
		setVisible(true);
	}

	private void init() {
		gbc = new GridBagConstraints();
		setValueField();
		setButtons();
	}

	private void setButtons() {
		int arrowBoxSize = 17;
		gbc = new GridBagConstraints();
		
		//topButton = new JButton(new ImageIcon(((new ImageIcon("/Green_Arrow_Up.png")).getImage()).getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH)));
		topButton = new JButton();
		try{
			topButton.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("Green_Arrow_Up.png"))));
		} catch (IOException e) {
			System.out.println("Not a valid image");
		}
		topButton.setPreferredSize(new Dimension(arrowBoxSize, arrowBoxSize));
		topButton.setVisible(true);
		
		gbc.gridy = 0;
		gbc.gridx = 1;
		add(topButton, gbc);
		
		//bottomButton = new JButton(new ImageIcon(((new ImageIcon("Red_Arrow_Down.png")).getImage()).getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH)));
		bottomButton = new JButton();
		try{
			bottomButton.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("Red_Arrow_Down.png"))));
		} catch (IOException e) {
			System.out.println("Not a valid image");
		}
		bottomButton.setPreferredSize(new Dimension(arrowBoxSize, arrowBoxSize));
		bottomButton.setVisible(true);
		
		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.PAGE_END;
		gbc.gridheight = 2;
		add(bottomButton, gbc);
		
		topButton.addActionListener(this);
		bottomButton.addActionListener(this);
	}

	private void setValueField() {
		//TODO 10 is what I'm defaulting right now
		valueField = new JTextField("10");
		valueField.setPreferredSize(new Dimension(70, 70));
		valueField.setHorizontalAlignment(SwingConstants.LEFT);
		valueField.setFont(new Font("Harlow Solid Italic", Font.BOLD, 50));
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == topButton) {
			int value = Integer.parseInt(valueField.getText());
			value++;
			valueField.setText(value + "");
		} else if (e.getSource() == bottomButton) {
			int value = Integer.parseInt(valueField.getText());

			if (value > 0)
				value--;

			valueField.setText(value + "");
		}
	}
}
