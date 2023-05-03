package com.extrawest.ocpp_2_0_1.model.response;
/*
   ChargeTime.eu - Java-OCA-OCPP

   MIT License

   Copyright (C) 2018 Thomas Volden <tv@chargetime.eu>
   Copyright (C) 2022 Emil Melar <emil@iconsultable.no>

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

import com.extrawest.common.model.Confirmation;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.common.model.validation.Validator;
import com.extrawest.common.utilities.MoreObjects;
import com.extrawest.ocpp_2_0_1.model.dataTypes.SetVariableResultType;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

/**
 * This contains the field definition of the SetVariablesResponse PDU sent by the Charging Station
 * to the CSMS in response to a SetVariablesRequest.
 */
@NoArgsConstructor
public class SetVariablesResponse extends Confirmation {
  private final transient Validator<Object> requiredValidator = new RequiredValidator();

  private SetVariableResultType[] setVariableResult;

  public SetVariablesResponse(SetVariableResultType[] setVariableResult) {
    requiredValidator.validate(setVariableResult);
    this.setVariableResult = setVariableResult;
  }

  /**
   * List of result statuses per Component-Variable.
   *
   * @return SetVariableResultType[]
   */
  public SetVariableResultType[] getSetVariableResult() {
    return setVariableResult;
  }

  /**
   * Required. List of result statuses per Component-Variable.
   *
   * @param setVariableResult SetVariableResultType[]
   */
  public void setSetVariableResult(SetVariableResultType[] setVariableResult) {
    requiredValidator.validate(setVariableResult);
    this.setVariableResult = setVariableResult;
  }

  @Override
  public boolean validate() {
    return setVariableResult != null
        && setVariableResult.length > 0
        && Arrays.stream(setVariableResult)
            .allMatch(setVariableResult -> setVariableResult.validate());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SetVariablesResponse that = (SetVariablesResponse) o;
    return Arrays.equals(setVariableResult, that.setVariableResult);
  }

  @Override
  public int hashCode() {
    return Objects.hash(setVariableResult);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("setVariableResult", setVariableResult).toString();
  }
}
