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
	

//	public List<ParkingLot> getParkinglotByManage(){
//		List<Parkingboy> parkingboys = parkingboyMapper.getAllParkingboys();
//		List<ParkingLot> parkingLots = parkingLotMapper.getAllParkingLots();
//		List<ParkingLot> containParkingLots = new ArrayList<ParkingLot>();
//		
//		for(ParkingLot pl : parkingLots) {
//			System.out.println("parkinglotid"+pl.getParkingboyID());
//			for(Parkingboy pb : parkingboys) {
//				System.out.println("parkingboyid"+pb.getId());
//				if(pl.getParkingboyID() == pb.getId()) {
//					containParkingLots.add(pl);
//				}
//			}
//		}
//		System.out.println("包括的停车场"+containParkingLots.get(0).getParkingLotId());
//		return containParkingLots;
//	}
	
	public List<String>getBoyManageLots(int id){
		List<ParkingLot> parkingLots = parkingboyMapper.getManage(id);
		List<String> parkinglotName = new ArrayList<String>();
		for(int i = 0 ; i< parkingLots.size();i++) {
			parkinglotName.add(parkingLots.get(i).getParkingLotId());
		}
		return parkinglotName;
	}
}
