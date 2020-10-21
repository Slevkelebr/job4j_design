package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final String HELLO = "Hello";
    private static final String EXIT = "Exit";

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean stopServer = false;
            while (!stopServer) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    String answer = "";
                    if (!str.isEmpty()) {
                        if (str.contains("=")) {
                            String[] text = str.split("=");
                            if (EXIT.equals(text[1])) {
                                stopServer = true;
                                server.close();
                            } else if (HELLO.equals(text[1])) {
                                answer = HELLO;
                            } else {
                                answer = str;
                            }
                        }
                        if (!server.isClosed()) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write(answer.getBytes());
                        }
                    }
                }
            }
        }
    }
}