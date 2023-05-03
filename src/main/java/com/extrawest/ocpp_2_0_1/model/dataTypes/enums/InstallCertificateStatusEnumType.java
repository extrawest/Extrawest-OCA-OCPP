package com.extrawest.ocpp_2_0_1.model.dataTypes.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpp_2_0_1.util.EnumUtil.findByField;


/**
 * Charging Station indicates if installation was successful.
 *
 *
 */
public enum InstallCertificateStatusEnumType {

    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    FAILED("Failed");
    private final String value;

    InstallCertificateStatusEnumType(String value) {
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
    public static InstallCertificateStatusEnumType fromValue(String value) {
        return findByField(
                InstallCertificateStatusEnumType.class,
                InstallCertificateStatusEnumType::value,
                value
        );
    }
}
