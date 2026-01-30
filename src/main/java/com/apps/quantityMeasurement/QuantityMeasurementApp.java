// QuantityMeasurementApps - UC1: Feet Measurement Equality
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
    }

    static class Inches {

        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        private void validate(double value) {
            if (Double.isNaN(value)) {
                throw new IllegalArgumentException("Inches value must be numeric");
            }
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
    }

    public static boolean checkFeetEquality(double v1, double v2) {
        Feet f1 = new Feet(v1);
        Feet f2 = new Feet(v2);
        return f1.equals((f2));
    }

    public static boolean checkInchesEquality(double v1, double v2) {
        Inches i1 = new Inches(v1);
        Inches i2 = new Inches(v2);
        return i1.equals((i2));
    }

    public static void main(String[] args) {

        System.out.println("Input: 2.5inch and 2.5 inch =(" + checkInchesEquality(2.5, 2.5) + ") ");
        System.out.println("Input: 3.5inch and 0.5 inch =(" + checkInchesEquality(3.5, 0.5) + ") ");
        System.out.println("Feet: 1.5ft and 1.5ft =(" + checkFeetEquality(1.5, 1.5) + ") ");
        System.out.println("Feet: 2.5ft and 1.5ft =(" + checkFeetEquality(2.5, 1.5) + ") ");
    }
}
