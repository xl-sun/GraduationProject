package qztc.sxl.service;

import java.util.List;

import qztc.sxl.pojo.Log;

public interface LogService {
	public boolean addLog(Log log);
	public short getStatusById(String id);
	public boolean updateStatus(String id,short status);
	public List<Log> getLogsById(String id);
}
