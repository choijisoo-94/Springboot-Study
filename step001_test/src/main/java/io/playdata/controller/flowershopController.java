package io.playdata.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.playdata.dao.FlowershopRepository;
import io.playdata.model.domain.Flowershop;

@RestController
public class flowershopController {
	@Autowired
	private FlowershopRepository dao;
	
	
	//http://127.0.0.1/Flowershop?i=1 ~ 5
	@PostMapping("Flowershop")
	public String m1(Long i) {
		Flowershop save = new Flowershop(i, "aromatic flowershoop", "02-1234-5678", "misty blue");
		dao.save(save);
		return "꽃집정보 저장 성공";
	}
	
	//http://127.0.0.1/Flowershopdata?id=1 ~ 5
	@GetMapping("Flowershopdata")
	public Flowershop m2(Long id) {
		Optional<Flowershop> cn = dao.findById(id);
		System.out.println("-------" + cn.get());
		return cn.get();
	}
	
	
	//http://127.0.0.1/Flowershopall
	@GetMapping("Flowershopall")
	public Iterable<Flowershop> m3(){
		Iterable<Flowershop> all = dao.findAll();
		System.out.println(all);
		return all;
	}
	
	//http://127.0.0.1/Flowershop-title
	@GetMapping("Flowershop-title")
	public List<Flowershop> m4(){
		List<Flowershop> all = dao.findFlowershopByTitle("aromatic flowershoop");	//select * from Flowershop where Title = 'aromatic flowershoop'
		System.out.println(all);
		return all;
	}
	
	//
	@GetMapping("Flowershop-titlecontain")
	public List<Flowershop> m5(){
		List<Flowershop> all = dao.findFlowershopByTitleContaining("aromatic");		//select * from Flowershop where Title like '%aromatic%'
		System.out.println(all);
		return all;
	}
}
