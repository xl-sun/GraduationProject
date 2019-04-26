package qztc.sxl.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import qztc.sxl.service.EmployeeInfoService;
import qztc.sxl.service.impl.EmployeeInfoServiceImpl;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/Client/Home")
public class HomeServlet extends HttpServlet {	//返回用户名，用户职务及权限
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-Type","text/html;charset=UTF-8");

		HttpSession session =request.getSession();
		System.out.println("user："+session.getAttribute("userid"));
		//查询Employee,获取id，job、name
		EmployeeInfoService eInfoServ = new EmployeeInfoServiceImpl();
		JSONObject jsonEmp = eInfoServ.getEmployeeById(session.getAttribute("userid").toString());
		//查询Position，获取name，各权限
		JSONObject jsonPos = eInfoServ.getPositionByName(jsonEmp.optString("job"));
		//返回结果
		JSONObject json = jsonPos;
		json.put("name",jsonEmp.optString("name"));
		json.put("id",jsonEmp.optString("id")); //System.out.println(json+"");
		response.getWriter().append(json+"");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
