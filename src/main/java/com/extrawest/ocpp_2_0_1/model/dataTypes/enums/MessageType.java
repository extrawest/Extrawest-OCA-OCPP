package com.extrawest.ocpp_2_0_1.model.dataTypes.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum MessageType {

    CALL(2),
    CALL_RESULT(3),
    CALL_ERROR(4);

    private final int messageTypeId;

    MessageType(int messageTypeId) {
        this.messageTypeId = messageTypeId;
    }

    @JsonValue
    public int getMessageTypeId() {
        return messageTypeId;
    }

    public static MessageType fromMessageTypeId(int messageTypeId) {
        return Arrays.stream(MessageType.values())
            .filter(messageType -> messageType.getMessageTypeId() == messageTypeId)
            .findFirst()
            .orElseThrow(
                () -> new IllegalArgumentException(String.format("MessageType (id = %d) was not found", messageTypeId))
            );
    }
}
