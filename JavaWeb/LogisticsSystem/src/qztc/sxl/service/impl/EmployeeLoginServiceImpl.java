package qztc.sxl.service.impl;

import java.util.Random;

import qztc.sxl.dao.DAOFactory;
import qztc.sxl.dao.EmployeeDAO;
import qztc.sxl.pojo.Employee;
import qztc.sxl.service.EmployeeLoginService;
import qztc.sxl.service.MSMCodeService;
import qztc.sxl.util.MSMServer;

public class EmployeeLoginServiceImpl implements EmployeeLoginService {

	@Override
	public String getMSMCode(String id) {
		// TODO Auto-generated method stub
		EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
		Employee employee;
		String phone;
		String code="";
		Random random = new Random();
		for(int i=0;i<3;i++)
			code+=random.nextInt(100);
		try {
			employee = employeeDAO.findById(id);
			phone=employee.getPhone();
			if (null==phone)
				return "NOTFOUND";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERRO";
		}
		return code;
	}

	@Override
	public String sendMSMById(String id, String code) {
		// TODO Auto-generated method stub
		EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
		MSMCodeService mcserv = new MSMCodeServiceImpl();
		String result="";
		try {
			Employee employee=employeeDAO.findById(id);
			String phone = employee.getPhone();
			result = mcserv.sendCodeForEmployee(phone, code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Òì³£";
		}
		
		return result;
	}

}
