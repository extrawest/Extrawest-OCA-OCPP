package com.extrawest.ocpp_2_0_1.model.response;

import com.extrawest.common.model.Confirmation;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.common.model.validation.Validator;
import com.extrawest.common.model.validation.ValidatorBuilder;
import com.extrawest.ocpp_2_0_1.model.dataTypes.CustomDataType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.StatusInfoType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.enums.Iso15118EVCertificateStatusEnumType;
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
        "status",
        "statusInfo",
        "exiResponse"
})
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Get15118EVCertificateResponse extends Confirmation {

    private final transient Validator exiResponseValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(OCPP2PrimDatatypes.string5600())
                    .build();

    private final transient Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    public CustomDataType customData;
    /**
     * Indicates whether the message was processed properly.
     *
     * (Required)
     *
     */
    @JsonProperty("status")
    public Iso15118EVCertificateStatusEnumType status;
    /**
     * Element providing more information about the status.
     *
     *
     */
    @JsonProperty("statusInfo")
    public StatusInfoType statusInfo;
    /**
     * Raw CertificateInstallationRes response for the EV, Base64 encoded.
     *
     * (Required)
     *
     */
    @JsonProperty("exiResponse")
    public String exiResponse;

    public Get15118EVCertificateResponse(Iso15118EVCertificateStatusEnumType status, String exiResponse) {
        requiredValidator.validate(status);
        exiResponseValidator.validate(exiResponse);
        this.status = status;
        this.exiResponse = exiResponse;
    }

    public void setCustomData(CustomDataType customData) {
        this.customData = customData;
    }

    public void setStatus(Iso15118EVCertificateStatusEnumType status) {
        requiredValidator.validate(status);
        this.status = status;
    }

    public void setStatusInfo(StatusInfoType statusInfo) {
        this.statusInfo = statusInfo;
    }

    public void setExiResponse(String exiResponse) {
        exiResponseValidator.validate(exiResponse);
        this.exiResponse = exiResponse;
    }

    @Override
    public boolean validate() {
        return exiResponseValidator.safeValidate(exiResponse)
                && requiredValidator.safeValidate(status);
    }
}
