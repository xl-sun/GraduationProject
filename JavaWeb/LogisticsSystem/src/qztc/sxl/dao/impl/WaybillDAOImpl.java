package qztc.sxl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import qztc.sxl.dao.WaybillDAO;
import qztc.sxl.pojo.Waybill;
import qztc.sxl.util.DBConnection;

public class WaybillDAOImpl implements WaybillDAO {
	private static final String SAVE="insert into waybill (id,recipient,recipient_addr,recipient_phone,sender,sender_addr,sender_phone) values(?,?,?,?,?,?,?)";
	private static final String GET_BY_ID="select * from waybill where id = ?";

	@Override
	public int save(Waybill waybill) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pStat = null;
		Connection conn = null;
		try{
			conn=DBConnection.getConnection();
			pStat=conn.prepareStatement(SAVE);
			pStat.setString(1, waybill.getId());
			pStat.setString(2, waybill.getRecipient());
			pStat.setString(3, waybill.getRecipientAddr());
			pStat.setString(4, waybill.getRecipientPhone());
			pStat.setString(5, waybill.getSender());
			pStat.setString(6, waybill.getSenderAddr());
			pStat.setString(7, waybill.getSenderPhone());
			//System.out.println(pStat.toString());
			return pStat.executeUpdate();
		}finally{
			DBConnection.close(pStat, conn);
		}
	}

	@Override
	public Waybill getById(String id) throws Exception {
		// TODO Auto-generated method stub
		Waybill waibill =null;
		PreparedStatement pStat = null;
		Connection conn = null;
		ResultSet rs = null;
		try{
			conn=DBConnection.getConnection();
			pStat=conn.prepareStatement(GET_BY_ID);
			pStat.setString(1, id);
			rs=pStat.executeQuery();
			if(rs.next())
				waibill=new Waybill(rs.getString("id"),
						rs.getString("sender"),
						rs.getString("sender_addr"),
						rs.getString("sender_phone"),
						rs.getString("recipient"),
						rs.getString("recipient_addr"),
						rs.getString("recipient_phone")
						);

		}finally{
			DBConnection.close(rs,pStat, conn);
		}
		
		return waibill;
	}

}
