<!doctype html>
<html lang="en">
<head>
<jsp:include page="../include/employee_header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>


<section>
    <div class="container">
        <form method="get" action="/employee/createSubmit">
        <input type="hidden" name="id" value="${form.id}">
            <div class="mb-3">
                <label for="firstname" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstname" name="firstname" value="${form.firstname}"
                 aria-describedby="firstnameHelp">
                <div id="firstnameHelp" class="form-text">Please enter first name</div>
            </div>
            <div class="mb-3">
                <label for="lastname" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastname" name="lastname" value="${form.lastname}">
            </div>
            <div class="mb-3">
            <label for="phonenumber" class="form-label">Phone</label>
            <input type="text" class="form-control" id="phonenumber" name="phonenumber" value="${form.phonenumber}">
            </div>
            <div class="mb-3">
             <label for="city" class="form-label">City</label>
             <input type="text" class="form-control" id="city" name="city" value="${form.city}">
              </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</section>
<jsp:include page="../include/footer.jsp"/>
</body>
</html>