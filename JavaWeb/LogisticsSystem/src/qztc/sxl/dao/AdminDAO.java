package qztc.sxl.dao;

import qztc.sxl.pojo.Admin;

public interface AdminDAO {
	public int save(Admin admin) throws Exception;
	public Admin findById(String string) throws Exception;
	public int update(Admin admin) throws Exception;
}
