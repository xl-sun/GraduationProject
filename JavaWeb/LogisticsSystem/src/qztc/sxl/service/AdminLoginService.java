package qztc.sxl.service;

import qztc.sxl.pojo.Admin;

public interface AdminLoginService {

	public String Login(Admin admin);
	
	public String getMSMCode(String id);
	public String sendMSMById(String id,String code);
	public String getNameById(String id);
}
