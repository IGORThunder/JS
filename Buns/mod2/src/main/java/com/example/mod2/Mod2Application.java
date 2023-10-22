package com.example.mod2;

import aop.Book;
import aop.MyConfig;
import aop.UniLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mod2Application {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MyConfig.class);

		context.close();
	}
}
