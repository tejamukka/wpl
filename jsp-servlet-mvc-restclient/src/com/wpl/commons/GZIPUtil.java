package com.wpl.commons;

import java.io.IOException;
import java.util.zip.GZIPInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.ClientResponse;

public class GZIPUtil {

	public static void decompressGZIPAndSetOutput(ClientResponse resp, HttpServletResponse servletResp)
			throws IOException {
		GZIPInputStream gzipIS = new GZIPInputStream(resp.getEntityInputStream());
		ServletOutputStream outputStream = servletResp.getOutputStream();
		int result = gzipIS.read();
		while (result != -1) {
			outputStream.write((byte) result);
			result = gzipIS.read();
		}
		gzipIS.close();
		outputStream.close();
	}

}
