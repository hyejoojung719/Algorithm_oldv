package com.ssafy.corona.virus;

public class Virus {
	private String name;
	private int level;

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
		return name.hashCode();
	}
}
