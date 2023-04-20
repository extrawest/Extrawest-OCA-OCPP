package eu.chargetime.ocpp.features.client.handlers;

import eu.chargetime.ocpp.model.request.CustomerInformationRequest;
import eu.chargetime.ocpp.model.response.CustomerInformationResponse;

/** Charging Station handler of {@link CustomerInformationRequest} */
public interface IClientCustomerInformationRequestHandler {
    CustomerInformationResponse handleCustomerInformationRequest(CustomerInformationRequest request);
}