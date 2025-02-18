package tws.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.MediaType;

import tws.entity.ParkingLot;
import tws.entity.Parkingboy;
import tws.service.ParkingboyService;

@RestController
@RequestMapping("/parkingboys")
public class ParkingboyController {
	
	@Autowired
	private ParkingboyService parkingboyService;
	
	@GetMapping
    public ResponseEntity<List<Parkingboy>> getAll() {
        return ResponseEntity.ok(parkingboyService.getAllParkingboys());
    }

	
//	@GetMapping("/{id}")
//	public ResponseEntity<List<ParkingLot>> getParkingLotByManager(@PathVariable int id){
//		return ResponseEntity.ok(parkingboyService.getParkinglotByManage());
//	}
	
	@GetMapping("/{id}/parkinglots")
	public ResponseEntity<List<String>> getParkingLotByManager(@PathVariable int id){
		return ResponseEntity.ok(parkingboyService.getBoyManageLots(id));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Parkingboy>> getOneParkingboy(@PathVariable int id){
		return ResponseEntity.ok(parkingboyService.getOneParkingboy(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteOneParkingboy(@PathVariable int id) {
		parkingboyService.deleteParkingboy(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity updateOneParkingboy(@PathVariable int id) {
		parkingboyService.updateParkingboy(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping
	public ResponseEntity insertOneParkingboy(@RequestBody Parkingboy parkingboy) {
		parkingboyService.insertParkingboy(parkingboy);
		return ResponseEntity.ok().build();
	}
	
}
