package com.markg1704.conversion;

import com.markg1704.definition.RomanNumerals;
import com.markg1704.model.RomanNumeral;

/**
 * RomanNumeralConverter
 * <p>
 * Class to convert integer values between 1 - 3,999 to a Roman Numeral String
 */
public class RomanNumeralConverter {

    private static final int THRESHOLD_NINE_HUNDRED = RomanNumerals.M.getValue() - RomanNumerals.C.getValue();
    private static final int THRESHOLD_FOUR_HUNDRED = RomanNumerals.D.getValue() - RomanNumerals.C.getValue();
    private static final int THRESHOLD_NINETY = RomanNumerals.C.getValue() - RomanNumerals.X.getValue();
    private static final int THRESHOLD_FORTY = RomanNumerals.L.getValue() - RomanNumerals.X.getValue();
    private static final int THRESHOLD_NINE = RomanNumerals.X.getValue() - RomanNumerals.I.getValue();
    private static final int THRESHOLD_FOUR = RomanNumerals.V.getValue() - RomanNumerals.I.getValue();


    /**
     * Method to convert int value between 1 - 3,999 to Roman Numeral String
     *
     * @param value - integer value to be converted
     * @return RomanNumeral.  Returns null if out of range.
     */
    public RomanNumeral convert(int value) {

        if (value < 1 || value > 3999)
            return null;

        String numeralString = getThousands(value);

        int factorValue = value % RomanNumerals.M.getValue();

        numeralString += getHundreds(factorValue);

        factorValue = factorValue % RomanNumerals.C.getValue();

        numeralString += getTens(factorValue);

        factorValue = factorValue % RomanNumerals.X.getValue();

        numeralString += getSingleDigits(factorValue);

        return new RomanNumeral(numeralString, value);

    }

    /**
     * Method to return thousands component of input value
     *
     * @param value between 1 - 3,999
     * @return String equivalent of thousands component
     */
    String getThousands(int value) {

        if (value < RomanNumerals.M.getValue())
            return "";

        int numberOfThousands = value / RomanNumerals.M.getValue();

        return createRepeatNumeral(numberOfThousands, RomanNumerals.M.getNumeral());
    }

    /**
     * Method to return hundreds component of input value
     *
     * @param value between 1 - 999
     * @return String equivalent of hundreds component
     */
    String getHundreds(int value) {

        String numeral = "";

        if (value >= THRESHOLD_NINE_HUNDRED)
            return RomanNumerals.C.getNumeral() + RomanNumerals.M.getNumeral();

        if (value >= RomanNumerals.D.getValue() && value < THRESHOLD_NINE_HUNDRED) {
            numeral += RomanNumerals.D.getNumeral();
            value = value % RomanNumerals.D.getValue();
        }

        if (value >= THRESHOLD_FOUR_HUNDRED)
            return RomanNumerals.C.getNumeral() + RomanNumerals.D.getNumeral();


        if (value < THRESHOLD_FOUR_HUNDRED && value >= RomanNumerals.C.getValue()) {
            int numberOfHundreds = value / RomanNumerals.C.getValue();
            numeral += createRepeatNumeral(numberOfHundreds, RomanNumerals.C.getNumeral());
        }

        return numeral;
    }

    /**
     * Method to return tens component of input value
     *
     * @param value between 1 - 99
     * @return String equivalent of tens component
     */
    String getTens(int value) {

        String numerals = "";

        if (value >= THRESHOLD_NINETY)
            return RomanNumerals.X.getNumeral() + RomanNumerals.C.getNumeral();

        if (value >= RomanNumerals.L.getValue() && value < THRESHOLD_NINETY) {
            numerals += RomanNumerals.L.getNumeral();
            value = value % RomanNumerals.L.getValue();
        }

        if (value >= THRESHOLD_FORTY)
            return RomanNumerals.X.getNumeral() + RomanNumerals.L.getNumeral();

        if (value >= RomanNumerals.X.getValue() && value < THRESHOLD_FORTY) {
            int numberOfTens = value / RomanNumerals.X.getValue();

            numerals += createRepeatNumeral(numberOfTens, RomanNumerals.X.getNumeral());

        }

        return numerals;

    }

    /**
     * Method to return Roman Numerals between 1 - 9
     *
     * @param value between 1 - 9
     * @return String value
     */
    String getSingleDigits(int value) {

        if (value >= THRESHOLD_NINE)
            return RomanNumerals.I.getNumeral() + RomanNumerals.X.getNumeral();


        String numerals = "";

        if (value >= RomanNumerals.V.getValue() && value < THRESHOLD_NINE) {
            numerals += RomanNumerals.V.getNumeral();
            value = value % RomanNumerals.V.getValue();
        }

        if (value == THRESHOLD_FOUR)
            return RomanNumerals.I.getNumeral() + RomanNumerals.V.getNumeral();

        if (value >= RomanNumerals.I.getValue() && value < THRESHOLD_FOUR) {
            numerals += createRepeatNumeral(value, RomanNumerals.I.getNumeral());
        }

        return numerals;

    }

    /**
     * Method to create repeat values of input string
     *
     * @param count - number of repeats required
     * @param input - input String
     * @return - concatenated String of input values
     */
    private String createRepeatNumeral(int count, String input) {

        String repeater = "";

        for (int i = 0; i < count; i++) {
            repeater += input;
        }

        return repeater;
    }
}
