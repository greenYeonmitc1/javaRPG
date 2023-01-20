package RPG_김범진;

import java.util.Random;
import java.util.Scanner;

public class Game {
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	final int BOSS = 9;
	final int MONSTER = 8;
	final int SIZE = 10;
	int map[];

	Player p = new Player();

	boolean win;

	void init() {
		map = new int[SIZE];
		win = true;
		map[3] = MONSTER;
		map[5] = MONSTER;
		map[7] = MONSTER;
		map[SIZE - 1] = BOSS;
		Player p1 = new Mage();
		Player p2 = new Healer();
//		Monster m1 = new Bat();
//		Monster m2 = new Wolf();

	}

	void monInit() {
		Unit.getMlist().clear();
		Monster m1 = new Bat();
		Monster m2 = new Wolf();
		Monster m3 = new Zombie();
		
	}

	void printMap() {
		for (int i = 0; i < map.length; i++) {
			if (i == p.position) {
				System.out.print("[■]");
			} else if (map[i] == MONSTER) {
				System.out.print("[M]");
			} else if (map[i] == BOSS) {
				System.out.print("[B]");
			} else {
				System.out.print("[ ]");
			}
		}
		System.out.println();
	}

	int menu() {
		System.out.println("[0]종료[1]한칸이동[2]현재상태");
		int num = sc.nextInt();
		if (num <= 0 || num > 2) {
			return 0;
		} else {
			return num;
		}
	}

//	Player getValue(String msg) {
//		int val=-1;
//		while (true) {
//			System.out.println(msg);
//			val = sc.nextInt();
//			if (val < 0 || val > Unit.getPlist().size() - 1) {
//				System.err.println("대상선택오류");
//				continue;
//			}
//			if(val == 0) {
//				
//			}
//		}
//	}
	/** 몬스터 랜덤생성 */
	Monster creM() {
		monInit();
		int idx = rd.nextInt(Unit.getMlist().size());
//		System.out.println("\n" + Unit.getMlist().get(idx).name + " 출현 !");
//		System.out.println(Unit.getMlist().get(idx) + "\n");
		return Unit.getMlist().get(idx);
	}
	/** 보스 랜덤생성 */
	Monster creB(Monster m) {
		m.name = " ★ 보스 " + m.name;
		if(m instanceof Bat) {
			m.hp +=20;
			m.mp +=20;
			m.max_hp = m.hp;
			m.max_mp = m.mp;
			m.strength += 10;
		} else if(m instanceof Wolf) {
			m.hp +=10;
			m.mp +=10;
			m.max_hp = m.hp;
			m.max_mp = m.mp;
			m.strength += 5;
		} else {
			m.hp +=30;
			m.strength += 10;
		}
		return m;
		
	}

	void battle(Monster mm) {
		//Monster mm = creM();		
//		monInit();
//		System.out.println(Unit.getMlist());
//		System.out.println(Unit.getPlist());
//		int idx = rd.nextInt(Unit.getMlist().size());
//		System.out.println(Unit.getMlist().get(idx).name + " 출현 !");
//		System.out.println(Unit.getMlist().get(idx));
		System.out.println("\n" + mm.name + " 출현 !");
		System.out.println(mm + "\n");
		boolean turn = true;
		while (true) {
			if (turn) {
				System.out.println("[플레이어 차례]");
				System.out.println(p.getPlist());
				for (int i = 0; i < Unit.getPlist().size(); i++) {
					System.out.println(Unit.getPlist().get(i).name + " 행동");
					if (Unit.getPlist().get(i).hp <= 0) {
						System.out.println("죽음, 행동불능\n");
					} else {
						System.out.println("[1]공격 [2]스킬");
						int sel = sc.nextInt();
						if (sel == 1) {
							Unit.getPlist().get(i).attack(mm);
						} else if (sel == 2) {
							if (Unit.getPlist().get(i) instanceof Mage) {
								Unit.getPlist().get(i).hitSkill(mm);
								// Unit.getPlist().get(i).buffSkill();
								// Unit.getPlist().get(i).healSkill(p);
							}
							if (Unit.getPlist().get(i) instanceof Healer) {
								// Unit.getPlist().get(i).hitSkill(Unit.getMlist().get(idx));
								// Unit.getPlist().get(i).buffSkill();
								System.out.println("스킬 대상 선택");
								System.out.println("[0]마법사 [1]힐러");
								int sel2 = sc.nextInt();
								Unit.getPlist().get(i).healSkill(Unit.getPlist().get(sel2));
							}
						}
					}
				}

				/////////
//				System.out.println(Unit.getPlist().get(0).name + " 행동");
//				if (Unit.getPlist().get(0).hp <= 0) {
//					System.out.println("죽음, 행동불능");
//				} else {
//					System.out.println("[1]공격 [2]스킬");
//					int sel = sc.nextInt();
//					if (sel == 1) {
//						Unit.getPlist().get(0).attack(Unit.getMlist().get(idx));
//					} else if (sel == 2) {
//						Unit.getPlist().get(0).hitSkill(Unit.getMlist().get(idx));
//					} else {
//						System.out.println("입력오류");
//						continue;
//					}
//				}
//				System.out.println(Unit.getPlist().get(1).name + " 행동");
//				if (Unit.getPlist().get(1).hp <= 0) {
//					System.out.println("죽음, 행동불능");
//				} else {
//					System.out.println("[1]공격 [2]스킬");
//
//					int sel = sc.nextInt();
//					if (sel == 1) {
//						Unit.getPlist().get(1).attack(Unit.getMlist().get(idx));
//					} else if (sel == 2) {
//						System.out.println("스킬 대상 선택");
//						System.out.println("[1]마법사 [2]힐러");
//						sel = sc.nextInt();
//						if (sel == 1) {
//							Unit.getPlist().get(1).healSkill(Unit.getPlist().get(0));
//						} else if (sel == 2) {
//							Unit.getPlist().get(1).healSkill(Unit.getPlist().get(1));
//						} else {
//							System.out.println("입력오류");
//							continue;
//						}
//					} else {
//						System.out.println("입력오류");
//						continue;
//					}
//				}
				if (mm.isDead()) {
					System.out.println("몬스터전멸, 전투 승리\n");
					map[p.position] = 0;
					// monInit();
					return;
				}

			} else {
				System.out.println("[몬스터 차례]");
				int mIdx = rd.nextInt(2);
				int pIdx = rd.nextInt(2);
				if (mIdx == 0) {
					mm.attack(Unit.getPlist().get(pIdx));
				} else if (mIdx == 1) {
					mm.hitSkill(Unit.getPlist().get(pIdx));
					mm.buffSkill();
					mm.healSkill(mm);
				}
				if (Unit.getPlist().get(0).isDead() && Unit.getPlist().get(1).isDead()) {
					System.out.println("플레이어전멸, 전투 패배");
					map[p.position] = 0;
					win = false;
					return;
				}
			}
			turn = !turn;
		}
	}

	void run() {
		init();
		while (true) {
			if (win == false) {
				System.out.println("게임 끝");
				return;
			}

			printMap();
			int sel = menu();
			if (sel == 0) {
				System.out.println("종료");
				return;
			} else if (sel == 1) {
				if (p.position < SIZE - 1) {
					p.position++;
				}
			} else {
				System.out.println(p.getPlist() + "\n");
			}
			if (map[p.position] == MONSTER) {
				battle(creM());
			}
			if (map[p.position] == BOSS) {
				battle(creB(creM()));
				if(win == true ) {
					System.out.println("보스 토벌 성공 , 게임 승리 !");
					return;
				}
			}
		}

	}

}
