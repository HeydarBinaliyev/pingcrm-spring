package com.app.monolightdemo.inertia;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Component
@RequestScope
public class Inertia {

	private final String rootViewName = "index";
	
	@Autowired
	private   HttpServletRequest request;
	
	@Autowired
	private  HttpServletResponse response;
	
	
	public  Object generateResponse(String component, Map<String, Object> props) {
		
		if(request != null) {

			Map<String, Object> inertiaProps = populateProps(component, props);
			
			populateResponseHeaders();
			
			String data = new Gson().toJson(inertiaProps);

			if(request.getHeader("X-Inertia") != null) {
				
				if(request.getHeader("X-Inertia").equals("true")) {
					
					return new ResponseEntity<>(data, HttpStatus.OK);
				}
			}
			else {
				
				ModelAndView view = new ModelAndView(rootViewName);
				view.addObject("page", data);
				return view;
				
			}
		
		}
		
		return null;
	}
	
	private  void populateResponseHeaders() {
		
		response.addHeader("X-Inertia", "true");
		response.addHeader("Vary", "Accept");
		response.addHeader("Content-Type", "application/json");
		
	}
	
	private  Map<String, Object> populateProps( String component, Map<String, Object> props) {
		
		Map<String, Object> inertiaProps = new HashMap<>();
		
		inertiaProps.put("url", request.getRequestURI());
		inertiaProps.put("version","");
		inertiaProps.put("component", component);
		inertiaProps.put("props", props);
		
		return inertiaProps;
		
	}

}
