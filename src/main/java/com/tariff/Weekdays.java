package com.tariff;
/**
 * @author Rajesh.Kumar4
 *
 */
import java.util.HashMap;
import java.util.Map;

public class Weekdays implements ParkingRate {

    public Map<RateGaps, Integer> getRate() {
        Map<RateGaps, Integer> map = new HashMap<>();
        map.put(RateGaps.FIRST, 5);
        map.put(RateGaps.SECOND, 8);
        map.put(RateGaps.THIRD, 12);
        map.put(RateGaps.FOURTH, 18);
        map.put(RateGaps.FIFTH, 25);
        return map;
    }

}
