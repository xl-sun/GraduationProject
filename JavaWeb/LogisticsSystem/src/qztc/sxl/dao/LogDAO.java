package qztc.sxl.dao;

import java.util.List;
import qztc.sxl.pojo.Log;

public interface LogDAO {
	public int addLog(Log log) throws Exception;
	public List<Log> getLogsById(String id) throws Exception;
	
}
