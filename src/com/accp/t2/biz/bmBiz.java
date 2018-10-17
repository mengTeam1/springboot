package com.accp.t2.biz;

import java.util.List;

import com.accp.t2.dao.IBmDao;
import com.accp.t2.dao.impl.IBmImpl;
import com.accp.t2.entity.bm;

public class bmBiz {
	private IBmDao dao=new IBmImpl();
	
	public List<bm> queryAll(){
		return dao.queryAllBm();
	}
	public bm queryByName(String name) {
		return dao.queryBm(name);
	}
	
}
