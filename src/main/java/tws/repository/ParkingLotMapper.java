package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import tws.entity.ParkingLot;

@Mapper
public interface ParkingLotMapper {
	@Select("select * from parkinglot")
	List<ParkingLot> getAllParkingLots();
	
	
}
