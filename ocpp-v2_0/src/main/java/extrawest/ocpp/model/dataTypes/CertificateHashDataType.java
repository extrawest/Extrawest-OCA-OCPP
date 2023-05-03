package extrawest.ocpp.model.dataTypes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.extrawest.common.model.Validatable;
import com.extrawest.ocpp_2_0_1.model.dataTypes.enums.HashAlgorithmEnumType;
import com.extrawest.ocpp_2_0_1.model.validation.OCPP2PrimDatatypes;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.common.model.validation.Validator;
import com.extrawest.common.model.validation.ValidatorBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customData",
        "hashAlgorithm",
        "issuerNameHash",
        "issuerKeyHash",
        "serialNumber"
})
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class CertificateHashDataType implements Validatable {

    private final transient Validator identifierString128Validator =
            new ValidatorBuilder()
                    .addRule(OCPP2PrimDatatypes.identifierString())
                    .addRule(OCPP2PrimDatatypes.string128())
                    .setRequired(true)
                    .build();

    private final transient Validator identifierString40Validator =
            new ValidatorBuilder()
                    .addRule(OCPP2PrimDatatypes.identifierString())
                    .addRule(OCPP2PrimDatatypes.string40())
                    .setRequired(true)
                    .build();

    private final transient Validator string128Validator =
            new ValidatorBuilder().addRule(OCPP2PrimDatatypes.string128())
                    .setRequired(true)
                    .build();

    private final transient Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    public CustomDataType customData;
    /**
     * Used algorithms for the hashes provided.
     *
     * (Required)
     *
     */
    @JsonProperty("hashAlgorithm")
    public HashAlgorithmEnumType hashAlgorithm;
    /**
     * Hashed value of the Issuer DN (Distinguished Name).
     *
     *
     * (Required)
     *
     */
    @JsonProperty("issuerNameHash")
    public String issuerNameHash;
    /**
     * Hashed value of the issuers public key
     *
     * (Required)
     *
     */
    @JsonProperty("issuerKeyHash")
    public String issuerKeyHash;
    /**
     * The serial number of the certificate.
     *
     * (Required)
     *
     */
    @JsonProperty("serialNumber")
    public String serialNumber;

    public CertificateHashDataType(HashAlgorithmEnumType hashAlgorithm, String issuerNameHash, String issuerKeyHash, String serialNumber) {
        string128Validator.validate(issuerKeyHash);
        identifierString40Validator.validate(serialNumber);
        identifierString128Validator.validate(issuerNameHash);
        requiredValidator.validate(hashAlgorithm);
        this.hashAlgorithm = hashAlgorithm;
        this.issuerNameHash = issuerNameHash;
        this.issuerKeyHash = issuerKeyHash;
        this.serialNumber = serialNumber;
    }

    public void setCustomData(CustomDataType customData) {
        this.customData = customData;
    }

    public void setHashAlgorithm(HashAlgorithmEnumType hashAlgorithm) {
        requiredValidator.validate(hashAlgorithm);
        this.hashAlgorithm = hashAlgorithm;
    }

    public void setIssuerNameHash(String issuerNameHash) {
        identifierString128Validator.validate(issuerNameHash);
        this.issuerNameHash = issuerNameHash;
    }

    public void setIssuerKeyHash(String issuerKeyHash) {
        string128Validator.validate(issuerKeyHash);
        this.issuerKeyHash = issuerKeyHash;
    }

    public void setSerialNumber(String serialNumber) {
        identifierString40Validator.validate(serialNumber);
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean validate() {
        return string128Validator.safeValidate(issuerKeyHash)
        &&identifierString40Validator.safeValidate(serialNumber)
        &&identifierString128Validator.safeValidate(issuerNameHash)
        &&requiredValidator.safeValidate(hashAlgorithm);
    }
}
