package com.assessment.devstaff.model;

import com.assessment.devstaff.model.enums.Season;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "planted_crop")
public class PlantedCrop {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String plantedId;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Field field;

    private double plantingArea; // Assuming area is in acres

    private String cropType;

    private double expectedProductAmount; // Assuming product amount is in tons

    @Column(columnDefinition = "text")
    @Enumerated(EnumType.STRING)
    private Season season;
}
