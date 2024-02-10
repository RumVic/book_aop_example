package com.vicrum.books.gradleGroovy.java21.controller;

import com.vicrum.books.gradleGroovy.java21.entity.Audit;
import com.vicrum.books.gradleGroovy.java21.entity.RecordAction;
import com.vicrum.books.gradleGroovy.java21.inputDto.InputAuditDto;
import com.vicrum.books.gradleGroovy.java21.service.ServiceAudit;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class Controller {


    private final ServiceAudit serviceAudit;
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    public Controller(ServiceAudit serviceAudit) {
        this.serviceAudit = serviceAudit;
    }

    @GetMapping
    public ResponseEntity<List<Audit>> getAllRecords() {
        return new ResponseEntity<>(serviceAudit.read(), HttpStatus.OK);
    }

    @CircuitBreaker(name = "book-service-creation", fallbackMethod = "interceptBookCreation")
    @RequestMapping(value = "/creation/{bookName}", method = RequestMethod.POST)
    public ResponseEntity<String> saveCreateRecord(@PathVariable String bookName, @RequestParam RecordAction action, @RequestBody InputAuditDto inputAuditDto) {
//        int a = 0;
//        int b = 1;
//        int c = b/a; - For testing how circuit breaker works
        serviceAudit.create(inputAuditDto,action);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(value = "/reading", method = RequestMethod.POST)
    public ResponseEntity<String> saveReadRecord(@RequestParam RecordAction action, @RequestBody List<InputAuditDto> listOfAudit) {
        serviceAudit.createReadRecord(listOfAudit,action);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(value = "/updating/{updateBookName}", method = RequestMethod.POST)
    public ResponseEntity<String> saveUpdateRecord(@PathVariable String updateBookName, @RequestParam RecordAction action,@RequestBody InputAuditDto inputAuditDto) {
        serviceAudit.create(inputAuditDto,action);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(value = "/deleting/{deleteBookName}", method = RequestMethod.POST)
    public ResponseEntity<String> saveDeleteRecord(@PathVariable String deleteBookName,@RequestParam RecordAction action, @RequestBody InputAuditDto inputAuditDto) {
        serviceAudit.create(inputAuditDto,action);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public void interceptBookCreation(Throwable throwable){
        LOGGER.error("Error during update statistics for account: {}",throwable.getMessage());
    }
    public ResponseEntity<String> interceptBookCreation(String bookName, RecordAction action, InputAuditDto inputAuditDto, Throwable ex) {
        // Fallback logic goes here
        LOGGER.error("Error during performin audit action for creating book :  {}",bookName);
        String responseMessage = "Fallback response due to error: " + ex.getMessage();
        return new ResponseEntity<>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
