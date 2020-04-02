package ru.sibsutis;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server_App {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8081, 0, InetAddress.getByName("0.0.0.0"));   /////   !!! sudo if port < 1000
        while (true) {
            Socket client = server.accept();

            Scanner in = new Scanner(client.getInputStream());
            PrintWriter out = new PrintWriter(client.getOutputStream());

            /// GET / -> index.html,    GET /image -> image.html
            //String str = in.nextLine();
            //System.out.print(str);
            String tmp = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: 149\r\n" +
                    "\r\n" +
                    "<html><body><h1>Hello</h1></body></html>";
            System.out.println(tmp);
            out.print(tmp);
            out.flush();
            //client.close();
            //server.close();
        }
    }
}
