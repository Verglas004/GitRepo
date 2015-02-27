package BasicUtility;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;


@SuppressWarnings("serial")
public class StatusBar extends JPanel{
	JLabel statusLabel;
	
	public StatusBar(){
		init();
	}
	
	public void init(){
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		setPreferredSize(new Dimension(getWidth(), 18));
		//setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setLayout(new BorderLayout());
		statusLabel = new JLabel();
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(statusLabel);
		copyright();
	}
	
	public void setStatus(String s, int font, int size, Color color){
		statusLabel.setText(s.replaceAll("Documents", "My Documents"));
		statusLabel.setFont(new Font("Times New Roman", font, size));
		statusLabel.setForeground(color);
	}
	
	public void copyright(){
		JLabel copyrightLabel = new JLabel();
		copyrightLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		copyrightLabel.setText("Craw!");
		copyrightLabel.setFont(new Font("Times New Roman", 1, 11));
		copyrightLabel.setForeground(new Color(35, 110, 26));
		add(copyrightLabel, BorderLayout.SOUTH);
	}
}