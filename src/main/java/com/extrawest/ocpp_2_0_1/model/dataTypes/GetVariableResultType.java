package com.extrawest.ocpp_2_0_1.model.dataTypes;
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

import com.extrawest.common.model.Validatable;
import com.extrawest.ocpp_2_0_1.model.dataTypes.enums.AttributeEnumType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.enums.GetVariableStatusEnumType;
import com.extrawest.ocpp_2_0_1.model.validation.OCPP2PrimDatatypes;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.common.model.validation.Validator;
import com.extrawest.common.model.validation.ValidatorBuilder;
import com.extrawest.common.utilities.MoreObjects;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor
public class GetVariableResultType implements Validatable {
  private final transient Validator<Object> requiredValidator = new RequiredValidator();
  private final transient Validator attributeValueValidator =
      new ValidatorBuilder().setRequired(true).addRule(OCPP2PrimDatatypes.string1000()).build();

  private GetVariableStatusEnumType attributeStatus;
  private AttributeEnumType attributeType;
  private String attributeValue;
  private ComponentType component;
  private VariableType variable;

  public GetVariableResultType(GetVariableStatusEnumType attributeStatus, ComponentType component, VariableType variable) {
    requiredValidator.validate(attributeStatus);
    requiredValidator.validate(component);
    requiredValidator.validate(variable);
    this.attributeStatus = attributeStatus;
    this.component = component;
    this.variable = variable;
  }

  /**
   * Required. Result status of getting the variable.
   *
   * @param attributeStatus {@link GetVariableStatusEnumType}
   */
  public void setAttributeStatus(GetVariableStatusEnumType attributeStatus) {
    requiredValidator.validate(attributeStatus);

    this.attributeStatus = attributeStatus;
  }

  /**
   * Optional. Attribute type for which value is requested. When absent, default Actual is assumed.
   *
   * @param attributeType {@link AttributeEnumType}
   */
  public void setAttributeType(AttributeEnumType attributeType) {
    this.attributeType = attributeType;
  }

  /**
   * Optional. Value of requested attribute type of componentvariable. This field can only be empty
   * when the given status is NOT accepted.
   *
   * <p>The Configuration Variable ValueSize can be used to limit the
   * VariableCharacteristicsType.ValueList and all AttributeValue fields. The max size of these
   * values will always remain equal. The default max size is set to 1000.
   *
   * @param attributeValue String[0..1000]
   */
  public void setAttributeValue(String attributeValue) {
    attributeValueValidator.validate(attributeValue);

    this.attributeValue = attributeValue;
  }

  /**
   * Required. Component for which the Variable is requested.
   *
   * @param component {@link ComponentType}
   */
  public void setComponent(ComponentType component) {
    requiredValidator.validate(component);
    this.component = component;
  }

  /**
   * Required. Variable for which the attribute value is requested.
   *
   * @param variable {@link VariableType}
   */
  public void setVariable(VariableType variable) {
    requiredValidator.validate(variable);
    this.variable = variable;
  }

  @Override
  public boolean validate() {
    return requiredValidator.safeValidate(attributeStatus)
            && (attributeStatus != GetVariableStatusEnumType.ACCEPTED
            || requiredValidator.safeValidate(attributeValue))
            && requiredValidator.safeValidate(component)
            && requiredValidator.safeValidate(variable)
            && component.validate()
            && variable.validate();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GetVariableResultType that = (GetVariableResultType) o;
    return Objects.equals(attributeType, that.attributeType)
        && Objects.equals(attributeStatus, that.attributeStatus)
        && Objects.equals(attributeValue, that.attributeValue)
        && Objects.equals(component, that.component)
        && Objects.equals(variable, that.variable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeType, attributeStatus, attributeValue, component, variable);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("attributeType", attributeType)
        .add("attributeStatus", attributeStatus)
        .add("attributeValue", attributeValue)
        .add("component", component)
        .add("variable", variable)
        .toString();
  }
}
