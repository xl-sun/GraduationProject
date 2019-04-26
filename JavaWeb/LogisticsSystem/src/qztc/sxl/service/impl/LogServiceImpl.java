package qztc.sxl.service.impl;

import java.util.Collections;
import java.util.List;

import qztc.sxl.dao.DAOFactory;
import qztc.sxl.dao.LogDAO;
import qztc.sxl.dao.LogisticsInfoDAO;
import qztc.sxl.dao.WaybillDAO;
import qztc.sxl.pojo.Log;
import qztc.sxl.pojo.LogisticsInfo;
import qztc.sxl.pojo.Waybill;
import qztc.sxl.service.LogService;

public class LogServiceImpl implements LogService{

	@Override
	public boolean addLog(Log log) {
		// TODO Auto-generated method stub
		LogDAO logDAO = DAOFactory.getLogDAO();
		try {
			return logDAO.addLog(log)>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public short getStatusById(String id) {
		// TODO Auto-generated method stub
		LogisticsInfoDAO loDAO = DAOFactory.getLogisticsInfoDAO();
		try {
			LogisticsInfo logInfo = loDAO.getById(id);
			return logInfo.getStatus();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<Log> getLogsById(String id) {
		// TODO Auto-generated method stub
		LogDAO logDAO = DAOFactory.getLogDAO();
		List<Log> list=null;
		try {
			list = logDAO.getLogsById(id);
			Collections.sort(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean updateStatus(String id,short status) {
		// TODO Auto-generated method stub
		LogisticsInfoDAO loDAO = DAOFactory.getLogisticsInfoDAO();
		try {
			return loDAO.updateStatus(id, status)>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
