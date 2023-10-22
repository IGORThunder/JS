package com.example.mod1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mod1Application {

	public static void main(String[] args) {
		System.out.println("XML Configuration:");
		ClassPathXmlApplicationContext xmlContext =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		xml.Person xmlPerson =
				xmlContext.getBean("person", xml.Person.class);
		xmlPerson.callPet();
		xmlContext.close();
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("ANNOTATIONS Configuration:");
		ClassPathXmlApplicationContext annotationContext =
				new ClassPathXmlApplicationContext("applicationContext2.xml");
		annotation.Person annotaionPerson =
				annotationContext.getBean("person", annotation.Person.class);
		System.out.println(annotaionPerson);
		annotaionPerson.callPet();
		annotationContext.close();
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("FIRST JAVA Configuration:");
		AnnotationConfigApplicationContext javaContext1 =
				new AnnotationConfigApplicationContext(javaConfig1.Config.class);
		javaConfig1.Person javaPerson1 = javaContext1.getBean("person",
				javaConfig1.Person.class);
		System.out.println(javaPerson1);
		javaPerson1.callPet();
		javaContext1.close();
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("SECOND JAVA Configuration:");
		AnnotationConfigApplicationContext javaContext2 =
				new AnnotationConfigApplicationContext(javaConfig2.Config.class);
		javaConfig2.Person javaPerson2 = javaContext2.getBean("person",
				javaConfig2.Person.class);
		System.out.println(javaPerson2);
		javaPerson2.callPet();
		javaContext2.close();
	}
}
