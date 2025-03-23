//package com.vicrum.books.gradleGroovy.java21;
//
//import com.vicrum.books.gradleGroovy.java21.domain.Author;
//import com.vicrum.books.gradleGroovy.java21.domain.Book;
//import com.vicrum.books.gradleGroovy.java21.domain.Description;
//import com.vicrum.books.gradleGroovy.java21.domain.GridFs;
//import com.vicrum.books.gradleGroovy.java21.inputdto.BookInputDTO;
//import com.vicrum.books.gradleGroovy.java21.service.api.BookService;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//import java.util.UUID;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@SpringBootTest
//@ActiveProfiles("test")
//@Testcontainers
//public class ApplicationServiceTestTestcontainer {
//
//
//    @Autowired
//    private BookService bookService;
//
//    @MockBean
//    @Qualifier("appLogger")
//    private Logger mockLogger;
//
//
//    @Container
//    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest")
//            .withDatabaseName("books")
//            .withUsername("postgres")
//            .withPassword("postgres");
//
//    @DynamicPropertySource
//    static void postgresqlProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", postgres::getJdbcUrl);
//        registry.add("spring.datasource.password", postgres::getPassword);
//        registry.add("spring.datasource.username", postgres::getUsername);
//    }
//
//    @Test
//    public void beforeCallAtMethod1TestWithTestContainer() {
//        BookInputDTO bookInputDTO = new BookInputDTO(UUID.fromString("b4f43fb2-72e5-460a-93c3-4af8b071fc8c"),"testName",new Author(),new Description(),new GridFs());
//        Book book = bookService.create(bookInputDTO);
//        bookService.delete(book.getId());
//        //two times logger is being called because first time is "before execution" and second times is "after returning"
//        verify(mockLogger,times(4)).info(ArgumentMatchers.anyString());
//    }
//
//}