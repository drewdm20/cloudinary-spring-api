package com.api.cloudinaryfileapi.repo;

import com.api.cloudinaryfileapi.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image, Long> {
}
