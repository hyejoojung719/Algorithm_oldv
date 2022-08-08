package com.ssafy.corona.virus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class VirusMgrImpl implements VirusMgr {
	private List<Virus> vs = null;
	private int index;
	private static VirusMgr mgr = new VirusMgrImpl(); // 2. 직접 객체 생성
	
	public static VirusMgr getInstance() {	//3. 객체 오픈
		return mgr;
	}
	
	private VirusMgrImpl() {	//1. 외부에서 객체 생성 못하도록 생성자를 숨긴다. 
		load(); // 객체 만들기전에 load 읽어봐
		if(vs == null) vs=new ArrayList<>();		// 배열 100개짜리 만듬
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

	/** virus.dat 파일에 데이터를 저장 */
	@Override
	public void save() {
		File f = new File("virus.dat");
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(vs);
			oos.close(); // finally 또는 try resources 활용
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/** virus.dat 파일에 데이터를 저장 */
	@Override
	public void load() {
		File f = new File("virus.dat");
		if(!f.exists()) return; // 파일 존재하지 않으면
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			vs = (List<Virus>)ois.readObject();
			ois.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
