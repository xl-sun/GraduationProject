package qztc.sxl.pojo;

public class Position {

	private String name;
	private boolean sortPermit;
	private boolean receivePermit;
	private boolean transportPermit;
	private boolean deliveryPermit;
	public Position(){
		
	}
	public Position(String name, boolean sortPermit, boolean receivePermit, boolean transportPermit,
			boolean deliveryPermit) {
		super();
		this.name = name;
		this.sortPermit = sortPermit;
		this.receivePermit = receivePermit;
		this.transportPermit = transportPermit;
		this.deliveryPermit = deliveryPermit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSortPermit() {
		return sortPermit;
	}
	public void setSortPermit(boolean sortPermit) {
		this.sortPermit = sortPermit;
	}
	public boolean isReceivePermit() {
		return receivePermit;
	}
	public void setReceivePermit(boolean receivePermit) {
		this.receivePermit = receivePermit;
	}
	public boolean isTransportPermit() {
		return transportPermit;
	}
	public void setTransportPermit(boolean transportPermit) {
		this.transportPermit = transportPermit;
	}
	public boolean isDeliveryPermit() {
		return deliveryPermit;
	}
	public void setDeliveryPermit(boolean deliveryPermit) {
		this.deliveryPermit = deliveryPermit;
	}
}
