package server;

//import org.apache.log4j.BasicConfigurator;
import game.ThreeKingdoms;
import game.players.Player;
import org.eclipse.jetty.websocket.api.Session;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import static spark.Spark.*;



public class ThreeKingdomsServer {
  public static int userNumber = 1;
  public static ConcurrentHashMap<Session, Integer> userMap = new ConcurrentHashMap<>();


  public static void main(String[] args) {
    ThreeKingdoms game = ThreeKingdoms.startNewGame(Player.createTest("player1"), Player.createTest("player2"));
    staticFileLocation("/ThreeKingdoms");
    webSocket("/game", ThreeKingdomsHandler.class);

    // launch the browser
    try {
      java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://localhost:4567/"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    get("/testget/", (request, response) ->  request.queryParams("input") );


  }

  public static void sendMessage(Session userSession, String message) {
    try {
      nextSession(userSession).getRemote().sendString(message);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Session nextSession(Session userSession) {
    return userMap.keySet().stream().filter(session -> session != userSession).findFirst().get();
  }
}
