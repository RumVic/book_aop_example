package com.vicrum.books_gradleKotlin_java21.service.api;

import java.util.List;
import java.util.UUID;

public interface IService<ENTITY,IDTO,ODTO> {
    ENTITY create (IDTO dto);
    List<ENTITY> read ();
    ENTITY update(UUID id, IDTO dto);
    void delete(UUID uuid);
}
