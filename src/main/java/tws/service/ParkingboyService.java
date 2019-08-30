package tws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import tws.entity.Parkingboy;
import tws.repository.ParkingboyMapper;

@Service
public class ParkingboyService {
	@Autowired
	private ParkingboyMapper parkingboyMapper;
	
	@GetMapping
	public List<Parkingboy> getAllParkingboys(){
		List<Parkingboy> parkingboys = parkingboyMapper.getAllParkingboys();
		return parkingboys;
	}
}
