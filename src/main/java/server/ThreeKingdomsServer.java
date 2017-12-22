package server;

import static spark.Spark.*;

public class ThreeKingdomsServer {

  public static void main(String[] args) {
    get("/hello", (req, res) -> "hello world");
  }

}
