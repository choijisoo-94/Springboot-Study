package running;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class Syntax3Optional {
		//NullPointerException 발생으로 Optional API
		//@Test
		public void m1() {
			String v = null;
			int length = v.length();//null.length();
			System.out.println("문자열 길이 " + length);
		}
		
		//@Test
		public void m2() {
			String v = null;
			
			if(v != null) {
				int length = v.length();//null.length();
				System.out.println("문자열 길이 " + length);
			}
		}
		
		/* ofNullable()
		 * 	- Optional 컨테이너가 보유하게 되는 객체가 null일 수도 실제 객체일수도 있는 메소드
		 * 	- ifPresent() 로 조건 검증 해서 실행여부 결정 권장
		 * 
		 */
		
		//@Test
		public void m3() {
			String v = null;
			String v2 = "playdata";
			
			//container Optional에 포함된 데이터가 객체가 아닌 null인 경우
			Optional<String> opt = Optional.ofNullable(v);
			System.out.println(opt); //Optional.empty
			System.out.println(opt.isPresent()); //false
			
			Optional<String> opt2 = Optional.ofNullable(v2);
			System.out.println(opt2); //Optional[playdata]
			System.out.println(opt2.isPresent()); //true
			
			opt2.ifPresent(data -> {
				System.out.println("존재하는 문자열 길이 : " + data.length());
			});
			
			//null이 아닌 실행 자체를 안 해서 예외 발생되지 않는 안정적인 코드
			//null인 경우 반드시 예외처리로 해야할 로직이 없어도 된다면 유연하게 예외 처리 없이 실행 자체를  skip할 수 있게 해 주는 방식
			opt.ifPresent(data -> {
				System.out.println("null이지만... : " + data.length());
			});
			
		}
		
		/* of() : 절대 null은 허용하지 않는 메소드
		 * 만일 null인 경우 NullPointerException 발생
		 * 
		 */
		
		//@Test
		public void m4() {
			String v = null;
			String v2 = "playdata";
			
//			Optional<String> opt1 = Optional.of(v); //NullPointerException 발생 따라서 다음 로직 실행 불가
//			System.out.println(opt1);
			
			Optional<String> opt2 = Optional.of(v2);
			System.out.println(opt2);
		}
		
		@Test
		public void m5() {
			String v = null;
			String v2 = "playdata";
			
			if(v != null) {
				int length = v.length();
				System.out.println("문자열 길이 " + length);
			}else {
				System.out.println("null이야~~");
			}
			
			Optional<String> opt = Optional.ofNullable(v);
			System.out.println(opt.orElse("null이야~~"));
			
			Optional<String> opt2 = Optional.ofNullable(v2);
			System.out.println(opt2.map(s -> "길이 : " + s.length()).orElse("null임"));
			
		}
}
