package etc.learn0727.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

		public static void main(String[] args) {
			
			List<String> list = Arrays.asList("A", "B", "C", "D");
			
			// C값이 존재하면 true 출력
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).equals("C")) {
					System.out.println(true);
				}
			}
			
			
			Stream<String> stream = list.stream();
//			stream.forEach(m->System.out.println(m));
//			stream.filter(m->m.equals("C")).forEach(System.out::println);
			
//			stream.forEach(m->System.out.println(m)); // 스트림이 이미 사용 됐다고 중복해서 쓸 수 없음
			// stream은 한 번만 사용 가능
			
			//stream
			//.filter(m->m.equals("C")) // 중간처리
			//.forEach(m->System.out.println(m)); // 최종처리
			// 스트림으로 뭘 하든 간에 원본값은 바뀌지 않는다.
			
			// 만약 중간 처리 메소드만 사용 할 경우 최종 처리 멤소드 실행 전까지는 아무 연산도 수행x, 따라서 최종 처리 메소드 추가
			stream.filter(m->{
				System.out.println(m);
				return m.equals("C");
			})
			.forEach(m->System.out.println(m));
			
			System.out.println(list);
			
			
			
			
		}
}
