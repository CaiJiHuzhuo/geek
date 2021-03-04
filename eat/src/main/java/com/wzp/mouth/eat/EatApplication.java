package com.wzp.mouth.eat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wzp.mouth.eat.mapper")
public class EatApplication {

	public static void main(String[] args) {
		SpringApplication.run(EatApplication.class, args);
	}

}
