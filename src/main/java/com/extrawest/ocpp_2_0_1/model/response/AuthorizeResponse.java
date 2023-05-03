package com.extrawest.ocpp_2_0_1.model.response;

import com.extrawest.common.model.Confirmation;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.ocpp_2_0_1.model.dataTypes.CustomDataType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.IdTokenInfoType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.enums.AuthorizeCertificateStatusEnumType;
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
        "idTokenInfo",
        "certificateStatus"
})
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class AuthorizeResponse extends Confirmation {

    private transient RequiredValidator requiredValidator = new RequiredValidator();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    public CustomDataType customData;
    /**
     * ID_ Token
     * urn:x-oca:ocpp:uid:2:233247
     * Contains status information about an identifier.
     * It is advised to not stop charging for a token that expires during charging, as ExpiryDate is only used for caching purposes. If ExpiryDate is not given, the status has no end date.
     *
     * (Required)
     *
     */
    @JsonProperty("idTokenInfo")
    public IdTokenInfoType idTokenInfo;
    /**
     * Certificate status information.
     * - if all certificates are valid: return 'Accepted'.
     * - if one of the certificates was revoked, return 'CertificateRevoked'.
     *
     *
     */
    @JsonProperty("certificateStatus")
    public AuthorizeCertificateStatusEnumType certificateStatus;

    public AuthorizeResponse(IdTokenInfoType idTokenInfo) {
        requiredValidator.validate(idTokenInfo);
        this.idTokenInfo = idTokenInfo;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(idTokenInfo);
    }
}
