package testChatServer;

import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.json.JSONObject;

@WebSocket
public class ChatWebSocketHandler {

//  private String sender, msg;
//
  @OnWebSocketConnect
  public void onConnect(Session userSession) throws Exception {
      int userId = Chat.userNumber++;
      System.out.println("Welcome user" + userId);
      Chat.userMap.put(userSession, userId);
      if (userId == 2) {
          userSession.getRemote().sendString(JSONObject.valueToString("init"));
      }

//    String username = "Player" + Chat.nextUserNumber++;
//    Chat.userUsernameMap.put(user, username);
//    Chat.broadcastMessage(sender = "Server", msg = (username + " joined the game"));
  }
//
//
  @OnWebSocketClose
  public void onClose(Session userSession, int statusCode, String reason) {
//    String username = Chat.userUsernameMap.get(userSession);
//    Chat.userUsernameMap.remove(userSession);
//    Chat.broadcastMessage(sender = "Server", msg = (username + " left the game"));
  }
//
//
  @OnWebSocketMessage
  public void onMessage(Session userSession, String message) {
      Chat.sendMessage(userSession, message);
  }



}
