package com.extrawest.ocpp_2_0_1.features.client.handlers;

import com.extrawest.ocpp_2_0_1.model.request.RequestStopTransactionRequest;
import com.extrawest.ocpp_2_0_1.model.response.RequestStopTransactionResponse;

/** Charging Station handler of {@link RequestStopTransactionRequest} */
public interface IClientRequestStopTransactionRequestHandler {
    RequestStopTransactionResponse handleRequestStopTransactionRequest(RequestStopTransactionRequest request);
}
