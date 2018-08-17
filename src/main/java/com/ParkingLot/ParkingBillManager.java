package com.ParkingLot;
/**
 * @author Rajesh.Kumar4
 *
 */
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingBillManager {

    private Map<Long, ParkingBill> parkingBills;

    public ParkingBillManager() {
        parkingBills = new HashMap<>();
    }


    public ParkingBill getParkingBill(Long billId) {
        return parkingBills.get(billId);
    }

    public long newParkingBill(OffsetDateTime entryDateTime) {
        long billId = System.currentTimeMillis();
        parkingBills.put(billId, new ParkingBill(entryDateTime));
        return billId;
    }

}
