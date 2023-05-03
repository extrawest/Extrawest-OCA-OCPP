package com.extrawest.ocpp_2_0_1.model.request;

import com.extrawest.common.model.RequestWithId;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.common.model.validation.Validator;
import com.extrawest.ocpp_2_0_1.model.dataTypes.ChargingNeedsType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.CustomDataType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customData",
        "maxScheduleTuples",
        "chargingNeeds",
        "evseId"
})
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class NotifyEVChargingNeedsRequest extends RequestWithId {

    private final transient Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    public CustomDataType customData;
    /**
     * Contains the maximum schedule tuples the car supports per schedule.
     *
     *
     */
    @JsonProperty("maxScheduleTuples")
    public Integer maxScheduleTuples;
    /**
     * Charging_ Needs
     * urn:x-oca:ocpp:uid:2:233249
     *
     * (Required)
     *
     */
    @JsonProperty("chargingNeeds")
    public ChargingNeedsType chargingNeeds;
    /**
     * Defines the EVSE and connector to which the EV is connected. EvseId may not be 0.
     *
     * (Required)
     *
     */
    @JsonProperty("evseId")
    public Integer evseId;

    public NotifyEVChargingNeedsRequest(ChargingNeedsType chargingNeeds, Integer evseId) {
        requiredValidator.validate(chargingNeeds);
        requiredValidator.validate(evseId);
        this.chargingNeeds = chargingNeeds;
        this.evseId = evseId;
    }

    public void setCustomData(CustomDataType customData) {
        this.customData = customData;
    }

    public void setMaxScheduleTuples(Integer maxScheduleTuples) {
        this.maxScheduleTuples = maxScheduleTuples;
    }

    public void setChargingNeeds(ChargingNeedsType chargingNeeds) {
        requiredValidator.validate(chargingNeeds);
        this.chargingNeeds = chargingNeeds;
    }

    public void setEvseId(Integer evseId) {
        requiredValidator.validate(evseId);
        this.evseId = evseId;
    }

    @Override
    public boolean transactionRelated() {
        return false;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(chargingNeeds)
                &&requiredValidator.safeValidate(evseId);
    }
}
