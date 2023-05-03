package com.extrawest.ocpp_2_0_1.model.dataTypes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.extrawest.common.model.Validatable;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.common.model.validation.Validator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * Contains the identifier to use for authorization.
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customData",
        "idToken",
        "idTokenInfo"
})
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class AuthorizationDataType implements Validatable {

    private final transient Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    public CustomDataType customData;
    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     *
     * (Required)
     *
     */
    @JsonProperty("idToken")
    public IdTokenType idToken;
    /**
     * ID_ Token
     * urn:x-oca:ocpp:uid:2:233247
     * Contains status information about an identifier.
     * It is advised to not stop charging for a token that expires during charging, as ExpiryDate is only used for caching purposes. If ExpiryDate is not given, the status has no end date.
     *
     *
     */
    @JsonProperty("idTokenInfo")
    public IdTokenInfoType idTokenInfo;

    public AuthorizationDataType(IdTokenType idToken) {
        requiredValidator.validate(idToken);
        this.idToken = idToken;
    }

    public void setCustomData(CustomDataType customData) {
        this.customData = customData;
    }

    public void setIdToken(IdTokenType idToken) {
        requiredValidator.validate(idToken);
        this.idToken = idToken;
    }

    public void setIdTokenInfo(IdTokenInfoType idTokenInfo) {
        this.idTokenInfo = idTokenInfo;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(idToken);
    }
}
