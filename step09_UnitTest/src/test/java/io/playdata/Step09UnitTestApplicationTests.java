package io.playdata;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import io.playdata.controller.Controller;

@SpringBootTest
class Step09UnitTestApplicationTests {
	
	
	@Autowired
	private Controller controller;
	
	private MockMvc mock;
	
	@BeforeEach
	public void init() {
		mock = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	void controllerTest() throws Exception {
		//mock.perform(get("/")).andExpect(status().isOk()).andDo(print());
		
		
		//http://ip:port/param?id=data
		//mock.perform(get("/param").param("id", "data")).andDo(print());
	
		//? 웹상에서 전송되는 데이터 타입들은 문자열
		mock.perform(post("/datanew").param("name", "data").param("age", "10")).andDo(print());
	
		//서버가 응답하는 데이터가 그 데이턱 맞는지?에 대한 검증 : 데이터 유효성 검증도 가능
		//json포멧으로 응답되는 데이터의 key로 value 검출하는 모드 "$.key명"
		//{"name" : "playdataman", "age" : 20}
		mock.perform(get("/validate")).andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value("playdataman")).andDo(print());
		
		//client에게 서비스 하는 데이터가 test 여야 하는 상황의 검증
//		mock.perform(get("/validate")).andExpect(status().isOk())
//				.andExpect(jsonPath("$.name").value("test")).andDo(print());
		
	}


}
