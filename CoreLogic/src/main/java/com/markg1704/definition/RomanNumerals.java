package com.markg1704.definition;

public enum RomanNumerals {

    I(1, "I"),
    V(5, "V"),
    X(10, "X"),
    L(50, "L"),
    C(100, "C"),
    D(500, "D"),
    M(1000, "M");

    private final int value;
    private final String numeral;

    RomanNumerals(int value, String numeral) {
        this.value = value;
        this.numeral = numeral;
    }

    public int getValue() {
        return value;
    }

    public String getNumeral() {
        return numeral;
    }

}
