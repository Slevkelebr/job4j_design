package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String answer = "";
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("=")) {
                            String[] text = str.split("=");
                            if (text[1].contains("Exit")) {
                                socket.close();
                                break;
                            } else if (text[1].contains("Hello")) {
                                answer = "Hello";
                            } else {
                                String[] tmp = text[1].split(" ");
                                answer = tmp[0];
                            }
                        }
                        System.out.println(str);
                    }
                    if (socket.isClosed()) {
                        server.close();
                        break;
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answer.getBytes());
                }
            }
        }
    }
}