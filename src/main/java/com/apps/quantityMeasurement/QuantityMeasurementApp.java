package com.apps.quantityMeasurement;

public class QuantityMeasurementApp {

    public static void demonstrateLengthComparison(double value, Length. LengthUnit lengthUnit, double value2, Length.LengthUnit lengthunit2) {
        if (lengthunit2 != null && lengthUnit != null){
            boolean status = (new Length(value, lengthUnit).equals(new Length(value2, lengthunit2))) ? true : false;
            System.out.println("Equality status for "+value +" "+lengthUnit+" and "+ value2+ " "+lengthunit2+" : "+ status);}
    }

        public static void main (String[]args){
            demonstrateLengthComparison(1.0, Length.LengthUnit.FEET, 12.0, Length.LengthUnit.INCHES);

            demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, 36.0, Length.LengthUnit.INCHES);

            demonstrateLengthComparison(100.0, Length.LengthUnit.CENTIMETERS, 39.3701, Length.LengthUnit.INCHES);


            demonstrateLengthComparison(3.0, Length.LengthUnit.FEET, 1.0, Length.LengthUnit.YARDS);


            demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETERS, 1.0, Length.LengthUnit.FEET);
        }
    }
