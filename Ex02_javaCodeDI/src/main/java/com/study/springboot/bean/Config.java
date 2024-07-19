package com.study.springboot.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;            

@Configuration // 스프링 설정으로 빈들을 자동으로 등록해주는 기능 
// @Bean 어노테이션은 @Configuration이 달려있는 클래스 내부에서 사용해야함.
public class Config
{
	@Bean 
	public Member member1() {
		Member  member1 = new Member();
		member1.setName("홍길동");
		member1.setNickname("도사");
		member1.setPrinter(new PrinterA());
		
		return member1;
	}
	
	@Bean(name="hello")
	public Member member2() {
		return new Member("전우치", "도사", new PrinterA());
	}
	
	@Bean
	public PrinterA printerA()
	{
		return new PrinterA();
	}
	
	@Bean
	public PrinterB printerB()
	{
		return new PrinterB();
	}
	
}
