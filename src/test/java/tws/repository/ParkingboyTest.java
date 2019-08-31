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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.hamcrest.CoreMatchers;
import org.springframework.boot.test.context.SpringBootTest;
import ch.qos.logback.core.status.Status;
import tws.entity.Employee;
import tws.entity.Parkingboy;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
