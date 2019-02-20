package logic.Objects.Plants;

import logic.Objects.GameObject;

public abstract class Plant extends GameObject {

	private int cost;
	//public abstract Plant parse(String plantName);
	public abstract Plant clone();
	public Plant (int COST, int CYCLES, int FREQUENCY, int DAMAGE, int RESISTANCE, String NAME, String SHORTNAME)
	{
		super(CYCLES,FREQUENCY,DAMAGE,RESISTANCE,NAME,SHORTNAME);
		this.cost = COST;
	}
	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public String getInfo() {
		StringBuilder str = new StringBuilder();
		{
			str.append(name + ": Cost: " + cost
						+ " suncoins  Harm: " + damage + System.lineSeparator());
		}
		return str.toString();
	}
	 public Plant parse(String plantName) {
			if(plantName.equalsIgnoreCase(this.shortname) || plantName.equalsIgnoreCase(name))
				return this;
			else
				return null;
		}
	 public void freeze() {
			// TODO Auto-generated method stub
			
		}

	
	
}
