package com.apps.quantityMeasurement;

public interface IMeasureable {

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    default SupportsArithmetic supportsArithmetic(){
        return() ->true;
    };

}
