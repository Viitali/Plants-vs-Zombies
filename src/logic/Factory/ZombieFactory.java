package logic.Factory;

import java.util.Random;
import logic.Objects.Zombies.Zombie;
import logic.Objects.Zombies.ZombieCaracubo;
import logic.Objects.Zombies.ZombieComun;
import logic.Objects.Zombies.ZombieDeportista;


public class ZombieFactory {
	private static Zombie[] availableZombies = {
			new ZombieComun(),
			new ZombieCaracubo(),
			new ZombieDeportista(),
	};
	public static Zombie getZombie() {
		int zombie = new Random().nextInt(availableZombies.length);
		return availableZombies[zombie].clone();
	}
    public static Zombie getZombie(String zombieName){
		
		for(Zombie zombie : availableZombies)
		{
			if(zombie.parse(zombieName)!=null)
			{
				return zombie.clone();
			}
		}
		return null;
	}
	public static String infoAvailableZombies()
	{
		StringBuilder str = new StringBuilder();
		for(Zombie zombie : availableZombies)
		{
			str.append(zombie.getInfo());
		}
		return str.toString();
	}
	
}
