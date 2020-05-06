package service;

import dao.NoticiaDAO;
import dao.TaskDAO;
import model.Noticia;
import model.Task;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Create")
public class Create extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        Task task = new Task();
        task.setTitulo(titulo);
        task.setDescricao(descricao);
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        task.setUser_email(email);
        TaskDAO conn = new TaskDAO();
        System.out.println(id);
        if (id != null) {
            task.setId(Integer.parseInt(id));
            conn.alterar(task);
        } else {
            conn.cadastrar(task);
        }

        response.sendRedirect("Home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        if(email != "" && email != null){

            String id = request.getParameter("id");
            if (id != null) {
                Task task = new Task();
                TaskDAO conn = new TaskDAO();
                task = conn.consultar(Integer.parseInt(id));
                request.setAttribute("task", task);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/create.jsp");
            rd.forward(request, response);
        }else
            response.sendRedirect("Login");

    }

}
