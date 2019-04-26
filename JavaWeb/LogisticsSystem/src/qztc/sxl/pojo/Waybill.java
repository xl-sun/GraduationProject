package qztc.sxl.pojo;

public class Waybill {

	private String id;
	private String sender;
	private String senderAddr;
	private String senderPhone;
	private String recipient;
	private String recipientAddr;
	private String recipientPhone;
	public Waybill(){
		
	}
	public Waybill(String id, String sender, String senderAddr, String senderPhone, String recipient,
			String recipientAddr, String recipientPhone) {
		super();
		this.id = id;
		this.sender = sender;
		this.senderAddr = senderAddr;
		this.senderPhone = senderPhone;
		this.recipient = recipient;
		this.recipientAddr = recipientAddr;
		this.recipientPhone = recipientPhone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSenderAddr() {
		return senderAddr;
	}
	public void setSenderAddr(String senderAddr) {
		this.senderAddr = senderAddr;
	}
	public String getSenderPhone() {
		return senderPhone;
	}
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getRecipientAddr() {
		return recipientAddr;
	}
	public void setRecipientAddr(String recipientAddr) {
		this.recipientAddr = recipientAddr;
	}
	public String getRecipientPhone() {
		return recipientPhone;
	}
	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}
}
