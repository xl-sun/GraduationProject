package qztc.sxl.pojo;

public class Region {
	private String id;
	private String regionName;
	private String pid;
	private int level;
	private String zipCode;
	private String mergerName;
	private String pinyin;
	public Region(){
		
	}
	public Region(String id, String regionName, String pid, int level, String zipCode, String mergerName,
			String pinyin) {
		super();
		this.id = id;
		this.regionName = regionName;
		this.pid = pid;
		this.level = level;
		this.zipCode = zipCode;
		this.mergerName = mergerName;
		this.pinyin = pinyin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getMergerName() {
		return mergerName;
	}
	public void setMergerName(String mergerName) {
		this.mergerName = mergerName;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
}
