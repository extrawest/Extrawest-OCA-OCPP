package eu.chargetime.ocpp.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import eu.chargetime.ocpp.model.RequestWithId;
import eu.chargetime.ocpp.model.dataTypes.CustomData;
import eu.chargetime.ocpp.model.dataTypes.IdTokenType;
import eu.chargetime.ocpp.model.dataTypes.OCSPRequestData;
import eu.chargetime.ocpp.model.validation.OCPP2PrimDatatypes;
import eu.chargetime.ocpp.model.validation.RequiredValidator;
import eu.chargetime.ocpp.model.validation.Validator;
import eu.chargetime.ocpp.model.validation.ValidatorBuilder;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customData",
        "idToken",
        "certificate",
        "iso15118CertificateHashData"
})
@Getter
public class AuthorizeRequest extends RequestWithId {

    private transient Validator certificateValidator =
            new ValidatorBuilder().addRule(OCPP2PrimDatatypes.string5500()).build();

    private transient RequiredValidator validator = new RequiredValidator();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    public CustomData customData;
    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     *
     * (Required)
     *
     */
    @JsonProperty("idToken")
    public IdTokenType idTokenType;
    /**
     * The X.509 certificated presented by EV and encoded in PEM format.
     *
     *
     */
    @JsonProperty("certificate")
    public String certificate;

    @JsonProperty("iso15118CertificateHashData")
    public List<OCSPRequestData> iso15118CertificateHashData;

    @Override
    public boolean transactionRelated() {
        return false;
    }

    public void setCustomData(CustomData customData) {
        this.customData = customData;
    }

    public void setIdTokenType(IdTokenType idTokenType) {
        this.idTokenType = idTokenType;
    }

    public void setCertificate(String certificate) {
        certificateValidator.validate(certificate);
        this.certificate = certificate;
    }

    public void setIso15118CertificateHashData(List<OCSPRequestData> iso15118CertificateHashData) {
        this.iso15118CertificateHashData = iso15118CertificateHashData;
    }

    @Override
    public boolean validate() {
        return validator.safeValidate(idTokenType);
    }
}