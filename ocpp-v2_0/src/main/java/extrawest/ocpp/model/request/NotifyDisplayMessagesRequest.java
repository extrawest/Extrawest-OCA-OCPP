package extrawest.ocpp.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.extrawest.common.model.RequestWithId;
import com.extrawest.ocpp_2_0_1.model.dataTypes.CustomDataType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.MessageInfoType;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.common.model.validation.Validator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customData",
        "messageInfo",
        "requestId",
        "tbc"
})
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class NotifyDisplayMessagesRequest extends RequestWithId {

    private final transient Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    public CustomDataType customData;
    @JsonProperty("messageInfo")
    public List<MessageInfoType> messageInfo;
    /**
     * The id of the GetDisplayMessagesRequest that requested this message.
     *
     * (Required)
     *
     */
    @JsonProperty("requestId")
    public Integer requestId;
    /**
     * "to be continued" indicator. Indicates whether another part of the report follows in an upcoming NotifyDisplayMessagesRequest message. Default value when omitted is false.
     *
     *
     */
    @JsonProperty("tbc")
    public Boolean tbc = false;

    public NotifyDisplayMessagesRequest(Integer requestId) {
        requiredValidator.validate(requestId);
        this.requestId = requestId;
    }

    public void setCustomData(CustomDataType customData) {
        this.customData = customData;
    }

    public void setMessageInfo(List<MessageInfoType> messageInfo) {
        this.messageInfo = messageInfo;
    }

    public void setRequestId(Integer requestId) {
        requiredValidator.validate(requestId);
        this.requestId = requestId;
    }

    public void setTbc(Boolean tbc) {
        this.tbc = tbc;
    }

    @Override
    public boolean transactionRelated() {
        return false;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(requestId);
    }
}
