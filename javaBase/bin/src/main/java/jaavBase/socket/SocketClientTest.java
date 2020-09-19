package jaavBase.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class SocketClientTest {
    private static String ip="127.0.0.1";
    private static int port=8081;
    public static void main(String[] args) {
        try (
                Socket socket = new Socket(ip, port);
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter out=new PrintWriter(outputStream,true);
                BufferedReader in= new BufferedReader(new InputStreamReader(inputStream));
                BufferedReader sysIn=new BufferedReader(new InputStreamReader(System.in));
        ) {
            String userInput;
            while((userInput=sysIn.readLine())!=null){
                out.println(userInput);
                System.out.println("echo" +in.readLine());
            }

        }  catch (IOException e) {
            e.printStackTrace();
        }

    }
}













