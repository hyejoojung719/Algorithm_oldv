package etc.learn0727.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamTest01 {
	public static void main(String[] args) {
		
		
		List<Member> list = Arrays.asList(
				new Member("손흥민", "32"),
				new Member("김연아", "20"),
				new Member("김은빈", "32"),
				new Member("손연재", "23"),
				new Member("박태환", "45"),
				new Member("최수종", "45")
				);
		System.out.println(list);
		
		//list 자료 중 이름만 출력
		
		list.stream()
		.map(member -> member.getName())
		.forEach(member->System.out.println(member));
		
		System.out.println("이름에 김이 포함된 사람");
		list.stream()
		.map(member -> member.getName())
		.filter(name -> name.contains("김"))
		.forEach(member->System.out.println(member));
		
		// 중간 처리 메소드
		// 필터링
		
		// 매핑
		
		// 정렬
		
		// 중복 제거
		
		//루핑
		
		
		//---------------------------------------------------
		
		
		// 최종 처리 메소드
		// 값의 존재 여부 체크
		
		// 집계
		
		// 루핑
		IntStream ist = IntStream.rangeClosed(0,10); // range는 마지막 값 포함 x, rangeclosed는 마지막 값 포함O
		ist.filter(m ->  m%2==0)
		//.forEach(el->System.out.println(el));
		.forEach(System.out::println); // 매개변수 생략해서 사용 가능
		
		IntStream ist2 = IntStream.rangeClosed(0, 10);
		int sum = ist2
		.filter(m -> m%2 == 0)
		.sum();
		
		System.out.println("0~10까지 짝수의 총합 : " + sum);
		
		// 11보다 큰값이 하나라도 존재하는 지 체크
		IntStream ist3 = IntStream.rangeClosed(0, 10);
		boolean isLargeEleven = ist3.anyMatch(m->m>11);
		System.out.println(isLargeEleven);
		
		//IntStream으로 배열 생성
		int[] arr = IntStream.rangeClosed(1, 10)
				.filter(m->m%3!=0) // 3의 배수만 빼기
				.toArray();
		System.out.println("int배열 생성 "+Arrays.toString(arr));
		
		
		
		
	}
}
