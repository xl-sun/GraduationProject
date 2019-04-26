package qztc.sxl.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import qztc.sxl.pojo.Log;
import qztc.sxl.pojo.LogisticsInfo;
import qztc.sxl.service.LogService;
import qztc.sxl.service.RegionService;
import qztc.sxl.service.WaybillService;
import qztc.sxl.service.impl.LogServiceImpl;
import qztc.sxl.service.impl.RegionServiceImpl;
import qztc.sxl.service.impl.WaybillServiceImpl;

/**
 * Servlet implementation class LogUpdateServlet
 */
@WebServlet("/Client/LogUpdateServlet")
public class LogUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-Type","text/html;charset=UTF-8");
		//String method=request.getParameter("method");
		boolean isSuccess=false;
		String result="";
		String id = request.getParameter("id");

		Short method = new Short(request.getParameter("method"));
		//LogService LogServ = new LogServiceImpl();
		WaybillService waybillServ = new WaybillServiceImpl();
		LogService LogServ = new LogServiceImpl();
		
		
		if(method==LogisticsInfo.RECEIVED){
			if(LogServ.getStatusById(id)!=LogisticsInfo.NOT_RECEIVED)
				result="此件已揽收";
			else{
				String des = request.getParameter("des");
				isSuccess = waybillServ.checkSheetId(id);
				if(isSuccess){
					RegionService regionServ = new RegionServiceImpl();
					//result = findRegionByID
					result = regionServ.getMergerNameById(des);
				}
			}
		}else{
			if(LogServ.getStatusById(id)==LogisticsInfo.NOT_RECEIVED)
				result="此件未揽收";
			else
				isSuccess=true;
		}

		
		JSONObject json = new JSONObject();
		json.put("success", isSuccess);
		json.put("result", result);
		response.getWriter().append(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-Type","text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String info =request.getParameter("info");
		String id =request.getParameter("id");
		Short status = new Short(request.getParameter("method"));
		Short tid = null;//new Short(request.getParameter("tid").toString());
		
		switch (status){
		//receive
		case LogisticsInfo.RECEIVED:
			info+="揽收员:";break;
		//sort
		case LogisticsInfo.SORTED:
			info+="分拣员:";break;
			//LogServ.updateStatus(id, LogisticsInfo.SORTED);
		//transport
		case LogisticsInfo.TRANSPORTED:
			info+="扫描员:";break;
		//delivery
		case LogisticsInfo.DELIVRYING:
			info+="派送员:";break;
		case LogisticsInfo.DELIVRYED:
			info="已签收";break;
		}
		info+=session.getAttribute("userjob") + "["+session.getAttribute("userid")+"]";
		Log log = new Log(id,tid,info,null);
		System.out.println(info);
		LogService LogServ = new LogServiceImpl();
		boolean result = LogServ.addLog(log);
		if(result)LogServ.updateStatus(id,status);
		response.getWriter().append(result+"");//?"揽收成功":"揽收失败");
	}

}
