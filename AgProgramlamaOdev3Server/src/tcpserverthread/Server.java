package tcpserverthread;



import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.*;

public class Server {
    private static Set<ClientHandler> clientHandlers = ConcurrentHashMap.newKeySet();
    private static Set<String> clientNames = ConcurrentHashMap.newKeySet();
    private static Map<String, List<String>> clientMessages = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Server");
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea));
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        int port = Integer.parseInt(JOptionPane.showInputDialog(frame, "Sunucu portunu girin:"));

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            String serverIP = InetAddress.getLocalHost().getHostAddress();
            textArea.append("Sunucu başlatıldı IP: " + serverIP + " Port: " + port + "\n");

            while (true) {//Sürekli olarak yeni istemci bağlantılarını kabul eden bir döngü. Her yeni bağlantı için bir ClientHandler nesnesi oluşturuluyor ve yeni bir thread'de çalıştırılıyor.
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket, textArea);
                clientHandlers.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            textArea.append("Sunucu başlatılırken hata oluştu: " + e.getMessage() + "\n");
        }
    }

    public static boolean addClientName(String name) {//Yeni bir kullanıcı adı eklerken senkronize edilmiş bir blok kullanılıyor. Kullanıcı adı en az 5 karakter olmalı ve benzersiz olmalı.
        synchronized (clientNames) {
            if (name.length() >= 5 && !clientNames.contains(name)) {
                clientNames.add(name);
                clientMessages.put(name, new ArrayList<>());
                return true;
            }
            return false;
        }
    }

    public static void removeClient(ClientHandler clientHandler) {//Bir istemci ayrıldığında, ilgili handler, kullanıcı adı ve mesajlar siliniyor. Diğer istemcilere ayrılan kullanıcı adı bildiriliyor.
        clientHandlers.remove(clientHandler);
        String clientName = clientHandler.getClientName();
        clientNames.remove(clientName);
        clientMessages.remove(clientName);
        broadcast("REMOVE_MESSAGES:" + clientName);
    }

    public static void broadcast(String message) {//Tüm istemcilere bir mesaj gönderiliyor.
        for (ClientHandler clientHandler : clientHandlers) {
            clientHandler.sendMessage(message);
        }
    }

    public static void storeMessage(String clientName, String message) {//Bir istemciden gelen mesaj kaydediliyor.
        List<String> messages = clientMessages.get(clientName);
        if (messages != null) {
            messages.add(message);
        }
    }
    public static List<String> getMessages() {//Tüm mesajlar alınıyor ve döndürülüyor.
        List<String> allMessages = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : clientMessages.entrySet()) {
            String clientName = entry.getKey();
            for (String message : entry.getValue()) {
                allMessages.add(clientName + ": " + message);
            }
        }
        return allMessages;
    }
}

class ClientHandler implements Runnable {//İstemci işlemlerini yönetmek için ClientHandler sınıfı başlıyor.
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String clientName;
    private JTextArea textArea;

    public ClientHandler(Socket socket, JTextArea textArea) {
        this.socket = socket;
        this.textArea = textArea;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                out.println("Bir kullanıcı adı girin (en az 5 karakterden oluşan, benzersiz):");
                clientName = in.readLine();
                if (Server.addClientName(clientName)) {
                    break;
                } else {
                    out.println("Kullanıcı adı ya çok kısa ya da zaten alınmış. Tekrar deneyin.");
                }
            }

            textArea.append(clientName + " katıldı\n");
            Server.broadcast(clientName + " katıldı");

            // Sunucuda mevcut tüm mesajları yeni istemciye gönder
            for (String message : Server.getMessages()) {
                sendMessage(message);
            }

            String message;//İstemciden gelen mesajları okuma ve yayınlama döngüsü. İstemci ayrıldığında gerekli temizleme işlemleri yapılıyor.
            while ((message = in.readLine()) != null) {
                String fullMessage = clientName + ": " + message;
                Server.storeMessage(clientName, message);
                Server.broadcast(fullMessage);
            }
        } catch (IOException e) {
            textArea.append("Bir istemci ayrıldı: " + e.getMessage() + "\n");
        } finally {
            Server.removeClient(this);
            Server.broadcast(clientName + " ayrıldı");
            textArea.append(clientName + " ayrıldı\n");
            try {
                socket.close();
            } catch (IOException e) {
                textArea.append("Soket kapatılırken hata oluştu: " + e.getMessage() + "\n");
            }
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
