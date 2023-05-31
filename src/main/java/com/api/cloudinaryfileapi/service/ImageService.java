package com.api.cloudinaryfileapi.service;

import com.api.cloudinaryfileapi.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    void uploadFile(Image image, MultipartFile file);

    List<Image> getAllImages();

    Image getImageById(Long id);
}
