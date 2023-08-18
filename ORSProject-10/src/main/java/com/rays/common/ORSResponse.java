package com.rays.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains REST response
 * 
 * @author Jayati Chouhan
 * 
 *
 */
public class ORSResponse {

	public static String DATA = "data";
	public static String INPUT_ERROR = "inputerror";
	public static String MESSAGE = "message";

	private boolean success = false;

	private Map<String, Object> result = new HashMap<String, Object>();

	private String jwttoken;

	public ORSResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
	
	public ORSResponse() {
	}

	public ORSResponse(boolean success) {
		this.success = success;
	}

	public ORSResponse(boolean success, String message) {
		this.success = success;
		addMessage(message);
	}

	public ORSResponse(boolean success, String message, Object value) {
		this.success = success;
		addMessage(message);
		addData(value);
	}

	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Map<String, Object> getresult() {
		return result;
	}

	public void setresult(Map<String, Object> result) {
		this.result = result;
	}

	public void addresult(String key, Object value) {
		result.put(key, value);//preload and image
	}

	public void addData(Object value) {
		result.put(DATA, value);//list
	}

	public void addInputErrors(Object value) {
		result.put(INPUT_ERROR, value);//input validations
	}

	public void addMessage(Object value) {
		result.put(MESSAGE, value);//business validations
	}

}
