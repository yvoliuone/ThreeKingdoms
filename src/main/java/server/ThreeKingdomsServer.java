package server;

import org.apache.log4j.BasicConfigurator;
import static spark.Spark.*;
import static j2html.TagCreator.html;

public class ThreeKingdomsServer {

  public static void main(String[] args) {
    BasicConfigurator.configure();
    get("/hello", (req, res) -> "石肥肥胖胖是个大傻子");

  }

}
