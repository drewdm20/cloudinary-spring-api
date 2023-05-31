package com.api.cloudinaryfileapi.service;

import com.api.cloudinaryfileapi.model.Image;
import com.api.cloudinaryfileapi.repo.ImageRepo;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private final ImageRepo imageRepo;
    private final Cloudinary cloudinary;

    public ImageServiceImpl(ImageRepo imageRepo, Cloudinary cloudinary) {
        this.imageRepo = imageRepo;
        this.cloudinary = cloudinary;
    }

    @Override
    public void uploadFile(Image image, MultipartFile file) {
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            image.setImageUrl(uploadResult.get("url").toString());
            image.setCreatedAt(uploadResult.get("created_at").toString());
            imageRepo.save(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Image> getAllImages() {
        return imageRepo.findAll();
    }

    public Image getImageById(Long id) {
        return imageRepo.findById(id).get();
    }
}
