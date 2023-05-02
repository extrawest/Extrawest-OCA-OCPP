package extrawest.ocpp.features.client;

import eu.chargetime.ocpp.feature.Feature;
import eu.chargetime.ocpp.model.Confirmation;
import eu.chargetime.ocpp.model.Request;
import extrawest.ocpp.constants.FeatureConstants;
import extrawest.ocpp.features.client.handlers.IClientCancelReservationRequestHandler;
import extrawest.ocpp.model.request.CancelReservationRequest;
import extrawest.ocpp.model.response.CancelReservationResponse;

import java.util.UUID;

public class CancelReservationFeature implements Feature {
    private final IClientCancelReservationRequestHandler handler;

    public CancelReservationFeature(IClientCancelReservationRequestHandler handler) {
        this.handler = handler;
    }

    @Override
    public Confirmation handleRequest(UUID sessionIndex, Request request) {
        return handler.handleCancelReservationRequest((CancelReservationRequest) request);
    }

    @Override
    public Class<? extends Request> getRequestType() {
        return CancelReservationRequest.class;
    }

    @Override
    public Class<? extends Confirmation> getConfirmationType() {
        return CancelReservationResponse.class;
    }

    @Override
    public String getAction() {
        return FeatureConstants.CANCEL_RESERVATION.value();
    }
}
