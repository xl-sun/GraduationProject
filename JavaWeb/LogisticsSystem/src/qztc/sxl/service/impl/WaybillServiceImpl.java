package qztc.sxl.service.impl;

import qztc.sxl.dao.DAOFactory;
import qztc.sxl.dao.LogisticsInfoDAO;
import qztc.sxl.dao.WaybillDAO;
import qztc.sxl.pojo.Waybill;
import qztc.sxl.service.WaybillService;

public class WaybillServiceImpl implements WaybillService {

	@Override
	public String getQRcodeById(String id) {
		// TODO Auto-generated method stub
		LogisticsInfoDAO logiInfoDAO = DAOFactory.getLogisticsInfoDAO();
		try {
			return logiInfoDAO.getById(id).getQrCode();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean checkSheetId(String id) {
		// TODO Auto-generated method stub
		WaybillDAO waybillDAO = DAOFactory.getWaybillDAO();
		try {
			Waybill waybill = waybillDAO.getById(id);
			return (waybill!=null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
