package cn.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Decoder;

/**
 * Servlet implementation class TestConfiguration
 */
@WebServlet("/TestConfiguration")
public class TestConfiguration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestConfiguration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		//System.out.println(session.getAttribute("auth"));
		Boolean isAuth=session.getAttribute("auth")==null?false:(Boolean)session.getAttribute("auth");
		if(isAuth)
		{
			 response.getWriter().println("auth already");
			 return;
		}
		
		
		String auth = request.getHeader("Authorization");
		if ((auth != null) && (auth.length() > 6)) {
			auth = auth.substring(6, auth.length());

			BASE64Decoder decoder=new BASE64Decoder();
			String decodedAuth = new String(decoder.decodeBuffer(auth));
			String [] up=decodedAuth.split(":");
			if(up[0].equals("liferaynoteasy")&&up[1].equals("liferayiseasy"))
				{
				//System.out.println("ssss004");
				   response.getWriter().println("auth successfully");
				   session.setAttribute("auth", true);
				}
			else
				response.getWriter().println("auth failure");		
		}else{
			response.setStatus(401);
			response.setHeader("WWW-authenticate", "Basic Realm=\"test\"");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request,response);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
