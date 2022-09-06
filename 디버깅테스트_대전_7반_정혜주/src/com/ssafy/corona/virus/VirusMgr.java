package com.ssafy.corona.virus;

import java.util.List;

public interface VirusMgr {
	void add(Virus v) throws DuplicatedException;
	List<Virus> search();
	Virus search(String name) throws NotFoundException;
	Virus search(Virus v);
	void save();
	void load();
}