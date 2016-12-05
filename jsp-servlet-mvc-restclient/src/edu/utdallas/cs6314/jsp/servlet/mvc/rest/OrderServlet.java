package edu.utdallas.cs6314.jsp.servlet.mvc.rest;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.spi.factory.ResponseBuilderImpl;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.wpl.commons.HttpSessionUtil;
import com.wpl.commons.ParameterConstants;
import com.wpl.json.JsonParser;


/**
 * Servlet implementation class Order
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final String ORDER_SERVICE_URL = "http://localhost:8080/RestHibernate/rest/order";
	private static final long serialVersionUID = -2526481505477971154L;
//	private static final Logger logger = LogManager.getLogger(Order.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SSLTool.disableCertificateValidation();
		if (HttpSessionUtil.isSessionValid(request)) {
			String queryString = request.getQueryString();
			if (queryString == null)
				queryString = "";

			Integer userId = HttpSessionUtil.getUserId(request);

			Client client = new Client();
			WebResource resource = client.resource(ORDER_SERVICE_URL);
			UriBuilder uriBuilder = resource.getUriBuilder();
			resource = client.resource(
					uriBuilder.replaceQuery(queryString).queryParam(ParameterConstants.USER_ID, userId).build());
			ClientResponse clientResponse = resource.header("Accept-Encoding", "gzip")
					.header(ParameterConstants.SECRET_KEY_NAME, ParameterConstants.SECRET_KEY_VALUE)
					.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			response.setContentType(MediaType.APPLICATION_JSON);
			GZIPUtil.decompressGZIPAndSetOutput(clientResponse, response);
		} else {
			String errorMsg = "There is no valid session associated with the user. Not fetching the orders";
			logger.error(errorMsg);
			response.getWriter().println(errorMsg);
		}
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		Client client = new Client();
		WebResource resource = client.resource("http://localhost:8080/RestHibernate/rest/order/createOrder");
			Integer userId = HttpSessionUtil.getUserId(request);
            System.out.println(userId  + "session has userID");
			 BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		      String json = "";
		      if(br != null){
		          json = br.readLine();
		      }
		System.out.println(json+ " hihhihi  ");
	
		Map<String, Object> dataMap = JsonParser.parseJsonMap(json);
		ArrayList a = new ArrayList<>();
		a = (ArrayList) dataMap.get("items");
		Map<String, Object> dataMap1= JsonParser.parseJsonMap(JsonParser.toJson(a.get(0)));
		MultivaluedMap formData = new MultivaluedMapImpl();
			formData.putSingle(ParameterConstants.ORDER_ITEMS,dataMap1.get("quantity"));
			formData.putSingle(ParameterConstants.SELLERID,dataMap1.get("userId") );
			formData.putSingle(ParameterConstants.TOTAL,dataMap.get("total"));
	     	formData.putSingle(ParameterConstants.USER_ID, String.valueOf(userId));
			ClientResponse resp = resource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.header("Accept-Encoding", "gzip")
					.post(ClientResponse.class, formData);
			response.setContentType(MediaType.APPLICATION_JSON);
			//response.setContentType(MediaType.APPLICATION_JSON_TYPE.toString());
		} 

	}



