package io.playdata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.playdata.model.domain.Customer;

@RestController
public class Controller {
	@GetMapping("/")
	public String m1() {
		System.out.println("----m1()----");
		return "hello world";
	}
	
	//http://ip:port/param?id=data
	@GetMapping("/param")
	public String m2(@RequestParam String id) {
		System.out.println("m2()----" + id);
		return "Hello World " + id;
	}
	
	@PostMapping("/datanew")
	public Customer m3(Customer c) {
		System.out.println("m3()-----" + c);
		return c;
	}
	
	@GetMapping("/validate")
	public Customer m5() {
		return new Customer("playdataman", 20); //db로부터 select한 데이터? 또는 등등... 반드시 playdataman 응답
	}
	
}

