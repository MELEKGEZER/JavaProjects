package tcpclient;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;

/**
 * İstemci olarak çalışacak program
 */
public class TCPClient {
    private static Socket socket = null;
    private static JTextArea messageArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TCP İstemci");
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

        JTextField textField = new JTextField();
        textField.setBounds(10, 220, 300, 25);
        panel.add(textField);

        JButton sendButton = new JButton("Gönder");
        sendButton.setBounds(320, 220, 80, 25);
        panel.add(sendButton);

        sendButton.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String message = textField.getText().trim(); // Girdiyi alırken baştaki ve sondaki boşlukları kaldırır
                if (!message.isEmpty()) { // Mesaj boş değilse işleme devam eder
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    Scanner input = new Scanner(socket.getInputStream());

                    out.println(message);
                    messageArea.append("İstemci: " + message + "\n");

                    String response = input.nextLine();
                    messageArea.append("Sunucu: " + response + "\n");

                    textField.setText("");
                } else {
                    JOptionPane.showMessageDialog(panel, "Boş bir mesaj gönderemezsiniz.", "Uyarı", JOptionPane.WARNING_MESSAGE);
                }
            } catch (IOException ex) {
                messageArea.append("Mesaj gönderme hatası: " + ex.getMessage() + "\n");
                System.exit(1);
            }
        }
    });

        // Sunucuya bağlanma işlemleri
        try {
            socket = new Socket("localhost", 1234);
        } catch (IOException ex) {
            messageArea.append("Sunucuya bağlanamadı: " + ex.getMessage() + "\n");
            System.exit(1);
        }
    }
}