package com.example.vehicle.controller;

import java.util.List;

import com.example.vehicle.model.ResultMessage;
import com.example.vehicle.model.Vehicle;
import com.example.vehicle.repository.VehicleRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
@Slf4j
public class VehicleApiController {
    private final VehicleRepository repository;

    @Operation(summary = "차량 정보 전부를 가져온다")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "차량 정보 전부를 가져온다",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = List.class)) }) })
    @GetMapping()
    public List<Vehicle> searchVehicleList(){
		log.info("=========searchVehicleList==========");
        List<Vehicle> vehicleList = repository.findAll();
        return vehicleList;
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
