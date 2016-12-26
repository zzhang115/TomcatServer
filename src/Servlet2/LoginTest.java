package Servlet2;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;


/**
 * Servlet implementation class LoginTest
 */
@WebServlet("/LoginTest")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String loginMessage="";
	private static final String velocity_path = "vms/LoginServlet.vm";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginTest() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		out.println("Hello");
//		response.setContentType("text/html");
//		response.setStatus(HttpServletResponse.SC_OK);
//		try 
//		{
//			bodycontent(request, response, velocity_path);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
//		response.setStatus(HttpServletResponse.SC_OK);
//		response.flushBuffer();
	}
	private void bodycontent(HttpServletResponse response, String Path) throws Exception 
	{
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty("resource.loader", "class");
		ve.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		ve.init();
		Template template = ve.getTemplate(Path);
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("loginMessage", loginMessage);

		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);
		PrintWriter out = response.getWriter();
		out.printf(stringWriter.toString());
	}
}
