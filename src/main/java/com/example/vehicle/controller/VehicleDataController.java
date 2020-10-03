package com.example.vehicle.controller;

import java.util.List;

import com.example.vehicle.model.ResultMessage;
import com.example.vehicle.model.Vehicle;
import com.example.vehicle.repository.VehicleRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleDataController {
    private final VehicleRepository repository;
    
    @PostMapping("/bulk-insert")
	public ResponseEntity<ResultMessage> insert( @RequestBody List<Vehicle> listVehicle) throws Exception {

        for(Vehicle vehicle : listVehicle){
            repository.save(vehicle);
        }        
        return getResponseEntity(1);
    }

    private ResponseEntity<ResultMessage> getResponseEntity(int result) {
		ResultMessage resultMessage;
		if (result > 0) {
			resultMessage = new ResultMessage("Y", "정상");
			return ResponseEntity.ok(resultMessage);
		}
		resultMessage = new ResultMessage("N", "오류");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultMessage);

	}
}
