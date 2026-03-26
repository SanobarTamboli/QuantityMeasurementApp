package com.apps.quantityMeasurement.entity;

import com.apps.quantityMeasurement.IMeasureable;

public class QuantityMeasurementEntity {

    private double value;
    private IMeasureable unit;

    public QuantityMeasurementEntity(double value, IMeasureable unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public IMeasureable getUnit() {
        return unit;
    }

    public double getBaseValue() {
        return unit.convertToBaseUnit(value);
    }
}