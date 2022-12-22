<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CarForm</title>
    <jsp:include page="/WEB-INF/view/header.jsp"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="d-flex justify-content-center">
    <form class="needs-validation was-validated" action="/carCard" method="post" novalidate>
        <div class="col-md-12">
            <label for="id" class="form-label">Id</label>
            <input type="text" class="form-control" id="id" required="">
        </div>
        <div class="col-md-12">
            <label for="owner" class="form-label">Owner</label>
            <input type="text" class="form-control" id="owner" required="">
        </div>
        <div class="col-md-12">
            <label for="vin" class="form-label">Vin</label>
            <input type="text" class="form-control" id="vin" required="">
        </div>
        <div class="col-md-12">
            <label for="plateNumber" class="form-label">PlateNumber</label>
            <input type="text" class="form-control" id="plateNumber" required="">
        </div>
        <div class="col-md-12">
            <label for="brand" class="form-label">Brand</label>
            <input type="text" class="form-control" id="brand" required="">
        </div>
        <div class="col-md-12">
            <label for="model" class="form-label">Model</label>
            <input type="text" class="form-control" id="model" required="">
        </div>
        <div class="col-md-12">
            <label for="generation" class="form-label">Generation</label>
            <input type="text" class="form-control" id="generation" required="">
        </div>
        <div class="col-md-12">
            <label for="modification" class="form-label">Modification</label>
            <input type="text" class="form-control" id="modification" required="">
        </div>
        <div>
            <label for="engine" class="form-label">Engine</label>
            <input type="text" class="form-control" id="engine" required="">
        </div>
        <div class="col-md-12">
            <label for="year" class="form-label">Year</label>
            <input type="text" class="form-control" id="year" required="">
        </div>
        <div class="row">
            <div class="col order-first">
                <button class="btn btn-success" type="submit">Save</button>
            </div>
            <div class="col">
                <button class="btn btn-primary" type="reset">Clear</button>
            </div>
            <div class="col order-last">
                <a href="/carTable" class="btn btn-danger" type="button">Cancel</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>
