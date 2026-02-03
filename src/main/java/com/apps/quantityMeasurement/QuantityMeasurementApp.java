package com.apps.quantityMeasurement;

public class QuantityMeasurementApp {

    public static void demonstrateFeetEquality() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.FEET);
        System.out.println("Are lengths equal? " + length1.equals(length2));
    }


    public static void demonstrateInchesEquality() {
        Length length1 = new Length(2.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(2.0, Length.LengthUnit.INCHES);
        System.out.println("Are lengths equal? " + length1.equals(length2));
    }

    public static void demonstrateFeetInchesComparison() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);
        System.out.println("Are lengths equal? " + length1.equals(length2));
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();

    }

}
