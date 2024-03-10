package com.vicrum.books.gradleGroovy.java21.service.api;

import java.util.List;
import java.util.UUID;

public interface Service<ENTITY,IDTO,ODTO> {
    ENTITY create (IDTO dto);
    List<ENTITY> read ();
    ENTITY update(UUID id, IDTO dto);
    void delete(UUID uuid);
    ENTITY readById(UUID id);
}
