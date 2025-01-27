<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Quiz Rules</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="card p-4 shadow-sm" style="width: 100%; max-width: 600px;">
            <form action="first.jsp">
                <h3 class="text-center mb-4">Rules & Regulations</h3>
                <hr>
                <ol>
                    <li>You will have 15 seconds for each question.</li>
                    <li>You cannot select multiple options.</li>
                    <li>You cannot select any options once the time goes off.</li>
                    <li>You can't exit from the quiz while you are playing.</li>
                    <li>You will get marks based on correct answers.</li>
                    <li>No negative marking for wrong answers.</li>
                </ol>
                <div class="form-check mb-3">
                    <input type="checkbox" class="form-check-input" id="terms" required>
                    <label for="terms" class="form-check-label">I accept the Terms & Conditions</label>
                </div>
                <hr>
                <div class="d-flex justify-content-between">
                    <a href="index.jsp" class="btn btn-danger">Exit</a>
                    <input type="submit" value="Continue" class="btn btn-primary">
                </div>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
