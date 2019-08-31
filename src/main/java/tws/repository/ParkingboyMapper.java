package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tws.entity.Parkingboy;

@Mapper
public interface ParkingboyMapper {
	@Select("select * from parkingboy")
	List<Parkingboy> getAllParkingboys();
	
//	@Insert("insert into parkingboy values(1,'V1')")
//	void insertDataToParkingboy(@Param("employee") Parkingboy parkingboy);
}
