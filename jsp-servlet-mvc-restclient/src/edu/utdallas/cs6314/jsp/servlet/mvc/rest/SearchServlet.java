package edu.utdallas.cs6314.jsp.servlet.mvc.rest;



import java.io.IOException;
import java.io.InputStream;
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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.wpl.commons.GZIPUtil;
import com.wpl.commons.HttpSessionUtil;
import com.wpl.commons.ParameterConstants;
import com.wpl.json.JsonParser;

@WebServlet("/search")
public class SearchServlet  extends HttpServlet{
	
	//private static final String LOGIN_SERVICE_URL = "http://localhost:8080/RestHibernate/rest/login";
	private static final long serialVersionUID = 1204852699550589060L;
	private static final Logger logger = LogManager.getLogger(Login.class);
	
	  public SearchServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
	 /* protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}*/
  
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//if (HttpSessionUtil.isSessionValid(req)) {
		//	SSLTool.disableCertificateValidation();
			Client client = new Client();
			WebResource resource = client.resource("http://localhost:8080/RestHibernate/rest/Search");
			String search = req.getParameter("search");
			System.out.println(search+ "   ");
			//	System.out.println( req.getParameter("userId"));
				UriBuilder uriBuilder = resource.getUriBuilder();
				resource = client.resource(uriBuilder.queryParam(ParameterConstants.SEARCH, search).build());
			//Integer userId = HttpSessionUtil.getUserId(req);
			/*UriBuilder uriBuilder = resource.getUriBuilder();
			resource = client.resource(uriBuilder.queryParam(ParameterConstants.USER_ID, userId).build());*/
			ClientResponse clientResponse = resource.header("Accept-Encoding", "gzip")
					.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			//System.out.println("O am in showitemservlet");
			resp.setContentType(MediaType.APPLICATION_JSON);
			
		//GZIPInputStream is = new GZIPInputStream(clientResponse.getEntityInputStream());
	//	InputStream in = GZIPUtil.decompressGZIPAndSetOutput(clientResponse, resp);
		//	Map<String, Object> dataMap = JsonParser.parseJsonMapFromStream(is);
			
			 String jsonArray =GZIPUtil.decompressGZIPAndSetOutput(clientResponse, resp);
			//System.out.println(dataMap.get(ParameterConstants.USER_ID));
			/* System.out.println("jsonArray"+ jsonArray);
			System.out.println("DOne");*/
			/*HttpSession ss = req.getSession();
			ss.setAttribute("data", dataMap);
			*/
		
			resp.setCharacterEncoding("UTF-8");
			req.setAttribute("jsonArray", jsonArray);
			
			RequestDispatcher rd=req.getRequestDispatcher("ShowcaseItems.jsp");  
			rd.forward(req, resp);
			
			
		}/* else {
			String errorMsg = "There is no valid session associated with request. Not fetching the user details!";
			//logger.error(errorMsg);
			resp.getWriter().println(errorMsg);
		}*/
	

}
