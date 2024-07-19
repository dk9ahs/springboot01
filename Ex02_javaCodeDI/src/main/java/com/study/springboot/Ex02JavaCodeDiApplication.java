package com.study.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.springboot.bean.Config;
import com.study.springboot.bean.Member;
import com.study.springboot.bean.Printer;


//@SpringBootApplication
public class Ex02JavaCodeDiApplication {

	public static void main(String[] args) {
		// 1. IoC 컨테이너 생성 : 빈이 생성되면 컨테이너에 등록된다..
		// 스프링이 돌아가는데 객체들을 사용하기 위해서
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class);
		
		// 2. Member Bean 가져오기 (스프링 컨테이너로 가져와 형변환)
		Member member1 = (Member)context.getBean("member1");
		member1.print();
		
		// 3. Member Bean 가져오기 (hello라는 이름으로 설정된 빈을 요청하고, 
		// 미리 형을 지정하고 리턴 받음
		Member member2 = context.getBean("hello", Member.class);
		member2.print();
		
		// 3. PrinterB Bean 가져오기
		Printer printer = context.getBean("printerB", Printer.class);
		member1.setPrinter(printer); // 세터를 통해서 빈에 등록된 값을 변경
		member1.print();
		
		if (member1 == member2) {
			System.out.println("동일한 객체입니다.");
		} else {
			System.out.println("서로 다른 객체입니다.");
		}
		
	}

}
