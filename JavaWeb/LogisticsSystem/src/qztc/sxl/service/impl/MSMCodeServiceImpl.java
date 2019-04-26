package qztc.sxl.service.impl;

import qztc.sxl.service.MSMCodeService;
import qztc.sxl.util.MSMServer;

public class MSMCodeServiceImpl implements MSMCodeService {
	public static final String ADMIN = "����ҵ��ơ����ĵ�¼��̬����:%s,5��������Ч��������Java����˽��ȫ�����ּ�����ϵͳ����";
	public static final String EMPLOYEE = "����ҵ��ơ����ĵ�¼��̬����:%s��5��������Ч��������Java����˽��ȫ�����ּ�����ϵͳ����";
	public static final String RECIPIENT = "����ҵ��ơ����Ŀ��%s�����ɼ�������ǩ������:%s��������Java����˽��ȫ�����ּ�����ϵͳ����";


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
