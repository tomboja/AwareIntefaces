package edu.miu.cs544.temesgen.service;

import edu.miu.cs544.temesgen.service.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: AwareIntefaces
 * @Author: Temesgen D.
 * @Date: 3/6/22
 */

public class Main {
    public static void main(String[] args) {
//        ApplicationContext springContext = new ClassPathXmlApplicationContext("config.xml");

        ApplicationContext springContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        Book book = springContext.getBean(Book.class);
        System.out.println("Bean Name: ");
        book.printBeanName();
        System.out.println();

        System.out.println("Resource Loader ");
        book.printResourceLoader();


        System.out.println("ApplicationContext = " );
        book.printApplicationContextInfo();
    }
}
