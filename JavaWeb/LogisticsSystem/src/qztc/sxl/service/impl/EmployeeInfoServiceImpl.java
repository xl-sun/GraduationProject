package qztc.sxl.service.impl;

import java.util.List;

import org.json.JSONObject;

import qztc.sxl.dao.DAOFactory;
import qztc.sxl.dao.EmployeeDAO;
import qztc.sxl.dao.PositionDAO;
import qztc.sxl.pojo.Employee;
import qztc.sxl.pojo.Position;
import qztc.sxl.service.EmployeeInfoService;

public class EmployeeInfoServiceImpl implements EmployeeInfoService {

	@Override
	public JSONObject getEmployeeById(String id) {
		// TODO Auto-generated method stub
		JSONObject json=new JSONObject();;
		EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
		try {
			Employee employee=employeeDAO.findById(id);
			json.put("name", employee.getName());
			json.put("id", employee.getId());
			json.put("job", employee.getJobTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	@Override
	public JSONObject getPositionByName(String jobName) {
		// TODO Auto-generated method stub
		JSONObject json=new JSONObject();
		PositionDAO positionDAO=DAOFactory.getPositionDAO();
		try {
			Position position=positionDAO.findByName(jobName);
			json.put("job", position.getName());
			json.put("sort", position.isSortPermit());
			json.put("receive", position.isReceivePermit());
			json.put("transport", position.isTransportPermit());
			json.put("delivery", position.isDeliveryPermit());	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		List<Employee> list =null;
		EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
		try {
			list=employeeDAO.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
