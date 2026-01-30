package com.apps.QuantityMeasurement.test;
import com.apps.quantityMeasurement.QuantityMeasurementApp.Feet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        assertEquals(f1, f2, "Double value should be exactly equal");
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet f1 = new Feet(0.0);
        Feet f2 = new Feet(1.0);
        assertNotEquals(f1, f2, "Double value should not be equal");
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet f1 = new Feet(0.0);
        assertNotEquals(null, f1, "Double value should not be equal to null");
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        Feet f1 = new Feet(0.0);
        Feet f2 = new Feet(1);
        assertNotEquals(f1, f2, "Double value should not be equal");
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet f1 = new Feet(5.0);
        assertEquals(f1, f1, "Value should be equal to itself");
    }
}