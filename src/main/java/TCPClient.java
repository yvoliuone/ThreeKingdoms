package server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Ashsandra on 12/21/17.
 */
public class TCPClient {
  public static void main(String argv[]) throws IOException{
    int number ,temp;
    Socket socket = new Socket("10.20.176.98",53592);
    Scanner scanner = new Scanner(System.in);
    Scanner scanner1 = new Scanner(socket.getInputStream()) ;
    System.out.println("enter a number");
    number = scanner.nextInt();
    PrintStream p = new PrintStream(socket.getOutputStream());
    p.println(number);
    temp = scanner1.nextInt();
    System.out.println(temp);

  }
}
