package RPG_박일권;

public class wizard extends player{

	final int consumeMp = 28;
	
	public wizard() {
		super(50, 50, 5 ,"마법사");
	}

	@Override
	void skill(Unit u) {
		if (this.mp - consumeMp <= 0) {
			System.err.println("마나가 부족합니다.");
		}else {
			System.out.println("얼리기 스킬");
			mp-=consumeMp;
			u.hp -= 45;
		}
	}

}
