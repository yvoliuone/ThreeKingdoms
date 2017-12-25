package server;

import org.apache.log4j.BasicConfigurator;
import static spark.Spark.*;
import static j2html.TagCreator.html;

public class ThreeKingdomsServer {

  public static void main(String[] args) {
    BasicConfigurator.configure();
    get("/hello", (req, res) -> "石肥肥胖胖是个大傻子"); // test


    staticFileLocation("/public"); //index.html is served at localhost:4567 (default port)
    webSocket("/chat", handler.class);
    init();

  }

}
