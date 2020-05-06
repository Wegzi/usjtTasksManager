<%@ page import="model.Task" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<%@ include file="/layout/header.html" %>
<body>
<div id="pageheader">
    <%@ include file="/layout/menu.jsp" %>
</div>
<div id="body">
    <div class="container pt-3">
        <div class="d-flex align-items-center justify-content-between mb-3">
            <h3 class="m-0">Nova tarefa</h3>
            <a href="Home" class="btn btn-sm btn-success" role="button"
               aria-pressed="true">Voltar</a>
        </div>
        <div class="p-3 bg-white rounded  shadow-sm">
            <form action="Create" method="post">
                <%
                    Task task = new Task();
                    if (request.getAttribute("task") != null) {
                        task = (Task) request.getAttribute("task");
                        out.print("<input type='hidden' name='id' value='" + task.getId() + "' />");
                    }
                %>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Titulo</label>
                    <div class="col-sm-10">
                        <input type="text" name="titulo" class="form-control" id="titulo"
                               value="<% out.print(task.getTitulo() != null ? task.getTitulo(): ""); %>" required/>

                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Descricao</label>
                    <div class="col-sm-10">
                        <input type="text" name="descricao" class="form-control" id="descricao"
                               value="<% out.print(task.getDescricao() != null ? task.getDescricao(): ""); %>" required/>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary mb-2">Enviar</button>
            </form>

        </div>
    </div>
</div>
</body>
</html>
