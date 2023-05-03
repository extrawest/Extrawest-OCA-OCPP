package com.extrawest.ocpp_2_0_1.model.dataTypes.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpp_2_0_1.util.EnumUtil.findByField;


/**
 * Charging Station indicates if it can process the request.
 *
 *
 */
public enum DeleteCertificateStatusEnumType {

    ACCEPTED("Accepted"),
    FAILED("Failed"),
    NOT_FOUND("NotFound");
    private final String value;

    DeleteCertificateStatusEnumType(String value) {
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
    public static DeleteCertificateStatusEnumType fromValue(String value) {
        return findByField(
                DeleteCertificateStatusEnumType.class,
                DeleteCertificateStatusEnumType::value,
                value
        );
    }
}
