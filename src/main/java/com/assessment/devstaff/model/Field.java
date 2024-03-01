package com.assessment.devstaff.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "field")
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String fieldId;
    private String farmId;
}
