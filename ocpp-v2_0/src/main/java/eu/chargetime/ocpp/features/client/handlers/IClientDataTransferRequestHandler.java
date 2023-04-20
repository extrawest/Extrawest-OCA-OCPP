package eu.chargetime.ocpp.features.client.handlers;

import eu.chargetime.ocpp.model.request.DataTransferRequest;
import eu.chargetime.ocpp.model.response.DataTransferResponse;

/** Charging Station handler of {@link DataTransferRequest} */
public interface IClientDataTransferRequestHandler {
    DataTransferResponse handleCancelDataTransferRequest(DataTransferRequest request);
}