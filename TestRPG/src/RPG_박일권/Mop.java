package RPG_박일권;

public abstract class Mop extends Unit{

	boolean boss;
	public Mop(int hp, int mp,int power ,String name) {
		super(hp, mp, power ,name);
	}

	void bossincoming(){
		boss = true;
		String temp = name;
		name = "(boss)"+temp;
		hp+= 50;
		maxHP = hp;
		power+=5;
	}
}
