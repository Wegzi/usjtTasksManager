    <nav class="navbar navbar-expand-lg navbar-dark bg-dark justify-content-between">
        <a class="navbar-brand" href="Home">TasksManager</a>
        <div>
        <span class="text-white">
            <%
                String name = (String) session.getAttribute("name");
                out.print(name);
            %>

        </span>
        <a class="" href="Logout">Sair</a>

        </div>
        </nav>
