package extrawest.ocpp.model.dataTypes.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpp_2_0_1.util.EnumUtil.findByField;

public enum MonitoringCriterionEnumType {

    THRESHOLD_MONITORING("ThresholdMonitoring"),
    DELTA_MONITORING("DeltaMonitoring"),
    PERIODIC_MONITORING("PeriodicMonitoring");
    private final String value;

    MonitoringCriterionEnumType(String value) {
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
    public static MonitoringCriterionEnumType fromValue(String value) {
        return findByField(
                MonitoringCriterionEnumType.class,
                MonitoringCriterionEnumType::value,
                value
        );
    }
}
