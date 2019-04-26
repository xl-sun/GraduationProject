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
		//ͨ��GET��������֤�뵽�ֻ�
		AdminLoginService adminLoginServ = new AdminLoginServiceImpl();
		String id = request.getParameter("id");
		String code = adminLoginServ.getMSMCode(id);
		//��ѯ�û�
		if(code.equals("NOTFOUND")){
			response.getWriter().append("�����ڵ��û�");
		}else if(code.equals("ERRO")){
			response.getWriter().append("��ȡʧ��");
		}else{
			//�û����ڣ���֤��ɹ�����
			//������֤�뵽Session
			HttpSession session =request.getSession();
			session.setAttribute("yzm", code);
			session.setAttribute("userid", id);
			session.setAttribute("logincodetime", System.currentTimeMillis());
			//���Ͷ���
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
		//�Աȶ�����֤��
		HttpSession session = request.getSession();  
        if(session.getAttribute("yzm")!=null 
        		&& session.getAttribute("yzm").equals(request.getParameter("code"))){
        	//������֤ͨ��->��¼��������Ϣ
        	AdminLoginService alservice = new AdminLoginServiceImpl();
        	Admin admin = new Admin();
        	admin.setId((String) request.getParameter("username"));
        	admin.setPassword((String) request.getParameter("password"));
        	//MSMServer.SendMSM("18659631560", request.getParameter("code").toString());
    		//msg=String.format("����ҵ��ơ����ĵ�¼��̬����:%s��from:������Java����˽��ȫ�����ּ�����ϵͳ����", msg);  
        	String result = alservice.Login(admin);
        	//��¼�ɹ�->��ת
        	if(result.equals(AdminLoginServiceImpl.SUCCESS)){
        		session.setAttribute("user", admin.getId());
        		session.setAttribute("name", alservice.getNameById(admin.getId()));
        		System.out.println(admin.getName());
        		//response.sendRedirect("/");  //ҳ��jsʵ��
        		//�����֤��
        		session.removeAttribute("yzm");
        		session.removeAttribute("logincodetime");
        		response.getWriter().append("��¼�ɹ�!");
        	}else{ //��¼ʧ�ܣ��ص���¼ҳ�沢��ʾ
        		response.getWriter().append(result);
        	}
        }else{
        	//������֤�������Ϣ
        	response.getWriter().append("��֤�����!");////
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
