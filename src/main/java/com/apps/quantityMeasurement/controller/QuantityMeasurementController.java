package com.apps.quantityMeasurement.controller;

import com.apps.quantityMeasurement.entity.QuantityMeasurementEntity;
import com.apps.quantityMeasurement.service.IQuantityMeasurementService;

public class QuantityMeasurementController {
    private IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public boolean compare(QuantityMeasurementEntity q1, QuantityMeasurementEntity q2) {
        return service.compare(q1, q2);
    }

    public double convert(QuantityMeasurementEntity quantity) {
        return service.convert(quantity);
    }

    public QuantityMeasurementEntity add(QuantityMeasurementEntity q1, QuantityMeasurementEntity q2) {
        return service.add(q1, q2);
    }

    public QuantityMeasurementEntity subtract(QuantityMeasurementEntity q1, QuantityMeasurementEntity q2) {
        return service.subtract(q1, q2);
    }
}