package com.services.rest;


import java.util.HashMap;
import java.util.Map;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Variant;

import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response;
import com.data.hibernate.DataInsertion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.jersey.core.spi.factory.ResponseBuilderImpl;
import com.wpl.commons.ParameterConstants;
import com.wpl.json.JsonParser;

@Path("/createUser")
public class CreateUserService {

	//private static final Logger logger = LogManager.getLogger(CreateUserService.class);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(@FormParam(ParameterConstants.USERNAME) String uname,
			@FormParam(ParameterConstants.PASSWORD) String password,
			@FormParam(ParameterConstants.EMAIL) String email,
			@FormParam(ParameterConstants.FIRST_NAME) String fname,
			@FormParam(ParameterConstants.LAST_NAME) String lname) throws JsonProcessingException {
		
		ResponseBuilder respBuilder = new ResponseBuilderImpl();
			
		
		 DataInsertion.addUser(uname, fname, lname, email,password);
		 Map<String, Object> responseData = new HashMap<String, Object>();
			responseData.put(ParameterConstants.EMAIL, email);
			Response response = respBuilder.entity(JsonParser.convertToJson(responseData)).build();
			return response;
		}

		

	

}
