//데이터값을 효율적으로 반복해서 활용 가능한 api 학습
package running;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import model.domain.Person;

public class Syntax1Lamda {
	@Test
	public void m1() {
		Person p1 = new Person("이민정", 20);
		Person p2 = new Person("푸블리", 40);
		Person p3 = new Person("전혜빈", 10);
		
		
		//다수의 데이터를 API 를 통해서 List 객체로 생성
		List<Person> list = Arrays.asList(p1, p2, p3);

		//step01 - 기본
		for(Person p : list) {
			System.out.println(p);
		}
		
		
		
		//step02 : lamda
		//메소드 구현부로 정의하지 않고 하나의 식처럼 표현하는 문법(표현식)
		System.out.println("--step02 : 표현식이라는 lamda 문법--");
		list.forEach(p -> System.out.println(p));

		//step03 - lamda & double colon
		System.out.println("--step03 : 표현식이라는 lamda & double colon 문법--");
		list.forEach(System.out::println);
		
		
		//step04 - lamda + 연산
		//출력 결과에 사칙연산
		int i = 10;
		Arrays.asList(1, 2, 3).forEach(v-> System.out.println(v + i));
		
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "현주엽");
		map.put("2", "신동엽");
		map.put("3", "유재석");
		map.put("4", "이영자");
		map.put("5", "정찬우");
		map.put("6", "김태균");
		
		map.forEach((k, v) -> System.out.println(k + " - " + v));
	}
}


