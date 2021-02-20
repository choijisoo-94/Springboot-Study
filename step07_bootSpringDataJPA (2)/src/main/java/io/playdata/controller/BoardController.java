package io.playdata.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.playdata.dao.BoardRepository;
import io.playdata.model.domain.Board;

@RestController
public class BoardController {
	
	// 처음에 application.properties에서 create로 실행하고 none으로 바꿔서 해야 데이터 적재가됨
	
	@Autowired
	private BoardRepository dao;
	
	// 없는 데이터 저장할떈 get말고 post
	// http://ip:port/board?i=2
	@PostMapping("board")
	public String m1(Long i) {
		Board save = new Board(i, "spring boot", "이민정", "아아");
		dao.save(save);
		return "게시판 저장 성공";
	}
	
	// ***
	/* {"seq" : 11, "title" : "java", "writer" : "준슬링", "content" : "준슬링 자바 창시자"}
	 * 
	 * JSON 포멧으로 새로운 데이터 저장 요청시 DTO 자동 생성시에는
	 * @RequestBody 는 필수
	 */
	@PostMapping("newboard")
	public Board m11(@RequestBody Board data) {
		System.out.println(data);
		return dao.save(data);
	}
	
	//http://ip:port/boarddata?id=1
	@GetMapping("boarddata")
	public Board m2(Long id) {
		Optional<Board> cn = dao.findById(id);
		System.out.println("---------" + cn.get());
		return cn.get();			
	}
	
	// 모든 게시판 검색 메소드
	//http://ip:port/boardall
	// json 배열 포멧으로 응답
	@GetMapping("boardall")
	public Iterable<Board> m3() {
		Iterable<Board> all = dao.findAll();
		System.out.println(all);
		return all;
	}
	
	// json 배열 형식으로 응답
	//http://ip:port/board-title
	@GetMapping("board-title")
	public List<Board> m4(){
		List<Board> all = dao.findBoardByTitle("spring boot");
		System.out.println(all);
		return all;
	}
	
	@GetMapping("board-titlecontain")
	public List<Board> m5(){
		List<Board> all = dao.findBoardByTitleContaining("boot");
		System.out.println(all);
		return all;
	}
	
	//http://127.0.0.1/board-seq-and-writer?seq=1&w=이민정
	@GetMapping("board-seq-and-writer")
	
	/*
	 * @RequestMapping
	 * 		- @Controller기반의 클래스에선 빈번히 사용하는 애노테이션
	 * 		- 혹여 jsp로 이동없이 JSON 포멧으로 바로 응답할 경우 사용하는 애노테이션
	 * 		@ResponseBody: JSON 포멧으로 응답
	 * 		비동기 요청시 응답 설정의 일부 
	 * 		@RestController 기반의 Rest API 에노테이션 사용시에는 생략 가능
	 * 		왜? 각 메소드들이 객체 반환시 자동으로 JSON 형식으로 반환하기 때문
	 *	
	 *	@RestController인 경우엔 List 반환시 - json 배열, DTO  반환시 - JSON 형식으로 반환
	 *	@RequestBody - client가 서버에 json 포멧으로 데이터를 전송
	 *				-> DTO 의 멤버 변수명과 JSON 포멧의 전송 key 가 일치될 경우 DTO 의 멤버 변수값으로 자동 초기화
	 *
	 */
	
	//@ResponseBody  옵션
	public Board m6(Long seq, String w){
		System.out.println(seq + " " + w);
		Board all = dao.findBoardBySeqAndWriter(seq, w);
		System.out.println(all);
		return all;
	}
}
/* 에러가 난 상황
 * 데이터가 없음
 * create -> http://127.0.0.1/board -> 메소드 추가 개발 및 저장 : 실행환경 초기화 (create) http://ip:port/boarddata?id=1
 * 따라서 none 수정
 * table 생성 존재 여부 확인
 * board 데이터 저장 - http://127.0.0.1//board
 * 검색 - http://ip:port/boarddata?id=1
 */