package qztc.sxl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import qztc.sxl.pojo.Region;
import qztc.sxl.service.RegionService;
import qztc.sxl.service.impl.RegionServiceImpl;

/**
 * Servlet implementation class RegionServlet
 */
@WebServlet("/RegionServlet")
public class RegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		RegionService regionServ = new RegionServiceImpl();
		JSONObject json = regionServ.getRegionsByPid(request.getParameter("pid").toString());
		response.getWriter().append(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		/*
		RegionService regionServ = new RegionServiceImpl();
		List<Region> list = regionServ.getRegionsByLevle(1);
		request.setAttribute("regions", list);
		request.getRequestDispatcher("/NewFile.jsp").forward(request, response);
		*/
		
		/*
		for(String name : regionServ.getNamesByLevle(1)) {
			  System.out.println(name);
			  response.getWriter().append(name);
			}*/
	}

}
