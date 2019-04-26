package qztc.sxl.service;

public interface MSMCodeService {
	/*
	public static class Receiver{
		public static final int ADMIN = 0;
		public static final int EMPLOYEE = 1;
		public static final int RECIPIENT = 2;
	}
	public String sendCode(String phone,String code,int receiver);
	*/
	
	public String sendCodeForAdmin(String phone,String code);
	public String sendCodeForEmployee(String phone,String code);
	public String sendCodeForRecipient(String phone,String code,String waybill);
	
}
