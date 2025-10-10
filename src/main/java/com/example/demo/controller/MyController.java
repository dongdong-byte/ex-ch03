package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.Myservice;





@RestController
public class MyController {

//	자바가 객체를 생성하는 방식 -> 안사용함
//	Myservice myservice = new Myservice();
	
	
 Myservice myservice;
	public MyController(Myservice myservice) {
		
		this.myservice = myservice;
		
	}
	
	
	@GetMapping("/")
	public String getMethodName() {
		
		System.out.println("기본화면 실행");
		return myservice.sayHello("화면이 정상적으로 작동했는가? ");
	}
	
	@GetMapping("/IF")
	public String IF() {
		return myservice.IF();
	}
	
	

	@GetMapping("/For")
	public String For() {
		return myservice.For();
	}
	@GetMapping("/While")
	public String While() {
		return myservice.While();
	}
	
	@GetMapping("/List")
	public String List() {
		return myservice.List();
	}
	@GetMapping("/ArrayList")
	public String ArrayList() {
		return myservice.ArrayList();
	}
	
}
