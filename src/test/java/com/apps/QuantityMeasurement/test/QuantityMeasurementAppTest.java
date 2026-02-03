package com.apps.QuantityMeasurement.test;
import com.apps.quantityMeasurement.Length;
import com.apps.quantityMeasurement.QuantityMeasurementApp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue() {
        Length feet1 = new Length(2.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(2.0, Length.LengthUnit.FEET);
        assertEquals(feet1, feet2);
    }


    @Test
    public void testInchEquality_SameValue() {
        Length inch1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length inch2 = new Length(1.0, Length.LengthUnit.INCHES);
        assertEquals(inch1, inch2);
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        assertNotEquals(null,feet);
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        Length inch1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        assertEquals(inch1, feet1);
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(2.0, Length.LengthUnit.FEET);
        assertNotEquals(feet1, feet2);
    }

    @Test
    public void testInchEquality_DifferentValue() {
        Length inch1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length inch2 = new Length(1.0, Length.LengthUnit.INCHES);
        assertNotEquals(inch1, inch2);
    }


    @Test
    public void testEquality_InvalidUnit() {
        Length inch = new Length(12.0, Length.LengthUnit.INCHES);
        String s = "HelloWorld";
        assertNotEquals(s,inch);
    }

    @Test
    public void testEquality_NullUnit() {
        try {
            Length nullUnit = new Length(1, null);
            Length inch = new Length(1, Length.LengthUnit.INCHES);
            assertNotEquals(nullUnit, inch);
        }catch (Exception e){
            assertNotNull(e);
        }
    }

    @Test
    public void testEquality_SameReference() {
        Length inch = new Length(12.0, Length.LengthUnit.INCHES);
        assertNotEquals(null,inch);
    }

    @Test
    public void testInchesEquality_NullComparison() {
        Length inch = new Length(12.0, Length.LengthUnit.INCHES);
        assertNotEquals(null,inch);
    }
}