<%-- 
    Document   : list_personnel
    Created on : 2024 Jun 5, 00:25:20
    Author     : Melek
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Personnel" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Personel Listele</title>
    <link rel="stylesheet" href="css/personel_listele_styles.css">
    <!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Personel Listesi</h1>
        <nav class="nav">
            <a class="nav-link" href="index.html">Ana Sayfa</a>
            <a class="nav-link" href="add_personnel.jsp">Personel Ekle</a>
            <a class="nav-link" href="personnel">Personel Listele</a>
        </nav>

        <%-- Personel eklendiğinde gösterilecek mesaj --%>
        <%
            String message = (String) request.getAttribute("message");
            if (message != null && !message.isEmpty()) {
        %>
            <div class="alert alert-success" role="alert">
                <%= message %>
            </div>
        <% } %>
        
        <table class="table table-striped mt-3">
            <thead>
                <tr>
                    <th>Adı</th>
                    <th>Soyadı</th>
                    <th>Sicil Numarası</th>
                    <th>Departman</th>
                    <th>Telefon</th>
                    <th>İşe Giriş Tarihi</th>
                    <th>Maaş</th>
                    <th>Aktiflik</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Personnel> personnelList = (List<Personnel>) request.getAttribute("personnelList");
                    if (personnelList != null) {
                        double totalSalary = 0;
                        for (Personnel personnel : personnelList) {
                            totalSalary += personnel.getSalary();
                %>
                            <tr>
                                <td><%= personnel.getFirstName() %></td>
                                <td><%= personnel.getLastName() %></td>
                                <td><%= personnel.getRegistrationNumber() %></td>
                                <td><%= String.join(", ", personnel.getDepartment()) %></td>
                                <td><%= personnel.getPhone() %></td>
                                <td><%= new SimpleDateFormat("yyyy-MM-dd").format(personnel.getHireDate()) %></td>
                                <td><%= personnel.getSalary() %></td>
                                <td><%= personnel.isActive() ? "Aktif" : "Pasif" %></td>
                            </tr>
                <%
                        }
                %>
                        <tr>
                            <td colspan="7" class="text-right"><strong>Toplam Personel Sayısı:</strong></td>
                            <td><%= personnelList.size() %></td>
                        </tr>
                        <tr>
                            <td colspan="7" class="text-right"><strong>Toplam Maaş Tutarı:</strong></td>
                            <td><%= totalSalary %></td>
                        </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>

