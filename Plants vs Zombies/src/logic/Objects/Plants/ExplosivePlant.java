package logic.Objects.Plants;

public abstract class ExplosivePlant extends Plant{

	public ExplosivePlant(int COST, int CYCLES, int FREQUENCY, int DAMAGE, int RESISTANCE, String NAME,
			String SHORTNAME) {
		super(COST, CYCLES, FREQUENCY, DAMAGE, RESISTANCE, NAME, SHORTNAME);
		// TODO Auto-generated constructor stub
	}

	public void update() {
			for (int i = posX - 1;i<=(posX + 1);i++) {
				for (int j = posY - 1;j <= (posY + 1);j++) {
					game.damageZombie(i, j, damage);
					}
	    		}
			resistance=0;
		
	}
}
