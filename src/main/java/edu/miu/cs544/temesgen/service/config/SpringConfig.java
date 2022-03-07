package edu.miu.cs544.temesgen.service.config;

import edu.miu.cs544.temesgen.service.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: AwareIntefaces
 * @Author: Temesgen D.
 * @Date: 3/6/22
 */

@Configuration
public class SpringConfig {

    @Bean("BookName")
    public Book book() {
        return new Book("The Book", "Juan Gonzalez");
    }
}
