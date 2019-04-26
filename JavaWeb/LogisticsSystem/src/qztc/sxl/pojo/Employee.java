package qztc.sxl.pojo;

public class Employee {
	private String id;
	private String name;
	private String phone;
	public Employee() {

	}
	public Employee(String id, String name, String phone, String jobTitle) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.jobTitle = jobTitle;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	private String jobTitle;
	
}
