package qztc.sxl.dao;

import java.util.List;

import qztc.sxl.pojo.LogType;

public interface LogTypeDAO {
	public List<LogType> getAllLogeTypes() throws Exception;
	public String getNameById(Short id) throws Exception;
	public Short getIdByName(String name) throws Exception;
}
