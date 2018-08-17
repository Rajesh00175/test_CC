package spring;

import org.springframework.web.bind.annotation.*;

import com.ParkingLot.ParkingBillManager;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@RestController
public class ParkingController {

    private final ParkingBillManager parkingBillManager = new ParkingBillManager();

    @RequestMapping(value = "/")
    public String index() {
        return "The app is up";
    }

    @RequestMapping(value = "/setEntryDateTime", method = RequestMethod.POST)
    public long setEntryDateTime(@RequestParam String entryDateTime) {
        return parkingBillManager.newParkingBill(OffsetDateTime.parse(entryDateTime));
    }

    @RequestMapping(value = "/setExitDateTime", method = RequestMethod.POST)
    public void setExitDateTime(@RequestParam String exitDateTime, Long billId) {
        parkingBillManager.getParkingBill(billId).setExitDateTime(OffsetDateTime.parse(exitDateTime));
        parkingBillManager.getParkingBill(billId).calculateTotal();
    }

    @RequestMapping(value = "/getParkingBillTariff", method = RequestMethod.GET)
    public BigDecimal getParkingBillTariff(@RequestParam Long billId) {
        return parkingBillManager.getParkingBill(billId).getTotalTariff();
    }

}