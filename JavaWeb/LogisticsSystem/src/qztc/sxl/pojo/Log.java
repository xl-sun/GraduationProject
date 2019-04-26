package qztc.sxl.pojo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Log  implements Comparable<Log>{
	private String id;
	private Short tid;
	private String info;
	private String time;//yyyy-mm-dd hh:mm
	private Timestamp timestamp;
	public Log(){
		
	}
	public Log(String id, Short tid, String info,Timestamp timestamp) {
		super();
		this.id = id;
		this.tid = tid;
		this.info = info;
		setTime(timestamp);
		this.timestamp = timestamp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Short getTid() {
		return tid;
	}
	public void setTid(Short tid) {
		this.tid = tid;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setTime(Timestamp time) {
		if(time!=null){
			String str = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(time);
			this.time = str;
			this.timestamp = time;
		}
			
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	@Override
	public int compareTo(Log o) {
		// TODO Auto-generated method stub
		return (int)(timestamp.getTime()-o.getTimestamp().getTime());
	}

}
