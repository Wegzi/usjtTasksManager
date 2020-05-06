<%@ page import="model.Task" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
            <h3 class="m-0">Lista de tarefas
            </h3>
            <a href="Create" class="btn btn-sm btn-success" role="button"
               aria-pressed="true">Nova tarefa</a>
        </div>
        <div class="d-flex flex-wrap">
            <%
                ArrayList<Task> list = new ArrayList<Task>();
                if (request.getAttribute("tasks") != null) {

                    list = (ArrayList<Task>) request.getAttribute("tasks");

                    for (Task task : list) {
                        if (task.getTitulo() != null) {
            %>
            <div class="p-3">
                <div class="card">
                    <div class="card-header d-flex">
                        <span class="mr-2">
                            <% out.print(task.getTitulo()); %>

                        </span>
                        <div class="ml-auto">
                            <a href="Create?id=<% out.print(task.getId()); %>" type="button"
                               class="btn btn-primary btn-sm">editar</a>
                            <a href="Delete?id=<% out.print(task.getId()); %>" type="button"
                               class="btn btn-danger btn-sm">apagar</a>
                        </div>
                    </div>
                    <div class="card-body">
                        <% out.print(task.getDescricao()); %>
                    </div>
                </div>
            </div>
            <%
                        }
                    }
                }
            %>

        </div>
    </div>
</div>
</body>
</html>
