package RPG_박일권;

public class 좀비 extends Mop{

	public 좀비() {
		super(45, 20, 12, "좀비");
	}


	@Override
	void skill(Unit u) {
		System.out.println("물어뜯기");
		hp += 5;
		u.hp -= 20;
	}

}
