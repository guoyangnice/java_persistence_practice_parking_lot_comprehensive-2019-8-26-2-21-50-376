package tws.repository;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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
    public void should_get_parkingboy_when_get_all_parking_boys() throws Exception{
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
}
