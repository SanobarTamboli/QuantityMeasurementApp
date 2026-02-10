package com.apps.quantityMeasurement;

import static com.apps.quantityMeasurement.Length.*;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        demonstrateComparison(12, Length.LengthUnit.INCHES, Length.LengthUnit.FEET);
        demonstrateComparison(03, Length.LengthUnit.YARDS, Length.LengthUnit.FEET);
        demonstrateComparison(26, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS);
        demonstrateComparison(1, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);
        demonstrateComparison(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);

    }

    private static void demonstrateComparison(double v, LengthUnit unit1, LengthUnit unit2) {
        if (unit1 != null && unit2 != null) {
            double result = Length.convert(v, unit1, unit2);
            System.out.println("Converted Value of "+v+" from " + unit1 + " to "+ unit2 +" is: "+result );
        }
    }
}