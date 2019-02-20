package logic.Objects.Plants;

import logic.Game;

public class Peashooter extends ShooterPlant{
    public final static int COST= 50;
	public final static int CYCLES = 0;
	public final static int DAMAGE = 1;
	public final static int FREQUENCY = 1;
	public final static int RESISTANCE = 3;
	public final static String NAME = "[P]eashooter";
	public final static String SHORT_NAME = "P";

    public Peashooter() {
    	super(COST,CYCLES,FREQUENCY,DAMAGE,RESISTANCE,NAME,SHORT_NAME);
    }

    public void update() {
    	if(canUpdate()) {
    	//game.findAndDamageZombieInLine(posX, posY,DAMAGE);
    	for(int i=posY+1;i<Game.getROWS();i++)
    		if(game.damageZombie(posX, i ,damage)) 
    			break;
    	}
    	increaseCycles();
    }

	public Plant clone() {
		Plant n= new Peashooter();
		return n;
	}

	@Override
	protected void attack(int posX, int i) {
		game.damageZombie(posX, i, damage);
	}

}