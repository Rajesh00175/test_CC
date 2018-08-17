package com.tariff;
/**
 * @author Rajesh.Kumar4
 *
 */
import java.time.DayOfWeek;

public class RateManager {

    private static RateManager instance = null;
    private ParkingRate parkingRate;

    private RateManager(DayOfWeek dayOfWeek) {
        decodeDay(dayOfWeek);
    }

    public static RateManager getManager(DayOfWeek dayOfWeek) {
        if (instance == null) {
            instance = new RateManager(dayOfWeek);
        }
        return instance;
    }

    private void decodeDay(DayOfWeek dayOfWeek) {
        if (dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            parkingRate = new Weekends();
        } else {
            parkingRate = new Weekdays();
        }
    }

    public ParkingRate getDecoder() {
        return parkingRate;
    }

}
