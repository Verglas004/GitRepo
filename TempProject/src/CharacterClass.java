import java.util.ArrayList;


public class CharacterClass
{
    private String classname;
    private ArrayList<ArrayList<Spell>> spellList = new ArrayList<ArrayList<Spell>>();
    
    public CharacterClass(String name){
	classname = name;
    }
    
    public String getClassname() {
	return classname;
    }
    
    public void setClassname(String classname) {
	this.classname = classname;
    }

    public ArrayList<Spell> getSpellListByLevel(int level) {
	if(spellList.size() > (level-1) && (level - 1) >= 0)
	    return spellList.get(level);
	
	return null;
    }
    
    public ArrayList<ArrayList<Spell>> getSpellList() {
	return spellList;
    }
    
    public void addAtSpellList(int num, Spell spell){
	spellList.get(num).add(spell);
    }
}