package qztc.sxl.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import qztc.sxl.pojo.LogisticsInfo;
import qztc.sxl.pojo.Waybill;
import qztc.sxl.service.OrderService;
import qztc.sxl.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/Order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String sender=request.getParameter("sender");
		String srcRegion=request.getParameter("srcregion");
		String senderAddr=request.getParameter("senderaddr");
		String senderPhone=request.getParameter("senderphone");
		String recipient=request.getParameter("recipient");
		String desRegion=request.getParameter("desregion");
		String recipientAddr=request.getParameter("recipientaddr");
		String recipientPhone=request.getParameter("recipientphone");
		String setQueryCode=request.getParameter("querycode");
		
		SimpleDateFormat dataFromat = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String id = dataFromat.format(new Date());//通过时间生成单号前缀
		Random random = new Random();
		for(int i=0;i<4;i++)
			id+=random.nextInt(10);//通过随机数生成后缀
		Waybill waybill = new Waybill(id,sender,senderAddr,senderPhone,recipient,recipientAddr,recipientPhone);
		OrderService orderServ = new OrderServiceImpl();
		if(!orderServ.saveWaybill(waybill)){
			  response.getWriter().append("填单失败！");
			  return;
		}
		
		JSONObject qrcode=new JSONObject();
		qrcode.put("id",id);
		qrcode.put("src",srcRegion);
		qrcode.put("des",desRegion);
		LogisticsInfo logiInfo = new LogisticsInfo(id,LogisticsInfo.NOT_RECEIVED,qrcode.toString(),setQueryCode.equals("no")?null:request.getParameter("code"));
		if(!orderServ.saveLogisticsInfo(logiInfo)){
			  response.getWriter().append("生成日志失败！");
			  return;
		}

		request.setAttribute("desmergername", request.getParameter("desmergername"));
		request.setAttribute("qrcode", qrcode.toString());
		request.setAttribute("waybillid",id);
		request.getRequestDispatcher("/waybill-print-content.jsp").forward(request, response);

	}

}
