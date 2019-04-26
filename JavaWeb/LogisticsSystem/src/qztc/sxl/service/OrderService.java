package qztc.sxl.service;

import qztc.sxl.pojo.LogisticsInfo;
import qztc.sxl.pojo.Waybill;

public interface OrderService {
	public boolean saveWaybill(Waybill waybill);
	public boolean saveLogisticsInfo(LogisticsInfo logisticsInfo);
	
}
