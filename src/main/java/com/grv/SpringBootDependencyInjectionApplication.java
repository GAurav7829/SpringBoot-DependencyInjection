package com.grv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.grv.controller.ConstructorInjectedController;
import com.grv.controller.MyController;
import com.grv.controller.PropertyInjectedController;
import com.grv.controller.SetterInjectedController;

@SpringBootApplication
public class SpringBootDependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootDependencyInjectionApplication.class, args);
		
		MyController controller = (MyController) ctx.getBean("myController");
		String greeting = controller.sayHello();
		System.out.println(greeting);
		
		System.out.println("Property based DI--------------------");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());
		
		System.out.println("Setter based DI----------------------");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());
		
		System.out.println("Constructor based DI-----------------");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

}
