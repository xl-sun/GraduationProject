package qztc.sxl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import qztc.sxl.dao.LogisticsInfoDAO;
import qztc.sxl.pojo.LogisticsInfo;
import qztc.sxl.util.DBConnection;

public class LogisticsInfoDAOImpl implements LogisticsInfoDAO {
	private static final String SAVE="insert into logistics_info (id,qr_code,status,verif_code) values(?,?,?,?)";
	private static final String GET_BY_ID="select * from logistics_info where id = ?";
	private static final String UPDATE_STATUS = "update logistics_info set status = ? where id = ?";

	@Override
	public int sava(LogisticsInfo logisticsInfo) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pStat = null;
		Connection conn = null;
		try{
			conn = DBConnection.getConnection();
			pStat = conn.prepareStatement(SAVE);
			pStat.setString(1, logisticsInfo.getId());
			pStat.setString(2, logisticsInfo.getQrCode());
			pStat.setShort(3, logisticsInfo.getStatus());
			pStat.setString(4, logisticsInfo.getVerifyCode());
			System.out.println(pStat);
			return pStat.executeUpdate();
		}finally{
			DBConnection.close(pStat, conn);
		}
	}

	@Override
	public LogisticsInfo getById(String id) throws Exception {
		// TODO Auto-generated method stub
		LogisticsInfo logiInfo = null;
		PreparedStatement pStat = null;
		Connection conn = null;
		ResultSet rs=null;
		try{
			conn = DBConnection.getConnection();
			pStat = conn.prepareStatement(GET_BY_ID);
			pStat.setString(1, id);
			rs = pStat.executeQuery();
			if(rs.next())
				logiInfo=new LogisticsInfo(rs.getString("id"),
						rs.getShort("status"),
						rs.getString("qr_code"),
						rs.getString("verif_code"));
			
		}finally{
			DBConnection.close(rs,pStat, conn);
		}
		return logiInfo;
	}

	@Override
	public int updateStatus(String id,short status) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pStat = null;
		Connection conn = null;
		try{
			conn = DBConnection.getConnection();
			pStat = conn.prepareStatement(UPDATE_STATUS);
			pStat.setShort(1, status);
			pStat.setString(2, id);
			System.out.println(pStat);
			return pStat.executeUpdate();
		}finally{
			DBConnection.close(pStat, conn);
		}
	}

}
