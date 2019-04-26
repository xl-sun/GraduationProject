package qztc.sxl.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import qztc.sxl.pojo.LogisticsInfo;
import qztc.sxl.util.DBConnection;

public class TestLogisticsInfoDAO {
	public LogisticsInfo getLogisticsInfoById(String id) throws Exception{
		LogisticsInfo logiInfo = new LogisticsInfo();
		Connection conn = null;
		PreparedStatement prepState =null;
		ResultSet rs =null;
		String sql = "select * from logistics_info where id = ?";
		try{
			
			conn = DBConnection.getConnection();
			prepState = conn.prepareStatement(sql);
			prepState.setString(1, id);
			rs=prepState.executeQuery();
			rs.next();
			logiInfo.setId(rs.getString("id"));
			logiInfo.setStatus(rs.getShort("status"));
			logiInfo.setQrCode(rs.getString("qr_code"));
			logiInfo.setVerifyCode(rs.getString("verif_code"));
		}finally{
			DBConnection.close(rs, prepState, conn);
		}
		return logiInfo;
	}
}
