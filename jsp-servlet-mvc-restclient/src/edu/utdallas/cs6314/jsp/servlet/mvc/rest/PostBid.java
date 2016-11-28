package edu.utdallas.cs6314.jsp.servlet.mvc.rest;

import java.io.IOException;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.wpl.commons.ParameterConstants;
import com.wpl.json.JsonParser;

/**
 * Servlet implementation class PostBid
 */
@WebServlet("/PostBid")
public class PostBid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostBid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Client client = new Client();
		WebResource resource = client.resource("http://localhost:8080/RestHibernate/rest/postBid/item");
		MultivaluedMap formData = new MultivaluedMapImpl();
		
		formData.putSingle(ParameterConstants.USER_ID, request.getParameter(ParameterConstants.USER_ID));
		
		formData.putSingle(ParameterConstants.PNAME, request.getParameter(ParameterConstants.PNAME));
		formData.putSingle(ParameterConstants.PDESC, request.getParameter(ParameterConstants.PDESC));	
		System.out.println(request.getParameter(ParameterConstants.USER_ID) + "Request must have it");
		ClientResponse restResponse = resource
			    .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).header("Accept-Encoding", "gzip")
			    .post(ClientResponse.class, formData);
		
		response.setContentType(MediaType.APPLICATION_JSON_TYPE.toString());
		GZIPInputStream is = new GZIPInputStream(restResponse.getEntityInputStream());
		//InputStream is = new InputStream();
		//System.out.println(response.toString());
		Map<String, Object> dataMap = JsonParser.parseJsonMapFromStream(is);
		Object pId = (Integer)dataMap.get(ParameterConstants.PID);
		if(pId !=null){
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}
		else
			request.getRequestDispatcher("error.jsp").forward(request, response);
		
		
		//GZIPUtil.decompressGZIPAndSetOutput(resp, response);
	}

	

}
