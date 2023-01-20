package RPG_박일권;

public class 드레이크 extends Mop{

	public 드레이크() {
		super(50, 10, 10, "드레이크");
	}

	@Override
	void skill(Unit u) {
		System.out.println("불뿜기");
		u.hp -= 20;
	}

	
}
