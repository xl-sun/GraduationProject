package qztc.sxl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import qztc.sxl.dao.EmployeeDAO;
import qztc.sxl.pojo.Employee;
import qztc.sxl.util.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String FINDBYID = "select * from employee where id=?";
	private static final String INSERT = "insert into employee(id,name,phone,job_title) values(?,?,?,?)";
	private static final String UPDATE = "update employee set name=?,phone=?,job_title=? where id=?";
	private static final String GET_ALL = "select * from employee";

	@Override
	public Employee findById(String id) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstat = null;
		Connection conn = null;
		ResultSet rs = null;
		Employee employee =new Employee(); //
		try{
			conn=DBConnection.getConnection();
			pstat=conn.prepareStatement(FINDBYID);
			pstat.setString(1, id);
			rs = pstat.executeQuery();
			if(rs.next()){
				employee.setId(rs.getString("id"));
				employee.setName(rs.getString("name"));
				employee.setPhone(rs.getString("phone"));
				employee.setJobTitle(rs.getString("job_title"));
			}
		}finally{
			DBConnection.close(rs, pstat, conn);
		}
		return employee;
	}

	@Override
	public int save(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateById(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> getAll() throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstat = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList<Employee>();
		try{
			conn=DBConnection.getConnection();
			pstat=conn.prepareStatement(GET_ALL);
			rs = pstat.executeQuery();
			while(rs.next()){
				list.add(new Employee(rs.getString("id"), 
						rs.getString("name"),
						rs.getString("phone"), 
						rs.getString("job_title")
						));
			}
		}finally{
			DBConnection.close(rs, pstat, conn);
		}
		return list;
	}

}
