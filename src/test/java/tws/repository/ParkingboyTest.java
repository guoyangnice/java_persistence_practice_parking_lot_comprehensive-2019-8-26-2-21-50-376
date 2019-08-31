package tws.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import tws.entity.Employee;
import tws.entity.Parkingboy;

@RunWith(SpringRunner.class)
@MybatisTest
public class ParkingboyTest {
	@Autowired
	private ParkingboyMapper parkingboyMapper;
	
	JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Before
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingboy");
    }

    //数据库测试1
    @Test
    public void shouldFetchAllParkingboy() {
        // given
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(1,'zhangsan')");
        // when
        List<Parkingboy> parkingboys = parkingboyMapper.getAllParkingboys();
        // then
        assertEquals(1, parkingboys.size());
    }
    
    //数据库测试2
    @Test
    public void shouldFetchOneParkingboy() {
        // given
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(1,'zhangsan')");
        // when
        List<Parkingboy> parkingboys = parkingboyMapper.getOneParkingboy(1);
        // then
        assertEquals("zhangsan", parkingboys.get(0).getName());
    }
    
    //数据库测试3
    @Test
    public void shouldDeleteParkingboy() {
    	// given
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(1,'zhangsan')");
        // when
        parkingboyMapper.deleteParkingboy(1);
        List<Parkingboy> parkingboys = parkingboyMapper.getAllParkingboys();
        // then
        assertEquals(0,parkingboys.size());
    }
}
