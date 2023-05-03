package extrawest.ocpp.test.features;
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

import static extrawest.ocpp.utilities.TestUtilities.aList;

import extrawest.ocpp.features.client.SetVariablesFeature;
import com.extrawest.ocpp_2_0_1.features.client.handlers.IClientSetVariablesRequestHandler;
import com.extrawest.ocpp_2_0_1.model.dataTypes.ComponentType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.SetVariableDataType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.SetVariableResultType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.VariableType;
import com.extrawest.ocpp_2_0_1.model.response.SetVariablesResponse;
import com.extrawest.ocpp_2_0_1.model.dataTypes.enums.SetVariableStatusEnumType;
import com.extrawest.ocpp_2_0_1.model.request.SetVariablesRequest;

public class SetVariables implements IClientSetVariablesRequestHandler {
  private SetVariablesFeature feature;
  private SetVariablesResponse confirmation;

  public SetVariables() {
    feature = new SetVariablesFeature(this);
    confirmation = createConfirmation();
  }

  private SetVariablesResponse createConfirmation() {
    VariableType variableType = new VariableType();
    variableType.setName("A name");

    ComponentType componentType = new ComponentType();
    componentType.setName("A name");

    SetVariableResultType setVariableResultType = new SetVariableResultType();
    setVariableResultType.setAttributeStatus(SetVariableStatusEnumType.ACCEPTED);
    setVariableResultType.setComponent(componentType);
    setVariableResultType.setVariable(variableType);

    SetVariablesResponse confirmation = new SetVariablesResponse();
    confirmation.setSetVariableResult(aList(setVariableResultType));
    return confirmation;
  }

  public SetVariablesResponse getConfirmation() {
    return confirmation;
  }

  public SetVariablesFeature getFeature() {
    return feature;
  }

  @Override
  public SetVariablesResponse handleSetVariablesRequest(SetVariablesRequest request) {
    return confirmation;
  }

  public SetVariablesRequest createRequest() {
    VariableType variableType = new VariableType();
    variableType.setName("A name");

    ComponentType componentType = new ComponentType();
    componentType.setName("A name");

    SetVariableDataType setVariableDataType = new SetVariableDataType();
    setVariableDataType.setAttributeValue("A variable");
    setVariableDataType.setComponent(componentType);
    setVariableDataType.setVariable(variableType);

    SetVariablesRequest request = new SetVariablesRequest();
    request.setSetVariableData(aList(setVariableDataType));

    return request;
  }
}
