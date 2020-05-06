package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NoticiaDAO;
import dao.TaskDAO;
import model.Noticia;
import model.Task;

@WebServlet("/Home")
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        if (email != "" && email != null) {

            TaskDAO conn = new TaskDAO();
            ArrayList<Task> lista = conn.listarTask(email);
            request.setAttribute("tasks", lista);

            RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
            rd.forward(request, response);
        } else
            response.sendRedirect("Login");

    }

}
