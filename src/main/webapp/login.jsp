<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<%@ include file="/layout/header.html" %>
<body>
<div id="body">
    <div class="container pt-3">

        <div class="row justify-content-center">
            <div class="col-sm-6 bg-white shadow-sm rounded p-3">
                <form method="post" action="Login">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" name="senha" class="form-control" id="exampleInputPassword1">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>
