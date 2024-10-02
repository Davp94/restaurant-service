package com.blumbit.restaurant_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blumbit.restaurant_service.dto.request.FileRequest;
import com.blumbit.restaurant_service.dto.response.FileResponse;
import com.blumbit.restaurant_service.service.IFileService;

@RestController
@RequestMapping("/file")
public class FileController {

    private final IFileService fileService;

    public FileController(IFileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public FileResponse uploadImage(@RequestPart("file") MultipartFile file) throws Exception {
        FileResponse fileResponse = new FileResponse();
        fileResponse.setFilePath(fileService.create(new FileRequest(file.getOriginalFilename(), file)));
        return fileResponse;
    }
}
