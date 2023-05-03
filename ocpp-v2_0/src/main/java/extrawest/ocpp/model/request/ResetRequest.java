package extrawest.ocpp.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.extrawest.common.model.RequestWithId;
import com.extrawest.ocpp_2_0_1.model.dataTypes.CustomDataType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.enums.ResetEnumType;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.common.model.validation.Validator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customData",
        "type",
        "evseId"
})
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ResetRequest extends RequestWithId {

    private final transient Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    public CustomDataType customData;
    /**
     * This contains the type of reset that the Charging Station or EVSE should perform.
     *
     * (Required)
     *
     */
    @JsonProperty("type")
    public ResetEnumType type;
    /**
     * This contains the ID of a specific EVSE that needs to be reset, instead of the entire Charging Station.
     *
     *
     */
    @JsonProperty("evseId")
    public Integer evseId;

    public ResetRequest(ResetEnumType type) {
        requiredValidator.validate(type);
        this.type = type;
    }

    public void setCustomData(CustomDataType customData) {
        this.customData = customData;
    }

    public void setType(ResetEnumType type) {
        requiredValidator.validate(type);
        this.type = type;
    }

    public void setEvseId(Integer evseId) {
        this.evseId = evseId;
    }

    @Override
    public boolean transactionRelated() {
        return false;
    }

    @Override
    public boolean validate() {
        return true;
    }
}
