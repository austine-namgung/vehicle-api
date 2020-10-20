package com.example.vehicle.controller;

import java.util.List;

import com.example.vehicle.model.ResultMessage;
import com.example.vehicle.model.Vehicle;
import com.example.vehicle.repository.VehicleRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleApiController {
    private final VehicleRepository repository;

    @GetMapping()
    public List<Vehicle> searchVehicleList(){
        List<Vehicle> vehicleList = repository.findAll();
        return vehicleList;
    }

	@GetMapping("/vehicle-server")   
    @ResponseBody 
    public String  version(){
        return "this is vehicle-api   #1 server";
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
