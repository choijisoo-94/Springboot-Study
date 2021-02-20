package step01.unittest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JunitTestLifeCycle {
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("초기 공유 데이터 처리를 위한 test");
	}
	//Test보다 선행되는 에노테이션 - 전처리
	@BeforeEach
	public void m2() {
		System.out.println("m2()");
	}
	@Test
	public void m1() {
		System.out.println("m1()");
	}
	
	@DisplayName("난 m5()")
	@Test
	public void m5() {
		System.out.println("m5()");
	}
	
	
	//Test보다 선행되는 에노테이션 - 후처리
	@AfterEach
	public void m3() {
		System.out.println("m3()");
	}
}
