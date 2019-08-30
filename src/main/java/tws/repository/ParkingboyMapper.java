package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import tws.entity.Parkingboy;

@Mapper
public interface ParkingboyMapper {
	List<Parkingboy> getAllParkingboy(Parkingboy parkingboy);
}
