package com.blumbit.restaurant_service.service;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.blumbit.restaurant_service.constant.FileConstant;
import com.blumbit.restaurant_service.dto.request.FileRequest;

@Service
public class FileServiceImpl implements IFileService {

    @Override
    public String create(FileRequest fileRequest) throws Exception {

        if (validateFiles(fileRequest)) {
            String filePath = FileConstant.PROJECT_FILES_PATH + File.separator + fileRequest.getTitle();
            byte[] bytes = fileRequest.getFile().getBytes();
            FileOutputStream outputStream = new FileOutputStream(filePath);
            outputStream.write(bytes);
            outputStream.close();
        } else {
            throw new Exception("Formato de imagen no valido");
        }
        return fileRequest.getTitle();
    }

    private boolean validateFiles(FileRequest fileRequest) {
        String contentType = fileRequest.getFile().getContentType();
        if (contentType == null)
            return false;
        return contentType.equals(MediaType.IMAGE_PNG_VALUE) || contentType.equals(MediaType.IMAGE_JPEG_VALUE);
    }

}
