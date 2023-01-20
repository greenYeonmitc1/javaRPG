package RPG_박일권;

public class 슬라임 extends Mop{

	public 슬라임() {
		super(20, 10, 5, "슬라임");
	}

	@Override
	void skill(Unit u) {
		System.out.println("깔아뭉개기");
		u.hp -= 10;
		
	}
}
