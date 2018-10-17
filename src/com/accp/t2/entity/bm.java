package com.accp.t2.entity;

import java.util.List;

public class bm {
	private int id;
	private String bmName;
	
	private List<yg> list;
	
	public List<yg> getList() {
		return list;
	}
	public void setList(List<yg> list) {
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBmName() {
		return bmName;
	}
	public void setBmName(String bmName) {
		this.bmName = bmName;
	}
	
   
}
