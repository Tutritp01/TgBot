<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<div class="navbar navbar-dark bg-dark d-flex">
    <div class="dropdown">
        <button class="btn btn-primary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
            Menu
        </button>
        <ul class="dropdown-menu" style="">
            <li><a class="dropdown-item" href="/carTable">Cars</a></li>
            <li><a class="dropdown-item" href="/orderTable">Orders</a></li>
            <li><a class="dropdown-item" href="/engineerTable">Engineers</a></li>
            <li><a class="dropdown-item" href="/customerTable">Customers</a></li>
        </ul>
    </div>
    <div class="d-flex">
        <div class="col-first">
            <a href="/login" class="btn btn-primary px-4 me-4" type="button">Login</a>
        </div>
        <div class="col-last">
            <form class="d-flex input-group align-items-center me-5" action="/input" method="get">
                <input type="text" class="form-control" name="input" placeholder="Input command...">
                <input type="submit" class="col-md-20 btn btn-primary px-4" value="Input">
            </form>
        </div>
    </div>
</div>
<div class="header"><h2>${requestScope.output}</h2></div>
<style>
    body {
        background-color: #333;
        color: whitesmoke;
    }
</style>
