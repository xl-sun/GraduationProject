package qztc.sxl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import qztc.sxl.dao.LogTypeDAO;
import qztc.sxl.pojo.LogType;
import qztc.sxl.util.DBConnection;

public class LogTypeDAOImpl implements LogTypeDAO {
	private static final String GET_ALL="select * from log_type";
	private static final String GET_NAME_BY_ID="select name from log_type";
	private static final String GET_ID_BY_NAME="select id from log_type";
	

	@Override
	public List<LogType> getAllLogeTypes() throws Exception{
		// TODO Auto-generated method stub
		List<LogType> list = new ArrayList<LogType>();
		PreparedStatement pStat = null;
		Connection conn = null;
		ResultSet rs = null;
		try{
			conn = DBConnection.getConnection();
			pStat = conn.prepareStatement(GET_ALL);
			rs=pStat.executeQuery();
			while(rs.next()){
				list.add(new LogType(rs.getShort("id"),rs.getString("name")));
			}
		}finally{
			DBConnection.close(rs, pStat, conn);
		}
		return list;
	}

	@Override
	public String getNameById(Short id) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pStat = null;
		String name;
		try{
			conn = DBConnection.getConnection();
			pStat = conn.prepareStatement(GET_NAME_BY_ID);
			pStat.setShort(1, id);
			rs=pStat.executeQuery();
			name = rs.getString("name");
			return name;
		}finally{
			DBConnection.close(rs, pStat, conn);
		}
	}

	@Override
	public Short getIdByName(String name) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pStat = null;
		Short id;
		try{
			conn = DBConnection.getConnection();
			pStat = conn.prepareStatement(GET_ID_BY_NAME);
			pStat.setString(1, name);
			rs=pStat.executeQuery();
			if(rs.next()){
				id = rs.getShort("id");
				return id;
			}else{
				return -1;
			}
		}finally{
			DBConnection.close(rs, pStat, conn);
		}
	}

}
