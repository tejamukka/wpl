package com.services.rest;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
 
@Path("/loginservices")
public class LoginServices {
	@Path("/checkuservalidity")
	@POST
	@Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.TEXT_PLAIN)
	public Response isValidUser(MultivaluedMap<String, String> formParam) {
		boolean response = false;
		if(formParam.getFirst("password").equals("admin1")){
			response = true;
		}
		else{
			response = false;
		}
		return Response.ok().entity(String.valueOf(response)).build();
	}
	
	@Path("/availableusername/{username}")
	@GET
	public String availableUsername(@PathParam("username") String username) {
		
		return username + "001";
	}
	
	
	
	
	
}
