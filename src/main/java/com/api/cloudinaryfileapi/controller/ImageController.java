package com.api.cloudinaryfileapi.controller;

import com.api.cloudinaryfileapi.model.Image;
import com.api.cloudinaryfileapi.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("fileUploadApi")
public class ImageController {

    @Autowired
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/uploadFiles")
    public String uploadFile(@RequestParam("image")MultipartFile file, Image image) {
        imageService.uploadFile(image,file);
        return "Files Uploaded Successfully";
    }

    @GetMapping("/getImages")
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/getImages/{id}")
    public Image getImageById(@PathVariable Long id) {
        return imageService.getImageById(id);
    }
}
