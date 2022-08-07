package com.ssafy.corona.virus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VirusMgrImpl implements VirusMgr {
	private List<Virus> vs = null;
	private int index;
	
	public VirusMgrImpl() {
		vs=new ArrayList<>();		// 배열 100개짜리 만듬
	}
	
	@Override
	public void add(Virus v) throws DuplicatedException{
		try {
			search(v.getName());	// 중복을 확인하기 위해 해당 바이러스 있는지 확인
			throw new DuplicatedException(v.getName()+": 등록된 바이러스입니다."); // 여기 행 추가
		} catch (NotFoundException e) {
			vs.add(v);	// 중복이 없으면 넣는다.
		}
	}
	
	@Override
	public Virus search(String name) throws NotFoundException{
		for(Virus v : vs) {
			if(v.getName().equals(name)) return v;
		}
		throw new NotFoundException(name+": 미등록 바이러스입니다.");
	}
	
	@Override
	public List<Virus> search() {
		return vs;
	}
	
	@Override
	public Virus search(Virus v) {
		for(Virus vv : vs) {
			if(vv.equals(v)) return v;
		}
		return null;
	}
	
}
