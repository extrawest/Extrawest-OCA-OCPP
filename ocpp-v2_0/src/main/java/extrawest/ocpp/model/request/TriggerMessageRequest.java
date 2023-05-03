package extrawest.ocpp.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.extrawest.common.model.RequestWithId;
import com.extrawest.ocpp_2_0_1.model.dataTypes.CustomDataType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.EVSEType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.enums.MessageTriggerEnumType;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.common.model.validation.Validator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customData",
        "evse",
        "requestedMessage"
})
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class TriggerMessageRequest extends RequestWithId {

    private final transient Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    public CustomDataType customData;
    /**
     * EVSE
     * urn:x-oca:ocpp:uid:2:233123
     * Electric Vehicle Supply Equipment
     *
     *
     */
    @JsonProperty("evse")
    public EVSEType evse;
    /**
     * Type of message to be triggered.
     *
     * (Required)
     *
     */
    @JsonProperty("requestedMessage")
    public MessageTriggerEnumType requestedMessage;

    public TriggerMessageRequest(MessageTriggerEnumType requestedMessage) {
        requiredValidator.validate(requestedMessage);
        this.requestedMessage = requestedMessage;
    }

    public void setCustomData(CustomDataType customData) {
        this.customData = customData;
    }

    public void setEvse(EVSEType evse) {
        this.evse = evse;
    }

    public void setRequestedMessage(MessageTriggerEnumType requestedMessage) {
        requiredValidator.validate(requestedMessage);
        this.requestedMessage = requestedMessage;
    }

    @Override
    public boolean transactionRelated() {
        return false;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(requestedMessage);
    }
}
