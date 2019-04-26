package qztc.sxl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import qztc.sxl.dao.LogDAO;
import qztc.sxl.pojo.Log;
import qztc.sxl.util.DBConnection;

public class LogDAOImpl implements LogDAO {
	private static final String ADD="insert into logistics_log (id,log_info,tid) values(?,?,?)";
	private  final static String GETS="select * from logistics_log where id = ?"; 

	@Override
	public List<Log> getLogsById(String id) throws Exception {
		// TODO Auto-generated method stub
		List<Log> list = new ArrayList<Log>();
		PreparedStatement pStat = null;
		Connection conn = null;
		ResultSet rs=null;
		try{
			conn=DBConnection.getConnection();
			pStat = conn.prepareStatement(GETS);
			pStat.setString(1, id);
			rs=pStat.executeQuery();
			while(rs.next()){
				list.add(new Log(rs.getString("id"),rs.getShort("tid"),rs.getString("log_info"),rs.getTimestamp("time")));
			}
		}finally{
			DBConnection.close(rs, pStat, conn);
		}
		Collections.sort(list);
		return list;
	}

	@Override
	public int addLog(Log log) throws Exception{
		// TODO Auto-generated method stub
		PreparedStatement pStat = null;
		Connection conn = null;
		
		try{
			conn=DBConnection.getConnection();
			pStat = conn.prepareStatement(ADD);
			pStat.setString(1, log.getId());
			pStat.setString(2, log.getInfo());
			pStat.setObject(3, log.getTid(), Types.TINYINT);
			return pStat.executeUpdate();
		}finally{
			DBConnection.close(pStat, conn);
		}
	}

}
