package com.extrawest.ocpp_2_0_1.model.request;

import com.extrawest.common.model.RequestWithId;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.common.model.validation.Validator;
import com.extrawest.common.model.validation.ValidatorBuilder;
import com.extrawest.ocpp_2_0_1.model.dataTypes.CustomDataType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.enums.CertificateActionEnumType;
import com.extrawest.ocpp_2_0_1.model.validation.OCPP2PrimDatatypes;
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
        "iso15118SchemaVersion",
        "action",
        "exiRequest"
})
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Get15118EVCertificateRequest extends RequestWithId {

    private final transient Validator<Object> requiredValidator = new RequiredValidator();

    private final transient Validator iso15118SchemaVersionValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(OCPP2PrimDatatypes.string50())
                    .build();

    private final transient Validator exiRequestValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(OCPP2PrimDatatypes.string5600())
                    .build();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    public CustomDataType customData;
    /**
     * Schema version currently used for the 15118 session between EV and Charging Station. Needed for parsing of the EXI stream by the CSMS.
     *
     *
     * (Required)
     *
     */
    @JsonProperty("iso15118SchemaVersion")
    public String iso15118SchemaVersion;
    /**
     * Defines whether certificate needs to be installed or updated.
     *
     * (Required)
     *
     */
    @JsonProperty("action")
    public CertificateActionEnumType action;
    /**
     * Raw CertificateInstallationReq request from EV, Base64 encoded.
     *
     * (Required)
     *
     */
    @JsonProperty("exiRequest")
    public String exiRequest;

    public Get15118EVCertificateRequest(String iso15118SchemaVersion, CertificateActionEnumType action, String exiRequest) {
        iso15118SchemaVersionValidator.validate(iso15118SchemaVersion);
        requiredValidator.validate(action);
        exiRequestValidator.validate(exiRequest);
        this.iso15118SchemaVersion = iso15118SchemaVersion;
        this.action = action;
        this.exiRequest = exiRequest;
    }

    public void setCustomData(CustomDataType customData) {
        this.customData = customData;
    }

    public void setIso15118SchemaVersion(String iso15118SchemaVersion) {
        iso15118SchemaVersionValidator.validate(iso15118SchemaVersion);
        this.iso15118SchemaVersion = iso15118SchemaVersion;
    }

    public void setAction(CertificateActionEnumType action) {
        requiredValidator.validate(action);
        this.action = action;
    }

    public void setExiRequest(String exiRequest) {
        exiRequestValidator.validate(exiRequest);
        this.exiRequest = exiRequest;
    }

    @Override
    public boolean transactionRelated() {
        return false;
    }

    @Override
    public boolean validate() {
        return iso15118SchemaVersionValidator.safeValidate(iso15118SchemaVersion)
                &&requiredValidator.safeValidate(action)
                &&exiRequestValidator.safeValidate(exiRequest);
    }
}
