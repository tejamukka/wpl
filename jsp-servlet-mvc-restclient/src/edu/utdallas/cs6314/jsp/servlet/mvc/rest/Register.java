package edu.utdallas.cs6314.jsp.servlet.mvc.rest;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.wpl.commons.ParameterConstants;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			//SSLTool.disableCertificateValidation();
			Client client = new Client();
			WebResource resource = client.resource("http://localhost:8080/RestHibernate/createUser");
			MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
			formData.putSingle(ParameterConstants.EMAIL, request.getParameter(ParameterConstants.EMAIL));
			formData.putSingle(ParameterConstants.PASSWORD, request.getParameter(ParameterConstants.PASSWORD));
			formData.putSingle(ParameterConstants.USERNAME, request.getParameter(ParameterConstants.USERNAME));
			formData.putSingle(ParameterConstants.FIRST_NAME, request.getParameter(ParameterConstants.FIRST_NAME));
			formData.putSingle(ParameterConstants.LAST_NAME, request.getParameter(ParameterConstants.LAST_NAME));

			/*if (HttpSessionUtil.isSessionValid(request)) {
				Integer userId = HttpSessionUtil.getUserId(request);
				formData.putSingle(ParameterConstants.USER_ID, String.valueOf(userId));
			}*/

			
		System.out.println(request.getParameter(ParameterConstants.EMAIL));
			ClientResponse restResponse = resource
				    .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
				    .post(ClientResponse.class, formData);
			
			response.setContentType(MediaType.APPLICATION_JSON);
			System.out.println(restResponse);
			if (restResponse.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : helooooooooo****************** " + restResponse.getStatus());
			}
			else System.out.println("Balle balle!");
			//GZIPUtil.decompressGZIPAndSetOutput(resp, response);
		}

		/*@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			if (HttpSessionUtil.isSessionValid(req)) {
				SSLTool.disableCertificateValidation();
				Client client = new Client();
				WebResource resource = client.resource(CREATE_USER_SERVICE_URL);
				Integer userId = HttpSessionUtil.getUserId(req);
				UriBuilder uriBuilder = resource.getUriBuilder();
				resource = client.resource(uriBuilder.queryParam(ParameterConstants.USER_ID, userId).build());
				ClientResponse clientResponse = resource.header("Accept-Encoding", "gzip")
						.header(ParameterConstants.SECRET_KEY_NAME, ParameterConstants.SECRET_KEY_VALUE)
						.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
				resp.setContentType(MediaType.APPLICATION_JSON);
				GZIPUtil.decompressGZIPAndSetOutput(clientResponse, resp);

			} else {
				String errorMsg = "There is no valid session associated with request. Not fetching the user details!";
				logger.error(errorMsg);
				resp.getWriter().println(errorMsg);
			}
		}*/

		
	}


