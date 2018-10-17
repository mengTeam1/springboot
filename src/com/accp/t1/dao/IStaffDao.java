package com.accp.t1.dao;

import java.util.List;

import com.accp.t1.entity.Staff;

public interface IStaffDao {
	
	public List<Staff> queryAll();
	
	public Staff	queryLinkByIdStaff(String id);
	
	
}
