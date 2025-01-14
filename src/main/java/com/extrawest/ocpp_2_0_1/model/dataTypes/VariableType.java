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
import com.extrawest.ocpp_2_0_1.model.validation.OCPP2PrimDatatypes;
import com.extrawest.common.model.validation.Validator;
import com.extrawest.common.model.validation.ValidatorBuilder;
import com.extrawest.common.utilities.MoreObjects;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

/** Reference key to a component-variable. */
@Getter
@NoArgsConstructor
public class VariableType implements Validatable {
  private final transient Validator nameValidator =
      new ValidatorBuilder().setRequired(true).addRule(OCPP2PrimDatatypes.string50()).build();
  private final transient Validator instanceValidator =
      new ValidatorBuilder().addRule(OCPP2PrimDatatypes.string50()).build();

  private String name;
  private String instance;

  public VariableType(String name) {
    nameValidator.validate(name);
    this.name = name;
  }

  /**
   * Required. Name of the variable. Name should be taken from the list of standardized variable
   * names whenever possible. Case Insensitive. strongly advised to use Camel Case.
   *
   * @param name string[0..50]
   */
  public void setName(String name) {
    nameValidator.validate(name);
    this.name = name;
  }

  /**
   * Optional. Name of instance in case the variable exists as multiple instances. Case Insensitive.
   * strongly advised to use Camel Case.
   *
   * @param instance string[0..50]
   */
  public void setInstance(String instance) {
    instanceValidator.validate(instance);
    this.instance = instance;
  }

  @Override
  public boolean validate() {
    return nameValidator.safeValidate(name) && instanceValidator.safeValidate(instance);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    VariableType that = (VariableType) o;
    return Objects.equals(name, that.name) && Objects.equals(instance, that.instance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, instance);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("name", name).add("instance", instance).toString();
  }
}
