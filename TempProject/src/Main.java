import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

import BasicUtility.Dice;
import BasicUtility.FrameUtility;
import BasicUtility.MyFrame;
import BasicUtility.PanelEvent;
import BasicUtility.PanelListener;
import BasicUtility.ButtonUtility;

public class Main implements PanelListener {
	private JPanel currentPanel;
	private MyFrame mainFrame;
	//Image img = Toolkit.getDefaultToolkit().createImage(getClass().getResource("tci icon.png"));
	
	public static void main(String[] args) {
		// m.rollCharacterStats(2);
		// CharacterSheet charSheet = new CharacterSheet();
		PullSpellInfo spellInfo = new PullSpellInfo();
		ArrayList<Spell> spellList = spellInfo.getSpellList();
		Main m = new Main();
	}
	
	public Main(){
		setupMainFrame();
		currentPanel = new BasicButtonPanel(this, ButtonUtility.basicButtonLabels);
		startMainFrame();
	}
	
	public void setupMainFrame(){
		mainFrame = new MyFrame("Character Sheet", 
				FrameUtility.WIDTH, FrameUtility.HEIGHT, 
				FrameUtility.X_LOCATION, FrameUtility.Y_LOCATION);
		//mainFrame.setIconImage(img);
		//startMainFrame();
	}
	
    public void startMainFrame(){
    	//currentPanel = mainPanel;
    	mainFrame.getContentPane().add(currentPanel);
    	mainFrame.revalidate();
    	mainFrame.setVisible(true);//set as false if access control is implemented
    }

	@Override
	public void panelReceived(PanelEvent e) {
		System.out.println("<<" + e.panel().getName());
		changeCurrentPanel(e.panel());
	}
	
	public void changeCurrentPanel(JPanel newPanel){
		mainFrame.getContentPane().removeAll();
		currentPanel = newPanel;
		mainFrame.getContentPane().add(currentPanel);
		
		if(currentPanel.getName() != null)
			mainFrame.setTitle(mainFrame.getProgramName() + " - " + currentPanel.getName());
		else
			mainFrame.setTitle(mainFrame.getProgramName());
		
		mainFrame.setStatus();
    	mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	
	// number of stats per set is 6
//	private void rollCharacterStats(int numberOfSets) {
//		ArrayList<int[]> statValues = new ArrayList<int[]>();
//		Dice dice = new Dice(6);
//
//		for (int i = 0; i < numberOfSets; i++) {
//			int[] characterRolls = new int[6];
//
//			for (int k = 0; k < 6; k++) {// 6 = number of stats per character
//				int[] oneSetOfRolls = new int[4];// 4 = 1 throw away
//
//				for (int j = 0; j < oneSetOfRolls.length; j++) {
//					dice.roll();
//					oneSetOfRolls[j] = dice.getValue();
//				}
//
//				characterRolls[k] = getSumRemoveLowest(oneSetOfRolls);
//			}
//
//			statValues.add(characterRolls);
//		}
//
//		// testing purposes
//		for (int i = 0; i < statValues.size(); i++) {
//			for (int j = 0; j < statValues.get(i).length; j++) {
//				System.out.print(statValues.get(i)[j] + " ");
//			}
//
//			System.out.println();
//		}
//	}
//
//	private int getSumRemoveLowest(int[] rolls) {
//		int sum = 0;
//		int lowest = 7;
//
//		for (int i = 0; i < rolls.length; i++) {
//			if (rolls[i] < lowest) {
//				lowest = rolls[i];
//			}
//
//			sum += rolls[i];
//		}
//
//		sum -= lowest;
//
//		return sum;
//	}
}
