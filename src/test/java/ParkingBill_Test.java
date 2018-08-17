import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.ParkingLot.ParkingBill;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import spring.ParkingController;
/**
 * @author Rajesh.Kumar4
 *
 */
public class ParkingBill_Test {

    @InjectMocks
    private ParkingController parkingController;

    @Before
    public void setup() {
        parkingController = new ParkingController();
    }
/*
 * testing for fix values
 */
    @Test
    public void calculateThreeHoursTariff() throws Exception{
        ParkingBill parkingBill = new ParkingBill();
        parkingBill.setEntryDateTime(OffsetDateTime.of(2018, 11, 11,
         15,  0,  0,  0, ZoneOffset.UTC));
        parkingBill.setExitDateTime(OffsetDateTime.of(2018, 11, 11,
                18,  0,  0,  0, ZoneOffset.UTC));
        parkingBill.calculateTotal();

        Assert.assertEquals(BigDecimal.valueOf(24), parkingBill.getTotalTariff());
    }

    @Test
    public void calculateThreeHoursTariffWithService() throws Exception{
        long billId = parkingController.setEntryDateTime(OffsetDateTime.of(2018, 11, 11,
                15,  0,  0,  0, ZoneOffset.UTC).toString());
        parkingController.setExitDateTime(OffsetDateTime.of(2018, 11, 11,
                18,  0,  0,  0, ZoneOffset.UTC).toString(), billId);

        Assert.assertEquals(BigDecimal.valueOf(24), parkingController.getParkingBillTariff(billId));
    }

}
