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
        if (userId == 2) {
            //TODO: DRAW
            userSession.getRemote().sendString(JSONObject.valueToString(new JSONObject("{ command: draw, cards: [[attack, 1, SPADE], [dodge, 1, DIAMOND]], amount: 2 }")));
        }
    }


    @OnWebSocketClose
    public void onClose(Session userSession, int statusCode, String reason) { }


    @OnWebSocketMessage
    public void onMessage(Session userSession, String message) {
        if (message.equals("end")) {
            //TODO: DRAW
        }
        ThreeKingdomsServer.sendMessage(userSession, message);
    }

}

