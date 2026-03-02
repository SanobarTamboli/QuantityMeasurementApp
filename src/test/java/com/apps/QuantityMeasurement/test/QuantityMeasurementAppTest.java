package com.apps.QuantityMeasurement.test;

import com.apps.quantityMeasurement.Length;
import com.apps.quantityMeasurement.LengthUnit;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.0001;


    @Test
    public void testLengthUnitEnum_FeetConstant() {
        assertEquals(12.0,
                LengthUnit.FEET.getConversionFactor(), EPSILON);
    }

    @Test
    public void testLengthUnitEnum_InchesConstant() {
        assertEquals(1.0,
                LengthUnit.INCHES.getConversionFactor(), EPSILON);
    }

    @Test
    public void testLengthUnitEnum_YardsConstant() {
        assertEquals(36.0,
                LengthUnit.YARDS.getConversionFactor(), EPSILON);
    }

    @Test
    public void testLengthUnitEnum_CentimetresConstant() {
        assertEquals(0.393701,
                LengthUnit.CENTIMETERS.getConversionFactor(), EPSILON);
    }

    @Test
    public void testConvertToBase_FeetToInches() {
        assertEquals(12.0,
                LengthUnit.FEET.convertToBaseUnit(1), EPSILON);
    }

    @Test
    public void testConvertToBase_InchesToInches() {
        assertEquals(12.0,
                LengthUnit.INCHES.convertToBaseUnit(12), EPSILON);
    }

    @Test
    public void testConvertToBase_YardsToInches() {
        assertEquals(36.0,
                LengthUnit.YARDS.convertToBaseUnit(1), EPSILON);
    }

    @Test
    public void testConvertToBase_CentimetresToInches() {
        assertEquals(1.0,
                LengthUnit.CENTIMETERS.convertToBaseUnit(2.54), EPSILON);
    }

    @Test
    public void testconvertFromBaseUnit_InchesToFeet() {
        assertEquals(1.0,
                LengthUnit.FEET.convertFromBaseUnit(12), EPSILON);
    }

    @Test
    public void testconvertFromBaseUnit_InchesToInches() {
        assertEquals(12.0,
                LengthUnit.INCHES.convertFromBaseUnit(12), EPSILON);
    }

    @Test
    public void testconvertFromBaseUnit_InchesToYards() {
        assertEquals(1.0,
                LengthUnit.YARDS.convertFromBaseUnit(36), EPSILON);
    }

    @Test
    public void testconvertFromBaseUnit_InchesToCentimetres() {
        assertEquals(2.54,
                LengthUnit.CENTIMETERS.convertFromBaseUnit(1), EPSILON);
    }

    @Test
    public void testLengthRefactored_Equality() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);
        assertEquals(l1, l2);
    }


    @Test
    public void testLengthRefactored_ConvertTo() {
        Length l = new Length(1, LengthUnit.FEET);
        Length result = l.convert(LengthUnit.INCHES);
        assertEquals(12.0, result.getValue(), EPSILON);
    }

    @Test
    public void testLengthRefactored_Add() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);
        Length result = Length.add(l1, l2, LengthUnit.FEET);
        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    public void testLengthRefactored_AddWithTargetUnit() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);
        Length result = Length.add(l1, l2, LengthUnit.YARDS);
        assertEquals(0.6667, result.getValue(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLengthRefactored_NullUnit() {
        new Length(1, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLengthRefactored_InvalidValue() {
        new Length(Double.NaN, LengthUnit.FEET);
    }

    @Test
    public void testBackwardCompatibility_UC1Equality() {
        Length l1 = new Length(3, LengthUnit.FEET);
        Length l2 = new Length(36, LengthUnit.INCHES);
        assertEquals(l1, l2);
    }

    @Test
    public void testBackwardCompatibility_UC5Conversion() {
        Length l = new Length(2, LengthUnit.FEET);
        Length result = l.convert(LengthUnit.INCHES);
        assertEquals(24.0, result.getValue(), EPSILON);
    }

    @Test
    public void testBackwardCompatibility_UC6Addition() {
        Length l1 = new Length(2, LengthUnit.FEET);
        Length l2 = new Length(24, LengthUnit.INCHES);
        Length result = Length.add(l1, l2, LengthUnit.FEET);
        assertEquals(4.0, result.getValue(), EPSILON);
    }

    @Test
    public void testBackwardCompatibility_UC7AdditionWithTargetUnit() {
        Length l1 = new Length(2, LengthUnit.FEET);
        Length l2 = new Length(24, LengthUnit.INCHES);
        Length result = Length.add(l1, l2, LengthUnit.YARDS);
        assertEquals(1.3333, result.getValue(), 0.001);
    }

    @Test
    public void testArchitecturalScalability() {
        Assert.assertNotNull(LengthUnit.FEET);
    }

    @Test
    public void testRoundTripConversion() {
        Length original = new Length(5, LengthUnit.FEET);
        Length converted = original.convert(LengthUnit.INCHES)
                .convert(LengthUnit.FEET);
        assertEquals(original.getValue(),
                converted.getValue(), EPSILON);
    }

    @Test
    public void testUnitImmutability() {
        Assert.assertTrue(LengthUnit.FEET instanceof Enum);
    }
}