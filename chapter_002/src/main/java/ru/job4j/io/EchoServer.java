package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    String answer = "";
                    while (!str.isEmpty()) {
                        if (str.contains("=")) {
                            String[] text = str.split("=");
                            if (text[1].contains("Exit")) {
                                answer = "Server closed";
                            } else if (text[1].contains("Hello")) {
                                answer = "Hello";
                            } else {
                                String[] tmp = text[1].split(" ");
                                answer = tmp[0];
                            }
                        }
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answer.getBytes());
                    if (answer.contains("closed")) {
                        socket.close();
                        server.close();
                    }
                }
            }
        }
    }
}