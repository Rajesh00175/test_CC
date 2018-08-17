package spring;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.Assert.*;
/**
 * @author Rajesh.Kumar4
 *
 */
@RestController
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingControllerRestApiTest {

    @LocalServerPort
    private int port;
    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Test
    public void getIndex() throws Exception{
        this.base = new URL("http://localhost:" + port + "/");
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        assertEquals(response.getBody(), ("The app is up"));
    }

    @Test
    public void test_setEntryDateTime_ResponseOK() throws Exception {
        String entryDateTime = OffsetDateTime.of(2018, 5, 11,
                18,  0,  0,  0, ZoneOffset.UTC).toString();

        this.base = new URL("http://localhost:" + port + "/setEntryDateTime?entryDateTime="+ entryDateTime);

        ResponseEntity<String> response = template.postForEntity(base.toString(), null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Ignore
    @Test
    public void test_setExitDateTime_ResponseOK() throws Exception {
        String exitDateTime = OffsetDateTime.of(2018, 5, 11,
                18,  0,  0,  0, ZoneOffset.UTC).toString();

        this.base = new URL("http://localhost:" + port + "/setExitDateTime?" +
                "exitDateTime="+ exitDateTime
                + "&" +
                "billId=" + 4325435L);

        ResponseEntity<String> response = template.postForEntity(base.toString(), null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
