package com.example.vehicle.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
@Table(name="vehicle")
public class Vehicle {

    @Id
	@Column(name = "object_id")
    @Schema(description = "오브젝트_ID")
    private String objectId;

    @Column(name = "year")
    @Schema(description = "제조년")
    private String year;

    @Column(name = "make")
    @Schema(description = "제조사")
    private String make;

    @Column(name = "model")
    @Schema(description = "차량명")
    private String model ;

    @Column(name = "category")
    @Schema(description = "카테고리")
    private String category;

    @Column(name = "created_at")
    @Schema(description = "데이터 생성일")
    private String createdAt;

    @Column(name = "updated_at")
    @Schema(description = "데이터 수정일")
    private String updatedAt;
    
}
