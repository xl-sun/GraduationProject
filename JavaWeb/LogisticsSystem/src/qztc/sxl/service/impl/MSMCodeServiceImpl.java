package qztc.sxl.service.impl;

import qztc.sxl.service.MSMCodeService;
import qztc.sxl.util.MSMServer;

public class MSMCodeServiceImpl implements MSMCodeService {
	public static final String ADMIN = "【毕业设计】您的登录动态码是:%s,5分钟内有效。《基于Java的隐私安全物流分拣、派送系统》。";
	public static final String EMPLOYEE = "【毕业设计】您的登录动态码是:%s，5分钟内有效。《基于Java的隐私安全物流分拣、派送系统》。";
	public static final String RECIPIENT = "【毕业设计】您的快递%s正在派件，您的签收码是:%s。《基于Java的隐私安全物流分拣、派送系统》。";


	@Override
	public String sendCodeForAdmin(String phone, String code) {
		// TODO Auto-generated method stub
		String msg=String.format(ADMIN, code);
		String result = MSMServer.SendMSM(phone, msg);
		return result;
	}
	@Override
	public String sendCodeForEmployee(String phone, String code) {
		// TODO Auto-generated method stub
		System.out.println("sendCodeForEmployee"+phone);
		String msg=String.format(EMPLOYEE, code); 
		String result = MSMServer.SendMSM(phone, msg);
		return result;
	}
	@Override
	public String sendCodeForRecipient(String phone, String code, String waybill) {
		// TODO Auto-generated method stub
		String msg=String.format(RECIPIENT,waybill,code);
		String result = MSMServer.SendMSM(phone, msg);
		return result;
	}

}
