package com.accp.t2.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accp.t2.dao.IBmDao;
import com.accp.t2.entity.bm;
import com.accp.t2.entity.yg;

public class IBmImpl extends BaseDAO implements IBmDao{

	private List<bm> queryBySql(String sql,Object...objects){
		ResultSet rs=super.query(sql, objects);
		List<bm> list=new ArrayList<bm>();
		bm b=null;
		try {
			while(rs.next()) {
				b=new bm();
				b.setId(rs.getInt(1));
				b.setBmName(rs.getString(2));
				
				
				
				list.add(b);
				
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
	public List<bm> queryAllBm() {
		String sql ="select*from bm";
			
		return this.queryBySql(sql);
	}

	private bm queryByName(String sql,Object...objects){
		ResultSet rs=super.query(sql, objects);
		bm b=null;
		List<yg> list=new ArrayList<yg>();
		try {
			while(rs.next()) {
				b=new bm();
				b.setId(rs.getInt(1));
				b.setBmName(rs.getString(2));
				
				yg y=new yg();
				y.setsName(rs.getString(4));
				list.add(y);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll(rs);
		}
		b.setList(list);
		return b;
	}
	
	
	

	@Override
	public bm queryBm(String bmName) {
		String sql="SELECT *FROM bm,yg WHERE bm.`bm`=yg.`bmId` AND bm.`bmName`=?";
		return this.queryByName(sql, bmName);
	}
	
}
