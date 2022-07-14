
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
		for(int i=1; i<=9; i++) {
			System.out.println("======"+i+"단======");
			for(int j=1; j<=9; j++) {
				System.out.println(i+" X "+j+" = "+(i*j));
			}
		}
	}

}
