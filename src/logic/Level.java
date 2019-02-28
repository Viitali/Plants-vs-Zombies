package logic;

import logic.Exceptions.ArgsException;

public enum Level {
    EASY(3,0.1), MEDIUM(5,0.2), HARD(10,0.3);

	private int numberOfZombies;
	private double zombieFrequency;
	
	private Level(int zombieNum, double zombieFreq){

	numberOfZombies = zombieNum;
	zombieFrequency = zombieFreq;
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
}
