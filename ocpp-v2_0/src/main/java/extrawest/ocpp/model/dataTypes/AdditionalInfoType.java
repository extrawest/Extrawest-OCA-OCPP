package extrawest.ocpp.model.dataTypes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.extrawest.common.model.Validatable;
import com.extrawest.ocpp_2_0_1.model.validation.OCPP2PrimDatatypes;
import com.extrawest.common.model.validation.Validator;
import com.extrawest.common.model.validation.ValidatorBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customData",
        "additionalIdToken",
        "type"
})
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class AdditionalInfoType implements Validatable {

    private final transient Validator additionalIdTokenValidator =
            new ValidatorBuilder().setRequired(true).addRule(OCPP2PrimDatatypes.string36()).build();

    private final transient Validator typeValidator =
            new ValidatorBuilder().setRequired(true).addRule(OCPP2PrimDatatypes.string50()).build();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    public CustomDataType customData;
    /**
     * This field specifies the additional IdToken.
     *
     * (Required)
     *
     */
    @JsonProperty("additionalIdToken")
    public String additionalIdToken;
    /**
     * This defines the type of the additionalIdToken. This is a custom type, so the implementation needs to be agreed upon by all involved parties.
     *
     * (Required)
     *
     */
    @JsonProperty("type")
    public String type;

    public AdditionalInfoType(String additionalIdToken, String type) {
        additionalIdTokenValidator.validate(additionalIdToken);
        typeValidator.validate(type);
        this.additionalIdToken = additionalIdToken;
        this.type = type;
    }

    public void setCustomData(CustomDataType customData) {
        this.customData = customData;
    }

    public void setAdditionalIdToken(String additionalIdToken) {
        additionalIdTokenValidator.validate(additionalIdToken);
        this.additionalIdToken = additionalIdToken;
    }

    public void setType(String type) {
        typeValidator.validate(type);
        this.type = type;
    }

    @Override
    public boolean validate() {
        return additionalIdTokenValidator.safeValidate(additionalIdToken)
                &&typeValidator.safeValidate(type);
    }
}
