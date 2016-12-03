package edu.utdallas.cs6314.jsp.servlet.mvc.rest;

import java.io.IOException;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.wpl.commons.GZIPUtil;
import com.wpl.commons.HttpSessionUtil;
import com.wpl.commons.ParameterConstants;
import com.wpl.json.JsonParser;


@WebServlet("/BidServlet")
public class BidsServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1204852699550589060L;
	private static final Logger logger = LogManager.getLogger(Login.class);
	
	  public BidsServlet() {
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
			WebResource resource = client.resource("http://localhost:8080/RestHibernate/rest/bidRequest");
			
			Integer userId = HttpSessionUtil.getUserId(req);
			/*UriBuilder uriBuilder = resource.getUriBuilder();
			resource = client.resource(uriBuilder.queryParam(ParameterConstants.USER_ID, userId).build());*/
			ClientResponse clientResponse = resource.header("Accept-Encoding", "gzip")
					.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			//System.out.println("O am in showitemservlet");
			resp.setContentType(MediaType.APPLICATION_JSON);
			
		//GZIPInputStream is = new GZIPInputStream(clientResponse.getEntityInputStream());
	//	InputStream in = GZIPUtil.decompressGZIPAndSetOutput(clientResponse, resp);
			String json = JsonParser.parseJsonFromStream(clientResponse.getEntityInputStream());
			
			
			//System.out.println(dataMap.get(ParameterConstants.USER_ID));
			/* System.out.println("jsonArray"+ jsonArray);
			System.out.println("DOne");*/
			/*HttpSession ss = req.getSession();
			ss.setAttribute("data", dataMap);
			*/
		
			//resp.setCharacterEncoding("UTF-8");
			req.setAttribute("data", json);
			
			RequestDispatcher rd=req.getRequestDispatcher("ShowBids.jsp");  
			rd.forward(req, resp);
			
			
		}/* else {
			String errorMsg = "There is no valid session associated with request. Not fetching the user details!";
			//logger.error(errorMsg);
			resp.getWriter().println(errorMsg);
		}*/
	
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 // System.out.println(request.getInputStream());
	  

	 
		/* (HttpSessionUtil.isSessionValid(request)) {
			Integer userId = HttpSessionUtil.getUserId(request);*/
		Client client = new Client();
		WebResource resource = client.resource("http://localhost:8080/RestHibernate/rest/bidRequest/Bid");
		
		
		  BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	      String json = "";
	      if(br != null){
	          json = br.readLine();
	      }
	System.out.println(json+ "  ");
	Map<String, Object> dataMap = JsonParser.parseJsonMap(json);
	System.out.println(dataMap.get("p_id")+ " " + dataMap.get("id") + " " + dataMap.get("bid_price") );
		MultivaluedMap formData = new MultivaluedMapImpl();
		
		formData.putSingle(ParameterConstants.USER_ID,dataMap.get("id"));
		
		formData.putSingle(ParameterConstants.PID,dataMap.get("p_id") );
		formData.putSingle(ParameterConstants.BPRICE,dataMap.get("bid_price"));	
		System.out.println(request.getParameter(ParameterConstants.USER_ID) + "Request must have it");
		ClientResponse restResponse = resource
			    .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).header("Accept-Encoding", "gzip")
			    .post(ClientResponse.class, formData);
		
		response.setContentType(MediaType.APPLICATION_JSON_TYPE.toString());
		//GZIPInputStream is = new GZIPInputStream(restResponse.getEntityInputStream());
		//InputStream is = new InputStream();
		//System.out.println(response.toString());
		
		Map<String, Object> dataMap1 = JsonParser.parseJsonMapFromStream(restResponse.getEntityInputStream());
		Object bid = (Integer)dataMap.get(ParameterConstants.BID);
		if(bid !=null){
			HttpSession session = request.getSession();
			session.setAttribute(ParameterConstants.USER_ID, request.getParameter(ParameterConstants.USER_ID));
			request.getRequestDispatcher("ShowcaseItems.jsp").forward(request, response);
		}
		else
			request.getRequestDispatcher("error.jsp").forward(request, response);
}
		
		//GZIPUtil.decompressGZIPAndSetOutput(resp, response);}



		protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    //The following are CORS headers. Max age informs the 
		    //browser to keep the results of this call for 1 day.
		    resp.setHeader("Access-Control-Allow-Origin", "*");
		    resp.setHeader("Access-Control-Allow-Methods", "GET, POST");
		    resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
		    resp.setHeader("Access-Control-Max-Age", "86400");
		    //Tell the browser what requests we allow.
		    resp.setHeader("Allow", "GET, HEAD, POST, TRACE, OPTIONS");
		}

}


