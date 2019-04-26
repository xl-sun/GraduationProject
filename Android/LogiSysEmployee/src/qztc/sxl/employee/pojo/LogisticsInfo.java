package qztc.sxl.employee.pojo;

public class LogisticsInfo {

	public static final short NOT_RECEIVED=0;
	public static final short RECEIVED=1;
	public static final short SORTED=2;
	public static final short TRANSPORTED=3;
	public static final short DELIVRYING=4;
	public static final short DELIVRYED=5;
	
	private String id;
	private Short status;
	private String qrCode;
	private String verifyCode;

	public LogisticsInfo(){

	}
	public LogisticsInfo(String id, Short status, String qrCode, String verifyCode) {
		super();
		this.id = id;
		this.status = status;
		this.qrCode = qrCode;
		this.verifyCode = verifyCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
}
