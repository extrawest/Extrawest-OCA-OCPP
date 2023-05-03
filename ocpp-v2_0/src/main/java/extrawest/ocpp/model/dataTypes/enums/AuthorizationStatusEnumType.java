package extrawest.ocpp.model.dataTypes.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpp_2_0_1.util.EnumUtil.findByField;

/**
 * ID_ Token. Status. Authorization_ Status
 * urn:x-oca:ocpp:uid:1:569372
 * Current status of the ID Token.
 *
 *
 */
public enum AuthorizationStatusEnumType {

    ACCEPTED("Accepted"),
    BLOCKED("Blocked"),
    CONCURRENT_TX("ConcurrentTx"),
    EXPIRED("Expired"),
    INVALID("Invalid"),
    NO_CREDIT("NoCredit"),
    NOT_ALLOWED_TYPE_EVSE("NotAllowedTypeEVSE"),
    NOT_AT_THIS_LOCATION("NotAtThisLocation"),
    NOT_AT_THIS_TIME("NotAtThisTime"),
    UNKNOWN("Unknown");
    private final String value;

    AuthorizationStatusEnumType(String value) {
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
    public static AuthorizationStatusEnumType fromValue(String value) {
        return findByField(
                AuthorizationStatusEnumType.class,
                AuthorizationStatusEnumType::value,
                value
        );
    }

}
