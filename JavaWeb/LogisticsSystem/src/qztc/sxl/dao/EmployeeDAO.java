package qztc.sxl.dao;

import java.sql.SQLException;
import java.util.List;

import qztc.sxl.pojo.Employee;

public interface EmployeeDAO {

	public int save(Employee employee) throws Exception;
	public Employee findById(String id) throws Exception;
	public int update(Employee employee) throws Exception;
	public int updateById(String id) throws Exception;
	public List<Employee> getAll() throws Exception;
}
