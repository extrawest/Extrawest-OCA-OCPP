package extrawest.ocpp.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.extrawest.common.model.RequestWithId;
import com.extrawest.ocpp_2_0_1.model.dataTypes.CustomDataType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.EventDataType;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.common.model.validation.Validator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customData",
        "generatedAt",
        "tbc",
        "seqNo",
        "eventData"
})
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class NotifyEventRequest extends RequestWithId {

    private final transient Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    public CustomDataType customData;
    /**
     * Timestamp of the moment this message was generated at the Charging Station.
     *
     * (Required)
     *
     */
    @JsonProperty("generatedAt")
    public LocalDateTime generatedAt;
    /**
     * “to be continued” indicator. Indicates whether another part of the report follows in an upcoming notifyEventRequest message. Default value when omitted is false.
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
     *
     * (Required)
     *
     */
    @JsonProperty("eventData")
    public List<EventDataType> eventData;

    public NotifyEventRequest(LocalDateTime generatedAt, Integer seqNo, List<EventDataType> eventData) {
        requiredValidator.validate(generatedAt);
        requiredValidator.validate(seqNo);
        requiredValidator.validate(eventData);
        this.generatedAt = generatedAt;
        this.seqNo = seqNo;
        this.eventData = eventData;
    }

    public void setCustomData(CustomDataType customData) {
        this.customData = customData;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        requiredValidator.validate(generatedAt);
        this.generatedAt = generatedAt;
    }

    public void setTbc(Boolean tbc) {
        this.tbc = tbc;
    }

    public void setSeqNo(Integer seqNo) {
        requiredValidator.validate(seqNo);
        this.seqNo = seqNo;
    }

    public void setEventData(List<EventDataType> eventData) {
        requiredValidator.validate(eventData);
        this.eventData = eventData;
    }

    @Override
    public boolean transactionRelated() {
        return false;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(generatedAt)
                &&requiredValidator.safeValidate(seqNo)
                &&requiredValidator.safeValidate(eventData)
                &&eventData.stream().filter(EventDataType::validate).count() == eventData.size();
    }
}
