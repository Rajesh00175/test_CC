package com.tariff;
/**
 * @author Rajesh.Kumar4
 *
 */
public enum RateGaps {

    FIRST("first"),
    SECOND("second"),
    THIRD("third"),
    FOURTH("fourth"),
    FIFTH("fifth");

    private final String value;

    RateGaps(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

}
