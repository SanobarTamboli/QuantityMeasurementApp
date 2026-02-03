package com.apps.quantityMeasurement;
//package com.apps.quantityMeasurement.QuantityMeasurementApp;

import java.util.Objects;

public class Length {

    private double value;
    private LengthUnit unit;


    public enum LengthUnit {
        FEET(12.0),

        INCHES(1.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;

        }

        public double toInches(double value) {
            System.out.println(conversionFactor + "Conversion Factor" + value);
            return value * conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;

    }

    private double convertToBaseUnit() {
        System.out.println(value +"convertToBaseUnit");
        return unit.toInches(value);
    }

    private Object obj;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;
        Length someObj = (Length) obj;
        System.out.println(this.value +"both" + convertToBaseUnit());
        System.out.println(convertToBaseUnit() +"both"+ someObj.convertToBaseUnit());
        return Double.compare(convertToBaseUnit(), someObj.convertToBaseUnit()) == 0;
    }

    public int hashcode() {
        return Objects.hash(convertToBaseUnit());
    }
    public static void main(String[] args) {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        System.out.println("Are lengths equal? " + length1.equals(length2)); // Should print true

    }
}
