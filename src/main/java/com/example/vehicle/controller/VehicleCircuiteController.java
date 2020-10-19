package com.example.vehicle.controller;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/test")
@Slf4j
public class VehicleCircuiteController {

    private static final String INSTANCE_ID = UUID.randomUUID().toString();
    private Random random = new Random();

    @Value("${VERSION}")
    private String version;

    @GetMapping("/random-error")
    public ResponseEntity<String> pingWithRandomError() {
        int r = random.nextInt(100);
        if (r % 2 == 0) {
            log.info("===호출(request) 랜덤에러 : name=vehicle-api version={}, random={}, httpCode={}", version, r,
                    HttpStatus.GATEWAY_TIMEOUT);
            return new ResponseEntity<>("에러 발생  " + INSTANCE_ID + " " + version, HttpStatus.GATEWAY_TIMEOUT);
        } else{
            log.info("=== 호출(request) 랜덤에러:  name=vehicle-api  version={}, random={}, httpCode={}", version, r, HttpStatus.OK);
            return new ResponseEntity<>("정상 서비스 중  " + INSTANCE_ID + " " + version, HttpStatus.OK);
        }
    }

    @GetMapping("/random-delay")
    public String pingWithRandomDelay() throws InterruptedException {
        int r = new Random().nextInt(3000);
        log.info("=== 호출(request) 랜덤지연 name=vehicle-api  version={}, delay={}", version, r);
        Thread.sleep(r);
        return "정상 서비스 중 " + version;
    }

}
