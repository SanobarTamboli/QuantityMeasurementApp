package com.apps.quantityMeasurement.service;

import com.apps.quantityMeasurement.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementService {

    boolean compare(QuantityMeasurementEntity q1, QuantityMeasurementEntity q2);

    double convert(QuantityMeasurementEntity quantity);

    QuantityMeasurementEntity add(QuantityMeasurementEntity q1, QuantityMeasurementEntity q2);

    QuantityMeasurementEntity subtract(QuantityMeasurementEntity q1, QuantityMeasurementEntity q2);
}