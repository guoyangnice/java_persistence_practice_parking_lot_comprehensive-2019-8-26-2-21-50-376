package tws.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import tws.entity.Parkingboy;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureMockMvc
public class ParkingboyTest {
	@Autowired
	private ParkingboyMapper parkingboyMapper;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
    private MockMvc mockMvc;
	
	JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Before
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingboy");
    }

    //数据库测试
    @Test
    public void shouldFetchAllParkingboy() {
        // given
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(1,'zhangsan')");
        // when
        List<Parkingboy> parkingboys = parkingboyMapper.getAllParkingboys();
        // then
        assertEquals(1, parkingboys.size());
    }
    
    //数据库测试
    @Test
    public void shouldFetchOneParkingboy() {
        // given
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(1,'zhangsan')");
        // when
        List<Parkingboy> parkingboys = parkingboyMapper.getOneParkingboy(1);
        // then
        assertEquals("zhangsan", parkingboys.get(0).getName());
    }
    
    //数据库测试
    @Test
    public void shouldDeleteOneParkingboyById() {
    	// given
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(1,'zhangsan')");
        // when
        parkingboyMapper.deleteParkingboy(1);
        List<Parkingboy> parkingboys = parkingboyMapper.getAllParkingboys();
        // then
        assertEquals(0,parkingboys.size());
    }
    
    //数据库测试
    @Test
    public void shouldUpdateOneParkingboyNameById() {
    	// given
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(1,'zhangsan')");
        // when
        parkingboyMapper.updateOneParkingboyNameById(1);
        List<Parkingboy> parkingboys = parkingboyMapper.getAllParkingboys();
        // then
        assertEquals("yangjie",parkingboys.get(0).getName());
    }
    
    
}
