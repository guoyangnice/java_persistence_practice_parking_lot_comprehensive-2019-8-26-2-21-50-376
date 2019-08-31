package tws.repository;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;
import javax.swing.text.AbstractDocument.Content;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.WebApplicationContext;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tws.entity.Parkingboy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingboyApiTest {

	@Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    WebApplicationContext context;
    MockMvc mockMvc;
    @Before
    public void initMockMvc() {
    	mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
    }
	
    //api≤‚ ‘
    @Test
    public void should_add_parkingboy_when_insert_into_parking_boy() throws Exception{
    	//given
    	Parkingboy parkingboy = new Parkingboy(5, "zhangsan");
    	String resultString = objectMapper.writeValueAsString(parkingboy);
    	
    	//when
        ResultActions resultActions =  this.mockMvc.perform(
        			MockMvcRequestBuilders.post("/parkingboys")
        			.contentType(MediaType.APPLICATION_PROBLEM_JSON)
            		.content(resultString)
        		);
        		
        //then
        resultActions.andDo(print()).andExpect(status().isCreated());
    }
    
    //api≤‚ ‘
    @Test
    public void should_get_one_parkingboy_when_get_one_parking_boy() throws Exception{
    	//given
    	
    	//when
        ResultActions resultActions =  this.mockMvc.perform(
        			MockMvcRequestBuilders.get("/parkingboys")
        		);
        		
        //then
        resultActions
        	.andDo(print())
        	.andExpect(status().isOk());
    }
    
    //api≤‚ ‘
    @Test
    public void should_test_delete_one_parking_boy_when_delete_one_parking_boy() throws Exception{
    	//given
    	Parkingboy parkingboy = new Parkingboy(1, "zhangsan");
    	String resultString = objectMapper.writeValueAsString(parkingboy);
    	//when
    	mockMvc.perform(delete("/parkingboys/1")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(resultString))
        //then
    			.andExpect(status().isOk())
        		.andDo(print());
    }
    
    //≤‚ ‘∏¸–¬
    @Test
    public void should_test_update_parking_boy_name() throws Exception {
    	//given
    	Parkingboy parkingboy = new Parkingboy(1, "zhangsan");
    	String resultString = objectMapper.writeValueAsString(parkingboy);
    	
    	//when
    	mockMvc.perform(put("/parkingboys/1")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(resultString))
    	//then
    			.andExpect(status().isOk());
    }
    
}
