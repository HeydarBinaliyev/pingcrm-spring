package com.app.monolightdemo.inertia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
			
			this.populateResponseHeaders();

			if(request.getHeader("X-Inertia") != null) {
				
				if(request.getHeader("X-Inertia").equals("true")) {
					
					if(this.isRequestPartialLoad(component)) 
							props = this.createPartialData(props);
					
					return new ResponseEntity<>( this.generateInertiaData(component, props), HttpStatus.OK);
				}
			}
			else {
				
				ModelAndView view = new ModelAndView(rootViewName);
				view.addObject( "page", this.generateInertiaData(component, props) );
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
	
	private boolean isRequestPartialLoad(String component) {
		
		if(request.getHeader("X-Inertia-Partial-Data") != null 
				&& request.getHeader("X-Inertia-Partial-Component").equals(component))
			return true;
		
		return false;
	}
	
	private Map<String, Object> createPartialData(Map<String, Object> props){
		
		List<String> requestedData = new ArrayList<>();
		
		Collections.addAll(requestedData, request.getHeader("X-Inertia-Partial-Data").split(","));
		System.err.println(requestedData);
		props.forEach((name,data) ->{
			if( !requestedData.contains(name) ) {
				props.replace(name, data, null);
			}
		});
		
		return props;
	}
	
	private String generateInertiaData(String component, Map<String, Object> props) {
		
		Map<String, Object> inertiaProps = this.populateProps(component, props);
		
		String data = new Gson().toJson(inertiaProps);
		
		return data;
	}

}
