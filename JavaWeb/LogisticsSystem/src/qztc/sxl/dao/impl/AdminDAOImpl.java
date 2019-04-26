package qztc.sxl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import qztc.sxl.dao.AdminDAO;
import qztc.sxl.pojo.Admin;
import qztc.sxl.util.DBConnection;

public class AdminDAOImpl implements AdminDAO {

	private static final String FINDBYID = "select * from admin_login where id=?";
	private static final String INSERT = "insert into admin_login(id,name,password,phone) values(?,?,?,?)";
	private static final String UPDATE = "update admin_login set name=?,password=?,phone=? where id=?";

	@Override
	public int save(Admin admin) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstat = null;
		Connection conn = null;
		int result;
		try{
			conn=DBConnection.getConnection();
			pstat=conn.prepareStatement(INSERT);
			pstat.setString(1, admin.getId());
			pstat.setString(2, admin.getName());
			pstat.setString(3, admin.getPassword());
			pstat.setString(4, admin.getPhone());
			result = pstat.executeUpdate();
		}finally{
			DBConnection.close(pstat, conn);
		}
		return result;
	
	}

	@Override
	public Admin findById(String id) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstat = null;
		Connection conn = null;
		ResultSet rs = null;
		Admin admin =new Admin(); //
		try{
			conn=DBConnection.getConnection();
			pstat=conn.prepareStatement(FINDBYID);
			pstat.setString(1, id);
			rs = pstat.executeQuery();
			if(rs.next()){
				admin.setId(rs.getString("id"));
				admin.setName(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
				admin.setPhone(rs.getString("phone"));
			}
		}finally{
			DBConnection.close(rs, pstat, conn);
		}
		return admin;
	}

	@Override
	public int update(Admin admin) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstat = null;
		Connection conn = null;
		int result;
		try{
			conn=DBConnection.getConnection();
			pstat=conn.prepareStatement(UPDATE);
			pstat.setString(4, admin.getId());
			pstat.setString(1, admin.getName());
			pstat.setString(2, admin.getPassword());
			pstat.setString(3, admin.getPhone());
			result = pstat.executeUpdate();
		}finally{
			DBConnection.close(pstat, conn);
		}
		return result;
	}

}
