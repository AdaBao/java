package cn.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Decoder;

/**
 * Servlet implementation class TestAuth
 */
@WebServlet("/TestAuth")
public class TestAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAuth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
			if(!checkHeaderAuth(request, response)){
				response.setStatus(401);
				response.setHeader("Cache-Control", "no-store");
				response.setDateHeader("Expires", 0);
				response.setHeader("WWW-authenticate", "Basic Realm=\"test\"");
			}else
				response.getWriter().print("authentication successfully!!!");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private boolean checkHeaderAuth(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 
		String auth = request.getHeader("Authorization");
		System.out.println("auth encoded in base64 is " + getFromBASE64(auth));
		
		if ((auth != null) && (auth.length() > 6)) {
			auth = auth.substring(6, auth.length());
 
			String decodedAuth = getFromBASE64(auth);
			String [] up=decodedAuth.split(":");
			if(up[0].equals("liferaynoteasy")&&up[1].equals("liferayiseasy"))
			return true;
			else
				return false;
		}else{
			return false;
		}
 
	}
	
	private String getFromBASE64(String s) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}



}
