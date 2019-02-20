package logic.Objects.Plants;

import logic.Game;

public abstract class ShooterPlant extends Plant{

	public ShooterPlant(int COST, int CYCLES, int FREQUENCY, int DAMAGE, int RESISTANCE, String NAME,
			String SHORTNAME) {
		super(COST, CYCLES, FREQUENCY, DAMAGE, RESISTANCE, NAME, SHORTNAME);
		// TODO Auto-generated constructor stub
	}

	protected abstract void attack(int posX, int i);
	public void update() {
    	if(canUpdate()) {
    	for(int i=posY+1;i<Game.getROWS();i++)
    		if(game.isZombieInPosition(posX, i))
    		{
    			attack(posX,i);
    			break;
    		}
    			
    	}
    	increaseCycles();
    }

	
}
