package com.tariff;
/**
 * @author Rajesh.Kumar4
 *
 */
import java.util.HashMap;
import java.util.Map;

public class Weekends implements ParkingRate {

    public Map<RateGaps, Integer> getRate() {
        Map<RateGaps, Integer> map = new HashMap<>();
        map.put(RateGaps.FIRST, 7);
        map.put(RateGaps.SECOND, 10);
        map.put(RateGaps.THIRD, 15);
        map.put(RateGaps.FOURTH, 22);
        map.put(RateGaps.FIFTH, 30);
        return map;
    }
}
