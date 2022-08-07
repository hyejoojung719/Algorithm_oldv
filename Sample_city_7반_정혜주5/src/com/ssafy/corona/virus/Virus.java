package com.ssafy.corona.virus;

import java.io.Serializable;


/** Sort:
 * 1. Ascending : 작은값 -> 큰값 : 오름차순
 * 2. Descending : 큰값 -> 작은값 : 내림차순
 * **/
public class Virus implements Serializable, Comparable<Virus>{
	private String name;
	private int level; // transient를 붙이면 serialize할 때 얘는 버리고 감
	

	public Virus() {}
	public Virus(String name, int level) {
		setName(name);
		setLevel(level);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(getName()).append("\t")
		  .append(getLevel());
		return sb.toString();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Virus) {
			Virus v = (Virus)obj;
			if(this.name.equals(v.getName())&&this.level == v.getLevel()) {
				return true;
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode() & new Integer(level).hashCode();
	}
	
	// 시험에 나옴
	@Override
	public int compareTo(Virus o) {
		// return this.name - o.getName() 이름 비교
		// return this.name.compareTo(o.getName()); // 양수 음수 판단
		return this.level - o.getLevel();
		// 큰거부터 보고 싶으면(내림차순) o.getLevel() - this.level
	}
}
