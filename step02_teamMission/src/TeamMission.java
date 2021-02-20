import static org.junit.Assert.assertTrue;
//import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TeamMission {
	@BeforeAll 
	public static void before() {
		System.out.println("===step1 25세 이하인 사람들 이름 출력==");
	}
	
	//25세 이하인 사람들 이름 출력
	@ParameterizedTest
	@CsvSource({"1,김준형,27","2,양호준,40","3,최지수,28","4,차왕현,21","5,최지원,24","6,김혜성,28"})
	public void m1(int i,String name,int age) {
		assertTrue(i + age<25);
		System.out.println(name);
	}
	
//	@AfterAll 
	public static void after() {
		System.out.println("===step1 테스트 완료==");
	}
}
