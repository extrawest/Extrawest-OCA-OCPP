package com.extrawest.ocpp_2_0_1.features.client;
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

import com.extrawest.ocpp_2_0_1.constants.FeatureConstants;
import com.extrawest.common.feature.Feature;
import com.extrawest.ocpp_2_0_1.features.client.handlers.IClientSetVariablesRequestHandler;
import com.extrawest.common.model.Confirmation;
import com.extrawest.common.model.Request;
import com.extrawest.ocpp_2_0_1.model.response.SetVariablesResponse;
import com.extrawest.ocpp_2_0_1.model.request.SetVariablesRequest;

import java.util.UUID;

public class SetVariablesFeature implements Feature {

  private final IClientSetVariablesRequestHandler handler;

  public SetVariablesFeature(IClientSetVariablesRequestHandler handler) {
    this.handler = handler;
  }

  @Override
  public Confirmation handleRequest(UUID sessionIndex, Request request) {
    return handler.handleSetVariablesRequest((SetVariablesRequest) request);
  }

  @Override
  public Class<? extends Request> getRequestType() {
    return SetVariablesRequest.class;
  }

  @Override
  public Class<? extends Confirmation> getConfirmationType() {
    return SetVariablesResponse.class;
  }

  @Override
  public String getAction() {
    return FeatureConstants.SET_VARIABLES.value();
  }
}
