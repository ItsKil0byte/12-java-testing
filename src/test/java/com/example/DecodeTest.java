package com.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DecodeTest {

    @Test
    void Integer_Decode_Decimal() {
        assertEquals(42, Integer.decode("42"));
    }

    @Test
    void Integer_Decode_Octal() {
        assertEquals(256, Integer.decode("0400"));
    }

    @Test
    void Integer_Decode_Hex() {
        assertEquals(52, Integer.decode("0x34"));
        assertEquals(44, Integer.decode("0X2C"));
        assertEquals(19, Integer.decode("#13"));
    }

    @Test
    void Integer_Decode_PositiveSigh() {
        assertEquals(100, Integer.decode("+100"));
        assertEquals(100, Integer.decode("+0144"));
        assertEquals(100, Integer.decode("+0x64"));
    }

    @Test
    void Integer_Decode_NegativeSigh() {
        assertEquals(-10, Integer.decode("-10"));
        assertEquals(-10, Integer.decode("-012"));
        assertEquals(-10, Integer.decode("-0xA"));
    }

    @Test
    void Integer_Decode_InvalidFormat() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("abc"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("1+0"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("10-"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("10 10 10"));
    }

    @Test
    void Integer_Decode_OutOfMaxValue() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("1000000000000"));
    }

    @Test
    void Integer_Decode_NullValue() {
        assertThrows(NullPointerException.class, () -> Integer.decode(null));
    }
}
