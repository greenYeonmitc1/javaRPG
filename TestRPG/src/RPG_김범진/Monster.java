package RPG_김범진;

import java.util.ArrayList;

abstract public class Monster extends Unit implements Skill{
	
	public Monster(int hp, int mp, String name, int strength) {
		super(hp, mp, name, strength);
		// TODO Auto-generated constructor stub
		getMlist().add(this);
	}
	

	
	
}
