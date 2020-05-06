package service;

import dao.TaskDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println(id);
        TaskDAO conn = new TaskDAO();
        conn.excluir(Integer.parseInt(id));
        response.sendRedirect("Home");
    }


}
