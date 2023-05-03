package com.extrawest.ocpp_2_0_1.model.request;

import com.extrawest.common.model.RequestWithId;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.common.model.validation.Validator;
import com.extrawest.ocpp_2_0_1.model.dataTypes.CustomDataType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.MonitoringDataType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customData",
        "monitor",
        "requestId",
        "tbc",
        "seqNo",
        "generatedAt"
})
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class NotifyMonitoringReportRequest extends RequestWithId {

    private final transient Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    public CustomDataType customData;

    @JsonProperty("monitor")
    public List<MonitoringDataType> monitor;
    /**
     * The id of the GetMonitoringRequest that requested this report.
     *
     *
     * (Required)
     *
     */
    @JsonProperty("requestId")
    public Integer requestId;
    /**
     * “to be continued” indicator. Indicates whether another part of the monitoringData follows in an upcoming notifyMonitoringReportRequest message. Default value when omitted is false.
     *
     *
     */
    @JsonProperty("tbc")
    public Boolean tbc = false;
    /**
     * Sequence number of this message. First message starts at 0.
     *
     * (Required)
     *
     */
    @JsonProperty("seqNo")
    public Integer seqNo;
    /**
     * Timestamp of the moment this message was generated at the Charging Station.
     *
     * (Required)
     *
     */
    @JsonProperty("generatedAt")
    public LocalDateTime generatedAt;

    public NotifyMonitoringReportRequest(Integer requestId, Integer seqNo, LocalDateTime generatedAt) {
        requiredValidator.validate(requestId);
        requiredValidator.validate(seqNo);
        requiredValidator.validate(generatedAt);
        this.requestId = requestId;
        this.seqNo = seqNo;
        this.generatedAt = generatedAt;
    }

    public void setCustomData(CustomDataType customData) {
        this.customData = customData;
    }

    public void setMonitor(List<MonitoringDataType> monitor) {
        this.monitor = monitor;
    }

    public void setRequestId(Integer requestId) {
        requiredValidator.validate(requestId);
        this.requestId = requestId;
    }

    public void setTbc(Boolean tbc) {
        this.tbc = tbc;
    }

    public void setSeqNo(Integer seqNo) {
        requiredValidator.validate(seqNo);
        this.seqNo = seqNo;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        requiredValidator.validate(generatedAt);
        this.generatedAt = generatedAt;
    }

    @Override
    public boolean transactionRelated() {
        return false;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(requestId)
                &&requiredValidator.safeValidate(seqNo)
                &&requiredValidator.safeValidate(generatedAt);
    }
}
