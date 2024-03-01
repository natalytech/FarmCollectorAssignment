package com.assessment.devstaff.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "harvested_crop")
public class HarvestedCrop {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String harvestedId;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Field field;

    @OneToOne
    @JoinColumn(name = "planted_id")
    private PlantedCrop plantedCrop;

    private double actualHarvestAmount; // Assuming amount is in tons

}
