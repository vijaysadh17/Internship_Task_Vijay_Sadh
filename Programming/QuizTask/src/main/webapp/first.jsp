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
        <div class="card p-4 shadow-sm" style="width: 100%; max-width: 500px;">
            <form action="FirstTask">
                <h3 class="mb-4 text-center">Which keyword is used to inherit a class in Java?</h3>

                <div class="form-check mb-2">
                    <input class="form-check-input" type="radio" name="q1" id="implement" value="implement">
                    <label class="form-check-label" for="implement">a) implement</label>
                </div>
                <div class="form-check mb-2">
                    <input class="form-check-input" type="radio" name="q1" id="extends" value="extends">
                    <label class="form-check-label" for="extends">b) extends</label>
                </div>
                <div class="form-check mb-2">
                    <input class="form-check-input" type="radio" name="q1" id="inherits" value="inherits">
                    <label class="form-check-label" for="inherits">c) inherits</label>
                </div>
                <div class="form-check mb-4">
                    <input class="form-check-input" type="radio" name="q1" id="super" value="super">
                    <label class="form-check-label" for="super">d) super</label>
                </div>

                <div class="d-flex justify-content-between">
                    <a href="rules.jsp" class="btn btn-secondary">Back</a>
                    <input type="submit" value="Save & Next" class="btn btn-primary">
                </div>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
