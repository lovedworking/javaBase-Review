package jaavBase.socket;

import sun.print.PrinterJobWrapper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest extends Socket {
    private static int port=8081;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket=serverSocket.accept();
             PrintWriter out= new PrintWriter(clientSocket.getOutputStream(),true);
             BufferedReader in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        ) {
            String inputLine;
            while((inputLine=in.readLine())!=null){
                out.println(inputLine);
                System.out.println(""+inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
















