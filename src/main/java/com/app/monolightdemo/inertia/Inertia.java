package com.app.monolightdemo.inertia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import com.app.monolightdemo.bean.UserBean;
import com.google.gson.GsonBuilder;

@Component
@RequestScope
public class Inertia {

	private final String rootViewName = "index";
	
	@Autowired
	UserBean userBean;
	
	@Autowired
	private   HttpServletRequest request;
	
	@Autowired
	private  HttpServletResponse response;
	
	@Autowired
	private HttpSession session;
	
	public  Object generateResponse(String component, Map<String, Object> props) {
		
		if(request != null) {
			
			this.changeRedirectCode();
			
			if(this.isRedirect()) {
				
				response.addHeader("Location", request.getHeader("Referer"));
				
				Object flash = props.get("flash");
				
				session.setAttribute("flash", flash);
				
				return new ResponseEntity<>(HttpStatus.valueOf(response.getStatus()));
			
			}
				
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
		
		String url = request.getRequestURI() +
				( request.getQueryString() !=null ? ( "?" + request.getQueryString() ):"" );
		
		inertiaProps.put("url", url);
	
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
		
		props.forEach((name,data) ->{
			
			if( !requestedData.contains(name) ) {
				
				props.replace(name, data, null);
				
			}
		});
		
		return props;
	}
	
	private String generateInertiaData(String component, Map<String, Object> props) {
		
		if(!isRequestPartialLoad(component))
			props = this.mergeProps(props);
		
		Map<String, Object> inertiaProps = this.populateProps(component, props);
		
		String data =new GsonBuilder().serializeNulls().create().toJson(inertiaProps);
		
		return data;
	}
	
	private Map<String, Object> mergeProps(Map<String, Object> props) {
		
		if(!props.containsKey("auth")) {
			
			Map<String, Object> auth  = new HashMap<>();
			
			auth.put("user", userBean.getUser());
			
			props.put("auth", auth);
		}
		if(!props.containsKey("errors")) {
			
			Map<String, Object> errors  = new HashMap<>();
			
			props.put("errors", errors);
		}
		if(!props.containsKey("flash")) {
			
			Map<String, Object> flash  = new HashMap<>();
			
			if(session.getAttribute("flash") != null) {
				
				@SuppressWarnings("unchecked")
				Map<String, Object> session_flash = (Map<String, Object>) session.getAttribute("flash");
				
				flash.put("success", session_flash.get("success"));
				
				flash.put("error", session_flash.get("error"));
				
				session.removeAttribute("flash");
			}
			
			props.put("flash", flash);
		}
		return props;
		
	}
	
	private boolean isRedirect() {
		
		return response.getStatus() == 303?true:false;
		
	}
	
	private void changeRedirectCode() {
		
		List<String> methodsForRedirect = Arrays.asList(new String[]{"PUT", "PATCH", "DELETE"});
		
		if(request.getHeader("X-Inertia") != null && methodsForRedirect.contains(request.getMethod()))
			response.setStatus(303);
	}

}
