package com.example.vehicle.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name="vehicle")
public class Vehicle {

    @Id
	@Column(name = "object_id")
    private String objectId;
    @Column(name = "year")
    private String year;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model ;
    @Column(name = "category")
    private String category;
    @Column(name = "created_at")   
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;

    
}
