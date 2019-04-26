package qztc.sxl.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qztc.sxl.pojo.Admin;
import qztc.sxl.service.AdminLoginService;
import qztc.sxl.service.impl.AdminLoginServiceImpl;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/management/AdminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		//通过GET请求发送验证码到手机
		AdminLoginService adminLoginServ = new AdminLoginServiceImpl();
		String id = request.getParameter("id");
		String code = adminLoginServ.getMSMCode(id);
		//查询用户
		if(code.equals("NOTFOUND")){
			response.getWriter().append("不存在的用户");
		}else if(code.equals("ERRO")){
			response.getWriter().append("获取失败");
		}else{
			//用户存在，验证码成功生成
			//保存验证码到Session
			HttpSession session =request.getSession();
			session.setAttribute("yzm", code);
			session.setAttribute("userid", id);
			session.setAttribute("logincodetime", System.currentTimeMillis());
			//发送短信
			String result = adminLoginServ.sendMSMById(id, code);	System.out.println(result+":"+code);
			if(result.equals("COPY")){
				response.getWriter().append("success");
			}else{
				response.getWriter().append("success");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		//testPrintParamenters(request);
		//对比短信验证码
		HttpSession session = request.getSession();  
        if(session.getAttribute("yzm")!=null 
        		&& session.getAttribute("yzm").equals(request.getParameter("code"))){
        	//短信验证通过->登录并返回信息
        	AdminLoginService alservice = new AdminLoginServiceImpl();
        	Admin admin = new Admin();
        	admin.setId((String) request.getParameter("username"));
        	admin.setPassword((String) request.getParameter("password"));
        	//MSMServer.SendMSM("18659631560", request.getParameter("code").toString());
    		//msg=String.format("【毕业设计】您的登录动态码是:%s。from:《基于Java的隐私安全物流分拣、派送系统》。", msg);  
        	String result = alservice.Login(admin);
        	//登录成功->跳转
        	if(result.equals(AdminLoginServiceImpl.SUCCESS)){
        		session.setAttribute("user", admin.getId());
        		session.setAttribute("name", alservice.getNameById(admin.getId()));
        		System.out.println(admin.getName());
        		//response.sendRedirect("/");  //页面js实现
        		//清除验证码
        		session.removeAttribute("yzm");
        		session.removeAttribute("logincodetime");
        		response.getWriter().append("登录成功!");
        	}else{ //登录失败，回到登录页面并提示
        		response.getWriter().append(result);
        	}
        }else{
        	//返回验证码错误信息
        	response.getWriter().append("验证码错误!");////
        }
        
	}


	private void testPrintParamenters(HttpServletRequest  request){
		Enumeration<?> enu=request.getParameterNames();  
		while(enu.hasMoreElements()){  
			String paraName=(String)enu.nextElement();  
			System.out.println(paraName+": "+request.getParameter(paraName));  
		}
	}

}
