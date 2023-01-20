package RPG_박일권;

public class warrior extends player{

	final int consumeMp = 10;
	
	public warrior() {
		super(100, 30, 8 ,"전사");
	}

	@Override
	void skill(Unit u) {
		if (this.mp - consumeMp <= 0) {
			System.err.println("마나가 부족합니다.");
		}else {
			System.out.println("강하게 베기");
			mp -= consumeMp;
			u.hp -= 25;
		}
		
	}

}
