package com.vicrum.books.gradleGroovy.java21.service.api;

import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface BookImageService {

    String storeFile(MultipartFile multipartFile) throws IOException;

    void setImageToBook(UUID uuid,String  imageId);

    GridFsResource retrieveFile(String id);
}
