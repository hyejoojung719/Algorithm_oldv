package contents;

public class SwitchCase {
	public static void main(String[] args) {
		int score = (int)(Math.random()*6)+1;
		
		// Math.random() : 0<= ? <1
		// 여기에 6을 곱하면 : 0<= ? <6 
		// 여기에 1을 더하면 : 1<= ? <7
		
		switch(score) {
		case 1 :
			System.out.println("1입니다.");
			break;
		case 2 : 
			System.out.println("2입니다.");
			break;
		case 3 :
			System.out.println("3입니다.");
			break;
		case 4 :
			System.out.println("4입니다.");
			break;
		case 5 :
			System.out.println("5입니다.");
			break;
		default :
			System.out.println("6입니다.");
			break;
		}
		
	}
}
