package server;

import org.apache.log4j.BasicConfigurator;
import static spark.Spark.*;

public class ThreeKingdomsServer {

  public static void main(String[] args) {
    BasicConfigurator.configure();
    get("/hello", (req, res) -> "hello sandra 石肥肥");
  }

}
