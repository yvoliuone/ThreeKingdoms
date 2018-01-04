package server;

//import org.apache.log4j.BasicConfigurator;
import game.ThreeKingdoms;
import game.deck.Card;
import game.deck.DeckofCards;
import game.players.Player;
import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import static j2html.TagCreator.html;
import static spark.Spark.*;



public class ThreeKingdomsServer {
  public static int userNumber = 1;
  public static ConcurrentHashMap<Session, Integer> sessionMap = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Integer, Session> userMap = new ConcurrentHashMap<>();
    static ArrayList<Card> deck = DeckofCards.test();

    public static void main(String[] args) {
//    ThreeKingdoms game = ThreeKingdoms.startNewGame(Player.createTest("player1"), Player.createTest("player2"));
    staticFileLocation("/threeKingdoms");
    webSocket("/threeKingdoms", ThreeKingdomsHandler.class);

    // launch the browser
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://localhost:4567/threeKingdoms/"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://localhost:4567/threeKingdoms/"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    get("/update/", (request, response) ->  request.queryParams("input") );

    get("/startTurn/", (request, response) ->  request.queryParams("input") );


    // start page
    get("/threeKingdoms/", (request, response) -> {
        response.redirect("/threeKingdoms.html", 301);
        return "Redirecting to client...";
    });


    }


  public static String draw(Session userSession, int amount) {
      JSONArray cards = new JSONArray();
      for (int i = 0; i < amount; i++) {
          Card card = deck.remove(0);
          cards.put(new JSONArray().put(card.getType()).put(card.getSuit()).put(card.getRank()));
      }
      return JSONObject.valueToString(new JSONObject().put("command", "draw").put("cards", cards).put("amount", amount));
  }

  public static void sendMessage(Session userSession, String message) {
    try {
      nextSession(userSession).getRemote().sendString(message);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

//  public static void sendToAll(String message) {
//        sessionMap.keySet().forEach( session -> {
//                try {
//                    session.getRemote().sendString(message);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }});
//  }

  public static Session nextSession(Session userSession) {
    return sessionMap.keySet().stream().filter(session -> session != userSession).findFirst().get();
  }
}
