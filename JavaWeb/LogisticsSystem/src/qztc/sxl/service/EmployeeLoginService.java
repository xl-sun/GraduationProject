package qztc.sxl.service;

public interface EmployeeLoginService {

	public String getMSMCode(String id);
	public String sendMSMById(String id,String code);
	//public boolean verifyPWD(String id,String password);
	
}
