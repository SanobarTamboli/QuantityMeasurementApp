package com.apps.quantityMeasurement;

import java.util.Objects;

public class Length {

    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);


        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }

        public double toUnit(double value) {
            return value * conversionFactor;
        }
    }


    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Value Cannot be Null");
        }
        this.value = value;
        this.unit = unit;
    }


    private double convertToBaseUnit() {
        return unit.toUnit(value);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return  true;
        if (!(obj instanceof Length)) return  false;
        Length someObj = (Length) obj;
        return Double.compare(this.convertToBaseUnit(), someObj.convertToBaseUnit())==0;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(convertToBaseUnit());
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

