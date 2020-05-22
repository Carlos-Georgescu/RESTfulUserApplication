package com.in28minutes.rest.webservices.restfulwebservices.helloworld;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import com.in28minutes.rest.webservices.restfulwebservices.user.UserDaoService;

//Controller: handling HTTP requests
@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	
	//Get Method
	//URI - /hello-world
	//method that returns Hello World
	//@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	//hello-world-bean
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	//path parameter
		@GetMapping(path="/hello-world/path-variable/{name}")
		public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
			return new HelloWorldBean(String.format("Hello World %s", name));
		}
	//message source
	//the locale is passed in the parameter so that the user can say what language they want the message in
		@GetMapping(path="/hello-world/internationalized")
		//the requestHeader is automatically to english if the user does not type anything
		public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
			return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
		}	
		
		


}
