package eu.chargetime.ocpp.model.confirmation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import eu.chargetime.ocpp.model.Confirmation;
import eu.chargetime.ocpp.model.dataTypes.CustomDataType;
import eu.chargetime.ocpp.model.dataTypes.IdTokenInfoType;
import eu.chargetime.ocpp.model.dataTypes.enums.AuthorizeCertificateStatusEnumType;
import eu.chargetime.ocpp.model.validation.RequiredValidator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
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
public class AuthorizeConfirmation extends Confirmation {

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

    public AuthorizeConfirmation(IdTokenInfoType idTokenInfo) {
        requiredValidator.validate(idTokenInfo);
        this.idTokenInfo = idTokenInfo;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(idTokenInfo);
    }
}
