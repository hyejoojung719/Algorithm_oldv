package contents;

public class TypeCasting {
	public static void main(String[] args) {
		  
		//자동 형 변환(묵시적 형변환)
		int a = 'A';	//65
		System.out.println(a);
		
		int b = 'a';	//97
		System.out.println(b);
		
		int c = '0';	//48
		System.out.println(c);
		
		// 명시적 형변환
		int number = 260;
		
		byte number2 = (byte)number;
		System.out.println(number2); //비트의 범위를 벗어나서 아무 값이 나옴
	}
}
