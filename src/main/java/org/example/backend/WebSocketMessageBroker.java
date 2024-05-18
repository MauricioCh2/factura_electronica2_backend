package org.example.backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //Esta anotación habilita el soporte para manejar mensajes WebSocket en métodos de controlador con mapeo de mensajes.
public class WebSocketMessageBroker implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
    //Este método se utiliza para configurar el corredor de mensajes WebSocket. En este caso, se habilita un corredor de mensajes simple en el prefijo de destino "/topic" y se configura el prefijo de destino de la aplicación en "/app".

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket-endpoint").withSockJS();
    }
}
//Este método se utiliza para registrar puntos finales STOMP que los clientes usarán para conectarse a nuestro servidor WebSocket. En este caso, se está registrando un solo punto final en "/websocket-endpoint" y se habilita el soporte para SockJS.