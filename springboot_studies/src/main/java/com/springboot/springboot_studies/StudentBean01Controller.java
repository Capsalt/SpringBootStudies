package com.springboot.springboot_studies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class StudentBean01Controller {
	
	//@RequestMapping(method=RequestMethod.GET, path = "/getRequest")
	//@ResponseBody
	//public String getMethod1() {
		//return "Get Request Method1 calistirildi...";
	//}
	
	@GetMapping(path = "/getString")
	public String getMethod1() {
		return "Get Request Method1 calistirildi...";
	}
	
	//Tight Coupling
	@GetMapping(path = "/getObjectTight")
	public StudentBean01 getMethod2() {
		
		return new StudentBean01("Ali", 14, "4");
	}
	
	//Loose Coupling
	@Autowired
	StudentBean01 s;
	@GetMapping(path = "/getObjectLoose")
	public StudentBean01 getMethod3() {
		s.setName("Veli");
		s.setAge(15);
		s.setId("7");
		
		return s; 
	}
	
	@GetMapping(path = "/getObjectParametreli/{school}")
	public StudentBean01 getMethod4(@PathVariable String school) {
		
		s.setName("Mehmet");
		s.setAge(32);
		s.setId("87");
		
		return s; 
		
	}
	
	
	@Autowired
	StudentBean01 t;
	
	@GetMapping(path = "/getStudy")
	public String getMethod7() {
		return t.study();
	}
	
	

}
