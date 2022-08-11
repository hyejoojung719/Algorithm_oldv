package contents;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		// 입력값의 구분은 공백으로 함.
		System.setIn(new FileInputStream("src/test2/input.txt"));
		Scanner sc = new Scanner(System.in);
		/*
		// 문자열 입력
		String str = sc.next();
		System.out.println(str);
		
		// 숫자 입력
		int a = sc.nextInt();
		System.out.println(a);
		
		// 문자 입력
		char b = sc.next().charAt(0);
		System.out.println(b);
		
		// 한 줄 입력
		String str1 = sc.nextLine();
		System.out.println(str1);
		*/
		sc.close();
		
		
	}

}
