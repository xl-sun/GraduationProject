/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.92
 * Generated at: 2019-04-10 23:43:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("\t<title>隐私安全快递 - 基于Java的隐私安全物流分拣、派送系统设计与实现</title>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"./js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"./js/jquery.slides.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"./js/index.js\"></script>\r\n");
      out.write("\t<link href=\"./css/index.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.html", out, false);
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"main\">\r\n");
      out.write("\t\t<div class=\"div_banner\">\r\n");
      out.write("\t\t\t<img src=\"img/banner01.jpg\" width=\"600\" height=\"225\" alt=\"\">\r\n");
      out.write("\t\t\t<img src=\"img/banner02.jpg\" width=\"600\" height=\"225\" alt=\"\">\r\n");
      out.write("\t\t\t<img src=\"img/banner03.jpg\" width=\"600\" height=\"225\" alt=\"\">\r\n");
      out.write("\t\t\t<img src=\"img/banner04.jpg\" width=\"600\" height=\"225\" alt=\"\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"index_box\" style=\"float:right\">\r\n");
      out.write("\t        <ul Style=\"margin:0px\">\r\n");
      out.write("\t\t\t\t<h3 Style=\"margin:5px\">快件查询</h3>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t            <form id=\"form\" name=\"form\" enctype=\"application/x-www-form-urlencoded\" action=\"./Tracking\" method=\"get\" target=\"_blank\">\r\n");
      out.write("\t            \t<textarea name=\"id\" id=\"waybill_text\" class=\"search_no\"></textarea>\r\n");
      out.write("\t\t            <div>\r\n");
      out.write("\t\t                <input type=\"submit\" value=\"查 询\" class=\"index_botton_sumbit\" id=\"waybill_search\"\">\r\n");
      out.write("\t\t                <input type=\"button\" value=\"清 除\" class=\"index_botton_sumbit\" id=\"waybill_clear\" onclick=\"clear_waybill()\">\r\n");
      out.write("\t\t            </div>\r\n");
      out.write("\t            </form>\r\n");
      out.write("\t        </ul>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.html", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
