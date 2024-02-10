package com.vicrum.books.gradleGroovy.java21.service.api;

import com.vicrum.books.gradleGroovy.java21.domain.GridFs;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface ImageService {

    GridFsResource storeFile(MultipartFile multipartFile) throws IOException;

    void setImageToBook(UUID uuid, GridFs imageId);

    //TODO
    GridFsResource retrieveFile(String id);
}
