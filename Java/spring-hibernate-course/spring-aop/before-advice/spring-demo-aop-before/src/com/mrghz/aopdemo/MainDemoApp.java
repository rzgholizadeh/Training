package com.mrghz.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mrghz.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call the business method
		System.out.println("\n First call to the business method:");
		theAccountDAO.addAccount();

		// call again
		System.out.println("\n Second call to the business method:");
		theAccountDAO.addAccount();

		// close the context
		context.close();

	}

}
