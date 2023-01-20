package RPG_박일권;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class rpgManager {
	
	player p;
	int idx = 0;
	int arr[] = new int [10];
	final int player = 1;
	final int mop = 2;
	ArrayList<Mop>monsterList = new ArrayList<Mop>();
	private static rpgManager instance = new rpgManager();
	
	public static rpgManager getInstance() {
		return instance;
	}
	
	void init(){
		  p =	selectClass();
		  arr[0] = player;
		  arr[2] = mop;
		  arr[4] = mop;
		  
		  monsterList.add(new 슬라임());
		  monsterList.add(new 드레이크());
		  monsterList.add(new 좀비());
		}
		
	//직업선택
	player selectClass() {
		Scanner sc = new Scanner(System.in);
		System.out.println("직업선택 : [1]마법사 [2]전사");
		int sel = sc.nextInt() - 1;
		if (sel == 1) {
			return new warrior();
		} else {
			return new wizard();
		}
	}

	//플레이어 이동
	void moveplayer(int num){
		
		int tx = p.index; 
			arr[tx] = 0;
		tx += num == 1 ? 1 : -1 ;
		if (tx < 0 || tx > arr.length - 1) {
			arr[p.index] = 1;
			return ;
		}

		if (arr[tx] == mop) {
			battle();
		}
		
		if (!p.isDead()) {
			arr[tx] = 1;
			p.index = tx ;
		}
	}	
	
	//포션먹기
	void healing(){
		int postion = 20;
		if (p.itemcnt == 0) {
			System.err.println("남은 포션이 없습니다.");
			return;
		}else {
			if (p.hp + postion > p.maxHP) {
				p.hp = p.maxHP;
				p.mp = p.maxMP;
			}else {
				p.hp += postion;
				p.mp += postion;
			}
		}
	}
	
	//전투돌입
	void battle(){
		boolean turn = true ; 
		Random rd = new Random();
		int random = rd.nextInt(monsterList.size());
		boolean ranboss = rd.nextBoolean();
		Mop m = monsterList.get(random);
		if (ranboss) {
			m.bossincoming();
		}
		System.out.printf("야생의 [ %s ]가 등장했다.\n" , m.name);
		
		while (true) {
			System.out.println(p.hp + "<=====");
			if (turn) {
				System.out.printf("[ %s ] : ",m.name + m.hp + " / " + m.maxHP);
				System.out.println("[1]공격 [2] 물약 먹기 [3]스킬사용");
				int sel = rpgController.getVal("메뉴입력 >>", 1, 3);
				
				if (sel == 3) {
					p.skill(m);
				}
				if (sel == 2) {
					healing();
				}else if(sel == 1){
					p.attackto(m);
				}
				
			}else {
				
				boolean flag = rd.nextBoolean();
				if (flag) {
					m.skill(p);
				} else {
					m.attackto(p);
				}
			}
			
			if (m.isDead() || p.isDead()) {
				if (m.boss) {
					System.out.println("보스를 물리쳤다 레벨 및 아이템 +1");
					p.itemcnt++;
					p.playerLevel ++;
					p.maxHP+=10;
					p.hp = p.maxHP;
					p.mp = p.maxMP;
				}
				break;
			}
			turn = turn == true ? false : true;

		}
	}
	
	
	
	
	
	
	
	
	
}
