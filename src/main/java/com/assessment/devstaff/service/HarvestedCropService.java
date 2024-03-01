package com.assessment.devstaff.service;

import com.assessment.devstaff.dto.HarvestedCropDto;
import com.assessment.devstaff.model.HarvestedCrop;

public interface HarvestedCropService {

    HarvestedCrop createHarvestedCrop(HarvestedCropDto harvestedCrop);
}
