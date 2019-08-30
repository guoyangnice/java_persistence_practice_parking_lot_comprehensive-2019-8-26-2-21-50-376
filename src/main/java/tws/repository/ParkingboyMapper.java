package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import tws.entity.Parkingboy;

@Mapper
public interface ParkingboyMapper {
	//≤È’“À˘”–parkingboy
	@Select("select * from parkingboy")
	List<Parkingboy> getAllParkingboys();
}
