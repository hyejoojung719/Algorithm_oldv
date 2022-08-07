package com.ssafy.corona.app;

import java.io.Serializable;
import java.util.*;
import com.ssafy.corona.virus.*;

public class MainTest {
	public static void main(String[] args) {
	

		// 10.질병관리 문제 //
		//
		//	아래 11~13번 주석을 해제하여
		//	"정상 출력 예" 와 같이 출력될 수 있도록 
		//	코드들을 디버깅 하세요!
		//
		System.out.println("10.질병관리(코로나,메르스) =================================");
		VirusMgr vmgr=VirusMgrImpl.getInstance();
		System.out.println();		
		
 //<- 주석 해제 후 작성 : start ////////////////////////////////
		System.out.println("11.코로나19 등록");
		// 정상 출력 예: 
		// 11.코로나19 등록
		// 코로나19: 등록된 바이러스입니다.
		try {
			vmgr.add(new Mers(  "메르스5", 1, 1.5));
			vmgr.add(new Corona("코로나9", 5, 2)); // 생성자에 void 있어서 생기는 문제
			vmgr.add(new Corona("코로나11", 2, 2)); // 다른 예로 기본생성자를 안 만들었는데 기본 생성자를 만들 경우 생길 수도 있다
			vmgr.add(new Mers(  "메르스22", 3, 1.5));
			vmgr.add(new Corona("코로나13", 7, 2)); // 생성자에 void 있어서 생기는 문제
			vmgr.add(new Corona("코로나77", 8, 2)); // 다른 예로 기본생성자를 안 만들었는데 기본 생성자를 만들 경우 생길 수도 있다
			vmgr.add(new Mers(  "메르스33", 4, 1.5));
			vmgr.add(new Corona("코로나88", 9, 2)); // 생성자에 void 있어서 생기는 문제
			vmgr.add(new Corona("코로나21", 11, 2)); // 다른 예로 기본생성자를 안 만들었는데 기본 생성자를 만들 경우 생길 수도 있다
		} catch (DuplicatedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		
		System.out.println("12.바이러스 전체검색");
		// 정상 출력 예: 
		// 12.바이러스 전체검색
		// 메르스15	2	1.5
		// 코로나19	3	2
		List<Virus> virus=vmgr.search();
		Collections.sort((List<Virus>) virus); // sort
		// COllections.sort(virus);만 해도 됨
		for(Virus v:virus) {
			System.out.println(v);
		}
		System.out.println();
		// null을 안 나오게 하려면 search()를 Arrays.copyof(list,index)로 바꿔줌
		
		System.out.println("13.코로나15 조회");
		// 정상 출력 예: 
		// 13.코로나15 조회
		// 코로나15: 미등록 바이러스입니다.
		try {
			Virus v=vmgr.search("코로나15");
			System.out.println(v);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		Virus v2=vmgr.search(new Mers(  "메르스15", 2, 1.5));
		System.out.println(v2);
		
		vmgr.save(); // 여기 추가
		// java.io.NotSerializableException: 보안이슈??
		// 파일 혹은 네크워크로 내보내고 싶을 떄는 implements Serializable 이걸 추가해준다
		// Virus 클래스에 implements Serializable 추가

	}
}
