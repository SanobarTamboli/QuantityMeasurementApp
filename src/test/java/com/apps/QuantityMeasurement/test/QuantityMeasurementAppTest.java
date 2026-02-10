package com.apps.QuantityMeasurement.test;

import com.apps.quantityMeasurement.Length;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testYardEquality_SameValue() {
        Length oneFeet = new Length(1.0, Length.LengthUnit.YARDS);
        Length anotherFeet = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(oneFeet, anotherFeet);
    }

    @Test
    public void testYardEquality_DifferentValue() {
        Length oneFeet = new Length(1.0, Length.LengthUnit.YARDS);
        Length anotherFeet = new Length(2.0, Length.LengthUnit.YARDS);
        assertNotEquals(oneFeet, anotherFeet);
    }

    @Test
    public void testYardToFeetEquality_EquivalentValue() {
        Length oneFeet = new Length(1.0, Length.LengthUnit.YARDS);
        Length anotherFeet = new Length(3.0, Length.LengthUnit.FEET);
        assertEquals(oneFeet, anotherFeet);
    }

    @Test
    public void testFeetToYardEquality_EquivalentValue() {
        Length oneFeet = new Length(3.0, Length.LengthUnit.FEET);
        Length anotherFeet = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(oneFeet, anotherFeet);
    }

    @Test
    public void testYardToInchesEquality_EquivalentValue() {
        Length oneFeet = new Length(1.0, Length.LengthUnit.YARDS);
        Length anotherFeet = new Length(36.0, Length.LengthUnit.INCHES);
        assertEquals(oneFeet, anotherFeet);
    }

    @Test
    public void testInchesToYardEquality_EquivalentValue() {
        Length oneFeet = new Length(36.0, Length.LengthUnit.INCHES);
        Length anotherFeet = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(oneFeet, anotherFeet);
    }

    @Test
    public void testYardTofeetEquality_NonEquivalentValue() {
        Length oneFeet = new Length(1.0, Length.LengthUnit.YARDS);
        Length anotherFeet = new Length(2.0, Length.LengthUnit.FEET);
        assertNotEquals(oneFeet, anotherFeet);
    }

    @Test
    public void testCentimeterToInchesEquality_EquivalentValue() {
        Length oneFeet = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length anotherFeet = new Length(0.393701, Length.LengthUnit.INCHES);
        assertEquals(oneFeet, anotherFeet);
    }

    @Test
    public void testCentimeterToFeetEquality_NonEquivalentValue() {
        Length oneFeet = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length anotherFeet = new Length(1.0, Length.LengthUnit.FEET);
        assertNotEquals(oneFeet, anotherFeet);
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty(){
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);
        assertEquals(yard, feet);
        assertEquals(feet, inches);
        assertEquals(yard, inches);
    }

    @Test
    public void testEquality_YardWithNullUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                new Length(1.0, null)
        );
    }

    @Test
    public void testYardEquality_SameReference() {
        Length oneYard = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(oneYard, oneYard);
    }

    @Test
    public void testYardEquality_NullComparison() {
        Length oneYard = new Length(1.0, Length.LengthUnit.YARDS);
        assertNotEquals(null, oneYard);
    }

    @Test
    public void testYardEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                new Length(1.0, null)
        );
    }

    @Test
    public void testCentimetersEquality_SameReference() {
        Length oneCentimeter = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        assertEquals(oneCentimeter, oneCentimeter);
    }

    @Test
    public void testCentimetersEquality_NullComparison() {
        Length oneCentimeter = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        assertNotEquals(null, oneCentimeter);
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario(){
        Length yard = new Length(2.0, Length.LengthUnit.YARDS);
        Length feet = new Length(6.0, Length.LengthUnit.FEET);
        Length inches = new Length(72.0, Length.LengthUnit.INCHES);
        assertEquals(yard, feet);
        assertEquals(feet, inches);
        assertEquals(yard, inches);
    }

}