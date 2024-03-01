package com.assessment.devstaff.repository;

import com.assessment.devstaff.model.PlantedCrop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantedCropRepository extends JpaRepository<PlantedCrop, String> {
}