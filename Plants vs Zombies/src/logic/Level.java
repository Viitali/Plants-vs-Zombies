package logic;

import logic.Exceptions.ArgsException;

public enum Level {
    EASY(3,0.1), MEDIUM(5,0.2), HARD(10,0.3), BLITZ(3, 0.1);

	private int numberOfZombies;
	private double zombieFrequency;
	
	private Level(int zombieNum, double zombieFreq){

	numberOfZombies = zombieNum;
	zombieFrequency = zombieFreq;
	
	}
	private Level()
	{
		this.numberOfZombies=0;
		this.zombieFrequency=0;
	}
	public Level nextLevel(Level l)
	{
		if(l.name().equals("BLITZ"))
		{
			Level lv = Level.BLITZ;
			lv.numberOfZombies*=2;
			lv.zombieFrequency+=0.1;
			return lv.numberOfZombies>12 ? null : lv;
		}
		return null;
		
	}
	
	public int getNumberOfZombies() {
		return numberOfZombies;
	}
	public double getZombieFrequency() {
		return zombieFrequency;
	}
	public static Level parse(String inputString) throws ArgsException {
		for (Level level : Level. values() )
			if (level.name().equalsIgnoreCase(inputString)) return level;
		throw new ArgsException ("El nivel introducido es incorrecto");
	}
	public static String all (String separator) {
		StringBuilder sb = new StringBuilder();
		for (Level level : Level. values() )
			sb. append(level.name() + separator);
		String allLevels = sb.toString();
		return allLevels.substring(0, allLevels.length()-separator.length());
	}
	public Level copy()
	{
		Level l=null;
		try {
			l = Level.parse(this.name());
			l.zombieFrequency = this.zombieFrequency;
			l.numberOfZombies = this.numberOfZombies;
			
			return l;
		} catch (ArgsException e) {
			e.printStackTrace();
		}
		return l;
		
	}
}
