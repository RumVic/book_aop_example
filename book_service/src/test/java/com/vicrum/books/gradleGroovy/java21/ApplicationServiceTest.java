//package com.vicrum.books.gradleGroovy.java21;
//
//import com.vicrum.books.gradleGroovy.java21.client.AuditClient;
//import com.vicrum.books.gradleGroovy.java21.domain.Author;
//import com.vicrum.books.gradleGroovy.java21.domain.Book;
//import com.vicrum.books.gradleGroovy.java21.domain.Description;
//import com.vicrum.books.gradleGroovy.java21.domain.GridFs;
//import com.vicrum.books.gradleGroovy.java21.inputdto.BookInputDTO;
//import com.vicrum.books.gradleGroovy.java21.logging.BookAspect;
//import com.vicrum.books.gradleGroovy.java21.service.api.BookService;
//import org.aspectj.lang.JoinPoint;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ActiveProfiles;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//import java.util.List;
//import java.util.UUID;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@SpringBootTest
//@ActiveProfiles("test")
//@Testcontainers
//public class ApplicationServiceTest {
//    @Autowired
//    private BookService bookService;
//    @Autowired
//    private BookAspect bookAspect;
//    @MockBean
//    private JoinPoint joinPoint;
//    @MockBean
//    @Qualifier("appLogger")
//    private Logger mockLogger;
//    @MockBean
//    private AuditClient auditClient;
//
//    @Test
//    public void beforeCallAtMethod1Test() {
//        BookInputDTO bookInputDTO = new BookInputDTO(UUID.fromString("b4f43fb2-72e5-460a-93c3-4af8b071fc8c"),"testName",new Author(),new Description(),new GridFs());
//        Book book = bookService.create(bookInputDTO);
//        bookService.delete(book.getId());
//        //two times logger is being called because first time is "before execution" and second times is "after returning"
//        verify(mockLogger,times(4)).info(ArgumentMatchers.anyString());
//    }
//
//    @Test
//    public void afterReturningWithListTest(){
//        List<Book> books = bookService.read();
//        //depends on what number of book actually now in repository (10 at this time+1 aspect invocation)
//        verify(mockLogger,times(14)).info(ArgumentMatchers.anyString());
//    }
//    @Test
//    public void afterReturningTest(){
//        Book book = bookService.readById(UUID.fromString("b4f43fb2-72e5-460a-93c3-4af8b071fc8c"));
//        verify(mockLogger,times(2)).info(ArgumentMatchers.anyString());
//    }
//}
