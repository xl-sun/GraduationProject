package qztc.sxl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import qztc.sxl.dao.RegionDAO;
import qztc.sxl.pojo.Region;
import qztc.sxl.util.DBConnection;

public class RegionDAOImpl implements RegionDAO {
	private static final String GETS_BY_LEVEL="select * from region where level = ?";
	private static final String GET_NAMES_BY_LEVEL="select region_name from region where level = ?";
	private static final String GETS_BY_PID="select * from region where pid = ?";
	private static final String GET_BY_ID="select * from region where id = ?";
	private static final String GET_ID_BY_MERGERNAME="select id from region where merger_name = ?";
	private static final String GET_MERGERNAME_BY_ID="select merger_name from region where id = ? ";

	@Override
	public List<Region> getRegionsByLevel(int level) throws Exception {
		// TODO Auto-generated method stub
		List<Region> list=new ArrayList<Region>();
		//Region region = null;
		PreparedStatement pStat = null;
		Connection conn = null;
		ResultSet rs = null;
		try{
			conn = DBConnection.getConnection();
			pStat = conn.prepareStatement(GETS_BY_LEVEL);
			pStat.setInt(1, level);
			rs = pStat.executeQuery();
			while(rs.next()){
				list.add(new Region(rs.getString("id"),
						rs.getString("region_name"),
						rs.getString("pid"),
						rs.getInt("level"),
						rs.getString("zip_code"),
						rs.getString("merger_name"),
						rs.getString("pinyin")));
			}
		}finally{
			DBConnection.close(rs, pStat, conn);
		}
		return list;
	}

	@Override
	public List<Region> getRegionsByPid(String pid) throws Exception {
		// TODO Auto-generated method stub
		List<Region> list=new ArrayList<Region>();
		//Region region = null;
		PreparedStatement pStat = null;
		Connection conn = null;
		ResultSet rs = null;
		try{
			conn = DBConnection.getConnection();
			pStat = conn.prepareStatement(GETS_BY_PID);
			pStat.setString(1, pid);
			rs = pStat.executeQuery();
			while(rs.next()){
				list.add(new Region(rs.getString("id"),
						rs.getString("region_name"),
						rs.getString("pid"),
						rs.getInt("level"),
						rs.getString("zip_code"),
						rs.getString("merger_name"),
						rs.getString("pinyin")));
			}
		}finally{
			DBConnection.close(rs, pStat, conn);
		}
		return list;
	}

	@Override
	public String getMergerNameById(String id) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pStat = null;
		Connection conn = null;
		ResultSet rs = null;
		String mergerName = null;
		try{
			conn = DBConnection.getConnection();
			pStat = conn.prepareStatement(GET_MERGERNAME_BY_ID);
			pStat.setString(1, id);
			rs = pStat.executeQuery();
			if(rs.next())
				mergerName = rs.getString("merger_name");
		}finally{
			DBConnection.close(rs, pStat, conn);
		}
		return mergerName;
	}

	@Override
	public Region getRegionById(int level) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdByMergerName(String mergername) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getRegionNamesByLevel(int level) throws Exception {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		PreparedStatement pStat = null;
		Connection conn = null;
		ResultSet rs = null;
		try{
			conn = DBConnection.getConnection();
			pStat = conn.prepareStatement(GET_NAMES_BY_LEVEL);
			pStat.setInt(1, level);
			rs = pStat.executeQuery();
			while(rs.next()){
				list.add(rs.getString("region_name"));
			}
		}finally{
			DBConnection.close(rs, pStat, conn);
		}
		return list;
	}





}
