package extrawest.ocpp.model.dataTypes.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpp_2_0_1.util.EnumUtil.findByField;


/**
 * Result of the clear request for this monitor, identified by its Id.
 *
 *
 *
 */
public enum ClearMonitoringStatusEnumType {

    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    NOT_FOUND("NotFound");
    private final String value;

    ClearMonitoringStatusEnumType(String value) {
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
    public static ClearMonitoringStatusEnumType fromValue(String value) {
        return findByField(
                ClearMonitoringStatusEnumType.class,
                ClearMonitoringStatusEnumType::value,
                value
        );
    }
}
