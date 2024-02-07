package com.vicrum.books.gradleGroovy.java21.service;

import java.util.List;

public interface Service<IDTO,ODTO,ENTITY> {

    ENTITY create(IDTO inputDto);

    List<ENTITY> read ();

}
