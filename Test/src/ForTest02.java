
public class ForTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 2�� ����ϱ�
		
		/*
		System.out.println("2��====");
		
		int num = 2;
		for(int i=1; i<10; i++) {
			System.out.println(num + " X " + i + " = " + (num*i));
		}*/
		
		// ������ ���
		for(int i=1; i<=9; i++) {
			System.out.println("======"+i+"��======");
			for(int j=1; j<=9; j++) {
				System.out.println(i+" X "+j+" = "+(i*j));
			}
		}
	}

}
