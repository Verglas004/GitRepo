import java.util.ArrayList;

abstract class DatabaseLoadup {
	public static PullSpellInfo spellInfo = new PullSpellInfo();
	public static ArrayList<Spell> spellList = spellInfo.getSpellList();
}
