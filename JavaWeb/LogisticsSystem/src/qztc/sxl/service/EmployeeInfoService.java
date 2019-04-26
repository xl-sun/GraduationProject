package qztc.sxl.service;

import java.util.List;

import org.json.JSONObject;

import qztc.sxl.pojo.Employee;

public interface EmployeeInfoService {
	public JSONObject getEmployeeById(String id);
	public JSONObject getPositionByName(String jobName);
	public List<Employee> getAll();
}
