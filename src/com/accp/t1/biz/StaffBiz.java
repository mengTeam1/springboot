package com.accp.t1.biz;

import java.util.List;

import com.accp.t1.dao.IStaffDao;
import com.accp.t1.dao.impl.StaffDaoImpl;
import com.accp.t1.entity.Staff;

public class StaffBiz {
	private IStaffDao dao=new StaffDaoImpl();
	
	
	public List<Staff> queryAll(){
		return dao.queryAll();
		
	}
	
	public Staff queryLinkByIdStaff(String id) {
		return dao.queryLinkByIdStaff(id);
	}
}
