package com.vicrum.books.gradleGroovy.java21.service;

import com.mongodb.client.gridfs.model.GridFSFile;
import com.vicrum.books.gradleGroovy.java21.domain.Book;
import com.vicrum.books.gradleGroovy.java21.domain.GridFs;
import com.vicrum.books.gradleGroovy.java21.repository.api.mongo.MongoRepo;
import com.vicrum.books.gradleGroovy.java21.service.api.ImageService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;


@Service
@Transactional(readOnly = true)
public class ServiceImageImplementation implements ImageService {
    private final GridFsTemplate gridFsTemplate;

    private final MongoRepo bookStorage;

    @Autowired
    public ServiceImageImplementation(GridFsTemplate gridFsTemplate, MongoRepo bookStorage) {
        this.gridFsTemplate = gridFsTemplate;
        this.bookStorage = bookStorage;
    }

    public GridFsResource storeFile(MultipartFile file) throws IOException {
        ObjectId objectId = gridFsTemplate.store(file.getInputStream(), file.getName(), file.getContentType());
        GridFSFile gFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(new ObjectId(objectId.toHexString()))));
        return gridFsTemplate.getResource(gFile);
    }

    public GridFsResource retrieveFile(String id) {
        GridFSFile gridFSFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(new ObjectId(id))));
        if (gridFSFile == null) {
            throw new NoSuchElementException("GridFSFile with this id not found");
        }
        return gridFsTemplate.getResource(gridFSFile);
    }

    @Override
    @Transactional
    public void setImageToBook(UUID uuid, GridFs imageId) {
        Optional<Book> book = bookStorage.findById(uuid);
        Book bookFromDb = book.orElseThrow();
        bookStorage.save(
                 Book.builder()
                .id(bookFromDb.getId())
                .author(bookFromDb.getAuthor())
                .name(bookFromDb.getName())
                .description(bookFromDb.getDescription())
                .gridFsImageId(imageId)
                .build());
    }
}
