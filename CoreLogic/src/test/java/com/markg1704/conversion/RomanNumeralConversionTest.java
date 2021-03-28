package com.markg1704.conversion;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RomanNumeralConversionTest {

    private RomanNumeralConverter converter;

    @BeforeAll
    public void initialise() {
        converter = new RomanNumeralConverter();
    }

    @Test
    public void test_conversion_sub_ten() {

        assertEquals("IX", converter.getSingleDigits(9));
        assertEquals("VIII", converter.getSingleDigits(8));
        assertEquals("VII", converter.getSingleDigits(7));
        assertEquals("VI", converter.getSingleDigits(6));
        assertEquals("V", converter.getSingleDigits(5));
        assertEquals("IV", converter.getSingleDigits(4));
        assertEquals("III", converter.getSingleDigits(3));
        assertEquals("II", converter.getSingleDigits(2));
        assertEquals("I", converter.getSingleDigits(1));

    }

    @Test
    public void test_conversion_ten_to_ninety() {

        assertEquals("X", converter.getTens(10));
        assertEquals("XX", converter.getTens(20));
        assertEquals("XXX", converter.getTens(30));
        assertEquals("XL", converter.getTens(40));
        assertEquals("L", converter.getTens(50));
        assertEquals("LX", converter.getTens(60));
        assertEquals("LXX", converter.getTens(70));
        assertEquals("LXXX", converter.getTens(80));
        assertEquals("XC", converter.getTens(90));

    }

    @Test
    public void test_conversion_hundreds() {

        assertEquals("C", converter.getHundreds(100));
        assertEquals("CC", converter.getHundreds(200));
        assertEquals("CCC", converter.getHundreds(300));
        assertEquals("CD", converter.getHundreds(400));
        assertEquals("D", converter.getHundreds(500));
        assertEquals("DC", converter.getHundreds(600));
        assertEquals("DCC", converter.getHundreds(700));
        assertEquals("DCCC", converter.getHundreds(800));
        assertEquals("CM", converter.getHundreds(900));

    }

    @Test
    public void test_conversion_thousands() {

        assertEquals("M", converter.getThousands(1000));
        assertEquals("MM", converter.getThousands(2000));
        assertEquals("MMM", converter.getThousands(3000));
    }

    @Test
    public void test_conversion() {

        assertEquals("XLIX", converter.convert(49).getNumeral());
        assertEquals("CLXXIV", converter.convert(174).getNumeral());
        assertEquals("CDLXXXVII", converter.convert(487).getNumeral());
        assertEquals("DV", converter.convert(505).getNumeral());
        assertEquals("DCCLXXXIX", converter.convert(789).getNumeral());
        assertEquals("MDCCXLVIII", converter.convert(1748).getNumeral());
        assertEquals("MMXVIII", converter.convert(2018).getNumeral());
        assertEquals("MMDCXX", converter.convert(2620).getNumeral());
        assertEquals("MMMXIX", converter.convert(3019).getNumeral());
        assertEquals("MMMCMXCIX", converter.convert(3999).getNumeral());

    }

    @Test
    public void test_low_threshold_returns_null() {
        assertNull(converter.convert(0));
    }

    @Test
    public void test_high_threshold_returns_null() {
        assertNull(converter.convert(4000));
    }

}
