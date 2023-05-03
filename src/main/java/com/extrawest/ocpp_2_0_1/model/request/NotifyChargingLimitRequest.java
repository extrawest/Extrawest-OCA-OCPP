package com.extrawest.ocpp_2_0_1.model.request;

import com.extrawest.common.model.RequestWithId;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.common.model.validation.Validator;
import com.extrawest.ocpp_2_0_1.model.dataTypes.ChargingLimitType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.ChargingScheduleType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.CustomDataType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customData",
        "chargingSchedule",
        "evseId",
        "chargingLimit"
})
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class NotifyChargingLimitRequest extends RequestWithId {

    private final transient Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    public CustomDataType customData;
    @JsonProperty("chargingSchedule")
    public List<ChargingScheduleType> chargingSchedule;
    /**
     * The charging schedule contained in this notification applies to an EVSE. evseId must be &gt; 0.
     *
     *
     */
    @JsonProperty("evseId")
    public Integer evseId;
    /**
     * Charging_ Limit
     * urn:x-enexis:ecdm:uid:2:234489
     *
     * (Required)
     *
     */
    @JsonProperty("chargingLimit")
    public ChargingLimitType chargingLimit;

    public NotifyChargingLimitRequest(ChargingLimitType chargingLimit) {
        requiredValidator.validate(chargingLimit);
        this.chargingLimit = chargingLimit;
    }

    public void setCustomData(CustomDataType customData) {
        this.customData = customData;
    }

    public void setChargingSchedule(List<ChargingScheduleType> chargingSchedule) {
        this.chargingSchedule = chargingSchedule;
    }

    public void setEvseId(Integer evseId) {
        this.evseId = evseId;
    }

    public void setChargingLimit(ChargingLimitType chargingLimit) {
        requiredValidator.validate(chargingLimit);
        this.chargingLimit = chargingLimit;
    }

    @Override
    public boolean transactionRelated() {
        return false;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(chargingLimit);
    }
}
