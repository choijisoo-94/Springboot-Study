package running;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.omg.Messaging.SyncScopeHelper;

import model.domain.Person;

public class Syntax2Stream {
	@Test
	public void m1() {
		int [] values = {1, 2, 3, 4, 5, 6};
		//모든 데이터 합 출력
		System.out.println(Arrays.stream(values).sum());
		
		//양수에 한해서만 합을 구해서 출력
		System.out.println(Arrays.stream(values).filter(v -> v % 2 == 0).sum());
		
		
		Person p1 = new Person("이민정", 20);
		Person p2 = new Person("푸블리", 21);
		Person p3 = new Person("전혜빈", 22);
		
		List<Person> list = Arrays.asList(p1, p2, p3);
		list.stream().filter(v -> v.getName() != null).forEach(v -> System.out.println(v.getName()));

		//하단 코드 에러 왜? filter의 반환값은 boolean이어야 하기 때문
		//		list.stream().filter(v -> v.getName()).forEach(v -> System.out.println(v.getName()));
		
		//step05 : map 계열 활용 방법
		Map<String, String> map = new HashMap<>();
		map.put("1", "이민정");
		map.put("2", "신동엽");
		map.put("3", "유재석");
		map.put("4", "이영자");
		map.put("5", "정찬우");
		map.put("6", "김태균");
		
		map.entrySet().stream().filter(v -> v.getValue().equals("유재석")).forEach(System.out::println);;
	
		map.entrySet().stream().filter(v -> v.getValue().equals("유재석")).forEach(data -> System.out.println(data));
		
		map.entrySet().stream().filter(v -> v.getValue().equals("유재석")).forEach(data -> System.out.println(data.getKey()));
	
		map.entrySet().stream().filter(v -> v.getValue().equals("유재석")).forEach(data -> System.out.println(data.getValue()));
	}
}
