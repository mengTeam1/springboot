package com.accp.t2.dao;

import java.util.List;

import com.accp.t2.entity.bm;

public interface IBmDao {
	public List<bm> queryAllBm();
	
	public bm queryBm(String bmName);
	
}
