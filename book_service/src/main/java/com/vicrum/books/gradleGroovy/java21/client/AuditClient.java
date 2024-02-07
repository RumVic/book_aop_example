package com.vicrum.books.gradleGroovy.java21.client;

import com.vicrum.books.gradleGroovy.java21.domain.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="book-audit")
public interface AuditClient {
        @RequestMapping(method = RequestMethod.POST, value = "/audit/{bookName}", consumes = MediaType.APPLICATION_JSON_VALUE)
        void storeRecord(@PathVariable("bookName") String bookName, @RequestBody Book book);
}
