package testChatServer;

import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static j2html.TagCreator.*;
import static spark.Spark.*;

public class Chat {
  static Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();
  static int nextUserNumber = 1;


  public static void main(String[] args) {
    staticFileLocation("/public");
//    staticFiles.expireTime(600);
    webSocket("/game", ChatWebSocketHandler.class);
    init();
  }


  private static String createHtmlMessageFromSender(String sender, String message) {
    return article().with(
        b(sender + " plays " + message),
        p(message)
//        span().withClass("timestamp").withText(new SimpleDateFormat("HH:mm:ss").format(new Date()))
    ).render();
  }


  public static void broadcastMessage(String sender, String message) {
    userUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
      try {
        session.getRemote().sendString(String.valueOf(new JSONObject()
            .put("userMessage", createHtmlMessageFromSender(sender, message))
            .put("userlist", userUsernameMap.values())
        ));
      } catch (Exception e) {
        e.printStackTrace();
      }
        }

    );
  }

}
