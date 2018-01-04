package server;

import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.json.JSONObject;
import java.io.IOException;

import static server.ThreeKingdomsServer.*;

@WebSocket
public class ThreeKingdomsHandler {

    @OnWebSocketConnect
    public void onConnect(Session userSession) throws Exception {
        int userId = userNumber++;
        System.out.println("Welcome user" + userId);
        sessionMap.put(userSession, userId);
        userMap.put(userId, userSession);
        if (userId == 2) {
            sessionMap.keySet().forEach(
                    session -> {
                        try {
                            session.getRemote().sendString(draw(session, 2));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }
    }


    @OnWebSocketClose
    public void onClose(Session userSession, int statusCode, String reason) { }


    @OnWebSocketMessage
    public void onMessage(Session userSession, String message) {
        if (message.equals("end")) {
            Session next = nextSession(userSession);
            try {
                next.getRemote().sendString(draw(next, 1));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            sendMessage(userSession, message);
        }
    }

}

