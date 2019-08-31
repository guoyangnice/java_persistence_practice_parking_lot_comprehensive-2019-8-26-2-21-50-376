package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tws.entity.ParkingLot;
import tws.entity.Parkingboy;

@Mapper
public interface ParkingboyMapper {
	@Select("select * from parkingboy")
	List<Parkingboy> getAllParkingboys();
	
	@Select("select parkinglot.PARKINGLOTID from parkinglot where #{id} = parkinglot.parkingboyID")
	List<ParkingLot> getManage(@Param("id")int id);
}
