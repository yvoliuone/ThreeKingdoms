package server;

import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.json.JSONObject;

@WebSocket
public class ThreeKingdomsHandler {

    @OnWebSocketConnect
    public void onConnect(Session userSession) throws Exception {
        int userId = ThreeKingdomsServer.userNumber++;
        System.out.println("Welcome user" + userId);
        ThreeKingdomsServer.sessionMap.put(userSession, userId);
        ThreeKingdomsServer.userMap.put(userId, userSession);
//        if (userId == 2) {
//            userSession.getRemote().sendString(JSONObject.valueToString("init"));
//        }
    }


    @OnWebSocketClose
    public void onClose(Session userSession, int statusCode, String reason) { }


    @OnWebSocketMessage
    public void onMessage(Session userSession, String message) {
        ThreeKingdomsServer.sendMessage(userSession, message);
    }

}

