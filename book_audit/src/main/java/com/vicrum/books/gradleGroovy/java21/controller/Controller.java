package com.vicrum.books.gradleGroovy.java21.controller;

import com.vicrum.books.gradleGroovy.java21.entity.Audit;
import com.vicrum.books.gradleGroovy.java21.inputDto.InputAuditDto;
import com.vicrum.books.gradleGroovy.java21.service.ServiceAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class Controller {


    private final ServiceAudit serviceAudit;

    @Autowired
    public Controller(ServiceAudit serviceAudit) {
        this.serviceAudit = serviceAudit;
    }

    @GetMapping
    public ResponseEntity<List<Audit>> getAllRecords() {
        return new ResponseEntity<>(serviceAudit.read(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{bookName}", method = RequestMethod.POST)
    public ResponseEntity<String> saveRecord(@PathVariable String bookName, @RequestBody InputAuditDto inputAuditDto) {
        serviceAudit.create(inputAuditDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
