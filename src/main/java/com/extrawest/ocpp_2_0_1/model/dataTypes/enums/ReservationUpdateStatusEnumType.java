package com.extrawest.ocpp_2_0_1.model.dataTypes.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpp_2_0_1.util.EnumUtil.findByField;


/**
 * The updated reservation status.
 *
 *
 */
public enum ReservationUpdateStatusEnumType {

    EXPIRED("Expired"),
    REMOVED("Removed");
    private final String value;

    ReservationUpdateStatusEnumType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static ReservationUpdateStatusEnumType fromValue(String value) {
        return findByField(
                ReservationUpdateStatusEnumType.class,
                ReservationUpdateStatusEnumType::value,
                value
        );
    }
}
