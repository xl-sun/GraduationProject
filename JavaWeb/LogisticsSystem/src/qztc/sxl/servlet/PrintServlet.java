package qztc.sxl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import qztc.sxl.pojo.LogisticsInfo;
import qztc.sxl.service.LogService;
import qztc.sxl.service.OrderService;
import qztc.sxl.service.RegionService;
import qztc.sxl.service.WaybillService;
import qztc.sxl.service.impl.LogServiceImpl;
import qztc.sxl.service.impl.OrderServiceImpl;
import qztc.sxl.service.impl.RegionServiceImpl;
import qztc.sxl.service.impl.WaybillServiceImpl;

/**
 * Servlet implementation class NullServlet
 */
@WebServlet("/WaybillPrint")
public class PrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String id=request.getParameter("id");
		WaybillService waybillServ = new WaybillServiceImpl();
		LogService LogServ = new LogServiceImpl();
		//验证单号、验证揽收
		if(!waybillServ.checkSheetId(id)){
			response.getWriter().append("无效单号！");return;
		}else if(LogServ.getStatusById(id)!=LogisticsInfo.NOT_RECEIVED){
			response.getWriter().append("已揽收，请勿重复打印！");return;
		}
		//获取QRCODE
		String qrcode = waybillServ.getQRcodeById(id);
		request.setAttribute("qrcode", qrcode);
		//获取MERGER_NAME
		JSONObject json = new JSONObject(qrcode);
		RegionService regionServ = new RegionServiceImpl();
		String mergername = regionServ.getMergerNameById(json.optString("des"));
		//获取地区名称
		request.setAttribute("desmergername", mergername);
		request.setAttribute("waybillid",id);
		request.getRequestDispatcher("/waybill-print-content.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
