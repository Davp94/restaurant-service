package com.blumbit.restaurant_service.service;

import com.blumbit.restaurant_service.dto.request.FileRequest;

public interface IFileService {
    String create(FileRequest fileRequest) throws Exception;
}
