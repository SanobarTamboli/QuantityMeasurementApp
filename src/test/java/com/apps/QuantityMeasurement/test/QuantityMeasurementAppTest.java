package com.apps.QuantityMeasurement.test;
import com.apps.quantityMeasurement.Length;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuantityMeasurementAppTest {

    @Test
    public void testConversion_FeetToInches() {
        double result= Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(12.0, result,0.0);
    }

    @Test
    public void testConversion_InchesToFeet() {
        double result= Length.convert(24.0, Length.LengthUnit.INCHES, Length.LengthUnit.FEET);
        assertEquals(2.0, result,0.0);
    }

    @Test
    public void testConversion_YardToInches() {
        double result= Length.convert(1.0, Length.LengthUnit.YARDS, Length.LengthUnit.INCHES);
        assertEquals(36.0, result,0.0);
    }

    @Test
    public void testConversion_InchesToYard() {
        double result= Length.convert(72.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS);
        assertEquals(2.0, result,0.0);
    }

    @Test
    public void testConversion_CentimetersToInches() {
        double result= Length.convert(2.54, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);
        assertEquals(1.0, result,1.00000054);
    }

    @Test
    public void testConversion_FeetToYard() {
        double result= Length.convert(6, Length.LengthUnit.FEET, Length.LengthUnit.YARDS);
        assertEquals(2.0, result,1.00000054);
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue() {
        double original = 5.0;
        double converted = Length.convert(
                Length.convert(original, Length.LengthUnit.YARDS, Length.LengthUnit.FEET),
                Length.LengthUnit.FEET, Length.LengthUnit.YARDS
        );
        assertEquals(original, converted, 1.00000054);
    }

    @Test
    public void testConversion_ZeroValue() {
        double result= Length.convert(0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(0.0, result,1.00000054);
    }


    @Test
    public void testInchesEquality_NegativeValue() {
        double result= Length.convert(-1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(-12.0, result,1.00000054);
    }

    @Test
    public void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(1.0, null, Length.LengthUnit.FEET)
        );
        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(1.0, Length.LengthUnit.FEET, null)
        );
    }

    @Test
    public void testConversion_NaNOrInfinite_Throws() {

        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(Double.NaN, Length.LengthUnit.FEET, Length.LengthUnit.INCHES)

        );


        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(Double.POSITIVE_INFINITY, Length.LengthUnit.FEET, Length.LengthUnit.INCHES)
        );

    }


    @Test
    public void testConversion_PrecisionTolerance() {
        double result = Length.convert(1.0, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.FEET);
        double expected = 1.0 / 30.48;
        assertEquals(expected, result,1.00000054);

    }



}