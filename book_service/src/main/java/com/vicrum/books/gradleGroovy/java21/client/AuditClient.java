package com.vicrum.books.gradleGroovy.java21.client;

import com.vicrum.books.gradleGroovy.java21.domain.Book;
import com.vicrum.books.gradleGroovy.java21.util.RecordAction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="book-audit",fallback = AuditFallBackImplementation.class)
public interface AuditClient {

        @RequestMapping(method = RequestMethod.POST, value = "/audit/creation/{bookName}", params = "action",consumes = MediaType.APPLICATION_JSON_VALUE)
        void storeCreateRecord(@PathVariable("bookName") String bookName, @RequestParam("action") RecordAction action, @RequestBody Book book);

        @RequestMapping(method = RequestMethod.POST, value = "/audit/reading", params = "action", consumes = MediaType.APPLICATION_JSON_VALUE)
        void storeReadRecord(@RequestParam("action") RecordAction actionRecord ,@RequestBody List<Book> listBooks );

        @RequestMapping(method = RequestMethod.POST, value = "/audit/updating/{updateBookName}",params = "action", consumes = MediaType.APPLICATION_JSON_VALUE)
        void storeUpdateRecord(@PathVariable("updateBookName") String updateBookName,@RequestParam("action") RecordAction action, @RequestBody Book book);

        @RequestMapping(method = RequestMethod.POST, value = "/audit/deleting/{deleteBookName}", params = "action",consumes = MediaType.APPLICATION_JSON_VALUE)
        void storeDeleteRecord(@PathVariable("deleteBookName") String deleteBookName,@RequestParam("action") RecordAction action, @RequestBody Book book);
}
