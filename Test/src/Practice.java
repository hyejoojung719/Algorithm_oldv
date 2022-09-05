
public class Practice {
	public static void main(String[] args) {
		// 공의 위치만 input으로 받고(수구, 목적구, 홀위치..?)
		// 수구에게 줄 방향과 힘을 아웃풋으로 주는 게임

		// 아래 코드를 수정해서 시뮬 돌리기
		// angle, power변수는 명칭 변경 X
		float angle, power;
		// 결국 angle과 power를 계산한다....으음..
		
		// 즉, 거리(power)와 각도를 계산해야함
		// 거리 = Math.sqrt((x좌표거리제곱)+(y좌표거리제곱));
		// 각도 = tan - height/width = atan -> 흰공이 나가는 방향이라고 생각 
			//(Math.atan2(width, height))*180/Math.PI -> 어차피 공식 주어짐
		// 공 배열에 좌표들이 계속 넣어질 것
		// 흰공의 좌표는 0번쨰
		// 나머지는 1부터 시작(2차원 배열에서 첫번째 요소 기준)
		
		// 변수 체크하기
			// 방해구
			// 직선의 방정식 (y-y1) = (y2-y1 / x2-x1)(x-x1); -> 이걸 이용해서 기울기a, 절편 b를 구함
			// 점과 직선 사이의 거리 Math.abs(ax1+by1+c)/Math.sqrt(a*a+b*b)-r >= r 일때만 방해구 없는 루트임
		
		float[][] balls = new float[255][128];
		// 흰 공의 x좌표, y좌표
		float whiteBall_x = balls[0][0];
		float whiteBall_y = balls[0][1];
		// 목적구의 x좌표, y좌표
		float targetBall_x = balls[1][0];
		float targetBall_y = balls[1][1];
		
		// width, height : 목적구와 흰 공의 x좌표 간의 거리, y좌표 간의 거리
		float width = Math.abs(targetBall_x - whiteBall_x);
		float height = Math.abs(targetBall_y - whiteBall_y);
		
		// 목적구가 흰 공의 우측 일직선 상에  위치 했을 때
		if(whiteBall_y == targetBall_y && whiteBall_x < targetBall_x) {
			angle = 90;
		}

		// distance : 두 점(좌표) 사이의 거리 계산
		double distance = Math.sqrt((width*width)+(height*height));
		
		// power : 거리 distance에 따른 힘의 세기 계산
		power = (float)distance;


		int white_x = 0;
		int white_y = 0;
		
		int target_x = 250;
		int target_y = 120;
		
		int xdis = Math.abs(white_x-target_x);
		int ydis = Math.abs(white_y-target_y);
		
		System.out.println((Math.atan2(xdis, ydis))*180/Math.PI);

	}
}
