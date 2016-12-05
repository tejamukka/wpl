package edu.utdallas.cs6314.jsp.servlet.mvc.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;


import java.util.zip.GZIPInputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import com.wpl.commons.ParameterConstants;
import com.wpl.json.JsonParser;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	private static final String LOGIN_SERVICE_URL = "http://localhost:8080/RestHibernate/rest/login";
	private static final long serialVersionUID = 1204852699550589060L;
	private static final Logger logger = LogManager.getLogger(Login.class);
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String email=request.getParameter("email");
		String password = request.getParameter("password");
		request.setAttribute("email", email);
		request.setAttribute("password", password);
		
		request.getRequestDispatcher("/DisplayLoginInfo.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		Client client = new Client();
		WebResource resource = client.resource(LOGIN_SERVICE_URL);
		MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
		formData.putSingle(ParameterConstants.EMAIL, request.getParameter(ParameterConstants.EMAIL));
		formData.putSingle(ParameterConstants.PASSWORD, request.getParameter(ParameterConstants.PASSWORD));
		/*formData.putSingle(ParameterConstants.IS_LOGIN_THROUGH_FB,
				request.getParameter(ParameterConstants.IS_LOGIN_THROUGH_FB));
		formData.putSingle(ParameterConstants.USERNAME, request.getParameter(ParameterConstants.USERNAME));*/
System.out.println("in here");
		ClientResponse resp = resource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
				.header("Accept-Encoding", "gzip")
				.post(ClientResponse.class, formData);
		
		
		
		response.setContentType(MediaType.APPLICATION_JSON_TYPE.toString());
		GZIPInputStream is = new GZIPInputStream(resp.getEntityInputStream());
		//InputStream is = new InputStream();
		//System.out.println(response.toString());
		System.out.println(resp.getEntityInputStream());
		Map<String, Object> dataMap = JsonParser.parseJsonMapFromStream(is);
		System.out.println(dataMap);
		Object userId = dataMap.get(ParameterConstants.USER_ID);
		Object uname = dataMap.get(ParameterConstants.USERNAME);
		Object fname = dataMap.get(ParameterConstants.FIRST_NAME);
		Object lname = dataMap.get(ParameterConstants.LAST_NAME);
		Object email = dataMap.get(ParameterConstants.EMAIL);
		Object llogin = dataMap.get(ParameterConstants.LAST_SUCCESSFUL_LOGIN_TIME);
		Object flogin = dataMap.get(ParameterConstants.FAILED_LOGIN_COUNT);
		
		System.out.println(fname);
		
		
		if (userId != null) {
			HttpSession session = request.getSession();
			Integer id = (Integer) userId;
			String firstname = (String)fname;
		session.setAttribute(ParameterConstants.FIRST_NAME, fname);
		session.setAttribute(ParameterConstants.LAST_NAME, (String)lname);
		session.setAttribute(ParameterConstants.EMAIL, (String)email);
		session.setAttribute(ParameterConstants.USERNAME, (String)uname);
		session.setAttribute(ParameterConstants.USER_ID, id);
		session.setAttribute(ParameterConstants.FAILED_LOGIN_COUNT, flogin);
		session.setAttribute(ParameterConstants.LAST_SUCCESSFUL_LOGIN_TIME, llogin);
		//	request.getRequestDispatcher("Display.jsp");
			
			
			RequestDispatcher rd=request.getRequestDispatcher("MyAccount.jsp");  
			//servlet2 is the url-pattern of the second servlet  
			  
			rd.forward(request, response);
			logger.debug("Successfully set the session attribute with userId: {}", id);
		}
		response.setStatus(200);
		/*PrintWriter writer = response.getWriter();
		writer.println(JsonParser.convertToJson(dataMap));
		//is.close();
		writer.close();*/
		
	}

}
