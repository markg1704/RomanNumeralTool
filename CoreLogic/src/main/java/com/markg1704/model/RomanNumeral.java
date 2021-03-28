package com.markg1704.model;

/**
 * RomanNumeral
 * <p>
 * Object containing roman numeral string and integer equivalent
 */
public class RomanNumeral {

    private final String numeral;
    private final int numeric;

    public RomanNumeral(String numeral, int numeric) {
        this.numeral = numeral;
        this.numeric = numeric;
    }

    public String getNumeral() {
        return numeral;
    }

    public int getNumeric() {
        return numeric;
    }

}
