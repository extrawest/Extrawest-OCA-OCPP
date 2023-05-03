package com.extrawest.ocpp_2_0_1.model.request;

import com.extrawest.common.model.RequestWithId;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.common.model.validation.Validator;
import com.extrawest.common.model.validation.ValidatorBuilder;
import com.extrawest.ocpp_2_0_1.model.dataTypes.CustomDataType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.IdTokenType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.OCSPRequestDataType;
import com.extrawest.ocpp_2_0_1.model.validation.OCPP2PrimDatatypes;
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
        "idToken",
        "certificate",
        "iso15118CertificateHashData"
})
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class AuthorizeRequest extends RequestWithId {

    private transient final Validator certificateValidator =
            new ValidatorBuilder().addRule(OCPP2PrimDatatypes.string5500()).build();

    private transient RequiredValidator requiredValidator = new RequiredValidator();

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
     * The X.509 certificated presented by EV and encoded in PEM format.
     *
     *
     */
    @JsonProperty("certificate")
    public String certificate;

    @JsonProperty("iso15118CertificateHashData")
    public List<OCSPRequestDataType> iso15118CertificateHashData;

    @Override
    public boolean transactionRelated() {
        return false;
    }

    public AuthorizeRequest(IdTokenType idTokenType) {
        this.idToken = idTokenType;
    }

    public void setCustomData(CustomDataType customData) {
        this.customData = customData;
    }

    public void setIdToken(IdTokenType idToken) {
        this.idToken = idToken;
    }

    public void setCertificate(String certificate) {
        certificateValidator.validate(certificate);
        this.certificate = certificate;
    }

    public void setIso15118CertificateHashData(List<OCSPRequestDataType> iso15118CertificateHashData) {
        this.iso15118CertificateHashData = iso15118CertificateHashData;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(idToken);
    }
}
