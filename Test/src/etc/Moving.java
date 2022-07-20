package etc;

import java.util.Scanner;

public class Moving {
	public static void main(String[] args) {

		// X * Y
		// 두 자리 자연수가 적혀있다. ( 방향  이동칸수 ) 
		// 참가비 1000원
		// 시작 좌표 , 이동 횟수 부여받음

		// 이동 좌표에 적혀진 숫자 * 100 = 상금
		// 경계 넘어가면 상금 X
		// 상금의 합?

		Scanner sc = new Scanner(System.in);

		int test_case = sc.nextInt();

		for(int tc=1; tc<=test_case; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int p = sc.nextInt();

			int[][] map = new int[x][y];

			int money = (-1000)*p;

			// map 입력 받기
			for(int i=0; i<x; i++) {
				for(int j=0; j<y; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 시작 좌표, 이동 횟수 
			for(int i=0; i<p; i++) {
				int px = sc.nextInt()-1;
				int py = sc.nextInt()-1;
				int mov = sc.nextInt();

				int pos = map[px][py];
				

				boolean check = false;

				for(int j=0; j<mov; j++) {
					// 10의 자리 -> /10 -> 방향
					int dir = pos/10;
					switch(dir) {
					case 1:
						// 위
						if(px-(pos%10) >= 0) {
							px = px-(pos%10);
							pos = map[px][py];
							check = true;
						}else {
							check = false;
						}
						break;
					case 2:
						// 우위
						if(px-(pos%10) >= 0 && py+(pos%10) <y) {
							px = px-(pos%10);
							py = py+(pos%10);
							pos = map[px][py];
							check = true;
						}else {
							check = false;
						}
						break;
					case 3: 
						// 우 
						if(py+(pos%10) < y) {
							py = py+(pos%10);
							pos = map[px][py];
							check = true;
						}else {
							check = false;
						}
						break;
					case 4:
						// 우아래
						if(px+(pos%10) < x && py+(pos%10) <y) {
							px = px+(pos%10);
							py = py+(pos%10);
							pos = map[px][py];
							check = true;
						}else {
							check = false;
						}
						break;
					case 5:
						// 아래
						if(px+(pos%10) < x) {
							px = px+(pos%10);
							pos = map[px][py];
							check = true;
						}else {
							check = false;
						}
						break;
					case 6:
						// 좌아래
						if(px+(pos%10) < x && py-(pos%10) >= 0) {
							px = px+(pos%10);
							py = py-(pos%10);
							pos = map[px][py];
							check = true;
						}else {
							check = false;
						}
						break;
					case 7:
						// 좌
						if(py-(pos%10) >= 0) {
							py = py-(pos%10);
							pos = map[px][py];
							check = true;
						}else {
							check = false;
						}
						break;
					default:
						// 좌위
						if(px-(pos%10) >= 0 && py-(pos%10) >= 0) {
							px = px-(pos%10);
							py = py-(pos%10);
							pos = map[px][py];
							check = true;
						}else {
							check = false;
						}
						break;
					}
				}

				if(check) {
					money += map[px][py]*100;
				}

			}
			
			System.out.println("#"+tc+" "+money);
		}
	}
}
