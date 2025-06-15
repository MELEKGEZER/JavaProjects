package tcpclient;


import java.io.*;
import java.net.*;
import javax.swing.*;

public class TCPClient {
    private static String serverAddress;
    private static int serverPort;
    private static String userName;
    private static PrintWriter out;
    private static BufferedReader in;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Client");
        JTextArea textArea = new JTextArea(20, 40);
        textArea.setEditable(false);
        JTextField textField = new JTextField(40);
        JButton sendButton = new JButton("Send");

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(sendButton);

        frame.getContentPane().add(new JScrollPane(textArea), "Center");
        frame.getContentPane().add(panel, "South");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while (true) {//Sunucu IP adresi ve portu kullanıcıdan alınarak sunucuya bağlanılıyor. Bağlantı kurulmazsa kullanıcı bilgilendiriliyor ve tekrar denemesi isteniyor.
            serverAddress = JOptionPane.showInputDialog(frame, "Sunucu IP adresini girin:");
            try {
                serverPort = Integer.parseInt(JOptionPane.showInputDialog(frame, "Sunucu portunu girin:"));
                Socket socket = new Socket(serverAddress, serverPort);
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                break;
            } catch (IOException | NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Bağlantı başarısız oldu. Tekrar deneyin.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        new Thread(() -> {//Sunucudan gelen mesajları dinlemek ve GUI'ye yansıtmak için yeni bir thread başlatılıyor. Kullanıcı adı istenirse kullanıcıdan alınıyor ve sunucuya gönderiliyor. Bir kullanıcının mesajları kaldırıldığında ilgili mesajlar siliniyor.
            try {
                while (true) {
                    String response = in.readLine();
                    if (response.startsWith("Bir kullanıcı adı girin")) {
                        userName = JOptionPane.showInputDialog(frame, response);
                        out.println(userName);
                    } else if (response.startsWith("REMOVE_MESSAGES:")) {
                        String targetUser = response.split(":")[1];
                        textArea.setText(textArea.getText().replaceAll(targetUser + ": .*\\n", ""));
                    } else {
                        textArea.append(response + "\n");
                    }
                }
            } catch (IOException e) {
                textArea.append("Bağlantı koptu: " + e.getMessage() + "\n");
            }
        }).start();

        sendButton.addActionListener(e -> {//Gönder butonu ve metin alanı için eylem dinleyicileri ekleniyor. Mesaj gönderildiğinde sunucuya iletiliyor ve metin alanı temizleniyor.
            String message = textField.getText();
            if (!message.isEmpty()) {
                out.println(message);
                textField.setText("");
            }
        });

        textField.addActionListener(e -> {
            String message = textField.getText();
            if (!message.isEmpty()) {
                out.println(message);
                textField.setText("");
            }
        });
    }
}
