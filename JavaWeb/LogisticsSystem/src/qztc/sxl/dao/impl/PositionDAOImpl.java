package qztc.sxl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import qztc.sxl.dao.PositionDAO;
import qztc.sxl.pojo.Position;
import qztc.sxl.util.DBConnection;

public class PositionDAOImpl implements PositionDAO {

	private static final String FINDBYNAME = "select * from job_title where name=?";
	private static final String INSERT = "insert into job_title(name,sort,receive,transport,delivery) values(?,?,?,?,?)";
	private static final String UPDATE = "update job_title set sort=?,receive=?,transport=?,delivery=? where name=?";
	@Override
	public int save(Position position) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Position findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstat = null;
		Connection conn = null;
		ResultSet rs = null;
		Position position=null;
		try{
			conn=DBConnection.getConnection();
			pstat=conn.prepareStatement(FINDBYNAME);
			pstat.setString(1, name);
			rs = pstat.executeQuery();
			if(rs.next()){
				position=new Position(rs.getString("name"),rs.getBoolean("sort"),rs.getBoolean("receive"),
						rs.getBoolean("transport"),rs.getBoolean("delivery"));
			}
		}finally{
			DBConnection.close(rs, pstat, conn);
		}
		return position;
		}

	@Override
	public int update(Position position) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
