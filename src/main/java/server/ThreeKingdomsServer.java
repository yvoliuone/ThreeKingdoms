package server;

import org.apache.log4j.BasicConfigurator;

import static spark.Spark.*;

public class ThreeKingdomsServer {

  public static void main(String[] args) {
    BasicConfigurator.configure();
    get("/hiYvonne", (req, res) -> "Yvonne is stupid");
  }

}
