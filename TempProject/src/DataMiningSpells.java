

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;


public class DataMiningSpells
{
    public URL filepath = this.getClass().getResource("Complete Spells.pdf");
    private ArrayList<String> pdf = new ArrayList<String>();
    
    public DataMiningSpells(){
	extractFromPdfToString();
	processPDF(pdf);
	parseTxt(pdf);
    }
    
    private void parseTxt(ArrayList<String> myLine){
	
    }
    
    private void extractFromPdfToString(){
	PdfReader reader;
	String temp = "";
	
        try {
	    reader = new PdfReader(filepath); 
	    int n = reader.getNumberOfPages();
	    System.out.println("Number of Lines in pdf: " + n);
	    TestStrategy customStrategy = new TestStrategy();
	    for(int i = 1; i <= n; i++){
		//temp = PdfTextExtractor.getTextFromPage(reader, i, customStrategy);
		temp = PdfTextExtractor.getTextFromPage(reader, i);
		//System.out.println(temp);
		pdf.add(temp);
		//Witch Bolt - Each turn you can use your action to deal 1d12 lightning damage to the target automatically
		//spell ends if target is out of range. use your action to do anything else, has cover from you
	    }
        } catch ( IOException e ) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
        }
    }
    
    private void processPDF(ArrayList<String> s){
	for(int i = 0; i < s.size(); i++){
	    processPage(s.get(i));
	    //System.out.println(s.get(i));
	}
    }
    
    private void processPage(String page){
	BufferedReader bufReader = new BufferedReader(new StringReader(page));
	String line = null;
	
	try {
	    while((line=bufReader.readLine()) != null){
		checkLine(line);
	        //System.out.println(line);
	    }
        } catch ( IOException e ) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
        }
    }
    
    ArrayList<CharacterClass> characterClass = new ArrayList<CharacterClass>();
    CharacterClass temp;
    String characterClassName = "";
    boolean cantrip;
    int level;
    //doing the brunt of the work
    private void checkLine(String line){
	if(line.contains("Spellcasting Class: ")){
	    characterClassName = line.replace("Spellcasting Class: ", "");
	    System.out.println(characterClass);
	    temp = new CharacterClass(characterClassName);
	    cantrip = false;
	    level = -1;
	} else if(line.contains(" Cantrips")){
	    cantrip=true;
	    level = 0;
	    System.out.println(level);
	} else if(line.contains(" Level") && !line.contains("Spell")){
	    level = Integer.parseInt(line.replace("Level", "").replaceAll(" ", ""));
	    System.out.println(level);
	} else if(line.contains(" P ")){//TODO can't get this character
	    processSpell(line);
	}
    }
    
    //example
    //? Acid Splash 1 crea or 2 crea within 5 ft of each other Dex save or 1d6 Acid dmg; CL5:2d6, CL11:3d6, CL17:4d6 Conj 1 a 60 ft V,S Instantaneous P 211
    private void processSpell(String line){
	Spell spell = new Spell(line);
	//System.out.println("\t" + line);
    }
}