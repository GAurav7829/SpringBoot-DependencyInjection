package com.grv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.grv.controller.MyController;

@SpringBootApplication
public class SpringBootDependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootDependencyInjectionApplication.class, args);
		
		MyController controller = (MyController) ctx.getBean("myController");
		String greeting = controller.sayHello();
		System.out.println(greeting);
	}

}
