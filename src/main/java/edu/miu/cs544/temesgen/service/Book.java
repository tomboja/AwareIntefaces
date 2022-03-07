package edu.miu.cs544.temesgen.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @ProjectName: AwareIntefaces
 * @Author: Temesgen D.
 * @Date: 3/6/22
 */

// This bean is aware of its name which is 'book' in the xml config
public class Book implements BeanNameAware, ResourceLoaderAware, ApplicationContextAware {
    private String title;
    private String author;
    private String beanName;
    private ResourceLoader resourceLoader;
    private ApplicationContext applicationContext;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }


    // ========= BEAN NAME AWARE
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
    public void printBeanName() {
        System.out.println("Bean name: " + beanName);
    }


    // ========= RESOURCE LOADER AWARE
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("resourceLoader = " + resourceLoader);
        this.resourceLoader = resourceLoader;
    }
    public void printResourceLoader() {
        Resource resource = resourceLoader.getResource("classpath:data.txt");
        try {
            FileReader fileReader = new FileReader(resource.getFile().getPath());
            BufferedReader reader = new BufferedReader(fileReader);

            String content = "";
            while (reader.readLine() != null) {
                content  += reader.readLine();
            }

            System.out.println("content = " + content);

        }catch (FileNotFoundException e) {
            e.fillInStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void printApplicationContextInfo() {
        System.out.println(applicationContext.getEnvironment());
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
    }
}
