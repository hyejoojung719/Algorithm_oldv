package Algo;
import java.util.Scanner;

public class Main_Jungol_124�������_������5_���� {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int input = s.nextInt();

		if(input==2) System.out.println("28");
		else if(input==4 || input==6 || input==9 || input==11) System.out.println("30");
		else System.out.println("31");
	}
}
