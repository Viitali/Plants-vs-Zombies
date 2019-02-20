package logic;

import logic.Lists.GameObjectList;

public class GameHistory {
	private GameObjectList plantsList;
	private GameObjectList zombieList;
	private int cycles;
	private int remainingZombies;
	private int suncoins;
	private Level level;
	
	public GameHistory(GameObjectList plantsList, GameObjectList zombieList, int cycles,
			int remainingZombies, int suncoins, Level level) {
		this.plantsList = plantsList;
		this.zombieList = zombieList;
		this.cycles = cycles;
		this.remainingZombies = remainingZombies;
		this.suncoins = suncoins;
		this.level = level;
	}


	public GameObjectList getPlantsList() {
		return plantsList;
	}

	public GameObjectList getZombieList() {
		return zombieList;
	}

	public int getCycles() {
		return cycles;
	}

	public int getRemainingZombies() {
		return remainingZombies;
	}

	public int getSuncoins() {
		return suncoins;
	}

	public Level getLevel() {
		return level;
	}
}
