package qztc.sxl.service.impl;

import qztc.sxl.dao.DAOFactory;
import qztc.sxl.dao.LogisticsInfoDAO;
import qztc.sxl.dao.WaybillDAO;
import qztc.sxl.pojo.LogisticsInfo;
import qztc.sxl.pojo.Waybill;
import qztc.sxl.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Override
	public boolean saveWaybill(Waybill waybill) {
		// TODO Auto-generated method stub
		WaybillDAO waybillDAO = DAOFactory.getWaybillDAO();
		try {
			return waybillDAO.save(waybill)>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveLogisticsInfo(LogisticsInfo logisticsInfo) {
		// TODO Auto-generated method stub
		LogisticsInfoDAO logiInfoDAO = DAOFactory.getLogisticsInfoDAO();
		try {
			return logiInfoDAO.sava(logisticsInfo)>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
