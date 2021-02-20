package io.playdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.playdata.dao.BoardRepository;
import io.playdata.model.domain.Board;

@RestController
public class BoardController {
	
	@Autowired
	private BoardRepository dao;
	
	@PostMapping("board")
	public Board m1() {
		Board save = new Board(1L, "spring boot", "정민", "spring app을 쉽게 개발 가능하게 하는 도구");
		dao.save(save);
		return "게시판 저장 성공";
	}
}
