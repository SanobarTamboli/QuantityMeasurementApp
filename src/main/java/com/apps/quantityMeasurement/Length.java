package com.apps.quantityMeasurement;

import java.util.Objects;


public class Length {

    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
        FEET(12),
        INCHES(1),
        YARDS(36),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // Constructor to initialize length value and unit
    public Length(Double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }


    public static double convert(double value, LengthUnit unit1, LengthUnit unit2) {
        if (unit1 == null || unit2 == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        double inchesvalue = value * unit1.conversionFactor;
        double targetvalue = inchesvalue / unit2.conversionFactor;
        return targetvalue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Length other = (Length) obj;
        double thisFeet = this.value * this.unit.getConversionFactor();
        double otherFeet = other.value * other.unit.getConversionFactor();
        return Double.compare(thisFeet, otherFeet) == 0;

    }
    public static void main(String[] args) {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        System.out.println("Are lengths equal? " + length1.equals(length2));

        Length length3 = new Length(1.0, LengthUnit.YARDS);
        Length length4 = new Length(36.0, LengthUnit.INCHES);
        System.out.println("Are lengths equal? " + length3.equals(length4)); // Should print true

        Length length5 = new Length(100.0, LengthUnit.CENTIMETERS);
        Length length6 = new Length(39.3701, LengthUnit.INCHES);
        System.out.println("Are lengths equal? " + length5.equals(length6));
    }
}