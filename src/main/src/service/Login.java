package service;

import dao.NoticiaDAO;
import dao.UserDAO;
import model.Noticia;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        User user = new User();
        user.setEmail(email);
        user.setSenha(senha);
        UserDAO conn = new UserDAO();
        User _user = conn.auth(user);
        if (_user.getNome() != null) {
            HttpSession session = request.getSession();
            session.setAttribute("name", _user.getNome());
            session.setAttribute("email", _user.getEmail());
            response.sendRedirect("Home");
        } else
            response.sendRedirect("Login");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
    }
}
