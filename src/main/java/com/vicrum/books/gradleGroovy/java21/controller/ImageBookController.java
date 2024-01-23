package com.vicrum.books.gradleGroovy.java21.controller;

import com.vicrum.books.gradleGroovy.java21.service.api.BookImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/image")
@Controller
public class ImageBookController {

    private final BookImageService bookImageService;

    @Autowired
    public ImageBookController(BookImageService bookImageService) {
        this.bookImageService = bookImageService;
    }

    @PostMapping("{id}")
    public ResponseEntity<String> post(@RequestParam("image") MultipartFile file,
                                       @PathVariable UUID id) throws IOException {
        String fileId = bookImageService.storeFile(file);
        bookImageService.setImageToBook(id, fileId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<InputStreamResource> downloadBookImage(@PathVariable String id) throws IOException {
        GridFsResource resource = bookImageService.retrieveFile(id);
        String filename = URLEncoder.encode(Objects.requireNonNull(resource.getFilename()), StandardCharsets.UTF_8).replaceAll("\\+", "%20");
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(resource.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=UTF-8''" + filename)
                .body(new InputStreamResource(resource.getInputStream()));
    }
}

