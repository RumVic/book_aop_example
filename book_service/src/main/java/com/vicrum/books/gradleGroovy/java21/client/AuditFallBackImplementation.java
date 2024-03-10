package com.vicrum.books.gradleGroovy.java21.client;

import com.vicrum.books.gradleGroovy.java21.domain.Book;
import com.vicrum.books.gradleGroovy.java21.util.RecordAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AuditFallBackImplementation implements AuditClient{

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditFallBackImplementation.class);
    @Override
    public void storeCreateRecord(String bookName, RecordAction action, Book book) {
        LOGGER.error("Error during update audit for account: {}", bookName);
    }

    @Override
    public void storeReadRecord(RecordAction actionRecord, List<Book> listBooks) {
        LOGGER.error("Error during update audit for account: {}", actionRecord);
    }

    @Override
    public void storeUpdateRecord(String updateBookName, RecordAction action, Book book) {
        LOGGER.error("Error during update audit for account: {}", updateBookName);
    }

    @Override
    public void storeDeleteRecord(String deleteBookName, RecordAction action, Book book) {
        LOGGER.error("Error during update audit for account: {}", deleteBookName);
    }
}
