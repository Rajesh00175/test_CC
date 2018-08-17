package com.ParkingLot;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

import com.tariff.RateGaps;
import com.tariff.RateManager;

public class ParkingBill {

    private OffsetDateTime entryDateTime;
    private OffsetDateTime exitDateTime;
    private BigDecimal totalTariff;

    public ParkingBill() {
    }

    public ParkingBill(OffsetDateTime entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    /**
     * Calculates the final price for the parking stay depending upon weekends or weekdays
     */
    public void calculateTotal() {
        totalTariff = BigDecimal.valueOf((calculateTariff() * calculateParkingDuration()));
    }

    /**
     * calculate the price per hour depending on the weekDay and weekends and hours of the parking stay
     * @return price per hour
     * @throws Exception (RuntimeException) if stay hours<=24 Hours
     */
    private int calculateTariff() throws RuntimeException {
        RateManager parkingRateManager = RateManager.getManager(entryDateTime.getDayOfWeek());
        if (calculateParkingDuration().compareTo(2L) < 0) {
            return parkingRateManager.getDecoder().getRate().get(RateGaps.FIRST);
        } else if (calculateParkingDuration().compareTo(5L) <= 0) {
            return parkingRateManager.getDecoder().getRate().get(RateGaps.SECOND);
        } else if (calculateParkingDuration().compareTo(10L) <= 0) {
            return parkingRateManager.getDecoder().getRate().get(RateGaps.THIRD);
        } else if (calculateParkingDuration().compareTo(15L) <= 0) {
            return parkingRateManager.getDecoder().getRate().get(RateGaps.FOURTH);
        } else if (calculateParkingDuration().compareTo(24L) <= 0) {
            return parkingRateManager.getDecoder().getRate().get(RateGaps.FIFTH);
        } else {
            throw new RuntimeException("Tarif not valid");
        }
    }

    /**
     * Calculates the parking stay between the entry and exit date 
     * @return hours of parking stay duration
     */
    private Long calculateParkingDuration() {
        OffsetDateTime tempDateTime = OffsetDateTime.from(entryDateTime);
        return tempDateTime.until(exitDateTime, ChronoUnit.HOURS);
    }
/*
 * set Entry time of the vehicle
 */
    public void setEntryDateTime(OffsetDateTime entryDateTime) {
        this.entryDateTime = entryDateTime;
    }
/*
 * set Exit time of the vehicle
 */
    public void setExitDateTime(OffsetDateTime exitDateTime) {
        this.exitDateTime = exitDateTime;
    }
/* Get total Tariff corresponding to total hrs spend
 * 
 */
    public BigDecimal getTotalTariff() {
        return totalTariff;
    }
}
