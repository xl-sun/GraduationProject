package qztc.sxl.service.impl;

import java.util.Random;

import qztc.sxl.dao.AdminDAO;
import qztc.sxl.dao.DAOFactory;
import qztc.sxl.dao.EmployeeDAO;
import qztc.sxl.pojo.Admin;
import qztc.sxl.pojo.Employee;
import qztc.sxl.service.AdminLoginService;
import qztc.sxl.service.MSMCodeService;

public class AdminLoginServiceImpl implements AdminLoginService {

	public static final String SUCCESS ="��¼�ɹ�!";
	public static final String ERROR = "��¼ʧ�ܣ��û������������";
	public static final String NOTFOUND ="��¼ʧ�ܣ������ڵ��û���";;
	public static final String EXCEPTION ="��¼�쳣��";
	
	
	@Override
	public String Login(Admin admin) {
		// TODO Auto-generated method stub
		AdminDAO admindao = DAOFactory.getAdminDAO();
		Admin newadmin =null;
		
		try {
			newadmin = admindao.findById(admin.getId());
			if(null==newadmin.getId()){
				return NOTFOUND;
			}else if( newadmin.getPassword().equals(admin.getPassword())){
				return SUCCESS;
			}else{
				return ERROR;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return EXCEPTION;
		}
		
	}


	@Override
	public String getMSMCode(String id) {
		// TODO Auto-generated method stub
		String code="";
		Random random = new Random();
		for(int i=0;i<4;i++)
			code+=random.nextInt(10);
		try {
			if (null==DAOFactory.getAdminDAO().findById(id).getPhone())
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
		try {
			String phone = DAOFactory.getAdminDAO().findById(id).getPhone();
			return new MSMCodeServiceImpl().sendCodeForEmployee(phone, code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "�쳣";
		}
	}


	@Override
	public String getNameById(String id) {
		// TODO Auto-generated method stub
		try {
			return DAOFactory.getAdminDAO().findById(id).getName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
