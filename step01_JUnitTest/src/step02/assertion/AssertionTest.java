package step02.assertion;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AssertionTest {
	
	/*
	 * parameter가 하나 이상인 상황
	 * 
	 */
	@ParameterizedTest
	@CsvSource({"1 , test", "2 , test2"})
	public void m4(int i, String s) {
		System.out.println("m4() : " + i + " - " + s );
	}
	
	
	
	
	//parameter 있는 메소드 처리
	/* @Test 불필요
	 * test하고자 하는 데이터 수만큼 메소드 자동 호출
	 */
//	@ParameterizedTest
//	@ValueSource(ints = {1, 2, 3, 4, 5})
	public void m3(int i) {
		//? parameter 값이 4미만 데이터값들만 출력해야만 하는 상황
		assertTrue(i < 4);
		System.out.println("m3()" + i);
	}
	
	
	
	
	//null값 검증 단정문 test
//	@Test
	public void m2() {
//		assertNotNull(null); //null이 아닌 상황 검증
		assertNull(null); //null이어야만 하는 상황 검증
		System.out.println("biz 1");
	}
	
	
	//데이터값 검증 단정문 test
//	@Test
	public void m1() {
		//단정 로직 :값이 다를경우엔 path
		assertNotEquals("junit", "Junit"); //path 왜?
		System.out.println("biz 1");
		
		//100% 일치되는 단일 객체가 아니어도 값이 동일한 경우 ㅔㅁ소 
//		assertEquals("A", new String("A"));
		
//		assertNotEquals("junit", "junit"); =//non path 따라서 다음 로직 실행 불가
		
		//데이터 타입과 값이 일치될 경우에만 path(true)
		assertSame("A", "A"); // path
//		assertSame("A", new String("A")); // non path
//		assertSame("A", "a"); // non path
		
		System.out.println("biz 2"); 
	}

}
