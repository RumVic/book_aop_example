package com.vicrum.books.gradleGroovy.java21.service;

import com.vicrum.books.gradleGroovy.java21.entity.Audit;
import com.vicrum.books.gradleGroovy.java21.entity.RecordAction;
import com.vicrum.books.gradleGroovy.java21.inputDto.InputAuditDto;
import com.vicrum.books.gradleGroovy.java21.repository.MongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ServiceImplementation implements ServiceAudit {

    private final MongoRepo mongoRepo;

    @Autowired
    public ServiceImplementation(MongoRepo mongoRepo) {
        this.mongoRepo = mongoRepo;
    }

    @Override
    public Audit create(InputAuditDto inputDto, RecordAction recordAction) {
        Audit audit = Audit.builder()
                .bookId(inputDto.getId())
                .bookName(inputDto.getName())
                .id(UUID.randomUUID())
                .recordAction(recordAction)
                .build();
        mongoRepo.save(audit);
        return audit;
    }

    @Override
    public void createReadRecord(List<InputAuditDto> list, RecordAction recordAction) {
        List<Audit> audits = list
                .stream()
                .map(dto -> Audit.builder()
                        .id(UUID.randomUUID())
                        .bookName(dto.getName())
                        .bookId(dto.getId())
                        .recordAction(recordAction)
                        .build()).toList();
        mongoRepo.saveAll(audits);
    }

    @Override
    public List<Audit> read() {
        return mongoRepo.findAll();
    }
}