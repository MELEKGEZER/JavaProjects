package tcpserver;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;

public class TCPServer {
    private static ServerSocket serverSocket = null;
    private static JTextArea messageArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TCP Sunucu");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        messageArea = new JTextArea();
        messageArea.setBounds(10, 10, 380, 200);
        panel.add(messageArea);

        JButton startButton = new JButton("Başlat");
        startButton.setBounds(10, 220, 80, 25);
        panel.add(startButton);

        JButton stopButton = new JButton("Durdur");
        stopButton.setBounds(100, 220, 80, 25);
        panel.add(stopButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startServer();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopServer();
            }
        });
    }

    private static void startServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(1234);
                    messageArea.append("Sunucu TCP Socket oluşturuldu. Bağlantı bekleniyor...\n");
                    Socket clientSocket = serverSocket.accept();
                    messageArea.append(clientSocket.toString() + " bağlandı.\n");

                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    Scanner input = new Scanner(clientSocket.getInputStream());

                    while (true) {
                        if (input.hasNextLine()) {
                            String receivedMessage = input.nextLine();
                            messageArea.append(clientSocket.getInetAddress().getHostName() + " istemci: " + receivedMessage + "\n");
                            out.println(receivedMessage.toUpperCase());
                        } else {
                            try {
                                Thread.sleep(100); // Bir sonraki satırın gelmesini beklemek için biraz bekleyin
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                } catch (IOException ex) {
                    messageArea.append("Bağlantı sağlanamadı: " + ex.getMessage() + "\n");
                }
            }
        }).start();
    }

    private static void stopServer() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
                messageArea.append("Sunucu kapatıldı.\n");
            }
        } catch (IOException ex) {
            messageArea.append("Bağlantı kapatılamadı: " + ex.getMessage() + "\n");
        }
    }
}