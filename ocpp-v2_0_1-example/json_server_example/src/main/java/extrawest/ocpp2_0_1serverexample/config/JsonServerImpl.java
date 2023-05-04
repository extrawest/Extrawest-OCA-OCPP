package extrawest.ocpp2_0_1serverexample.config;

import com.extrawest.common.ServerEvents;
import com.extrawest.ocpp_2_0_1.JSONServer;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class JsonServerImpl {

    private final ServerEvents serverEvents;
    private final JSONServer server;
    private final ApplicationConfiguration applicationConfiguration;

    @PostConstruct
    public void startServer() throws Exception {
        server.open("localhost", applicationConfiguration.getServerPort(), serverEvents);
    }
}
