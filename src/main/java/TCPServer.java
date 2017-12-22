package game.deck;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Ashsandra on 12/21/17.
 */
public class TCPServer {
  public static void main (String argv[]) throws IOException{
    int number, temp;
    ServerSocket serverSocket = new ServerSocket(53592);
    Socket socket = serverSocket.accept();
    Scanner scanner = new Scanner(socket.getInputStream());
    number = scanner.nextInt();
    temp = number * 2;
    PrintStream printStream = new PrintStream(socket.getOutputStream());
    printStream.println(temp);
  }

}

