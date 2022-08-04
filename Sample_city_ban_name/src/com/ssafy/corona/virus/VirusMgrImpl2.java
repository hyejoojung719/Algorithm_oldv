package com.ssafy.corona.virus;

import java.util.ArrayList;
import java.util.List;

public class VirusMgrImpl2 implements VirusMgr{
	
	List<Virus> vs = new ArrayList<>();

	@Override
	public void add(Virus v) throws DuplicatedException {
		// TODO Auto-generated method stub
		try {
			search(v.getName());
			throw new DuplicatedException(v.getName()+": 등록된 바이러스입니다.");
		}catch(NotFoundException e) {
			vs.add(v);
		}
		
	}

	@Override
	public Virus[] search() {
		// TODO Auto-generated method stub
		Virus[] newvs = new Virus[vs.size()];
		return vs.toArray(newvs);
	}

	@Override
	public Virus search(String name) throws NotFoundException {
		// TODO Auto-generated method stub
		for(Virus v : vs) {
			if(v.getName().equals(name)) {
				return v;
			}
		}
		throw new NotFoundException(name+": 미등록 바이러스입니다.");
	}

}
