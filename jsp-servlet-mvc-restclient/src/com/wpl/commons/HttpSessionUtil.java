package com.wpl.commons;


import javax.servlet.http.HttpServletRequest;



public class HttpSessionUtil {

	public static boolean isSessionValid(HttpServletRequest request) {
		Object sessionAttr = request.getSession().getAttribute(ParameterConstants.USER_ID);

		// return (sessionAttr == null) ? true : true;
		return (sessionAttr == null) ? false : true;
	}

	public static Integer getUserId(HttpServletRequest request) {
		// return new Integer(1001);
		return (Integer) request.getSession().getAttribute(ParameterConstants.USER_ID);

	}

}
