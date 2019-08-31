package tws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.Parkingboy;
import tws.service.ParkingboyService;

@RestController
@RequestMapping("/parkingboys")
public class ParkingboyController {
	
	@Autowired
	private ParkingboyService parkingboyService;
	
	@GetMapping("")
    public ResponseEntity<List<Parkingboy>> getAll() {
        return ResponseEntity.ok(parkingboyService.getAllParkingboys());
    }
	
	
}
