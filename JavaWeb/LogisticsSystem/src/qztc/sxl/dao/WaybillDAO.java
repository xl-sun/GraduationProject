package qztc.sxl.dao;

import qztc.sxl.pojo.Waybill;

public interface WaybillDAO {
	public int save(Waybill waybill) throws Exception;
	public Waybill getById(String id) throws Exception;
}
