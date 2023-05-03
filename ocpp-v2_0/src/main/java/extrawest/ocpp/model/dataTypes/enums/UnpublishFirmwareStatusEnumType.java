package extrawest.ocpp.model.dataTypes.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpp_2_0_1.util.EnumUtil.findByField;


/**
 * Indicates whether the Local Controller succeeded in unpublishing the firmware.
 *
 *
 */
public enum UnpublishFirmwareStatusEnumType {

    DOWNLOAD_ONGOING("DownloadOngoing"),
    NO_FIRMWARE("NoFirmware"),
    UNPUBLISHED("Unpublished");
    private final String value;

    UnpublishFirmwareStatusEnumType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static UnpublishFirmwareStatusEnumType fromValue(String value) {
        return findByField(
                UnpublishFirmwareStatusEnumType.class,
                UnpublishFirmwareStatusEnumType::value,
                value
        );
    }
}
