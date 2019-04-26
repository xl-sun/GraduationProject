package qztc.sxl.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import qztc.sxl.pojo.Employee;
import qztc.sxl.service.EmployeeInfoService;
import qztc.sxl.service.EmployeeLoginService;
import qztc.sxl.service.impl.EmployeeInfoServiceImpl;
import qztc.sxl.service.impl.EmployeeLoginServiceImpl;

/**
 * Servlet implementation class EmployeeLoginServlet
 */
@WebServlet("/EmployeeLogin")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Content-Type","text/html;charset=UTF-8");
		try{
			if(!request.getParameter("method").equals("getcode")){
				response.getWriter().append("参数错误");
				return;
			}
		}catch(Exception e){
			response.getWriter().append("参数错误2");
			return;
		}
		
		EmployeeLoginService eLoginServ = new EmployeeLoginServiceImpl();
		String id = request.getParameter("id");
		String code = eLoginServ.getMSMCode(id);
		//查询用户
		if(code.equals("NOTFOUND")){
			response.getWriter().append("不存在的用户");
		}else if(code.equals("ERRO")){
			response.getWriter().append("获取失败");
		}else{
			//用户存在，验证码成功生成
			//保存验证码到Session
			HttpSession session =request.getSession();
			session.setAttribute("logincode", code);
			session.setAttribute("loginid", id);
			//	System.out.println(((long)session.getAttribute("logincodetime")-System.currentTimeMillis())/(1000));
			session.setAttribute("logincodetime", System.currentTimeMillis());
			//发送短信
			String result = eLoginServ.sendMSMById(id, code);	System.out.println(result);
			if(result.equals("COPY")){
				response.getWriter().append("发送成功");
			}else{
				response.getWriter().append(result);				
			}
			//response.getWriter().append("发送成功");
			System.out.println(session.getId());
			System.out.println(request.getParameter("id")+"\t"+code);
		}

		//String phone = eLoginServ.getMSMCode(request.getParameter("id"));
		///"code is:"+code);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setHeader("Content-Type","text/html;charset=UTF-8");
		HttpSession session =request.getSession();
		System.out.println(session.getId());
		String loginid,logincode;
		boolean idEquals,codeEquals;
		//检查参数
		try{
			loginid = session.getAttribute("loginid").toString();
			logincode = session.getAttribute("logincode").toString();
			idEquals = request.getParameter("id").equals(loginid);
			codeEquals = request.getParameter("code").equals(logincode);
		}catch(Exception e){
			response.getWriter().append("参数错误");
			System.out.println("参数错误");
			return;
		}
		//验证验证码合法
		try{
			long t = (System.currentTimeMillis()-(long)session.getAttribute("logincodetime"));
			System.out.println(t/1000);
			
			if((System.currentTimeMillis()-(long)session.getAttribute("logincodetime"))/(1000*60)>1){
				response.getWriter().append("登录码已过期");return;
			}
		}catch(Exception e){
			response.getWriter().append("请获取登录码");
		}
		//验证验证码匹配
		
			if(idEquals){
				if(codeEquals){
					//登录成功
					EmployeeInfoService eInfoServ = new EmployeeInfoServiceImpl();
					String id = request.getParameter("id");
					JSONObject employee =  eInfoServ.getEmployeeById(id);
					session.setAttribute("userid",id);
					session.setAttribute("username",employee.opt("name"));
					session.setAttribute("userjob",employee.opt("job"));
					session.removeAttribute("loginid");
					session.removeAttribute("logincode");
					response.getWriter().append("登录成功");
					return;
				}
			}
		response.getWriter().append("登录失败");
	}

}
