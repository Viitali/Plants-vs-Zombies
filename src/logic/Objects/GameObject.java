package logic.Objects;

import logic.Game;

public abstract class GameObject {
	protected int cycles;
	protected int frequency;
	protected int damage;
	protected int resistance;
	protected String shortname;
	protected String name;
	protected int posX;
	protected int posY;
	protected Game game;
	
	public GameObject(int CYCLES,int FREQUENCY, int DAMAGE,int RESISTANCE,String NAME,String SHORTNAME)
	{
		this.cycles=CYCLES;
		this.damage=DAMAGE;
		this.resistance=RESISTANCE;
		this.shortname=SHORTNAME;
		this.name=NAME;
		this.frequency = FREQUENCY;
	}
	public abstract void update();
	public abstract String getInfo();
	
	public GameObject loadObject(String ShortName,int resis, int x, int y, int cycles)
	{
		this.cycles=cycles;
		this.shortname=ShortName;
		this.resistance=resis;
		this.posX=x;
		this.posY=y;
		return this;
	}
	
	public int getCycles() {
		return cycles;
	}
	public void setCycles(int cycles) {
		this.cycles = cycles;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public String getObjectName() {
		return name;
	}
	public int getFrequency() {
		return frequency;
	}
	public int getDamage() {
		return damage;
	}
	
	public boolean canUpdate() {
		return (cycles == frequency-1);
	}
	
	public void increaseCycles(){
		cycles = (cycles + 1)%frequency;
	}
	
	public boolean isAlive() {
		return resistance>0;
	}
	public String toString()
	{
		return shortname+"[" + resistance + "]";
	}
	
	public String debugString() {
		return shortname +"[l:" + resistance + ",x:" + posX +",y:"+ posY +",t:"+
	(frequency - cycles)+"]";
	}
	public String writeString()
	{
		return shortname + ":" + resistance +":"+posX+":"+posY+":"+(frequency-cycles);
	}
	
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public int getResistance() {
		return resistance;
	}
	public void setResistance(int resistance) {
		this.resistance = resistance;
	}
	public void damageObject(int damage) {
		resistance = resistance - damage;
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
}
