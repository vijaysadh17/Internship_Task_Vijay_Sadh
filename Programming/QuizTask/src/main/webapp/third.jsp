<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Quiz</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="card p-4 shadow-sm" style="width: 100%; max-width: 600px;">
            <form action="ThirdTask">
                <h3 class="text-center mb-4">Which access modifier allows visibility within the same package and subclasses?</h3>
                <div class="form-check">
                    <input type="radio" class="form-check-input" name="q3" value="private" id="option1">
                    <label for="option1" class="form-check-label">a) private</label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" name="q3" value="protected" id="option2">
                    <label for="option2" class="form-check-label">b) protected</label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" name="q3" value="public" id="option3">
                    <label for="option3" class="form-check-label">c) public</label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" name="q3" value="default" id="option4">
                    <label for="option4" class="form-check-label">d) default</label>
                </div>
                <br>
                <div class="d-flex justify-content-between">
                    <a href="second.jsp" class="btn btn-secondary">Previous</a>
                    <input type="submit" value="Save & Next" class="btn btn-primary">
                </div>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
