package qztc.sxl.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/TerifyServlet")
public class TerifyServlet extends HttpServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
		System.out.println("TerifyServlet");
		
		/*if(){
			arg0.getRequestDispatcher("management/LoginTest.html").forward(arg0, arg1);
		}else{
			arg0.getRequestDispatcher("management/LoginTest.html").forward(arg0, arg1);

		}*/
		
		
	}

}
