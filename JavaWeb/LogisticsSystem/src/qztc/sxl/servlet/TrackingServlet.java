package qztc.sxl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qztc.sxl.pojo.Log;
import qztc.sxl.service.LogService;
import qztc.sxl.service.WaybillService;
import qztc.sxl.service.impl.LogServiceImpl;
import qztc.sxl.service.impl.WaybillServiceImpl;

/**
 * Servlet implementation class TrackingServlet
 */
@WebServlet("/Tracking")
public class TrackingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrackingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		WaybillService waybillServ = new WaybillServiceImpl();
		//验证单号
		if(!waybillServ.checkSheetId(id)){
			//response.getWriter().append("无效单号！");return;
			request.setAttribute("id","无效单号！");
		}else{
			request.setAttribute("id",id);
		}
		LogService logServ = new LogServiceImpl();
		List<Log> logs = logServ.getLogsById(id);
		request.setAttribute("logs", logs);
		request.getRequestDispatcher("/tracking.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
