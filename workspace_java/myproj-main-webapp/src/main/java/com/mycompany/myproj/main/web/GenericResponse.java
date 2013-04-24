package com.mycompany.myproj.main.web;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GenericResponse")
public class GenericResponse implements RequestBodyResponse {

	@XmlElement
	private Map<String, String> data;

	public GenericResponse() {
		data = new HashMap<String, String>();
	}

	public Map<String, String> getData() {
		return data;
	}

}
