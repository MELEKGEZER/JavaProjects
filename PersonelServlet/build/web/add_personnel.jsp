<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="tr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Personel Ekle</title>
    <link rel="stylesheet" href="css/personel_ekle_styles.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Personel Ekle</h1>
        <nav class="nav">
            <a class="nav-link" href="index.html">Ana Sayfa</a>
            <a class="nav-link" href="add_personnel.jsp">Personel Ekle</a>
            <a class="nav-link" href="personnel">Personel Listele</a>
        </nav>

        <%-- Başarı mesajı işlemesi --%>
        <%
            String message = (String) request.getAttribute("message");
            if (message != null && !message.isEmpty()) {
        %>
            <div class="alert alert-success mt-3" role="alert">
                <%= message %>
                <a href="personnel" class="btn btn-success ml-3">Personel Listesine Git</a>
            </div>
        <% } %>

        <form class="mt-3" action="personnel" method="post">
            <div class="form-group">
                <label for="firstName">Adı</label>
                <input type="text" class="form-control" id="firstName" name="firstName" required>
            </div>
            <div class="form-group">
                <label for="lastName">Soyadı</label>
                <input type="text" class="form-control" id="lastName" name="lastName" required>
            </div>
            <div class="form-group">
                <label for="registrationNumber">Sicil Numarası</label>
                <input type="text" class="form-control" id="registrationNumber" name="registrationNumber">
            </div>
            <div class="form-group">
                <label for="department">Departman</label>
                <select class="form-control" id="department" name="department" multiple>
                    <option>IT</option>
                    <option>HR</option>
                    <option>Finance</option>
                    <option>Marketing</option>
                </select>
            </div>
            <div class="form-group">
                <label for="phone">Telefon</label>
                <input type="text" class="form-control" id="phone" name="phone">
            </div>
            <div class="form-group">
                <label for="hireDate">İşe Giriş Tarihi</label>
                <input type="date" class="form-control" id="hireDate" name="hireDate" required>
            </div>
            <div class="form-group">
                <label for="salary">Maaş Tutarı</label>
                <input type="number" class="form-control" id="salary" name="salary" required>
            </div>
            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="active" name="active" value="true">
                <label class="form-check-label" for="active">Aktif</label>
            </div>
            <button type="submit" class="btn btn-primary">Kaydet</button>
        </form>
    </div>
</body>
</html>


