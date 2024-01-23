package com.vicrum.books.gradleGroovy.java21.service;

import com.mongodb.client.gridfs.model.GridFSFile;
import com.vicrum.books.gradleGroovy.java21.builder.BookBuilder;
import com.vicrum.books.gradleGroovy.java21.entity.Book;
import com.vicrum.books.gradleGroovy.java21.repository.api.postgres.BookStorage;
import com.vicrum.books.gradleGroovy.java21.service.api.BookImageService;
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
public class BookServiceImageImplementation implements BookImageService {
    private final GridFsTemplate gridFsTemplate;

    private final BookStorage bookStorage;

    @Autowired
    public BookServiceImageImplementation(GridFsTemplate gridFsTemplate, BookStorage bookService) {
        this.gridFsTemplate = gridFsTemplate;
        this.bookStorage = bookService;
    }

    public String storeFile(MultipartFile file) throws IOException {
        ObjectId objectId = gridFsTemplate.store(file.getInputStream(), file.getName(), file.getContentType());
        return objectId.toHexString();
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
    public void setImageToBook(UUID uuid, String imageId) {
        Optional<Book> book = bookStorage.findById(uuid);
        Book bookFromDb = book.orElseThrow();
        bookStorage.save(BookBuilder.create()
                .setId(bookFromDb.getId())
                .setAuthor(bookFromDb.getAuthor())
                .setName(bookFromDb.getName())
                .setDescription(bookFromDb.getDescription())
                .setImageId(imageId)
                .build());
    }
}
