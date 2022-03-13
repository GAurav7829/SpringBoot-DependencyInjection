package com.grv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.grv.controller.ConstructorInjectedController;
import com.grv.controller.I18nController;
import com.grv.controller.MyController;
import com.grv.controller.PropertyInjectedController;
import com.grv.controller.SetterInjectedController;
import com.grv.service.ProtoptypeBean;
import com.grv.service.SingletonBean;

@SpringBootApplication
//by default spring scans the package 'com.grv', we need to specify other package to scan to get the classes
@ComponentScan(basePackages = {"com.i18n","com.grv"})
public class SpringBootDependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootDependencyInjectionApplication.class, args);
		
		System.out.println("Primary bean-------------------------");
		MyController controller = (MyController) ctx.getBean("myController");
		System.out.println(controller.sayHello());
		
		System.out.println("Property based DI--------------------");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());
		
		System.out.println("Setter based DI----------------------");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());
		
		System.out.println("Constructor based DI-----------------");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
		
		System.out.println("Spring Profile-----------------------");
		//Profile set in application.properties
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());
		
		System.out.println("----- BEAN SCOPES -------------------");
		System.out.println("SingletonBean------------------------");
		SingletonBean singletonBean1 = (SingletonBean) ctx.getBean("singletonBean");
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = (SingletonBean) ctx.getBean("singletonBean");
		System.out.println(singletonBean2.getMyScope());
		
		System.out.println("PrototypeBean------------------------");
		ProtoptypeBean protoptypeBean1 = ctx.getBean(ProtoptypeBean.class); 
		System.out.println(protoptypeBean1.getMyScope());
		ProtoptypeBean protoptypeBean2 = ctx.getBean(ProtoptypeBean.class); 
		System.out.println(protoptypeBean2.getMyScope());
	}

}
