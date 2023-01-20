package RPG_박일권;

public abstract class Unit {

	int hp;
	int mp;
	int power;
	int maxHP;
	final int maxMP;
	
	String name;
	
	public Unit(int hp, int mp, int power ,String name) {
		super();
		this.hp = hp;
		this.mp = mp;
		this.power = power;
		this.maxHP = hp;
		this.maxMP = mp;
		this.name = name;
	}

	abstract void skill(Unit u);

	void attackto(Unit u) {
		System.out.printf("\n[%s] 가 [%s]에게 공격하여 [%d] 만큼의 데미지를 줬습니다.\n" , 
				this.name ,u.name,this.power);
		u.hp-=power;
	}
	
	boolean isDead(){
		if (hp <= 0) {
			return true;
		}
		return false;
	}
	
}
