package server;

import game.deck.Card;
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
        System.out.println("Welcome player" + userId);
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
        Session next = nextSession(userSession);
        if (message.equals("end")) {
            try {
                next.getRemote().sendString(draw(next, 1));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Card card = getPlayer(userSession).getCard(Integer.parseInt(message));
            switch (card.getType()) {
                case "attack":
                    try {
                        next.getRemote().sendString(JSONObject.valueToString(
                                new JSONObject().put("command", "request").put("type", "dodge")
                                        .put("amount", 1).put("index", message)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "dodge":
                    try {
                        userSession.getRemote().sendString(JSONObject.valueToString(
                                new JSONObject().put("command", "invalid").put("index", message)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "peach":
                    try {
                        userSession.getRemote().sendString(JSONObject.valueToString(
                                new JSONObject().put("command", "heal").put("amount", 1).put("index", message)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Error: Invalid card in message");
            }
            sendMessage(userSession, message);
        }
    }

}

