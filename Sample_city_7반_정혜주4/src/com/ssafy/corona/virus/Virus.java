package com.ssafy.corona.virus;

import java.io.Serializable;

public class Virus implements Serializable{
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
}
