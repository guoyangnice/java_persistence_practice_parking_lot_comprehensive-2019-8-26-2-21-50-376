package tws.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.internal.metadata.descriptor.ParameterDescriptorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tws.entity.ParkingLot;
import tws.entity.Parkingboy;
import tws.repository.ParkingLotMapper;
import tws.repository.ParkingboyMapper;

@Service
public class ParkingboyService {
	@Autowired
	private ParkingboyMapper parkingboyMapper;
	
	@Autowired
	private ParkingLotMapper parkingLotMapper;

	public List<Parkingboy> getAllParkingboys(){
		List<Parkingboy> parkingboys = parkingboyMapper.getAllParkingboys();
		return parkingboys;
	}
	
	public List<String> getBoyManageLots(int id){
		List<ParkingLot> parkingLots = parkingboyMapper.getManage(id);
		List<String> parkinglotName = new ArrayList<String>();
		for(int i = 0 ; i< parkingLots.size();i++) {
			parkinglotName.add(parkingLots.get(i).getParkingLotId());
		}
		return parkinglotName;
	}
	
	public List<Parkingboy> getOneParkingboy(int id){
		List<Parkingboy> parkingboys = parkingboyMapper.getOneParkingboy(id);
		return parkingboys;
	}
	
	public void deleteParkingboy(int id) {
		parkingboyMapper.deleteParkingboy(id);
	}
	
	//¸üÐÂ
	public void updateParkingboy(int id) {
		parkingboyMapper.updateOneParkingboyNameById(id);
	}
	
	//Ìí¼Ó
	public void insertParkingboy(Parkingboy parkingboy) {
		parkingboyMapper.insertOneParkingboy(parkingboy);
	}
}
