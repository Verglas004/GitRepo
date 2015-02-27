package BasicUtility;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
//import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel;


@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	public static StatusBar statusBar;
	String programName;
	
	public MyFrame(String s, int w, int h, int x, int y){
		try {
			//UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
			UIManager.setLookAndFeel(new SyntheticaBlueLightLookAndFeel());
			//UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
		} catch (UnsupportedLookAndFeelException | ParseException e) {
			e.printStackTrace();
		}
		
		SwingUtilities.updateComponentTreeUI(this);
		init(s, w, h, x, y);
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	public void init(String s, int w, int h, int x, int y){
		programName = s;
		setTitle(s);
		setSize(w, h);
		setLocation(x, y);
		setLayout(new BorderLayout());
		//setResizable(false);
		setStatus();
	}
	
	public String getProgramName(){
		return programName;
	}
	
	public void setStatus(){
		statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);
	}
}