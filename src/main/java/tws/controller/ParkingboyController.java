package tws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.Employee;
import tws.entity.Parkingboy;
import tws.repository.ParkingboyMapper;

@RestController
@RequestMapping("/employees")
public class ParkingboyController {
	@Autowired
	private ParkingboyMapper parkingboyMapper;
	
	@GetMapping("")
    public ResponseEntity<List<Parkingboy>> getAll() {
        return ResponseEntity.ok(parkingboyMapper.getAllParkingboys());
    }
}
