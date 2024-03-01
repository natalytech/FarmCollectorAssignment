-- V1__Init_schema.sql

-- Create the 'field' table
CREATE TABLE field (
    field_id VARCHAR(36) PRIMARY KEY,
    farm_id VARCHAR(36)
    );

 -- Create the 'planted_crop' table
CREATE TABLE planted_crop (
    planted_id VARCHAR(36) PRIMARY KEY,
    field_id VARCHAR(36),
    crop_type VARCHAR(255),
    planting_area DOUBLE PRECISION,
    expected_product_amount DOUBLE PRECISION,
    season VARCHAR(255),
    FOREIGN KEY (field_id) REFERENCES field(field_id)
    );

    -- Create indexes
    CREATE INDEX idx_field_id ON planted_crop(field_id);
    CREATE INDEX idx_crop_type ON planted_crop(crop_type);

-- Create the 'harvested_crop' table
    CREATE TABLE harvested_crop (
        harvested_id VARCHAR(36) PRIMARY KEY,
        field_id VARCHAR(36),
        planted_id VARCHAR(36),
        actual_harvest_amount DOUBLE PRECISION,
        FOREIGN KEY (field_id) REFERENCES field(field_id),
        FOREIGN KEY (planted_id) REFERENCES planted_crop(planted_id)
    );

    -- Create indexes
    CREATE INDEX idx_field_id_harvest ON harvested_crop(field_id);
