// QuantityMeasurementApps - UC2: Feet Measurement Equality
package com.apps.quantityMeasurement;

public class QuantityMeasurementApp {

    public static class Feet {

        private final double value;

        public Feet(double value) {

            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Feet other = (Feet) obj;
            return Double.compare(other.value, this.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.valueOf(value).hashCode();
        }

        @Override
        public String toString() {
            return value + "feet";
        }

        public double toInches(){
            return value*12 ;
        }
    }

    public static class Inches {

        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }
        public double toInches(){
            return value ;
        }

        public static boolean compareFeetToInches(double feetValue, double inchesValue){
            Feet feet= new Feet(feetValue);
            Inches inches = new Inches(inchesValue);
            return Double.compare(feet.toInches(), inches.toInches())==0;
        }

    }

    public static void demonstrateFeetEquality() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        System.out.println(f1.equals((f2)));
    }


    public static void demonstrateInchesEquality() {
        Inches i1 = new Inches(1.0);
        Inches i2 = new Inches(1.0);
        System.out.println(i1.equals((i2)));
        System.out.println(Inches.compareFeetToInches(2.0,24.0)+"noww");
    }

    public static void main(String[] args) {
        QuantityMeasurementApp.demonstrateFeetEquality();
        QuantityMeasurementApp.demonstrateInchesEquality();
    }
}
