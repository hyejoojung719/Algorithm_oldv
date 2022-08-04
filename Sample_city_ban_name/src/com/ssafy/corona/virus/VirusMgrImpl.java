package com.ssafy.corona.virus;

import java.lang.reflect.Array;
import java.util.Arrays;

public class VirusMgrImpl implements VirusMgr {
	private Virus[] virus;
	private int index;
	
	public VirusMgrImpl() {
		virus=new Virus[100];		// 배열 100개짜리 만듬
	}
	
	@Override
	public void add(Virus v) throws DuplicatedException{
		try {
			search(v.getName());	// 중복을 확인하기 위해 해당 바이러스 있는지 확인
			throw new DuplicatedException(v.getName()+": 등록된 바이러스입니다."); // 여기 행 추가
		} catch (NotFoundException e) {
			virus[index++]=v;	// 중복이 없으면 넣는다.
		}
	}
	@Override
	public Virus[] search() {
		return Arrays.copyOf(virus, index);
	}
	@Override
	public Virus search(String name) throws NotFoundException{
		for(int i=0; i<index/*virus.length*/; i++) {
			if(virus[i].getName().equals(name)) return virus[i];
		}
		throw new NotFoundException(name+": 미등록 바이러스입니다.");
	}
}
