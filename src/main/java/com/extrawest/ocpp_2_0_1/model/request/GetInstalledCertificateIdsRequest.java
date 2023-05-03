package com.extrawest.ocpp_2_0_1.model.request;

import com.extrawest.common.model.RequestWithId;
import com.extrawest.ocpp_2_0_1.model.dataTypes.CustomDataType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.enums.GetCertificateIdUseEnumType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customData",
        "certificateType"
})
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class GetInstalledCertificateIdsRequest extends RequestWithId {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    public CustomDataType customData;
    /**
     * Indicates the type of certificates requested. When omitted, all certificate types are requested.
     *
     *
     */
    @JsonProperty("certificateType")
    public List<GetCertificateIdUseEnumType> certificateType;

    @Override
    public boolean transactionRelated() {
        return false;
    }

    @Override
    public boolean validate() {
        return true;
    }
}
