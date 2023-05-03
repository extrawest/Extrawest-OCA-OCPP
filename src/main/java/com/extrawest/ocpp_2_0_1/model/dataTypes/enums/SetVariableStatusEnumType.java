package com.extrawest.ocpp_2_0_1.model.dataTypes.enums;
/*
   ChargeTime.eu - Java-OCA-OCPP

   MIT License

   Copyright (C) 2018 Thomas Volden <tv@chargetime.eu>

   Permission is hereby granted, free of charge, to any person obtaining a copy
   of this software and associated documentation files (the "Software"), to deal
   in the Software without restriction, including without limitation the rights
   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
   copies of the Software, and to permit persons to whom the Software is
   furnished to do so, subject to the following conditions:

   The above copyright notice and this permission notice shall be included in all
   copies or substantial portions of the Software.

   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
   SOFTWARE.
*/

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.extrawest.ocpp_2_0_1.model.response.SetVariablesResponse;
import com.extrawest.ocpp_2_0_1.util.EnumUtil;

/**
 * SetVariableStatusEnumType is used by {@link
 * SetVariablesResponse}
 */
public enum SetVariableStatusEnumType {

  /** Variable successfully set. */
  ACCEPTED("Accepted"),

  /** Request is rejected. */
  REJECTED("Rejected"),

  /** Value has invalid format for the variable. */
  INVALID_VALUE("InvalidValue"),

  /** Component is not known. */
  UNKNOWN_COMPONENT("UnknownComponent"),

  /** Variable is not known. */
  UNKNOWN_VARIABLE("UnknownVariable"),

  /** The AttributeType is not supported. */
  NOT_SUPPORTED_ATTRIBUTE_TYPE("NotSupportedAttributeType"),

  /** Value is out of range defined in VariableCharacteristics. */
  OUT_OF_RANGE("OutOfRange"),

  /** A reboot is required. */
  REBOOT_REQUIRED("RebootRequired");

  private final String value;

  SetVariableStatusEnumType(String value) {
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
  public static SetVariableStatusEnumType fromValue(String value) {
    return EnumUtil.findByField(
            SetVariableStatusEnumType.class,
            SetVariableStatusEnumType::value,
            value
    );
  }
}
