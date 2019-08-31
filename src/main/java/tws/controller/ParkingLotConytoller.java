package tws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.ParkingLot;
import tws.entity.Parkingboy;
import tws.service.ParkingboyService;
import tws.service.ParkinglotService;

@RestController
@RequestMapping("/parkinglots")
public class ParkingLotConytoller {
	@Autowired
	private ParkinglotService parkinglotService;
	
	@GetMapping
    public ResponseEntity<List<ParkingLot>> getAll() {
        return ResponseEntity.ok(parkinglotService.getAllParkingboys());
    }
}
