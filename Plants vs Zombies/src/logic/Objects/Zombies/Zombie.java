package logic.Objects.Zombies;
import logic.Objects.GameObject;

public abstract class Zombie extends GameObject{
	
	
	public abstract Zombie clone();
	public abstract Zombie parse(String zombieName);
	public Zombie(int CYCLES, int DAMAGE, int RESISTANCE,int FREQUENCY, String NAME,String SHORTNAME) {
		super(CYCLES,FREQUENCY, DAMAGE, RESISTANCE, NAME,SHORTNAME);
	}
	
	public void zombieMove() {
		posY = posY-1;
	}
	public boolean zombieWon() {
        return posY == 0;
    }
	public void update()
	{
		action(damage);
	}
	
	public void action(int DAMAGE) {
			if(canUpdate()&&!game.isPlantInPosition(posX, posY-1))
			{
				zombieMove();
			}
			if(game.isPlantInPosition(posX, posY-1)) {
				game.damagePlant(posX, posY-1, DAMAGE);
			}
	       increaseCycles();
	    }
	
	public String getInfo()
	{
		StringBuilder str = new StringBuilder();
		
			str.append(name + ": speed " + frequency
						+" Harm: " + damage
						+" Life: " + resistance + System.lineSeparator());
		
		return str.toString();
	}
	public void freeze()
	{
		setCycles(getCycles()-2);
	}
}
