
public class OperatorTest03 {
	public static void main(String[] args) {
		int num = 10;
		
		++num; 	// num ���� �� �ٸ� ���� ����
		num++;	// �ٸ� ���� ���� �� num�� ����
		
		
		// &�̶� &&����
		// && : ���ʺ��� �Ǵ�(������ false�� &&�ڿ��� ����x)
		if(num < 10 && num++ > 5) {
			System.out.println(" ������ true ");
		}
		System.out.println(num);
	}
}
