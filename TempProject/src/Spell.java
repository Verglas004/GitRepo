public class Spell {
	private String name;
	private String description;
	private int pg;
	private int level;
	private String school;
	private String castingTime;
	private boolean ritual;
	private boolean v, s, m;
	private boolean concentration;
	private boolean bard, cleric, druid, paladin, ranger, sorcerer, warlock,
			wizard;

	// Name, Description, Page #, Level, School, Casting Time, Ritual, V, S, M,
	// Concentration, Bard, Cleric, Druid, Paladin, Ranger, Sorcerer,
	// Warlock, Wizard
	// 19 columns
	public Spell(String spellLine) {
		splitLine(spellLine);
	}

	public String[] spellInListForm(){
		String[] temp = {name, level+"", getClassAvailability(), description};		
		
		return temp;
	}
	
	public String getClassAvailability(){
		String temp = "";
		
		if(bard)
			temp += "Bard ";
		if(cleric)
			temp += "Cleric ";
		if(druid)
			temp += "Druid ";
		if(paladin)
			temp += "Paladin ";
		if(ranger)
			temp += "Ranger ";
		if(sorcerer)
			temp += "Socerer ";
		if(warlock)
			temp += "Warlock ";
		if(wizard)
			temp += "Wizard ";
		
		return temp;
	}
	
	public String toString() {
		return "\n\n" + name + "\n\n" + description;
	}

	public Spell(String name2, String description2, int pg2, int level2,
			String school2, String castingTime2, boolean ritual2, boolean v2,
			boolean s2, boolean m2, boolean concentration2, boolean bard2,
			boolean cleric2, boolean druid2, boolean paladin2, boolean ranger2,
			boolean sorcerer2, boolean warlock2, boolean wizard2) {
		setName(name2);
		setDescription(description2);
		setPg(pg2);
		setLevel(level2);
		setSchool(school2);
		setCastingTime(castingTime2);
		setRitual(ritual2);
		setV(v2);
		setS(s2);
		setM(m2);
		setConcentration(concentration2);
		setBard(bard2);
		setCleric(cleric2);
		setDruid(druid2);
		setPaladin(paladin2);
		setRanger(ranger2);
		setSorcerer(sorcerer2);
		setWarlock(warlock2);
		setWizard(wizard2);
	}

	// Spell Description School Time Range Comp Duration B Pg.
	// ? Druidcraft Small nature effect; predict weather, expedite small plant
	// growth, snuff light, harmless sensory effect Trans 1 a 30 ft V,S
	// Instantaneous P 236
	public void splitLine(String line) {
		line = line.replace("\t", "");
		System.out.println(line);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPg() {
		return pg;
	}

	public void setPg(int pg) {
		this.pg = pg;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCastingTime() {
		return castingTime;
	}

	public void setCastingTime(String castingTime) {
		this.castingTime = castingTime;
	}

	public boolean isRitual() {
		return ritual;
	}

	public void setRitual(boolean ritual) {
		this.ritual = ritual;
	}

	public boolean isS() {
		return s;
	}

	public void setS(boolean s) {
		this.s = s;
	}

	public boolean isM() {
		return m;
	}

	public void setM(boolean m) {
		this.m = m;
	}

	public boolean isV() {
		return v;
	}

	public void setV(boolean v) {
		this.v = v;
	}

	public boolean isConcentration() {
		return concentration;
	}

	public void setConcentration(boolean concentration) {
		this.concentration = concentration;
	}

	public String getComponents(){
		String temp = "";
		
		if(v)
			temp += " V";
		if(s)
			temp += " S";
		if(m)
			temp += " M";
		
		return temp;
	}
	
	public boolean isBard() {
		return bard;
	}

	public void setBard(boolean bard) {
		this.bard = bard;
	}

	public boolean isCleric() {
		return cleric;
	}

	public void setCleric(boolean cleric) {
		this.cleric = cleric;
	}

	public boolean isDruid() {
		return druid;
	}

	public void setDruid(boolean druid) {
		this.druid = druid;
	}

	public boolean isPaladin() {
		return paladin;
	}

	public void setPaladin(boolean paladin) {
		this.paladin = paladin;
	}

	public boolean isRanger() {
		return ranger;
	}

	public void setRanger(boolean ranger) {
		this.ranger = ranger;
	}

	public boolean isSorcerer() {
		return sorcerer;
	}

	public void setSorcerer(boolean sorcerer) {
		this.sorcerer = sorcerer;
	}

	public boolean isWarlock() {
		return warlock;
	}

	public void setWarlock(boolean warlock) {
		this.warlock = warlock;
	}

	public boolean isWizard() {
		return wizard;
	}

	public void setWizard(boolean wizard) {
		this.wizard = wizard;
	}
}
