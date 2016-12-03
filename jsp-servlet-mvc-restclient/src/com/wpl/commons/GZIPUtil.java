package com.wpl.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.ClientResponse;

public class GZIPUtil {

	public static String decompressGZIPAndSetOutput(ClientResponse resp, HttpServletResponse servletResp)
			throws IOException {
		GZIPInputStream gzipIS = new GZIPInputStream(resp.getEntityInputStream());
		
		
		
		 BufferedReader bf = new BufferedReader(new InputStreamReader(gzipIS, "UTF-8"));
	        String outStr = "";
	        String line;
	        while ((line=bf.readLine())!=null) {
	          outStr += line;
	        }
		/*ServletOutputStream outputStream = servletResp.getOutputStream();
		int result = gzipIS.read();
		while (result != -1) {
			outputStream.write((byte) result);
			result = gzipIS.read();
		}*/
	        
	       
		gzipIS.close();
		return outStr;
		/*outputStream.close();*/
	}

}
