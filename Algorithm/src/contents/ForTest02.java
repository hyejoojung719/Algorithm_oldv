package contents;

public class ForTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 2단 출력하기 
		/*
		System.out.println("2단====");
		
		int num = 2;
		for(int i=1; i<10; i++) {
			System.out.println(num + " X " + i + " = " + (num*i));
		}*/
		
		// 구구단 출력
		/*
		for(int i=1; i<=9; i++) {
			System.out.println("======"+i+"단======");
			for(int j=1; j<=9; j++) {
				System.out.println(i+" X "+j+" = "+(i*j));
			}
		}
		*/
		
		// 3X + 5Y = 60
		// X,Y는 자연수이고, 20이하
		// 위 방정식의 해를 모두 출력
		for(int x=1; x<=20; x++) {
			for(int y=1; y<=20; y++) {
				if((3*x+5*y)==60) System.out.println("("+x+", "+y+")");
			}
		}
	}

}
