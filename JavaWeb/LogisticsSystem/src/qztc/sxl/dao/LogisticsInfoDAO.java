package qztc.sxl.dao;

import qztc.sxl.pojo.LogisticsInfo;

public interface LogisticsInfoDAO {
	public int sava(LogisticsInfo logisticsInfo) throws Exception;
	public LogisticsInfo getById(String id) throws Exception;
	public int updateStatus(String id,short status) throws Exception;
	
}
