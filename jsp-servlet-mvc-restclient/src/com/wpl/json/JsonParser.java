package com.wpl.json;



import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {


	private static final ObjectMapper mapper = new ObjectMapper();

	public static String toJson(Object o) throws JsonProcessingException {
		return mapper.writeValueAsString(o);
	}

	public static <T> T fromJson(Class<T> c, String s) throws IOException {
		return mapper.readValue(s, c);
	}
		
	

	public static String convertToJson(Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(obj);
		
	}
	public static Object parseJson(String json, Class clazz) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, clazz);
		} catch (Exception e) {
			//logger.error("Unable to parse JSON. ", e);
			return null;
		}
	}

	public static String parseJsonFromStream(InputStream stream) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(stream, String.class);
		} catch (Exception e) {
			//logger.error("Unable to parse JSON. ", e);
			return null;
		}
	}

	public static Map<String, Object> parseJsonMap(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, new TypeReference<HashMap<String, Object>>() {
			});
		} catch (Exception e) {
			//logger.error("Unable to parse JSON. ", e);
			return null;
		}
	}

	public static Map<String, Object> parseJsonMapFromStream(InputStream inputStream) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(inputStream, new TypeReference<HashMap<String, Object>>() {
			});
		} catch (Exception e) {
			//Logger.error("Unable to parse JSON. ", e);
			System.out.println("hello null" );
			return null;
		}
	}
/*
	public static String convertToJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			logger.error("Unable to convert the object to JSON.", e);
			return null;
		}*/

}
