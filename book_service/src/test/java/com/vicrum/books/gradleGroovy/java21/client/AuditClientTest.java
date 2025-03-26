//package com.vicrum.books.gradleGroovy.java21.client;
//
//import com.vicrum.books.gradleGroovy.java21.domain.Author;
//import com.vicrum.books.gradleGroovy.java21.domain.Book;
//import com.vicrum.books.gradleGroovy.java21.domain.Description;
//import com.vicrum.books.gradleGroovy.java21.domain.GridFs;
//import com.vicrum.books.gradleGroovy.java21.util.RecordAction;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.*;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("test")
//public class AuditClientTest {
//
//    @LocalServerPort
//    private int port = 8585;
//    @MockBean
//    private AuditClient auditClient;
//    @MockBean
//    private RestTemplate restTemplate;
//
//    @Test
//    public void createTest() {
//        Book book = new Book(UUID.randomUUID(),
//                "testBook",
//                new Author(),
//                new GridFs(),
//                new Description());
//        RecordAction recordAction = RecordAction.CREATE;
//        auditClient.storeCreateRecord(
//                book.getName(), recordAction, book);
//    }
//
//    @Test
//    public void clientCreateTest() {
//        Book book = new Book(UUID.randomUUID(),
//                "testBook",
//                new Author(),
//                new GridFs(),
//                new Description());
//        RecordAction recordAction = RecordAction.CREATE;
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Book> request = new HttpEntity<>(book, headers);
//        String url = "http://localhost:" + port + "/audit/creation/" + book.getName() + "?action=" + recordAction;
//        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
//        assertEquals(HttpStatus.OK, HttpStatus.OK);
//    }
//
//    @Test
//    public void clientReadTest() {
//        List<Book> bookList = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            bookList.add(new Book());
//        }
//        RecordAction recordAction = RecordAction.READ;
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<List<Book>> request = new HttpEntity<>(bookList, headers);
//        String url = "http://localhost:" + port + "/audit/reading?action=" + recordAction;
//        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
//        assertEquals(HttpStatus.OK, HttpStatus.OK);
//    }
//
//    @Test
//    public void clientUpdateTest() {
//        Book book = new Book(UUID.randomUUID(),
//                "testBook",
//                new Author(),
//                new GridFs(),
//                new Description());
//        String updateBookName = "updatedName";
//        RecordAction recordAction = RecordAction.UPDATE;
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Book> request = new HttpEntity<>(book, headers);
//        String url = "http://localhost:" + port + "/audit/updating/" + updateBookName + "?action=" + recordAction;
//        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
//        assertEquals(HttpStatus.OK, HttpStatus.OK);
//
//    }
//
//    @Test
//    public void clientDeleteTest() {
//        Book book = new Book(UUID.randomUUID(),
//                "testBook",
//                new Author(),
//                new GridFs(),
//                new Description());
//        String deleteBookName = "deletedBook";
//        RecordAction recordAction = RecordAction.DELETE;
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Book> request = new HttpEntity<>(book, headers);
//        String url = "http://localhost:" + port + "/audit/deleting/" + deleteBookName + "?action=" + recordAction;
//        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
//        assertEquals(HttpStatus.OK, HttpStatus.OK);
//    }
//}