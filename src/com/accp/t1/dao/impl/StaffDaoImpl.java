package com.accp.t1.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accp.t1.dao.IStaffDao;
import com.accp.t1.entity.Staff;

public class StaffDaoImpl extends BaseDAO implements IStaffDao {
	private List<Staff> queryBySql(String sql,Object...objects){
		ResultSet rs=super.query(sql, objects);
		List<Staff> list=new ArrayList<Staff>();
		Staff staff=null;
		try {
			while(rs.next()) {
				staff=new Staff();
				staff.setId(rs.getInt(1));
				staff.setsName(rs.getString(2));
				staff.setsAddress(rs.getString(3));
				staff.setEmail(rs.getString(4));
				
				
				
				list.add(staff);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll(rs);
		}
		return list;
	}
	
	
	@Override
	public List<Staff> queryAll() {
		String sql="select *from staff;";
		
		
		return this.queryBySql(sql);
	}


	@Override
	public Staff queryLinkByIdStaff(String id) {
		String sql="select *from staff where sid=?";
		
		return this.queryBySql(sql, id).size()>0?this.queryBySql(sql, id).get(0):null;
	}

}
