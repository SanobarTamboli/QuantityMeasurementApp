package com.apps.quantityMeasurement;

public class QuantityMeasurementApp {
    public static class Feet {
        private final double value;

        public Feet (double value) {

            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() !=obj.getClass()){
                return false;
            }
            Feet other = (Feet) obj;
            return Double.compare(other.value, this.value) ==0;
        }

        @Override
        public int hashCode() {
            return Double.valueOf(value).hashCode();
        }

        @Override
        public String toString() {
            return value+ "feet";
        }
    }

    public static void  main (String [] args){
        Feet f1 = new Feet(1.5);
        Feet f2 = new Feet(1.5);
        Feet f3 = new Feet(0.5);

        System.out.println("Are feet1 and feet2 equal? " + f1.equals(f2));
        System.out.println("Are feet1 and feet2 equal? " + f1.equals(f3));
        System.out.println("Are feet1 and null equal? " + f1.equals(null));
    }
}