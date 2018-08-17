package spring;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * @author Rajesh.Kumar4
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingControllerMockApiTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test_getIndex() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("The app is up")));
    }

    @Test
    public void test_setEntryDateTime_ResponseOK() throws Exception {
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2018, 5, 11,
                15,  0,  0,  0, ZoneOffset.UTC);

        mvc.perform(MockMvcRequestBuilders.post("/setEntryDateTime")
                .param("entryDateTime", String.valueOf(offsetDateTime)))
                .andExpect(status().isOk());
    }

    
    
    @Ignore
    @Test
    public void test_setExitDateTime_ResponseOK() throws Exception {
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2018, 5, 11,
                18,  0,  0,  0, ZoneOffset.UTC);

        mvc.perform(MockMvcRequestBuilders.post("/setExitDateTime")
                .param("exitDateTime", String.valueOf(offsetDateTime))
                .param("billId", String.valueOf(324324L)))
                .andExpect(status().isOk());
    }

}