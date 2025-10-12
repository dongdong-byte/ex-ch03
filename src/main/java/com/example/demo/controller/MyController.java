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
	
	@GetMapping("/ArrayListAPI")
	public  String ArrayListAPI() {
		return myservice.ArrayListAPI();
		
		
	}
	
	@GetMapping("/ArrayListFor1")
	public String ArrayListFor1() {
		return myservice.ArrayListFor1();
		
	}
	@GetMapping("/ArrayListFor2")
	public String ArrayListFor2() {
		return myservice.ArrayListFor2();
		
		
	}
	@GetMapping("/ArrayListBetterFor")
	public String ArrayListBetterFor() {
		return myservice.ArrayListBetterFor();
		
		
	}
	@GetMapping("/Fiter")
	public String Fiter() {
		return myservice.Fiter();
		
	}
	@GetMapping("/Distanct")
	public String Distanct() {
		return myservice.Distanct();
		
	}
	@GetMapping("/Map")
	public String Map() {
		return myservice.Map();
		
	}
	
	@GetMapping("/Optional")
	public String Optional() {
		return myservice.Optional();
		
	}
	@GetMapping("/NullPointerException1")
	public String NullPointerException1() {
		return myservice.NullPointerException1();
		
	}
	@GetMapping("/OptionalEmpty")
	public String OptionalEmpty() {
		return myservice.OptionalEmpty();
		
	}
	@GetMapping("/Optional03")
	public String Optional03() {
		return myservice.Optional03();
		
	}
}
