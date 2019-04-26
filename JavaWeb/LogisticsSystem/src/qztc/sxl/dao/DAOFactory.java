package qztc.sxl.dao;

import qztc.sxl.dao.impl.*;

public class DAOFactory {

	private static AdminDAOImpl adminDAO =  new AdminDAOImpl();
	private static EmployeeDAOImpl employeeDAO =  new EmployeeDAOImpl();
	private static PositionDAOImpl positionDAO =  new PositionDAOImpl();
	private static LogDAOImpl logDAO =  new LogDAOImpl();
	private static RegionDAOImpl regionDAO = new RegionDAOImpl();
	private static WaybillDAOImpl waybillDAO = new WaybillDAOImpl();
	private static LogisticsInfoDAOImpl logisticsInfoDAO = new LogisticsInfoDAOImpl();
	private static LogTypeDAOImpl logTypeDAO = new LogTypeDAOImpl();
	
	public static AdminDAO getAdminDAO(){
		return adminDAO;
	}

	public static EmployeeDAO getEmployeeDAO(){
		return employeeDAO;
	}
	
	public static PositionDAO getPositionDAO(){
		return positionDAO;
	}
	
	public static LogDAO getLogDAO(){
		return logDAO;
	}

	public static RegionDAO getRegionDAO(){
		return regionDAO;
	}

	public static WaybillDAO getWaybillDAO() {
		// TODO Auto-generated method stub
		return waybillDAO;
	}
	
	public static LogisticsInfoDAOImpl getLogisticsInfoDAO() {
		// TODO Auto-generated method stub
		return logisticsInfoDAO;
	}
	
	public static LogTypeDAOImpl getLogTypeDAO() {
		// TODO Auto-generated method stub
		return logTypeDAO;
	}
	
	
	
	
}
