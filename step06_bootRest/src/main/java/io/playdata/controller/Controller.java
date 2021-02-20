package io.playdata.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.playdata.domain.Board;

@RestController
public class Controller {
	public Controller() {
		System.out.println("------------------ Controller 생성자");
	}


	//GET - http://localhost:80/hello
	@GetMapping("hello")
	public String m1() {
		return "hello 안녕";
	}

	//GET - http://localhost:80/hello2?id=tester
	@GetMapping("hello2")
	public String m2(String id) {
		return "hello " + id;
	}

	/* RestController 기반의 GetMapping 사용시
	 * DTO 클래스들은 멤버 변수명과 데이터값들이 JSON 형식으로 응답
	 */

	//GET - http://localhost:80/board
	@GetMapping("board")
	public Board m3() {
		return new Board(1, "spring boot", "공유", "spring app을 쉽게 개발 가능하게 하는 도구");
	}

	//JSON 배열 형식으로 응답
	//GET - http://localhost:80/boardall
	@GetMapping("boardall")
	public List<Board> m4() {
		List<Board> all = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			all.add(new Board(i, 
					"spring boot " + i,
					"남주혁 " + i, 
					"spring app을 쉽게 개발 가능하게 하는 도구"));
		}
		return all;
	}

	//REST API + URI Template
	//GET - http://localhost:80/boarduri/{?}
	@GetMapping("boarduri/{id}")
	public String m5(@PathVariable String id) {
		return "안녕 " + id;
	}

}
