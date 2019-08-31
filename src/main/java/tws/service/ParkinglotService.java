package tws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

@Service
public class ParkinglotService {
	@Autowired
	private ParkingLotMapper parkingLotMapper;
	
	@GetMapping
	public List<ParkingLot> getAllParkingboys(){
		List<ParkingLot> parkingLots = parkingLotMapper.getAllParkingLots();
		return parkingLots;
	}
}
