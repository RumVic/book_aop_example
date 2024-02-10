package com.vicrum.books.gradleGroovy.java21.service;

import com.vicrum.books.gradleGroovy.java21.entity.RecordAction;

import java.util.List;

public interface Service<IDTO,ODTO,ENTITY> {

    ENTITY create(IDTO inputDto, RecordAction recordAction);

    void createReadRecord(List<IDTO> idto,RecordAction recordAction);

    List<ENTITY> read ();

}
