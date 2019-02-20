package logic.Factory;
import logic.Objects.Plants.Nuez;
import logic.Objects.Plants.Peashooter;
import logic.Objects.Plants.Petacereza;
import logic.Objects.Plants.Plant;
import logic.Objects.Plants.PotatoMine;
import logic.Objects.Plants.SnowPeashooter;
import logic.Objects.Plants.Sunflower;

public class PlantFactory {

	private static Plant[] availablePlants = {
			new Nuez(),
			new Peashooter(),
			new Petacereza(),
			new Sunflower(),
			new SnowPeashooter(),
			new PotatoMine(),
	};
	public static Plant getPlant(String plantName){
		
		for(Plant plant : availablePlants)
		{
			if(plant.parse(plantName)!=null)
			{
				return plant.clone();
			}
		}
		return null;
	}
	public static String infoAvaiablePlants()
	{
		StringBuilder str = new StringBuilder();
		for(Plant plant : availablePlants)
		{
			str.append(plant.getInfo());
		}
		return str.toString();
	}
}
