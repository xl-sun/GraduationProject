

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qztc.sxl.pojo.LogisticsInfo;
import qztc.sxl.test.TestLogisticsInfoDAO;
import qztc.sxl.util.DBConnection;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
		//res.getWriter().write("res.getWriter().write(ServletFirst)");
		System.out.println("System.out.println(ServletFirst)");

		try {
			LogisticsInfo info = new TestLogisticsInfoDAO().getLogisticsInfoById("777");
			req.setAttribute("qrcode", info.getQrCode());
			System.out.println(info.getId());
			System.out.println(info.getStatus());
			System.out.println(info.getQrCode());
			System.out.println(info.getVerifyCode());
			System.out.println(info);
			
			req.getRequestDispatcher("/Test.jsp").forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
