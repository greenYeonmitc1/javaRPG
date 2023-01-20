package RPG_박일권;

import java.util.InputMismatchException;
import java.util.Scanner;

public class rpgController {
	
	rpgManager mg = rpgManager.getInstance();
	static Scanner sc ;
	String name = "\n========== RPG2단계 ==========";
	
	void init(){
		mg.init();
		sc = new Scanner(System.in);
	}

	void run() {
		init();
		while (true) {
			printstatus();
			printmap();
			printmainmenu();
			int sel = getVal("메뉴를 입력해주세요: ", 1, 2);
			if (sel == 3) {
				mg.healing();
			}
			mg.moveplayer(sel);
			if (mg.p.isDead()) {
				System.out.println("게임오버");
				break;
			}
		}
	} 
	
	void printmainmenu(){
		System.out.println("\n==============================");
		System.out.println("[1]전진 [2] 후진 [3] 물약먹기");
		
	}
	
	void printmap(){
		for (int i = 0; i < mg.arr.length; i++) {
			if (mg.arr[i] == 1) {
				System.out.printf("%-2s", "옷");
			}else if (mg.arr[i] == 2) {
				System.out.printf("%-2s", "ψ");
			}else {
				System.out.printf("%-2s", "▤");
			}

		}
	}
	
	void printstatus() {
		System.out.println(name);
		System.out.println("현재 플레이어의 직업 : " + mg.p.name);
		System.out.print("현재 체력 및 마나: ");
		System.out.println(mg.p.hp + " / " + mg.p.maxHP+ " /// "
				 + mg.p.mp + " / " + mg.p.maxMP);
		
	}
	
	static int getVal(String msg , int n , int m) {
		int sel = 0;
		try {
			System.out.println(msg);
			sel = sc.nextInt();
			if (sel < n || sel > m) {
				throw new Exception();
			}
			
		}catch (InputMismatchException e) {
			System.err.println("문자열은 입력될 수 없습니다.");
		}
		catch (Exception e) {
			System.err.println("입력범위 초과 에러");
		}
		sc.nextLine();
		return sel;
		
	}
	
	
	
	
	
}
