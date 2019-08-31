package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PutMapping;

import tws.entity.ParkingLot;
import tws.entity.Parkingboy;

@Mapper
public interface ParkingboyMapper {
	@Select("select * from parkingboy")
	List<Parkingboy> getAllParkingboys();
	
	@Select("select parkinglot.PARKINGLOTID from parkinglot where #{id} = parkinglot.parkingboyID")
	List<ParkingLot> getManage(@Param("id")int id);
	
	//≤È’““ª∏ˆ
	@Select("select parkingboy.id,parkingboy.name from parkingboy where #{id} = parkingboy.id")
	List<Parkingboy> getOneParkingboy(@Param("id") int id);
	
	@Delete("delete from parkingboy where #{id} = parkingboy.id")
	void deleteParkingboy(@Param("id") int id);
	
	@Update("update parkingboy set parkingboy.name = 'yangjie' where #{id} = parkingboy.id")
	void updateOneParkingboyNameById(@Param("id") int id);
}
