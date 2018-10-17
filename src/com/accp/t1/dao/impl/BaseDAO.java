package com.accp.t1.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {
	//�������ַ�
	private String driver="com.mysql.jdbc.Driver";
	//�������ӵ��ַ�
	private String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
	
	private Connection conn;
	private PreparedStatement pstmt;
	
	private void getConn(){
			
		try {
			//������ݿ���
			Class.forName(driver);
			//������ݿ�
				conn=DriverManager.getConnection(url,"root","123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//�ر�
	public void closeAll(ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null&&!conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//��ɾ��
	public int update(String sql,Object...objects){
		getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			bindsObjects(objects);
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(null);
		}	
		return 0;
	}
	
	public ResultSet query(String sql,Object...objects){
		getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			bindsObjects(objects);
			return pstmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	/**
	 * 查询唯一值
	 */
	public Object queryByUnique(String sql,Object...objects){
		ResultSet rs = this.query(sql, objects);
		
		try {
			while(rs.next()){
				return rs.getObject(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(rs);
		}
		return null;
	}
	
	
	
	
	//��sql����
	private void bindsObjects(Object... objects) throws SQLException {
		if(objects!=null){
		for(int i=0;i<objects.length;i++){
				pstmt.setObject(i+1, objects[i]);
		}
		}
	}
}
